package co.ufps.edu.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import co.ufps.edu.bd.SpringDbMgr;

public class LineaDao {

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
