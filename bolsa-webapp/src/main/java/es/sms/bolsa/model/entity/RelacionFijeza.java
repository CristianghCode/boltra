package es.sms.bolsa.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BTW_BT_RELACION_FIJEZA")
public class RelacionFijeza {
	
	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "DESCRIPCION")
	private String descripcion;

	@Column(name = "CATEGORIA")
	private String categoria;

	@Column(name = "ADMINISTRACION")
	private String administracion;

	@Column(name = "FECHA_TOMA_POSESION")
	private Date fechaTomaPosesion;
	
	@Column(name = "COMUNIDAD_AUTONOMA")
	private String comunidadAutonoma;
	
	@Column(name = "PUNTO_ASISTENCIAL")
	private String puntoAsistencial;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getAdministracion() {
		return administracion;
	}

	public void setAdministracion(String administracion) {
		this.administracion = administracion;
	}

	public Date getFechaTomaPosesion() {
		return fechaTomaPosesion;
	}

	public void setFechaTomaPosesion(Date fechaTomaPosesion) {
		this.fechaTomaPosesion = fechaTomaPosesion;
	}

	public String getComunidadAutonoma() {
		return comunidadAutonoma;
	}

	public void setComunidadAutonoma(String comunidadAutonoma) {
		this.comunidadAutonoma = comunidadAutonoma;
	}

	public String getPuntoAsistencial() {
		return puntoAsistencial;
	}

	public void setPuntoAsistencial(String puntoAsistencial) {
		this.puntoAsistencial = puntoAsistencial;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((administracion == null) ? 0 : administracion.hashCode());
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((comunidadAutonoma == null) ? 0 : comunidadAutonoma.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((fechaTomaPosesion == null) ? 0 : fechaTomaPosesion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((puntoAsistencial == null) ? 0 : puntoAsistencial.hashCode());
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
		RelacionFijeza other = (RelacionFijeza) obj;
		if (administracion == null) {
			if (other.administracion != null)
				return false;
		} else if (!administracion.equals(other.administracion))
			return false;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (comunidadAutonoma == null) {
			if (other.comunidadAutonoma != null)
				return false;
		} else if (!comunidadAutonoma.equals(other.comunidadAutonoma))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (fechaTomaPosesion == null) {
			if (other.fechaTomaPosesion != null)
				return false;
		} else if (!fechaTomaPosesion.equals(other.fechaTomaPosesion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (puntoAsistencial == null) {
			if (other.puntoAsistencial != null)
				return false;
		} else if (!puntoAsistencial.equals(other.puntoAsistencial))
			return false;
		return true;
	}
	
	

	
}
