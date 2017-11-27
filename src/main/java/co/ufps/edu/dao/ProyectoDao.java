package co.ufps.edu.dao;

import java.sql.Date;
import java.time.Instant;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import co.ufps.edu.bd.SpringDbMgr;
import co.ufps.edu.model.Proyecto;
import co.ufps.edu.model.ResultDB;

public class ProyectoDao {

	public boolean registrarProyecto(Proyecto p, int codigo) {
		SpringDbMgr springDbMgr = new SpringDbMgr();

		// Agrego los datos del registro (nombreColumna/Valor)
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("titulo", p.getTitulo());
		map.addValue("resumen", p.getResumen());
		map.addValue("docenteGuia", p.getDocenteGuia());
		map.addValue("codigoLinea", p.getLinea());

		String query = "insert into proyecto(titulo,resumen,docenteGuia,codigoLinea)"
				+ "values(:titulo,:resumen,:docenteGuia,:codigoLinea)";

		ResultDB result = springDbMgr.executeDmlWithKey(query, map);
		ingresarIntegrante(codigo, result.getKey(), true);
		ingresarIntegrante(p.getCodigoEstudiante1(), result.getKey(), false);

		if (p.getCodigoEstudiante2() != 0) {
			ingresarIntegrante(p.getCodigoEstudiante2(), result.getKey(), false);
		}

		return (result.getResult() == 1);
	}

	private void ingresarIntegrante(int codigoEstudiante, long projectId, boolean esLider) {

		SpringDbMgr springDbMgr = new SpringDbMgr();

		// Agrego los datos del registro (nombreColumna/Valor)
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("id_estudiante", codigoEstudiante);
		map.addValue("id_proyecto", projectId);
		map.addValue("fecha_proyecto", new Date(Instant.now().getNano()/1000000));
		map.addValue("lider", esLider);

		String query = "insert into estudiante_proyecto(id_estudiante,id_proyecto,fecha_proyecto,lider)"
				+ "values(:id_estudiante,:id_proyecto,:fecha_proyecto,:lider)";

		int result = springDbMgr.executeDml(query, map);
	}
}
