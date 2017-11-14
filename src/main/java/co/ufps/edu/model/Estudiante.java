package co.ufps.edu.model;

public class Estudiante {

	private int codigo;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private byte semestre;
	private String contrasena;
	
	public Estudiante(){
		
	}
		
	public Estudiante(int codigo, String nombre, String apellido, String email, String telefono, byte semestre,
			String contrasena) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.semestre = semestre;
		this.contrasena = contrasena;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public byte getSemestre() {
		return semestre;
	}
	public void setSemestre(byte semestre) {
		this.semestre = semestre;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
	
}
