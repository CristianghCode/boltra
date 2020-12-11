package es.sms.bolsa.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BT_MERITO")
@IdClass(value = MeritoPK.class)
public class Merito implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ME_CODBOL", insertable=false, updatable=false)
	private Long idBolsa;

	@Id
	@Column(name = "ME_FECVIG", insertable=false, updatable=false)
	private Date fechaEntradaVigor;

	@Id
	@Column(name = "ME_CODMER", insertable=false, updatable=false)
	private String idMeritos;

	@Column(name = "ME_DENMER")
	private String denominacion;
	
	@Column(name = "ME_PUNTOS")
	private Double puntosDocumentacion;
	
	@Column(name = "ME_TOPE")
	private Double topePuntos;
	
	
	@OneToOne
	@JoinColumns(value = { @JoinColumn(name = "ME_CODBOL", referencedColumnName = "ME_CODBOL"),
			@JoinColumn(name = "ME_FECVIG", referencedColumnName = "ME_FECVIG"),
			@JoinColumn(name = "ME_PADMER", referencedColumnName = "ME_CODMER") })
	private Merito padre;

	public Long getIdBolsa() {
		return idBolsa;
	}

	public void setIdBolsa(Long idBolsa) {
		this.idBolsa = idBolsa;
	}

	public Date getFechaEntradaVigor() {
		return fechaEntradaVigor;
	}

	public void setFechaEntradaVigor(Date fechaEntradaVigor) {
		this.fechaEntradaVigor = fechaEntradaVigor;
	}

	public String getIdMeritos() {
		return idMeritos;
	}

	public void setIdMeritos(String idMeritos) {
		this.idMeritos = idMeritos;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public Double getPuntosDocumentacion() {
		return puntosDocumentacion;
	}

	public void setPuntosDocumentacion(Double puntosDocumentacion) {
		this.puntosDocumentacion = puntosDocumentacion;
	}

	public Double getTopePuntos() {
		return topePuntos;
	}

	public void setTopePuntos(Double topePuntos) {
		this.topePuntos = topePuntos;
	}
	
	public Merito getPadre() {
		return padre;
	}

	public void setPadre(Merito padre) {
		this.padre = padre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((denominacion == null) ? 0 : denominacion.hashCode());
		result = prime * result + ((fechaEntradaVigor == null) ? 0 : fechaEntradaVigor.hashCode());
		result = prime * result + ((idBolsa == null) ? 0 : idBolsa.hashCode());
		result = prime * result + ((idMeritos == null) ? 0 : idMeritos.hashCode());
		result = prime * result + ((puntosDocumentacion == null) ? 0 : puntosDocumentacion.hashCode());
		result = prime * result + ((topePuntos == null) ? 0 : topePuntos.hashCode());
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
		Merito other = (Merito) obj;
		if (denominacion == null) {
			if (other.denominacion != null)
				return false;
		} else if (!denominacion.equals(other.denominacion))
			return false;
		if (fechaEntradaVigor == null) {
			if (other.fechaEntradaVigor != null)
				return false;
		} else if (!fechaEntradaVigor.equals(other.fechaEntradaVigor))
			return false;
		if (idBolsa == null) {
			if (other.idBolsa != null)
				return false;
		} else if (!idBolsa.equals(other.idBolsa))
			return false;
		if (idMeritos == null) {
			if (other.idMeritos != null)
				return false;
		} else if (!idMeritos.equals(other.idMeritos))
			return false;
		if (puntosDocumentacion == null) {
			if (other.puntosDocumentacion != null)
				return false;
		} else if (!puntosDocumentacion.equals(other.puntosDocumentacion))
			return false;
		if (topePuntos == null) {
			if (other.topePuntos != null)
				return false;
		} else if (!topePuntos.equals(other.topePuntos))
			return false;
		return true;
	}

}
