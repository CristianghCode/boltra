package es.sms.bolsa.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BTW_BT_FORMACION_ESPECIALIZADA")
public class FormacionEspecializada {
		@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "TIPO_ESPECIALIDAD")
	private String tipoEspecialidad;
	
	
	@Column(name = "CENTRO_EXPEDICION")
	private String centroExpedicion;
	

	@Column(name = "FECHA_FINALIZACION")
	private Date fechaFinalizacion;
	
	
	@Column(name = "VIA_ACCESO")
	private Integer viaAcceso;

	@Column(name = "ESPECIALISTA")
	private String especialista;
	

	@Column(name = "TIPO_ADJUNTO")
	private String tipoAdjunto;
	

	@Column(name = "TIPO_VALORACION")
	private String tipoValoracion;
	

	@Column(name = "VALORACION_CUANTITATIVA")
	private Integer valoracionCuantitativa;
	

	@Column(name = "VALORACION_CUALITATIVA")
	private String valoracionCualitativa;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTipoEspecialidad() {
		return tipoEspecialidad;
	}


	public void setTipoEspecialidad(String tipoEspecialidad) {
		this.tipoEspecialidad = tipoEspecialidad;
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


	public Integer getViaAcceso() {
		return viaAcceso;
	}


	public void setViaAcceso(Integer viaAcceso) {
		this.viaAcceso = viaAcceso;
	}


	public String getEspecialista() {
		return especialista;
	}


	public void setEspecialista(String especialista) {
		this.especialista = especialista;
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


	public Integer getValoracionCuantitativa() {
		return valoracionCuantitativa;
	}


	public void setValoracionCuantitativa(Integer valoracionCuantitativa) {
		this.valoracionCuantitativa = valoracionCuantitativa;
	}


	public String getValoracionCualitativa() {
		return valoracionCualitativa;
	}


	public void setValoracionCualitativa(String valoracionCualitativa) {
		this.valoracionCualitativa = valoracionCualitativa;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((centroExpedicion == null) ? 0 : centroExpedicion.hashCode());
		result = prime * result + ((especialista == null) ? 0 : especialista.hashCode());
		result = prime * result + ((fechaFinalizacion == null) ? 0 : fechaFinalizacion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((tipoAdjunto == null) ? 0 : tipoAdjunto.hashCode());
		result = prime * result + ((tipoEspecialidad == null) ? 0 : tipoEspecialidad.hashCode());
		result = prime * result + ((tipoValoracion == null) ? 0 : tipoValoracion.hashCode());
		result = prime * result + ((valoracionCualitativa == null) ? 0 : valoracionCualitativa.hashCode());
		result = prime * result + ((valoracionCuantitativa == null) ? 0 : valoracionCuantitativa.hashCode());
		result = prime * result + ((viaAcceso == null) ? 0 : viaAcceso.hashCode());
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
		FormacionEspecializada other = (FormacionEspecializada) obj;
		if (centroExpedicion == null) {
			if (other.centroExpedicion != null)
				return false;
		} else if (!centroExpedicion.equals(other.centroExpedicion))
			return false;
		if (especialista == null) {
			if (other.especialista != null)
				return false;
		} else if (!especialista.equals(other.especialista))
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
		if (tipoAdjunto == null) {
			if (other.tipoAdjunto != null)
				return false;
		} else if (!tipoAdjunto.equals(other.tipoAdjunto))
			return false;
		if (tipoEspecialidad == null) {
			if (other.tipoEspecialidad != null)
				return false;
		} else if (!tipoEspecialidad.equals(other.tipoEspecialidad))
			return false;
		if (tipoValoracion == null) {
			if (other.tipoValoracion != null)
				return false;
		} else if (!tipoValoracion.equals(other.tipoValoracion))
			return false;
		if (valoracionCualitativa == null) {
			if (other.valoracionCualitativa != null)
				return false;
		} else if (!valoracionCualitativa.equals(other.valoracionCualitativa))
			return false;
		if (valoracionCuantitativa == null) {
			if (other.valoracionCuantitativa != null)
				return false;
		} else if (!valoracionCuantitativa.equals(other.valoracionCuantitativa))
			return false;
		if (viaAcceso == null) {
			if (other.viaAcceso != null)
				return false;
		} else if (!viaAcceso.equals(other.viaAcceso))
			return false;
		return true;
	}

	

	
	
}
