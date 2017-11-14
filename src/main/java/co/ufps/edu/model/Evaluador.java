package co.ufps.edu.model;

public class Evaluador {
	
	
	private int codigo;
	private String nombre, apellido,linea;
	
	
	
	
	public Evaluador() {
		
	}


	public Evaluador(int codigo, String nombre, String apellido, String linea) {
		
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.linea = linea;
	}
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
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
	public String getLinea() {
		return linea;
	}
	public void setLinea(String linea) {
		this.linea = linea;
	}
	
	
	

}
