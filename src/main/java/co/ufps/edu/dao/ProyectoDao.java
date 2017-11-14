package co.ufps.edu.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import co.ufps.edu.bd.SpringDbMgr;
import co.ufps.edu.model.Proyecto;

public class ProyectoDao {

	
	public boolean registrarProyecto(Proyecto p){
		SpringDbMgr springDbMgr = new SpringDbMgr();		
		
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
