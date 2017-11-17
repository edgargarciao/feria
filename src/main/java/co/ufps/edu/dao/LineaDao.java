package co.ufps.edu.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import co.ufps.edu.bd.SpringDbMgr;
import co.ufps.edu.model.Estudiante;
import co.ufps.edu.model.Linea;

public class LineaDao {

	public boolean registrarLineas(Linea l) {

		SpringDbMgr springDbMgr = new SpringDbMgr();

		// Agrego los datos del registro (nombreColumna/Valor)

		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("nombre", l.getNombre());
		map.addValue("descripcion", l.getDescripcion());

		String query = "insert into linea(nombre,descripcion) " + "values(:nombre,:descripcion)";

		int result = springDbMgr.executeDml(query, map);

		return (result == 1);
	}

	public Map<String, String> getLineas() {
		Map<String, String> map = new HashMap<>();
		SpringDbMgr springDbMgr = new SpringDbMgr();

		SqlRowSet sqlRowSet = springDbMgr.executeQuery("select codigoLinea codigo, nombre nombre from linea");

		while (sqlRowSet.next()) {
			map.put(sqlRowSet.getString("codigo"), sqlRowSet.getString("nombre"));
		}
		return map;
	}
}
