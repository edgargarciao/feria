package co.ufps.edu.model;

import javax.servlet.http.Part;

public class Proyecto {

	private String titulo, resumen, objetivoGeneral, objetivoEspecifico, alcance, docenteGuia, linea;
	private int codigoEstudiante1, codigoEstudiante2;
	private Part archivo;

	public Proyecto() {

	}

	public Proyecto(String titulo, String resumen, String objetivoGeneral, String objetivoEspecifico, String alcance,
			String docenteGuia, String linea, int codigoEstudiante1, int codigoEstudiante2, Part archivo) {
		super();
		this.titulo = titulo;
		this.resumen = resumen;
		this.objetivoGeneral = objetivoGeneral;
		this.objetivoEspecifico = objetivoEspecifico;
		this.alcance = alcance;
		this.docenteGuia = docenteGuia;
		this.linea = linea;
		this.codigoEstudiante1 = codigoEstudiante1;
		this.codigoEstudiante2 = codigoEstudiante2;
		this.archivo = archivo;
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

	public int getCodigoEstudiante1() {
		return codigoEstudiante1;
	}

	public void setCodigoEstudiante1(int codigoEstudiante1) {
		this.codigoEstudiante1 = codigoEstudiante1;
	}

	public int getCodigoEstudiante2() {
		return codigoEstudiante2;
	}

	public void setCodigoEstudiante2(int codigoEstudiante2) {
		this.codigoEstudiante2 = codigoEstudiante2;
	}

	public Part getArchivo() {
		return archivo;
	}

	public void setArchivo(Part archivo) {
		this.archivo = archivo;
	}

}
