package co.ufps.edu.model;

import java.io.File;

public class Proyecto {

	private String titulo, resumen, objetivoGeneral, objetivoEspecifico, alcance, docenteGuia, linea;
	private int codigo, codigo2;
	//private File file;
	
	
public Proyecto() {
		
	}

public Proyecto(String titulo, String resumen, String objetivoGeneral, String objetivoEspecifico, String alcance,
		String docenteGuia, String linea, int codigo, int codigo2) {
	
	this.titulo = titulo;
	this.resumen = resumen;
	this.objetivoGeneral = objetivoGeneral;
	this.objetivoEspecifico = objetivoEspecifico;
	this.alcance = alcance;
	this.docenteGuia = docenteGuia;
	this.linea = linea;
	this.codigo = codigo;
	this.codigo2 = codigo2;
}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getResumen() {
		return resumen;
	}
	public void setResumen(String resumen) {
		this.resumen = resumen;
	}
	public String getObjetivoGeneral() {
		return objetivoGeneral;
	}
	public void setObjetivoGeneral(String objetivoGeneral) {
		this.objetivoGeneral = objetivoGeneral;
	}
	public String getObjetivoEspecifico() {
		return objetivoEspecifico;
	}
	public void setObjetivoEspecifico(String objetivoEspecifico) {
		this.objetivoEspecifico = objetivoEspecifico;
	}
	public String getAlcance() {
		return alcance;
	}
	public void setAlcance(String alcance) {
		this.alcance = alcance;
	}
	public String getDocenteGuia() {
		return docenteGuia;
	}
	public void setDocenteGuia(String docenteGuia) {
		this.docenteGuia = docenteGuia;
	}
	public String getLinea() {
		return linea;
	}
	public void setLinea(String linea) {
		this.linea = linea;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodigo2() {
		return codigo2;
	}
	public void setCodigo2(int codigo2) {
		this.codigo2 = codigo2;
	}
	
	

}