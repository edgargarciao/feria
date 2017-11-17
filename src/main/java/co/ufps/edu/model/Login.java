package co.ufps.edu.model;

public class Login {
	
	private int codigo;
	private String contraseña;
	
	public Login() {
	}

	public Login(int codigo, String contraseña) {
		this.codigo = codigo;
		this.contraseña = contraseña;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getContraseña() {
		return contraseña;
	}


	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

}
