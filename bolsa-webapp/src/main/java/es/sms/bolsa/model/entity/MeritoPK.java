package es.sms.bolsa.model.entity;

import java.io.Serializable;
import java.util.Date;


public class MeritoPK implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private Long idBolsa;

	
	private Date fechaEntradaVigor;

	
	private String idMeritos;

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

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechaEntradaVigor == null) ? 0 : fechaEntradaVigor.hashCode());
		result = prime * result + ((idBolsa == null) ? 0 : idBolsa.hashCode());
		result = prime * result + ((idMeritos == null) ? 0 : idMeritos.hashCode());
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
		MeritoPK other = (MeritoPK) obj;
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
		return true;
	}

}
