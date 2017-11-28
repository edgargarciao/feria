package co.ufps.edu.dao;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.JDBCType;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Types;
import java.time.Instant;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.jdbc.core.SqlTypeValue;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.web.multipart.MultipartFile;

import co.ufps.edu.bd.SpringDbMgr;
import co.ufps.edu.model.Proyecto;
import co.ufps.edu.model.ResultDB;

public class ProyectoDao {

	public boolean registrarProyecto(Proyecto p, int codigo, MultipartFile file) {
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
		ingresarArchivo(result.getKey(),file);
		ingresarIntegrante(codigo, result.getKey(), true);
		ingresarIntegrante(p.getCodigoEstudiante1(), result.getKey(), false);
		
		if (p.getCodigoEstudiante2() != 0) {
			ingresarIntegrante(p.getCodigoEstudiante2(), result.getKey(), false);
		}

		return (result.getResult() == 1);
	}

	private void ingresarArchivo(long projectId, MultipartFile file) {

		SpringDbMgr springDbMgr = new SpringDbMgr();

		// Agrego los datos del registro (nombreColumna/Valor)
		MapSqlParameterSource map = new MapSqlParameterSource();		
		map.addValue("id_proyecto", projectId);
		map.addValue("nombre", file.getOriginalFilename());
	
		try {
			map.addValue("contenido", new SqlLobValue(new ByteArrayInputStream(file.getBytes()), file.getBytes().length, new DefaultLobHandler()), Types.BLOB);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String query = "insert into Archivo(id_proyecto,nombre,contenido)"
				+ "values(:id_proyecto,:nombre,:contenido)";

		int result = springDbMgr.executeDml(query, map);
		
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
