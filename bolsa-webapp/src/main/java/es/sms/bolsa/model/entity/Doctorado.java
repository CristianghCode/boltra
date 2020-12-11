package es.sms.bolsa.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

public class Doctorado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "CENTRO_EXPEDICION")
	private String centroExpedicion;
	
	@Column(name = "FECHA_FINALIZACION")
	private Date fechaFinalizacion;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCentroExpedicion() {
		return centroExpedicion;
	}

	public void setCentroExpedicion(String centroExpedicion) {
		this.centroExpedicion = centroExpedicion;
	}

	public Date getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(Date fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}

	@Column(name = "CALIFICACION")
	private String calificacion;

}
