package es.sms.bolsa.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "BTW_BT_TIT_PREMIO_TRIBUNAL")
public class TitulacionPremioTribunal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_tit_premio_tribunal")
	@SequenceGenerator(
			name="sec_tit_premio_tribunal", sequenceName = "BOLTRA.SEQ_TIT_PREMIO_TRIBUNAL",
		    allocationSize = 1
		)
	@Column(name = "ID")
	private Long id;
	
	
	@OneToOne
	@JoinColumn(name = "ID_TIT_PREMIO")
	private TitulacionPremio titulacionPremio;
	
	@Column(name = "PREMIO_FIN_CARRERA")
	private String premioFinCarrera;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TitulacionPremio getTitulacionPremio() {
		return titulacionPremio;
	}

	public void setTitulacionPremio(TitulacionPremio titulacionPremio) {
		this.titulacionPremio = titulacionPremio;
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
		result = prime * result + ((titulacionPremio == null) ? 0 : titulacionPremio.hashCode());
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
		TitulacionPremioTribunal other = (TitulacionPremioTribunal) obj;
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
		if (titulacionPremio == null) {
			if (other.titulacionPremio != null)
				return false;
		} else if (!titulacionPremio.equals(other.titulacionPremio))
			return false;
		return true;
	}
	
	
	
	

}
