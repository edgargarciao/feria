package co.ufps.edu.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import co.ufps.edu.bd.SpringDbMgr;

import co.ufps.edu.model.Evaluador;

public class EvaluadorDao {
	
public boolean registrarEvaluador(Evaluador e){

		
		SpringDbMgr springDbMgr = new SpringDbMgr();

		if(esCodigoRepetido(e.getCodigo(),springDbMgr)){
			return false;
		}
		
		// Agrego los datos del registro (nombreColumna/Valor)
		
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("codigo", e.getCodigo());
		map.addValue("nombre", e.getNombre());
		map.addValue("apellido", e.getApellido());
		map.addValue("linea", e.getLinea());
		
		
		String query = "insert into evaluador(codigo,nombre,apellido,linea) "
				  + "values(:codigo,:nombre,:apellido,:correo,:telefono,:semestre,:contrasena)";
				
		int result = springDbMgr.executeDml(query, map);
		
		return (result==1);
	}
	
	
	
	private boolean esCodigoRepetido(int codigo, SpringDbMgr springDbMgr) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("code", codigo);
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("select codigo from estudiante where codigo = :code",mapSqlParameterSource);		
		return (sqlRowSet.next());
	}
	
	
	
	

}
