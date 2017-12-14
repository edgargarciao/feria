package co.ufps.edu.dao;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Date;
import java.sql.JDBCType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Types;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialBlob;

import org.springframework.jdbc.core.SqlTypeValue;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.web.multipart.MultipartFile;

import co.ufps.edu.bd.SpringDbMgr;
import co.ufps.edu.model.Archivo;
import co.ufps.edu.model.Proyecto;
import co.ufps.edu.model.ProyectoR;
import co.ufps.edu.model.ResultDB;

public class ProyectoDao {

	public boolean registrarProyecto(Proyecto p, int codigo, MultipartFile file) {
		SpringDbMgr springDbMgr = new SpringDbMgr();

		// Agrego los datos del registro (nombreColumna/Valor)
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("titulo", p.getTitulo());
		map.addValue("resumen", p.getResumen());
		map.addValue("docenteGuia", p.getDocenteGuia());
		map.addValue("codigoLinea", p.getLinea());

		String query = "insert into proyecto(titulo,resumen,docenteGuia,codigoLinea)"
				+ "values(:titulo,:resumen,:docenteGuia,:codigoLinea)";

		ResultDB result = springDbMgr.executeDmlWithKey(query, map);
		ingresarArchivo(result.getKey(), file);
		ingresarIntegrante(codigo, result.getKey(), true);
		ingresarIntegrante(p.getCodigoEstudiante1(), result.getKey(), false);

		if (p.getCodigoEstudiante2() != 0) {
			ingresarIntegrante(p.getCodigoEstudiante2(), result.getKey(), false);
		}

		return (result.getResult() == 1);
	}

	private void ingresarArchivo(long projectId, MultipartFile file) {

		SpringDbMgr springDbMgr = new SpringDbMgr();

		// Agrego los datos del registro (nombreColumna/Valor)
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("id_proyecto", projectId);
		map.addValue("nombre", file.getOriginalFilename());

		try {
			map.addValue("contenido", new SqlLobValue(new ByteArrayInputStream(file.getBytes()), file.getBytes().length,
					new DefaultLobHandler()), Types.BLOB);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String query = "insert into Archivo(id_proyecto,nombre,contenido)" + "values(:id_proyecto,:nombre,:contenido)";

		int result = springDbMgr.executeDml(query, map);

	}

	private void ingresarIntegrante(int codigoEstudiante, long projectId, boolean esLider) {

		SpringDbMgr springDbMgr = new SpringDbMgr();

		// Agrego los datos del registro (nombreColumna/Valor)
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("id_estudiante", codigoEstudiante);
		map.addValue("id_proyecto", projectId);
		map.addValue("fecha_proyecto", new Date(Instant.now().getNano() / 1000000));
		map.addValue("lider", esLider);

		String query = "insert into estudiante_proyecto(id_estudiante,id_proyecto,fecha_proyecto,lider)"
				+ "values(:id_estudiante,:id_proyecto,:fecha_proyecto,:lider)";

		int result = springDbMgr.executeDml(query, map);
	}

	public List<ProyectoR> getProyectos(String codigo) {
		SpringDbMgr springDbMgr = new SpringDbMgr();
		List<ProyectoR> proyectos = new LinkedList<>();
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("code", Integer.parseInt(codigo));
		SqlRowSet sqlRowSet = springDbMgr.executeQuery(
				"select estudiante_proyecto.id_proyecto id_proyecto, proyecto.titulo titulo, proyecto.resumen resumen,tutor.nombre docenteGuia, linea.nombre linea,proyecto.calificacion cal,proyecto.descripcionCalificacion descal  \n"
						+ "from estudiante_proyecto,proyecto,linea,tutor\n"
						+ "where estudiante_proyecto.id_estudiante = :code \n"
						+ "and proyecto.id_proyecto = estudiante_proyecto.id_proyecto\n"
						+ "and linea.codigoLinea = proyecto.codigoLinea\n" + "and tutor.codigo = proyecto.docenteGuia",
				mapSqlParameterSource);

		while (sqlRowSet.next()) {
			int codigoProyecto = sqlRowSet.getInt("id_proyecto");
			String titulo = sqlRowSet.getString("titulo");
			String resumen = sqlRowSet.getString("resumen");
			String docenteGuia = sqlRowSet.getString("docenteGuia");
			String linea = sqlRowSet.getString("linea");
			String desCal = sqlRowSet.getString("descal");
			float cal = sqlRowSet.getFloat("cal");
			
		
			ArrayList<Integer> cods = getCodsInt(codigoProyecto);
			int est1 = cods.get(0);
			int est2 = (cods.size() > 1) ? cods.get(1) : 0;
			ProyectoR r = new ProyectoR();
			r.setCodp(codigoProyecto);
			r.setCodigoEstudiante1(est1);
			r.setCodigoEstudiante2(est2);
			r.setDocenteGuia(docenteGuia);
			r.setLinea(linea);
			r.setTitulo(titulo);
			r.setResumen(resumen);
			r.setDescripCalif(desCal);
			r.setCalificacion(cal);
			proyectos.add(r);
		}
		return proyectos;
	}

	private ArrayList<Integer> getCodsInt(int codigoProyecto) {

		ArrayList<Integer> result = new ArrayList<>();
		SpringDbMgr springDbMgr = new SpringDbMgr();
		List<ProyectoR> proyectos = new LinkedList<>();
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("code", (codigoProyecto));
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("SELECT estudiante_proyecto.id_estudiante id \n"
				+ "  from estudiante_proyecto\n" + " WHERE estudiante_proyecto.id_proyecto = :code \n"
				+ "   and estudiante_proyecto.lider = FALSE", mapSqlParameterSource);
		while (sqlRowSet.next()) {
			result.add(sqlRowSet.getInt("id"));
		}
		return result;
	}

	public List<ProyectoR> getProyectos() {
		SpringDbMgr springDbMgr = new SpringDbMgr();
		List<ProyectoR> proyectos = new LinkedList<>();
		SqlRowSet sqlRowSet = springDbMgr.executeQuery(
				"SELECT DISTINCT e.nombre nomEst, ep.id_proyecto id_proyecto, p.titulo titulo, p.resumen resumen,tutor.nombre docenteGuia, linea.nombre linea \n"
						+ "from estudiante e,estudiante_proyecto ep,proyecto p,linea,tutor \n"
						+ "WHERE e.codigo = ep.id_estudiante AND p.id_proyecto = ep.id_proyecto \n"
						+ "and linea.codigoLinea = p.codigoLinea \n" + "and tutor.codigo = p.docenteGuia "
						+ "and p.id_proyecto \n " + "NOT IN \n" + "(\n" + "    SELECT pt.id_proyecto \n"
						+ "    FROM proyecto_evaluador pt\n" + ") ");

		while (sqlRowSet.next()) {
			int codigoProyecto = sqlRowSet.getInt("id_proyecto");
			String titulo = sqlRowSet.getString("titulo");
			String resumen = sqlRowSet.getString("resumen");
			String docenteGuia = sqlRowSet.getString("docenteGuia");
			String linea = sqlRowSet.getString("linea");
			String nombreEstudiante = sqlRowSet.getString("nomEst");

			ArrayList<Integer> cods = getCodsInt(codigoProyecto);
			int est1 = cods.get(0);
			int est2 = (cods.size() > 1) ? cods.get(1) : 0;
			ProyectoR r = new ProyectoR();
			r.setCodp(codigoProyecto);
			r.setCodigoEstudiante1(est1);
			r.setCodigoEstudiante2(est2);
			r.setDocenteGuia(docenteGuia);
			r.setLinea(linea);
			r.setTitulo(titulo);
			r.setResumen(resumen);
			r.setNomEst(nombreEstudiante);
			proyectos.add(r);
		}
		return proyectos;
	}

	public List<ProyectoR> getProyectosPorEvaluador(String codigoEvaluador) {
		SpringDbMgr springDbMgr = new SpringDbMgr();
		List<ProyectoR> proyectos = new LinkedList<>();
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("code", Integer.parseInt(codigoEvaluador));
		SqlRowSet sqlRowSet = springDbMgr.executeQuery(
				"SELECT DISTINCT e.nombre nomEst, ep.id_proyecto id_proyecto, p.titulo titulo, p.resumen resumen,tutor.nombre docenteGuia, linea.nombre linea \n"
						+ "from proyecto_evaluador pe,estudiante e,estudiante_proyecto ep,proyecto p,linea,tutor \n"
						+ "WHERE e.codigo = ep.id_estudiante AND p.id_proyecto = ep.id_proyecto \n"
						+ "and linea.codigoLinea = p.codigoLinea \n" + "and tutor.codigo = p.docenteGuia "
						+ "and p.id_proyecto = pe.id_proyecto "
						+ "and p.id_proyecto NOT IN (	SELECT c.codigoProyecto FROM calificacion c ) and pe.id_evaluador = :code",
				mapSqlParameterSource);

		while (sqlRowSet.next()) {
			int codigoProyecto = sqlRowSet.getInt("id_proyecto");
			String titulo = sqlRowSet.getString("titulo");
			String resumen = sqlRowSet.getString("resumen");
			String docenteGuia = sqlRowSet.getString("docenteGuia");
			String linea = sqlRowSet.getString("linea");
			String nombreEstudiante = sqlRowSet.getString("nomEst");

			ArrayList<Integer> cods = getCodsInt(codigoProyecto);
			int est1 = cods.get(0);
			int est2 = (cods.size() > 1) ? cods.get(1) : 0;
			ProyectoR r = new ProyectoR();
			r.setCodp(codigoProyecto);
			r.setCodigoEstudiante1(est1);
			r.setCodigoEstudiante2(est2);
			r.setDocenteGuia(docenteGuia);
			r.setLinea(linea);
			r.setTitulo(titulo);
			r.setResumen(resumen);
			r.setNomEst(nombreEstudiante);
			proyectos.add(r);
		}
		return proyectos;
	}

	public void evaluarProyecto(Evaluacion evaluacion) {

		SpringDbMgr springDbMgr = new SpringDbMgr();
		float calificacionFinal = evaluacion.obtenerCalificacionFinal();
		// Agrego los datos del registro (nombreColumna/Valor)
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("calificacion", calificacionFinal);
		map.addValue("id_proyecto", evaluacion.getCodigoProyecto());
		map.addValue("descripcionCalificacion", evaluacion.getObservacion10());

		String query = "update 	proyecto set descripcionCalificacion = :descripcionCalificacion, calificacion = :calificacion " + "where 	id_proyecto = :id_proyecto";

		int result = springDbMgr.executeDml(query, map);
		insertarCalificaciones(evaluacion);
	}

	private void insertarCalificaciones(Evaluacion evaluacion) {
		insertarCalificacion(evaluacion.getCodigoProyecto(), evaluacion.getCalificacion1(), evaluacion.getValoracion1(),
				evaluacion.getObservacion1());
		insertarCalificacion(evaluacion.getCodigoProyecto(), evaluacion.getCalificacion2(), evaluacion.getValoracion2(),
				evaluacion.getObservacion2());
		insertarCalificacion(evaluacion.getCodigoProyecto(), evaluacion.getCalificacion3(), evaluacion.getValoracion3(),
				evaluacion.getObservacion3());
		insertarCalificacion(evaluacion.getCodigoProyecto(), evaluacion.getCalificacion4(), evaluacion.getValoracion4(),
				evaluacion.getObservacion4());
		insertarCalificacion(evaluacion.getCodigoProyecto(), evaluacion.getCalificacion5(), evaluacion.getValoracion5(),
				evaluacion.getObservacion5());
		insertarCalificacion(evaluacion.getCodigoProyecto(), evaluacion.getCalificacion6(), evaluacion.getValoracion6(),
				evaluacion.getObservacion6());
		insertarCalificacion(evaluacion.getCodigoProyecto(), evaluacion.getCalificacion7(), evaluacion.getValoracion7(),
				evaluacion.getObservacion7());
		insertarCalificacion(evaluacion.getCodigoProyecto(), evaluacion.getCalificacion8(), evaluacion.getValoracion8(),
				evaluacion.getObservacion8());
		insertarCalificacion(evaluacion.getCodigoProyecto(), evaluacion.getCalificacion8(), evaluacion.getValoracion9(),
				evaluacion.getObservacion9());

	}

	private void insertarCalificacion(String codigoProyecto, float calificacion, float valoracion, String observacion) {

		SpringDbMgr springDbMgr = new SpringDbMgr();
		// Agrego los datos del registro (nombreColumna/Valor)
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("codigoProyecto", codigoProyecto);
		map.addValue("puntaje", calificacion);
		map.addValue("porcentaje", valoracion);
		map.addValue("comentario", observacion);

		String query = "INSERT INTO calificacion(codigoProyecto,puntaje,porcentaje,comentario) "
				     + "VALUES(:codigoProyecto,:puntaje,:porcentaje,:comentario)";

		int result = springDbMgr.executeDml(query, map);

	}

	public void asignarHorario(MultipartFile file) {
		SpringDbMgr springDbMgr = new SpringDbMgr();

		// Agrego los datos del registro (nombreColumna/Valor)
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("nombre", file.getOriginalFilename());

		try {
			map.addValue("contenido", new SqlLobValue(new ByteArrayInputStream(file.getBytes()), file.getBytes().length,
					new DefaultLobHandler()), Types.BLOB);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String query = "insert into Archivo(nombre,contenido)" + "values(:nombre,:contenido)";

		int result = springDbMgr.executeDml(query, map);
		
	}
	
	public Archivo getHorario(HttpServletRequest request) {
		SpringDbMgr springDbMgr = new SpringDbMgr();
		Archivo archivo = new Archivo();
		String query = "select * from archivo order by id_archivo desc";
		
		SqlRowSet result = springDbMgr.executeQuery(query);
		result.next();
		
		archivo.setNombre(result.getString("nombre"));
		Object imageBlob = (Object) result.getObject("contenido");
		byte[] con = (byte[]) imageBlob;
		InputStream binaryStream = null;

		binaryStream = new ByteArrayInputStream(con);
		archivo.setContenido(binaryStream);


			    try {
				    byte[] buffer = new byte[binaryStream.available()];
				    binaryStream.read(buffer);
				    String ruta = request.getServletContext().getRealPath("")+archivo.getNombre();
				    System.out.println("ruta --> "+ruta);
				    File targetFile = new File(ruta);
				    OutputStream outStream = new FileOutputStream(targetFile);
					outStream.write(buffer);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		return archivo;
	}
	
	public List<ProyectoR> getProyectosEvaluadosPorEvaluador(String codigoEvaluador) {
		SpringDbMgr springDbMgr = new SpringDbMgr();
		List<ProyectoR> proyectos = new LinkedList<>();
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("code", Integer.parseInt(codigoEvaluador));
		SqlRowSet sqlRowSet = springDbMgr.executeQuery(
				"SELECT DISTINCT e.nombre nomEst, ep.id_proyecto id_proyecto, p.titulo titulo, p.resumen resumen,tutor.nombre docenteGuia, linea.nombre linea,p.calificacion cal \n"
						+ "from proyecto_evaluador pe,estudiante e,estudiante_proyecto ep,proyecto p,linea,tutor \n"
						+ "WHERE e.codigo = ep.id_estudiante AND p.id_proyecto = ep.id_proyecto \n"
						+ "and linea.codigoLinea = p.codigoLinea \n" + "and tutor.codigo = p.docenteGuia "
						+ "and p.id_proyecto = pe.id_proyecto "
						+ "and p.id_proyecto IN (	SELECT c.codigoProyecto FROM calificacion c ) and pe.id_evaluador = :code",
				mapSqlParameterSource);
		
		while (sqlRowSet.next()) {
			int codigoProyecto = sqlRowSet.getInt("id_proyecto");
			String titulo = sqlRowSet.getString("titulo");
			String resumen = sqlRowSet.getString("resumen");
			String docenteGuia = sqlRowSet.getString("docenteGuia");
			String linea = sqlRowSet.getString("linea");
			String nombreEstudiante = sqlRowSet.getString("nomEst");
			float cal = sqlRowSet.getFloat("cal");

			ArrayList<Integer> cods = getCodsInt(codigoProyecto);
			int est1 = cods.get(0);
			int est2 = (cods.size() > 1) ? cods.get(1) : 0;
			ProyectoR r = new ProyectoR();
			r.setCodp(codigoProyecto);
			r.setCodigoEstudiante1(est1);
			r.setCodigoEstudiante2(est2);
			r.setDocenteGuia(docenteGuia);
			r.setLinea(linea);
			r.setTitulo(titulo);
			r.setResumen(resumen);
			r.setNomEst(nombreEstudiante);
			r.setCalificacion(cal);
			proyectos.add(r);
		}
		return proyectos;
	}
	
	public List<ProyectoR> getProyectosEvaluados() {
		SpringDbMgr springDbMgr = new SpringDbMgr();
		List<ProyectoR> proyectos = new LinkedList<>();
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();

		SqlRowSet sqlRowSet = springDbMgr.executeQuery(
				"SELECT DISTINCT e.nombre nomEst, ep.id_proyecto id_proyecto, p.titulo titulo, p.resumen resumen,tutor.nombre docenteGuia, linea.nombre linea,p.calificacion cal \n"
						+ "from proyecto_evaluador pe,estudiante e,estudiante_proyecto ep,proyecto p,linea,tutor \n"
						+ "WHERE e.codigo = ep.id_estudiante AND p.id_proyecto = ep.id_proyecto \n"
						+ "and linea.codigoLinea = p.codigoLinea \n" + "and tutor.codigo = p.docenteGuia "
						+ "and p.id_proyecto = pe.id_proyecto "
						+ "and p.id_proyecto IN (	SELECT c.codigoProyecto FROM calificacion c )"
						+ "ORDER BY p.calificacion DESC",
				mapSqlParameterSource);
		
		while (sqlRowSet.next()) {
			int codigoProyecto = sqlRowSet.getInt("id_proyecto");
			String titulo = sqlRowSet.getString("titulo");
			String resumen = sqlRowSet.getString("resumen");
			String docenteGuia = sqlRowSet.getString("docenteGuia");
			String linea = sqlRowSet.getString("linea");
			String nombreEstudiante = sqlRowSet.getString("nomEst");
			float cal = sqlRowSet.getFloat("cal");

			ArrayList<Integer> cods = getCodsInt(codigoProyecto);
			int est1 = cods.get(0);
			int est2 = (cods.size() > 1) ? cods.get(1) : 0;
			ProyectoR r = new ProyectoR();
			r.setCodp(codigoProyecto);
			r.setCodigoEstudiante1(est1);
			r.setCodigoEstudiante2(est2);
			r.setDocenteGuia(docenteGuia);
			r.setLinea(linea);
			r.setTitulo(titulo);
			r.setResumen(resumen);
			r.setNomEst(nombreEstudiante);
			r.setCalificacion(cal);
			proyectos.add(r);
		}
		return proyectos;
	}
	
	
}
