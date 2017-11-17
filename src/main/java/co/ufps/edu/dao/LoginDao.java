package co.ufps.edu.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import co.ufps.edu.bd.SpringDbMgr;

public class LoginDao {

	SpringDbMgr springDbMgr = new SpringDbMgr();
	
	public String authenticate(int codigo,String contraseņa) {		
		if(esEstudiante(codigo,contraseņa)) {
			return "estudiante";
		}
		else if(esEvaluador(codigo,contraseņa)){
			return "evaluador";
		}
		else if(esAdmin(codigo,contraseņa)){
			return "admin";
		}
		return "";
	}

	private boolean esAdmin(int codigo, String contraseņa) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean esEvaluador(int codigo, String contraseņa) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean esEstudiante(int codigo, String contraseņa) {
		// TODO Auto-generated method stub
		return false;
	}
}
