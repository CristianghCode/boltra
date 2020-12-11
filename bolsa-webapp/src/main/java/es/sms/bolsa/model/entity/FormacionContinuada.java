package es.sms.bolsa.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BTW_BT_FORMACION_CONTINUADA")
public class FormacionContinuada {
	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "TIPO_CENTRO")
	private Integer tipoCentro;
	
	@Column(name = "CENTRO_EXPEDICION")
	private String centroExpedicion;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@Column(name = "FECHA_INICIO")
	private Date fechaInicio;
	
	@Column(name = "FECHA_FIN")
	private Date fechaFin;
	
	@Column(name = "TIPO_ADJUNTO")
	private String tipoAdjunto;

	@Column(name = "TIPO_VALORACION")
	private String tipoValoracion;
	
	@Column(name = "UNIDAD_VALORACION")
	private String unidadValoracion;
	
	@Column(name = "VALORACION")
	private Integer valoracion;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getTipoCentro() {
		return tipoCentro;
	}

	public void setTipoCentro(Integer tipoCentro) {
		this.tipoCentro = tipoCentro;
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

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getTipoAdjunto() {
		return tipoAdjunto;
	}

	public void setTipoAdjunto(String tipoAdjunto) {
		this.tipoAdjunto = tipoAdjunto;
	}

	public String getTipoValoracion() {
		return tipoValoracion;
	}

	public void setTipoValoracion(String tipoValoracion) {
		this.tipoValoracion = tipoValoracion;
	}

	public String getUnidadValoracion() {
		return unidadValoracion;
	}

	public void setUnidadValoracion(String unidadValoracion) {
		this.unidadValoracion = unidadValoracion;
	}

	public Integer getValoracion() {
		return valoracion;
	}

	public void setValoracion(Integer valoracion) {
		this.valoracion = valoracion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((centroExpedicion == null) ? 0 : centroExpedicion.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((fechaFin == null) ? 0 : fechaFin.hashCode());
		result = prime * result + ((fechaInicio == null) ? 0 : fechaInicio.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((tipoAdjunto == null) ? 0 : tipoAdjunto.hashCode());
		result = prime * result + ((tipoCentro == null) ? 0 : tipoCentro.hashCode());
		result = prime * result + ((tipoValoracion == null) ? 0 : tipoValoracion.hashCode());
		result = prime * result + ((unidadValoracion == null) ? 0 : unidadValoracion.hashCode());
		result = prime * result + ((valoracion == null) ? 0 : valoracion.hashCode());
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
		FormacionContinuada other = (FormacionContinuada) obj;
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
		if (fechaFin == null) {
			if (other.fechaFin != null)
				return false;
		} else if (!fechaFin.equals(other.fechaFin))
			return false;
		if (fechaInicio == null) {
			if (other.fechaInicio != null)
				return false;
		} else if (!fechaInicio.equals(other.fechaInicio))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tipoAdjunto == null) {
			if (other.tipoAdjunto != null)
				return false;
		} else if (!tipoAdjunto.equals(other.tipoAdjunto))
			return false;
		if (tipoCentro == null) {
			if (other.tipoCentro != null)
				return false;
		} else if (!tipoCentro.equals(other.tipoCentro))
			return false;
		if (tipoValoracion == null) {
			if (other.tipoValoracion != null)
				return false;
		} else if (!tipoValoracion.equals(other.tipoValoracion))
			return false;
		if (unidadValoracion == null) {
			if (other.unidadValoracion != null)
				return false;
		} else if (!unidadValoracion.equals(other.unidadValoracion))
			return false;
		if (valoracion == null) {
			if (other.valoracion != null)
				return false;
		} else if (!valoracion.equals(other.valoracion))
			return false;
		return true;
	}


	

}
