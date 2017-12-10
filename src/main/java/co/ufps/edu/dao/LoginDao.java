package co.ufps.edu.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import co.ufps.edu.bd.SpringDbMgr;

public class LoginDao {

	SpringDbMgr springDbMgr = new SpringDbMgr();

	public String authenticate(long codigo, String contraseña) {
		if (esEstudiante(codigo, contraseña)) {
			return "estudiante";
		} else if (esAdmin(codigo, contraseña)) {
			return "admin";
		} else if (esEvaluador(codigo, contraseña)) {
			return "evaluador";
		}
		return "";
	}

	private boolean esAdmin(long codigo, String contraseña) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("codigo", codigo);
		mapSqlParameterSource.addValue("contraseña", contraseña);
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("SELECT codigo " + "	FROM administrador "
				+ "	WHERE codigo = :codigo " + " AND contraseña = :contraseña", mapSqlParameterSource);
		return (sqlRowSet.next());
	}

	private boolean esEvaluador(long codigo, String contraseña) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("codigo", codigo);
		mapSqlParameterSource.addValue("contraseña", contraseña);
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("SELECT codigo " + "	FROM evaluador "
				+ "	WHERE codigo = :codigo " + " AND contraseña = :contraseña", mapSqlParameterSource);
		return (sqlRowSet.next());
	}

	private boolean esEstudiante(long codigo, String contraseña) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("codigo", codigo);
		mapSqlParameterSource.addValue("contraseña", contraseña);
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("SELECT codigo " + "	FROM estudiante "
				+ "	WHERE codigo = :codigo " + " AND contraseña = :contraseña", mapSqlParameterSource);
		return (sqlRowSet.next());
	}
}
