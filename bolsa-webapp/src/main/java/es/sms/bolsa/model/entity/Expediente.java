package es.sms.bolsa.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

public class Expediente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	private Long ID;
	
	@Column(name = "NUMERO_ASIGNATURAS")
	private String numeroAsignaturas;
	
	@Column(name = "NUMERO_MATRICULAS")
	private Integer numeroMatriculas;
	
	@Column(name = "NUMERO_SOBRESALIENTES")
	private String numeroSobresalientes;
	
	@Column(name = "NUMERO_NOTABLES")
	private Date numeroNotables;

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getNumeroAsignaturas() {
		return numeroAsignaturas;
	}

	public void setNumeroAsignaturas(String numeroAsignaturas) {
		this.numeroAsignaturas = numeroAsignaturas;
	}

	public Integer getNumeroMatriculas() {
		return numeroMatriculas;
	}

	public void setNumeroMatriculas(Integer numeroMatriculas) {
		this.numeroMatriculas = numeroMatriculas;
	}

	public String getNumeroSobresalientes() {
		return numeroSobresalientes;
	}

	public void setNumeroSobresalientes(String numeroSobresalientes) {
		this.numeroSobresalientes = numeroSobresalientes;
	}

	public Date getNumeroNotables() {
		return numeroNotables;
	}

	public void setNumeroNotables(Date numeroNotables) {
		this.numeroNotables = numeroNotables;
	}
}
