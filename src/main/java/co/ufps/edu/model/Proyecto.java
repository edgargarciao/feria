package co.ufps.edu.model;

import javax.servlet.http.Part;

import org.springframework.web.multipart.MultipartFile;

public class Proyecto {

	private String titulo, resumen, linea,docenteGuia;
	private int codigoEstudiante1, codigoEstudiante2;
	private MultipartFile  archivo;

	public Proyecto() {
	}

	

	public Proyecto(String titulo, String resumen, String linea, String docenteGuia, int codigoEstudiante1,
			int codigoEstudiante2,
			 MultipartFile archivo) {
		this.titulo = titulo;
		this.resumen = resumen;
		this.linea = linea;
		this.docenteGuia = docenteGuia;
		this.codigoEstudiante1 = codigoEstudiante1;
		this.codigoEstudiante2 = codigoEstudiante2;
		//this.archivo = archivo;
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

	public MultipartFile getArchivo() {
		return archivo;
	}

	public void setArchivo(MultipartFile archivo) {
		this.archivo = archivo;
	}

}
