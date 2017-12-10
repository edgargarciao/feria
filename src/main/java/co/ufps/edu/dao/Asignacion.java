package co.ufps.edu.dao;

import org.springframework.util.StringUtils;

public class Asignacion {

	private String codigoProyecto;
	private String evaluador1;
	private String evaluador2;
	private String evaluador3;

	public String getCodigoProyecto() {
		return codigoProyecto;
	}

	public void setCodigoProyecto(String codigoProyecto) {
		this.codigoProyecto = codigoProyecto;
	}

	public String getEvaluador1() {
		return evaluador1;
	}

	public void setEvaluador1(String evaluador1) {
		this.evaluador1 = evaluador1;
	}

	public String getEvaluador2() {
		return evaluador2;
	}

	public void setEvaluador2(String evaluador2) {
		this.evaluador2 = evaluador2;
	}

	public String getEvaluador3() {
		return evaluador3;
	}

	public void setEvaluador3(String evaluador3) {
		this.evaluador3 = evaluador3;
	}

	public boolean validarDatos() {
		if (StringUtils.isEmpty(this.evaluador1) && StringUtils.isEmpty(this.evaluador2)
				&& StringUtils.isEmpty(this.evaluador3)) {
			return false;
		} else if ((!StringUtils.isEmpty(this.evaluador1) && !StringUtils.isEmpty(this.evaluador2))
				&& (this.evaluador1.equalsIgnoreCase(this.evaluador2))) {
			return false;
		} else if ((!StringUtils.isEmpty(this.evaluador1) && !StringUtils.isEmpty(this.evaluador3))
				&& (this.evaluador1.equalsIgnoreCase(this.evaluador3))) {
			return false;
		} else if ((!StringUtils.isEmpty(this.evaluador2) && !StringUtils.isEmpty(this.evaluador3))
				&& (this.evaluador2.equalsIgnoreCase(this.evaluador3))) {
			return false;
		}
		return true;
	}

}
