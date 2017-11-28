package co.ufps.edu.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import co.ufps.edu.bd.SpringDbMgr;

import co.ufps.edu.model.Evaluador;
import co.ufps.edu.model.ResultDB;

public class EvaluadorDao {

	public boolean registrarEvaluador(Evaluador e) {

		SpringDbMgr springDbMgr = new SpringDbMgr();

		if (esCodigoRepetido(e.getCodigo(), springDbMgr)) {
			return false;
		}

		// Agrego los datos del registro (nombreColumna/Valor)

		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("codigo", e.getCodigo());
		map.addValue("nombre", e.getNombre());
		map.addValue("apellido", e.getApellido());
		map.addValue("correo", e.getEmail());
		map.addValue("contraseña", e.getContraseña());

		String query = "insert into evaluador(codigo,nombre,apellido,correo,contraseña) "
				+ "values(:codigo,:nombre,:apellido,:correo,:contraseña)";

		int result = springDbMgr.executeDml(query, map);
		insertarLineasAEvaluador(e.getCodigo(),e.getLineas());
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

}
