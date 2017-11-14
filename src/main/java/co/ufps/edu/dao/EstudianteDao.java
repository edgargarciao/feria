package co.ufps.edu.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import co.ufps.edu.bd.SpringDbMgr;
import co.ufps.edu.model.Estudiante;
import co.ufps.edu.model.Proyecto;

public class EstudianteDao {

	

	public boolean registrarEstudiante(Estudiante e){

		
		SpringDbMgr springDbMgr = new SpringDbMgr();

		if(!validarCodigo(e.getCodigo(),springDbMgr)){
			return false;
		}
		
		// Agrego los datos del registro (nombreColumna/Valor)
		
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("codigo", e.getCodigo());
		map.addValue("nombre", e.getNombre());
		map.addValue("apellido", e.getApellido());
		map.addValue("correo", e.getEmail());
		map.addValue("telefono", e.getTelefono());
		map.addValue("semestre", e.getSemestre());
		map.addValue("contrasena", e.getContrasena());
		
		
		
		String query = "insert into estudiante(codigo,nombre,apellido,correo,telefono,semestre,contrasena) "
				  + "values(:codigo,:nombre,:apellido,:correo,:telefono,:semestre,:contrasena)";
				
		int result = springDbMgr.executeDml(query, map);
		
		return (result==1);
	}
	
	
	
	private boolean validarCodigo(int codigo, SpringDbMgr springDbMgr) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("code", codigo);
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("select codigo from estudiante where codigo = :code");		
		return (sqlRowSet.next());
	}



	public boolean registrarProyecto(Proyecto p){
		SpringDbMgr springDbMgr = new SpringDbMgr();
		
		SqlRowSet r = springDbMgr.executeQuery("select * from proyecto");
		r.next();
		
		
		
		// Agrego los datos del registro (nombreColumna/Valor)
		
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("titulo", p.getTitulo());
		map.addValue("resumen", p.getResumen());
		map.addValue("objetivoGeneral", p.getObjetivoGeneral());
		map.addValue("objetivosEspecificos", p.getObjetivoEspecifico());
		map.addValue("alcance", p.getAlcance());
		map.addValue("docenteGuia", p.getDocenteGuia());
		map.addValue("linea", p.getLinea());
		
		
		
		String query = "insert into estudiante(titulo,resumen,objetivoGeneral,objetivosEspecificos,alcance,docenteGuia,linea)"
				  + "values(:titulo,:resumen,:objetivoGeneral,:objetivosEspecificos,:alcance,:docenteGuia,:linea)";
				
		int result = springDbMgr.executeDml(query, map);
		
		return (result==1);
	}
	
}
