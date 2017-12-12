package co.ufps.edu.model;

import java.io.InputStream;

public class Archivo {

	private String nombre;
	private InputStream contenido;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public InputStream getContenido() {
		return contenido;
	}
	public void setContenido(InputStream contenido) {
		this.contenido = contenido;
	}
}
