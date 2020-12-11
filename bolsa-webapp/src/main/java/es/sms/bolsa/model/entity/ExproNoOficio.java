package es.sms.bolsa.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BTW_BT_EXPRO_NO_OFICIO")
public class ExproNoOficio {
	
	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@Column(name = "ADMINISTRACION")
	private String andministracion;
	
	@Column(name = "PUNTO_ASISTENCIAL")
	private String puntoAsistencial;
	
	@Column(name = "FECHA_DESDE")
	private Date fechaDesde;
	
	@Column(name = "FECHA_HASTA")
	private Date fechaHasta;
	
	@Column(name = "TIPO_CONTRATO")
	private String tipoContrato;
	
	@Column(name = "CATEGORÍA")
	private String categoría;
	
	@Column(name = "HORAS_GUARDIA_REFUERZO")
	private Integer horasGuardiaRefuerzo;
	
	@Column(name = "COMUNIDAD_AUTONOMA")
	private String comunidadAutonoma;
	
	
	
	
	
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

	public String getAndministracion() {
		return andministracion;
	}

	public void setAndministracion(String andministracion) {
		this.andministracion = andministracion;
	}

	public String getPuntoAsistencial() {
		return puntoAsistencial;
	}

	public void setPuntoAsistencial(String puntoAsistencial) {
		this.puntoAsistencial = puntoAsistencial;
	}

	public Date getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Date getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public String getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public String getCategoría() {
		return categoría;
	}

	public void setCategoría(String categoría) {
		this.categoría = categoría;
	}



	public Integer getHorasGuardiaRefuerzo() {
		return horasGuardiaRefuerzo;
	}

	public void setHorasGuardiaRefuerzo(Integer horasGuardiaRefuerzo) {
		this.horasGuardiaRefuerzo = horasGuardiaRefuerzo;
	}

	public String getComunidadAutonoma() {
		return comunidadAutonoma;
	}

	public void setComunidadAutonoma(String comunidadAutonoma) {
		this.comunidadAutonoma = comunidadAutonoma;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((andministracion == null) ? 0 : andministracion.hashCode());
		result = prime * result + ((categoría == null) ? 0 : categoría.hashCode());
		result = prime * result + ((comunidadAutonoma == null) ? 0 : comunidadAutonoma.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((fechaDesde == null) ? 0 : fechaDesde.hashCode());
		result = prime * result + ((fechaHasta == null) ? 0 : fechaHasta.hashCode());
		result = prime * result + ((horasGuardiaRefuerzo == null) ? 0 : horasGuardiaRefuerzo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((puntoAsistencial == null) ? 0 : puntoAsistencial.hashCode());
		result = prime * result + ((tipoContrato == null) ? 0 : tipoContrato.hashCode());
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
		ExproNoOficio other = (ExproNoOficio) obj;
		if (andministracion == null) {
			if (other.andministracion != null)
				return false;
		} else if (!andministracion.equals(other.andministracion))
			return false;
		if (categoría == null) {
			if (other.categoría != null)
				return false;
		} else if (!categoría.equals(other.categoría))
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
		if (fechaDesde == null) {
			if (other.fechaDesde != null)
				return false;
		} else if (!fechaDesde.equals(other.fechaDesde))
			return false;
		if (fechaHasta == null) {
			if (other.fechaHasta != null)
				return false;
		} else if (!fechaHasta.equals(other.fechaHasta))
			return false;
		if (horasGuardiaRefuerzo == null) {
			if (other.horasGuardiaRefuerzo != null)
				return false;
		} else if (!horasGuardiaRefuerzo.equals(other.horasGuardiaRefuerzo))
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
		if (tipoContrato == null) {
			if (other.tipoContrato != null)
				return false;
		} else if (!tipoContrato.equals(other.tipoContrato))
			return false;
		return true;
	}

	
	

}
