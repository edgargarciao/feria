package co.ufps.edu.model;

import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;

public class Evaluador {

	private String nombre, apellido, email, contrase�a, codigo;
	private String lineas[];

	public Evaluador() {
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String[] getLineas() {
		return lineas;
	}

	public void setLineas(String lineas[]) {
		this.lineas = lineas;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public boolean validarDatos() {
		if (StringUtils.isEmpty(this.nombre) || StringUtils.isEmpty(this.apellido)
				|| StringUtils.isEmpty(this.contrase�a) || StringUtils.isEmpty(this.email)
				|| StringUtils.isEmpty(this.codigo) || !contieneLetras(this.codigo) || this.lineas.length == 0) {
			return false;
		}
		return true;
	}

	private boolean contieneLetras(String codigo) {
		return (codigo.matches("^[0-9]*$") && codigo.length() > 2);
	}

}
