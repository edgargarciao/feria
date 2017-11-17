package co.ufps.edu.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import co.ufps.edu.bd.SpringDbMgr;

public class LoginDao {

	SpringDbMgr springDbMgr = new SpringDbMgr();
	
	public String authenticate(int codigo,String contrase�a) {		
		if(esEstudiante(codigo,contrase�a)) {
			return "estudiante";
		}
		else if(esEvaluador(codigo,contrase�a)){
			return "evaluador";
		}
		else if(esAdmin(codigo,contrase�a)){
			return "admin";
		}
		return "";
	}

	private boolean esAdmin(int codigo, String contrase�a) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean esEvaluador(int codigo, String contrase�a) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean esEstudiante(int codigo, String contrase�a) {
		// TODO Auto-generated method stub
		return false;
	}
}
