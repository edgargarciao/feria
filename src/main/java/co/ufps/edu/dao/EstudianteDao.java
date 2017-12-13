package co.ufps.edu.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import co.ufps.edu.bd.SpringDbMgr;
import co.ufps.edu.model.Estudiante;
import co.ufps.edu.model.Proyecto;

public class EstudianteDao {

	public boolean registrarEstudiante(Estudiante e) {

		SpringDbMgr springDbMgr = new SpringDbMgr();

		if (esCodigoRepetido(e.getCodigo(), springDbMgr)) {
			return false;
		}


		// Agrego los datos del registro (nombreColumna/Valor)

		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("codigo", Integer.parseInt(e.getCodigo()));
		map.addValue("nombre", e.getNombre());
		map.addValue("apellido", e.getApellido());
		map.addValue("correo", e.getEmail());
		map.addValue("telefono", e.getTelefono());
		map.addValue("semestre", Integer.parseInt(e.getSemestre()));
		map.addValue("contraseña", e.getContrasena());

		String query = "insert into estudiante(codigo,nombre,apellido,correo,telefono,semestre,contraseña) "
				+ "values(:codigo,:nombre,:apellido,:correo,:telefono,:semestre,:contraseña)";

		int result = springDbMgr.executeDml(query, map);

		return (result == 1);
	}

	private boolean esCodigoRepetido(String codigo, SpringDbMgr springDbMgr) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("code", Integer.parseInt(codigo));
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("select codigo from estudiante where codigo = :code",
				mapSqlParameterSource);
		return (sqlRowSet.next());
	}

}
