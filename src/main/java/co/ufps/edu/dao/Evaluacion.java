package co.ufps.edu.dao;

import org.springframework.util.StringUtils;

public class Evaluacion {

	private String codigoProyecto;
	private float valoracion1, calificacion1, valoracion2, calificacion2, valoracion3, calificacion3, valoracion4,
			calificacion4, valoracion5, calificacion5, valoracion6, calificacion6, valoracion7, calificacion7,
			valoracion8, calificacion8, valoracion9, calificacion9, valoracion10, calificacion10;
	private String observacion1, observacion2, observacion3, observacion4, observacion5, observacion6, observacion7,
			observacion8, observacion9, observacion10;

	public float getValoracion1() {
		return valoracion1;
	}

	public void setValoracion1(float valoracion1) {
		this.valoracion1 = valoracion1;
	}

	public float getCalificacion1() {
		return calificacion1;
	}

	public void setCalificacion1(float calificacion1) {
		this.calificacion1 = calificacion1;
	}

	public float getValoracion2() {
		return valoracion2;
	}

	public void setValoracion2(float valoracion2) {
		this.valoracion2 = valoracion2;
	}

	public float getCalificacion2() {
		return calificacion2;
	}

	public void setCalificacion2(float calificacion2) {
		this.calificacion2 = calificacion2;
	}

	public float getValoracion3() {
		return valoracion3;
	}

	public void setValoracion3(float valoracion3) {
		this.valoracion3 = valoracion3;
	}

	public float getCalificacion3() {
		return calificacion3;
	}

	public void setCalificacion3(float calificacion3) {
		this.calificacion3 = calificacion3;
	}

	public float getValoracion4() {
		return valoracion4;
	}

	public void setValoracion4(float valoracion4) {
		this.valoracion4 = valoracion4;
	}

	public float getCalificacion4() {
		return calificacion4;
	}

	public void setCalificacion4(float calificacion4) {
		this.calificacion4 = calificacion4;
	}

	public float getValoracion5() {
		return valoracion5;
	}

	public void setValoracion5(float valoracion5) {
		this.valoracion5 = valoracion5;
	}

	public float getCalificacion5() {
		return calificacion5;
	}

	public void setCalificacion5(float calificacion5) {
		this.calificacion5 = calificacion5;
	}

	public float getValoracion6() {
		return valoracion6;
	}

	public void setValoracion6(float valoracion6) {
		this.valoracion6 = valoracion6;
	}

	public float getCalificacion6() {
		return calificacion6;
	}

	public void setCalificacion6(float calificacion6) {
		this.calificacion6 = calificacion6;
	}

	public float getValoracion7() {
		return valoracion7;
	}

	public void setValoracion7(float valoracion7) {
		this.valoracion7 = valoracion7;
	}

	public float getCalificacion7() {
		return calificacion7;
	}

	public void setCalificacion7(float calificacion7) {
		this.calificacion7 = calificacion7;
	}

	public float getValoracion8() {
		return valoracion8;
	}

	public void setValoracion8(float valoracion8) {
		this.valoracion8 = valoracion8;
	}

	public float getCalificacion8() {
		return calificacion8;
	}

	public void setCalificacion8(float calificacion8) {
		this.calificacion8 = calificacion8;
	}

	public float getValoracion9() {
		return valoracion9;
	}

	public void setValoracion9(float valoracion9) {
		this.valoracion9 = valoracion9;
	}

	public float getCalificacion9() {
		return calificacion9;
	}

	public void setCalificacion9(float calificacion9) {
		this.calificacion9 = calificacion9;
	}

	public float getValoracion10() {
		return valoracion10;
	}

	public void setValoracion10(float valoracion10) {
		this.valoracion10 = valoracion10;
	}

	public float getCalificacion10() {
		return calificacion10;
	}

	public void setCalificacion10(float calificacion10) {
		this.calificacion10 = calificacion10;
	}

	public String getObservacion1() {
		return observacion1;
	}

	public void setObservacion1(String observacion1) {
		this.observacion1 = observacion1;
	}

	public String getObservacion2() {
		return observacion2;
	}

	public void setObservacion2(String observacion2) {
		this.observacion2 = observacion2;
	}

	public String getObservacion3() {
		return observacion3;
	}

	public void setObservacion3(String observacion3) {
		this.observacion3 = observacion3;
	}

	public String getObservacion4() {
		return observacion4;
	}

	public void setObservacion4(String observacion4) {
		this.observacion4 = observacion4;
	}

	public String getObservacion5() {
		return observacion5;
	}

	public void setObservacion5(String observacion5) {
		this.observacion5 = observacion5;
	}

	public String getObservacion6() {
		return observacion6;
	}

	public void setObservacion6(String observacion6) {
		this.observacion6 = observacion6;
	}

	public String getObservacion7() {
		return observacion7;
	}

	public void setObservacion7(String observacion7) {
		this.observacion7 = observacion7;
	}

	public String getObservacion8() {
		return observacion8;
	}

	public void setObservacion8(String observacion8) {
		this.observacion8 = observacion8;
	}

	public String getObservacion9() {
		return observacion9;
	}

	public void setObservacion9(String observacion9) {
		this.observacion9 = observacion9;
	}

	public String getObservacion10() {
		return observacion10;
	}

	public void setObservacion10(String observacion10) {
		this.observacion10 = observacion10;
	}

	public String getCodigoProyecto() {
		return codigoProyecto;
	}

	public void setCodigoProyecto(String codigoProyecto) {
		this.codigoProyecto = codigoProyecto;
	}

	public boolean validarDatos(String idProyecto) {
		if (StringUtils.isEmpty(idProyecto) || StringUtils.isEmpty(calificacion1) || StringUtils.isEmpty(calificacion2)
				|| StringUtils.isEmpty(calificacion3) || StringUtils.isEmpty(calificacion4) || StringUtils.isEmpty(calificacion5)
				|| StringUtils.isEmpty(calificacion6) || StringUtils.isEmpty(calificacion7) || StringUtils.isEmpty(calificacion8)
				|| StringUtils.isEmpty(calificacion9) || StringUtils.isEmpty(calificacion10)) {
			return false;
		}
		return true;
	}

	public float obtenerCalificacionFinal() {
		float res1 = getCalificacion1() * getValoracion1() / 100;
		float res2 = getCalificacion2() * getValoracion2() / 100;
		float res3 = getCalificacion3() * getValoracion3() / 100;
		float res4 = getCalificacion4() * getValoracion4() / 100;
		float res5 = getCalificacion5() * getValoracion5() / 100;
		float res6 = getCalificacion6() * getValoracion6() / 100;
		float res7 = getCalificacion7() * getValoracion7() / 100;
		float res8 = getCalificacion8() * getValoracion8() / 100;
		float res9 = getCalificacion9() * getValoracion9() / 100;
		return (res1 + res2 + res3 + res4 + res5 + res6 + res7 + res8 + res9);
	}

	@Override
	public String toString() {
		return "Evaluacion [codigoProyecto=" + codigoProyecto + ", valoracion1=" + valoracion1 + ", calificacion1="
				+ calificacion1 + ", valoracion2=" + valoracion2 + ", calificacion2=" + calificacion2 + ", valoracion3="
				+ valoracion3 + ", calificacion3=" + calificacion3 + ", valoracion4=" + valoracion4 + ", calificacion4="
				+ calificacion4 + ", valoracion5=" + valoracion5 + ", calificacion5=" + calificacion5 + ", valoracion6="
				+ valoracion6 + ", calificacion6=" + calificacion6 + ", valoracion7=" + valoracion7 + ", calificacion7="
				+ calificacion7 + ", valoracion8=" + valoracion8 + ", calificacion8=" + calificacion8 + ", valoracion9="
				+ valoracion9 + ", calificacion9=" + calificacion9 + ", valoracion10=" + valoracion10
				+ ", calificacion10=" + calificacion10 + ", observacion1=" + observacion1 + ", observacion2="
				+ observacion2 + ", observacion3=" + observacion3 + ", observacion4=" + observacion4 + ", observacion5="
				+ observacion5 + ", observacion6=" + observacion6 + ", observacion7=" + observacion7 + ", observacion8="
				+ observacion8 + ", observacion9=" + observacion9 + ", observacion10=" + observacion10 + "]";
	}

}
