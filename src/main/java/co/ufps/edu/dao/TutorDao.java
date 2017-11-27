package co.ufps.edu.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import co.ufps.edu.bd.SpringDbMgr;

public class TutorDao {

	public Map<String, String> getTutores() {
		Map<String, String> map = new HashMap<>();
		SpringDbMgr springDbMgr = new SpringDbMgr();

		SqlRowSet sqlRowSet = springDbMgr.executeQuery("select codigo codigo, nombre nombre from tutor");

		while (sqlRowSet.next()) {
			map.put(sqlRowSet.getString("codigo"), sqlRowSet.getString("nombre"));
		}
		return map;
	}
}
