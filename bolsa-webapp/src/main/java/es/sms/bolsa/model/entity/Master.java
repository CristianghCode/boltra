package es.sms.bolsa.model.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.common.collect.ImmutableList;

@Entity
@Table(name = "BTW_BT_MASTER")
public class Master extends TipoAportacionMeritosItem {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int N_ATRIBUTOS_EDITABLES = 3;  
	public static final ImmutableList<String> NAME_ATRIBUTOS = 
			  ImmutableList.of("CENTRO DE EXPEDICIÓN", "FECHA DE FINALIZACIÓN", "DESCRIPCIÓN");
	
	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "CENTRO_EXPEDICION")
	private String centroExpedicion;
	
	@Column(name = "FECHA_FINALIZACION")
	private Date fechaFinalizacion;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
		

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

	

	public String getDescripcion() {
		return descripcion;
	}

	public Date getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(Date fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((centroExpedicion == null) ? 0 : centroExpedicion.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((fechaFinalizacion == null) ? 0 : fechaFinalizacion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Master other = (Master) obj;
		if (centroExpedicion == null) {
			if (other.centroExpedicion != null)
				return false;
		} else if (!centroExpedicion.equals(other.centroExpedicion))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (fechaFinalizacion == null) {
			if (other.fechaFinalizacion != null)
				return false;
		} else if (!fechaFinalizacion.equals(other.fechaFinalizacion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
