package co.ufps.edu.model;

public class Login {
	
	private int codigo;
	private String contrase�a;
	
	public Login() {
	}

	public Login(int codigo, String contrase�a) {
		this.codigo = codigo;
		this.contrase�a = contrase�a;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getContrase�a() {
		return contrase�a;
	}


	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

}
