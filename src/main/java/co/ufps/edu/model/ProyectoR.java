package co.ufps.edu.model;

import javax.servlet.http.Part;

import org.springframework.web.multipart.MultipartFile;

public class ProyectoR {

	private String titulo, resumen, linea,docenteGuia,nomEst,descripCalif;
	private int codp,cod,codigoEstudiante1, codigoEstudiante2;
	private float calificacion;
	private MultipartFile  archivo;

	public ProyectoR() {
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



	public int getCod() {
		return cod;
	}



	public void setCod(int cod) {
		this.cod = cod;
	}

	public int getCodp() {
		return codp;
	}

	public void setCodp(int codp) {
		this.codp = codp;
	}

	public String getNomEst() {
		return nomEst;
	}

	public void setNomEst(String nomEst) {
		this.nomEst = nomEst;
	}

	@Override
	public String toString() {
		return "ProyectoR [titulo=" + titulo + ", resumen=" + resumen + ", linea=" + linea + ", docenteGuia="
				+ docenteGuia + ", nomEst=" + nomEst + ", codp=" + codp + ", cod=" + cod + ", codigoEstudiante1="
				+ codigoEstudiante1 + ", codigoEstudiante2=" + codigoEstudiante2 + ", archivo=" + archivo + "]";
	}

	public float getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(float calificacion) {
		this.calificacion = calificacion;
	}

	public String getDescripCalif() {
		return descripCalif;
	}

	public void setDescripCalif(String descripCalif) {
		this.descripCalif = descripCalif;
	}

}
