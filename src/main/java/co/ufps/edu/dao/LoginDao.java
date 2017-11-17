package co.ufps.edu.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import co.ufps.edu.bd.SpringDbMgr;

public class LoginDao {

	SpringDbMgr springDbMgr = new SpringDbMgr();
	
	public String authenticate(int codigo,String contraseña) {		
		if(esEstudiante(codigo,contraseña)) {
			return "estudiante";
		}
		else if(esEvaluador(codigo,contraseña)){
			return "evaluador";
		}
		else if(esAdmin(codigo,contraseña)){
			return "admin";
		}
		return "";
	}

	private boolean esAdmin(int codigo, String contraseña) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean esEvaluador(int codigo, String contraseña) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean esEstudiante(int codigo, String contraseña) {
		// TODO Auto-generated method stub
		return false;
	}
}
