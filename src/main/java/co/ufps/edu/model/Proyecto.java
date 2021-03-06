package co.ufps.edu.model;

import javax.servlet.http.Part;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public class Proyecto {

	private String titulo, resumen, linea, docenteGuia;
	private int cod, codigoEstudiante1, codigoEstudiante2;
	private MultipartFile archivo;

	public Proyecto() {
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

	public boolean isValidoParaRegistrar(MultipartFile file) {
		if (StringUtils.isEmpty(this.titulo) || StringUtils.isEmpty(this.resumen) || this.cod == 0 || this.codigoEstudiante1 == 0
				|| this.codigoEstudiante2 == 0 || StringUtils.isEmpty(this.linea)
				|| StringUtils.isEmpty(this.docenteGuia) || StringUtils.isEmpty(file.getOriginalFilename())) {
			return false;
		}

		return true;
	}
}