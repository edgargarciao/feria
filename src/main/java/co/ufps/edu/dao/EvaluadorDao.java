package co.ufps.edu.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.util.StringUtils;

import co.ufps.edu.bd.SpringDbMgr;

import co.ufps.edu.model.Evaluador;
import co.ufps.edu.model.ResultDB;

public class EvaluadorDao {

	public boolean registrarEvaluador(Evaluador e) {

		SpringDbMgr springDbMgr = new SpringDbMgr();

		if (esCodigoRepetido(Integer.parseInt(e.getCodigo()), springDbMgr)) {
			return false;
		}

		// Agrego los datos del registro (nombreColumna/Valor)

		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("codigo", Integer.parseInt(e.getCodigo()));
		map.addValue("nombre", e.getNombre());
		map.addValue("apellido", e.getApellido());
		map.addValue("correo", e.getEmail());
		map.addValue("contraseña", e.getContraseña());

		String query = "insert into evaluador(codigo,nombre,apellido,correo,contraseña) "
				+ "values(:codigo,:nombre,:apellido,:correo,:contraseña)";

		int result = springDbMgr.executeDml(query, map);
		insertarLineasAEvaluador(Integer.parseInt(e.getCodigo()),e.getLineas());
		return (result == 1);
	}

	private void insertarLineasAEvaluador(long evaluadorId, String[] lineas) {
		 SpringDbMgr springDbMgr = new SpringDbMgr();
		 long[] codigos = getCodigoLineas(lineas); 
		 for(long codigo:codigos) {
			MapSqlParameterSource map = new MapSqlParameterSource();
			map.addValue("idlinea",codigo);
			map.addValue("idevaluador", evaluadorId);
			springDbMgr.executeDml("insert into evaluador_linea(idlinea,idevaluador) values(:idlinea,:idevaluador)",map);
		 }
	}

	private long[] getCodigoLineas(String[] lineas) {
		SpringDbMgr springDbMgr = new SpringDbMgr();
		String lin = String.join("' OR nombre = '", lineas);
		String query = "SELECT codigoLinea FROM linea WHERE nombre = '"+lin+"'";
		SqlRowSet rowSet = springDbMgr.executeQuery(query);
		long result[] = new long[lineas.length];
		int i = 0;
		while(rowSet.next()) {
			 result[i++] = rowSet.getLong("codigoLinea");
		}		
		return result;
	}

	private boolean esCodigoRepetido(int codigo, SpringDbMgr springDbMgr) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("code", codigo);
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("select codigo from estudiante where codigo = :code",
				mapSqlParameterSource);
		return (sqlRowSet.next());
	}

	public Map<String, String> getEvaluadoresPorProyecto(int idProyecto) {
		Map<String, String> map = new HashMap<>();
		SpringDbMgr springDbMgr = new SpringDbMgr();
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("code", idProyecto);
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("SELECT e.codigo,e.nombre \n" + 
				"  FROM evaluador e,evaluador_linea el, proyecto p\n" + 
				" WHERE e.codigo = el.idevaluador\n" + 
				"   AND el.idlinea = p.codigoLinea\n" + 
				"   AND p.id_proyecto = :code",mapSqlParameterSource);

		while (sqlRowSet.next()) {
			map.put(sqlRowSet.getString("codigo"), sqlRowSet.getString("nombre"));
		}
		return map;
	}

	public void asignarEvaluador(Asignacion asignacion) {
		if(!StringUtils.isEmpty(asignacion.getEvaluador1())) {
			asignarEvaluadorAProyecto(asignacion.getCodigoProyecto(),asignacion.getEvaluador1());
		}
		if(!StringUtils.isEmpty(asignacion.getEvaluador2())) {
			asignarEvaluadorAProyecto(asignacion.getCodigoProyecto(),asignacion.getEvaluador2());
		}
		if(!StringUtils.isEmpty(asignacion.getEvaluador3())) {
			asignarEvaluadorAProyecto(asignacion.getCodigoProyecto(),asignacion.getEvaluador3());
		}
	}

	private void asignarEvaluadorAProyecto(String codigoProyecto, String evaluador) {
		SpringDbMgr springDbMgr = new SpringDbMgr();
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("id_evaluador", Integer.parseInt(evaluador));
		map.addValue("id_proyecto", Integer.parseInt(codigoProyecto));
		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);
		map.addValue("fecha_asignacion", currentTime);

		String query = "insert into proyecto_evaluador(id_evaluador,id_proyecto,fecha_asignacion) "
				+ "values(:id_evaluador,:id_proyecto,:fecha_asignacion)";

		int result = springDbMgr.executeDml(query, map);
		
	}

}
