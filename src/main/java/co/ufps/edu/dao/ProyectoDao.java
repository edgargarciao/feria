package co.ufps.edu.dao;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.JDBCType;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Types;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.jdbc.core.SqlTypeValue;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.web.multipart.MultipartFile;

import co.ufps.edu.bd.SpringDbMgr;
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
		ingresarArchivo(result.getKey(),file);
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
			map.addValue("contenido", new SqlLobValue(new ByteArrayInputStream(file.getBytes()), file.getBytes().length, new DefaultLobHandler()), Types.BLOB);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String query = "insert into Archivo(id_proyecto,nombre,contenido)"
				+ "values(:id_proyecto,:nombre,:contenido)";

		int result = springDbMgr.executeDml(query, map);
		
	}

	private void ingresarIntegrante(int codigoEstudiante, long projectId, boolean esLider) {

		SpringDbMgr springDbMgr = new SpringDbMgr();

		// Agrego los datos del registro (nombreColumna/Valor)
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("id_estudiante", codigoEstudiante);
		map.addValue("id_proyecto", projectId);
		map.addValue("fecha_proyecto", new Date(Instant.now().getNano()/1000000));
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
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("select estudiante_proyecto.id_proyecto id_proyecto, proyecto.titulo titulo, proyecto.resumen resumen,tutor.nombre docenteGuia, linea.nombre linea  \n" + 
				"from estudiante_proyecto,proyecto,linea,tutor\n" + 
				"where estudiante_proyecto.id_estudiante = :code \n" + 
				"and proyecto.id_proyecto = estudiante_proyecto.id_proyecto\n" + 
				"and linea.codigoLinea = proyecto.codigoLinea\n" + 
				"and tutor.codigo = proyecto.docenteGuia",
				mapSqlParameterSource);
		
		while(sqlRowSet.next()) {
			int codigoProyecto = sqlRowSet.getInt("id_proyecto");
			String titulo = sqlRowSet.getString("titulo");
			String resumen = sqlRowSet.getString("resumen");
			String docenteGuia = sqlRowSet.getString("docenteGuia");
			String linea = sqlRowSet.getString("linea");
			
			ArrayList<Integer> cods = getCodsInt(codigoProyecto);
			int est1 = cods.get(0);
			int est2 = (cods.size()>1)?cods.get(1):0;
			ProyectoR r = new ProyectoR();
			r.setCodp(codigoProyecto);
			r.setCodigoEstudiante1(est1);
			r.setCodigoEstudiante2(est2);
			r.setDocenteGuia(docenteGuia);
			r.setLinea(linea);
			r.setTitulo(titulo);
			r.setResumen(resumen);
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
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("SELECT estudiante_proyecto.id_estudiante id \n" + 
				"  from estudiante_proyecto\n" + 
				" WHERE estudiante_proyecto.id_proyecto = :code \n" + 
				"   and estudiante_proyecto.lider = FALSE", mapSqlParameterSource);
		while(sqlRowSet.next()) {
			result.add(sqlRowSet.getInt("id"));
		}
		return result;
	}
	
	
	public List<ProyectoR> getProyectos() {
		SpringDbMgr springDbMgr = new SpringDbMgr();
		List<ProyectoR> proyectos = new LinkedList<>();
		SqlRowSet sqlRowSet = springDbMgr.executeQuery(
				"SELECT DISTINCT e.nombre nomEst, ep.id_proyecto id_proyecto, p.titulo titulo, p.resumen resumen,tutor.nombre docenteGuia, linea.nombre linea \n" + 
				"from estudiante e,estudiante_proyecto ep,proyecto p,linea,tutor \n" + 
				"WHERE e.codigo = ep.id_estudiante AND p.id_proyecto = ep.id_proyecto \n" + 
				"and linea.codigoLinea = p.codigoLinea \n" + 
				"and tutor.codigo = p.docenteGuia " + 
				"and p.id_proyecto \n " + 
				"NOT IN \n" + 
				"(\n" + 
				"    SELECT pt.id_proyecto \n" + 
				"    FROM proyecto_evaluador pt\n" + 
				") ");
		
		while(sqlRowSet.next()) {
			int codigoProyecto = sqlRowSet.getInt("id_proyecto");
			String titulo = sqlRowSet.getString("titulo");
			String resumen = sqlRowSet.getString("resumen");
			String docenteGuia = sqlRowSet.getString("docenteGuia");
			String linea = sqlRowSet.getString("linea");
			String nombreEstudiante = sqlRowSet.getString("nomEst");
			
			ArrayList<Integer> cods = getCodsInt(codigoProyecto);
			int est1 = cods.get(0);
			int est2 = (cods.size()>1)?cods.get(1):0;
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
				"SELECT DISTINCT e.nombre nomEst, ep.id_proyecto id_proyecto, p.titulo titulo, p.resumen resumen,tutor.nombre docenteGuia, linea.nombre linea \n" + 
				"from proyecto_evaluador pe,estudiante e,estudiante_proyecto ep,proyecto p,linea,tutor \n" + 
				"WHERE e.codigo = ep.id_estudiante AND p.id_proyecto = ep.id_proyecto \n" + 
				"and linea.codigoLinea = p.codigoLinea \n" + 
				"and tutor.codigo = p.docenteGuia " + 
				"and p.id_proyecto = pe.id_proyecto "
				+ " AND pe.id_evaluador = :code",
				mapSqlParameterSource);
		
		while(sqlRowSet.next()) {
			int codigoProyecto = sqlRowSet.getInt("id_proyecto");
			String titulo = sqlRowSet.getString("titulo");
			String resumen = sqlRowSet.getString("resumen");
			String docenteGuia = sqlRowSet.getString("docenteGuia");
			String linea = sqlRowSet.getString("linea");
			String nombreEstudiante = sqlRowSet.getString("nomEst");
			
			ArrayList<Integer> cods = getCodsInt(codigoProyecto);
			int est1 = cods.get(0);
			int est2 = (cods.size()>1)?cods.get(1):0;
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
		// TODO Auto-generated method stub
		
	}
}
