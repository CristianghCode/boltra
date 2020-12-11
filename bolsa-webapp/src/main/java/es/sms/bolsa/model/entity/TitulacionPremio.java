package es.sms.bolsa.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BTW_BT_TIT_PREMIO")
public class TitulacionPremio {

	
	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "PREMIO_FIN_CARRERA")
	private String premioFinCarrera;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPremioFinCarrera() {
		return premioFinCarrera;
	}

	public void setPremioFinCarrera(String premioFinCarrera) {
		this.premioFinCarrera = premioFinCarrera;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((premioFinCarrera == null) ? 0 : premioFinCarrera.hashCode());
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
		TitulacionPremio other = (TitulacionPremio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (premioFinCarrera == null) {
			if (other.premioFinCarrera != null)
				return false;
		} else if (!premioFinCarrera.equals(other.premioFinCarrera))
			return false;
		return true;
	}
	
	

}
