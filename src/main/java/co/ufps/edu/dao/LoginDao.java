package co.ufps.edu.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import co.ufps.edu.bd.SpringDbMgr;

public class LoginDao {

	SpringDbMgr springDbMgr = new SpringDbMgr();

	public String authenticate(long codigo, String contraseņa) {
		if (esEstudiante(codigo, contraseņa)) {
			return "estudiante";
		} else if (esAdmin(codigo, contraseņa)) {
			return "admin";
		} else if (esEvaluador(codigo, contraseņa)) {
			return "evaluador";
		}
		return "";
	}

	private boolean esAdmin(long codigo, String contraseņa) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("codigo", codigo);
		mapSqlParameterSource.addValue("contraseņa", contraseņa);
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("SELECT codigo " + "	FROM administrador "
				+ "	WHERE codigo = :codigo " + " AND contraseņa = :contraseņa", mapSqlParameterSource);
		return (sqlRowSet.next());
	}

	private boolean esEvaluador(long codigo, String contraseņa) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("codigo", codigo);
		mapSqlParameterSource.addValue("contraseņa", contraseņa);
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("SELECT codigo " + "	FROM evaluador "
				+ "	WHERE codigo = :codigo " + " AND contraseņa = :contraseņa", mapSqlParameterSource);
		return (sqlRowSet.next());
	}

	private boolean esEstudiante(long codigo, String contraseņa) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("codigo", codigo);
		mapSqlParameterSource.addValue("contraseņa", contraseņa);
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("SELECT codigo " + "	FROM estudiante "
				+ "	WHERE codigo = :codigo " + " AND contraseņa = :contraseņa", mapSqlParameterSource);
		return (sqlRowSet.next());
	}
}
