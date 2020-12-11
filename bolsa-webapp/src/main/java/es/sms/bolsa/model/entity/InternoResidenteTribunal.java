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
@Table(name = "BTW_BT_INT_RES_TRIBUNAL")
public class InternoResidenteTribunal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_int_res_tribunal")
	@SequenceGenerator(
			name="sec_int_res_tribunal", sequenceName = "BOLTRA.SEQ_INT_RES_TRIBUNAL",
		    allocationSize = 1
		)
	@Column(name = "ID")
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "ID_INTERNO_RESIDENTE")
	private InternoResidente internoResidente;

	@Column(name = "TIPO_RESIDENTE")
	private String tipoResidente;
	
	@Column(name = "ANO_EXAMEN")
	private Integer anoExamen;
	
	@Column(name = "NUM_ORDEN")
	private Integer numOrden;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public InternoResidente getInternoResidente() {
		return internoResidente;
	}

	public void setInternoResidente(InternoResidente internoResidente) {
		this.internoResidente = internoResidente;
	}

	public String getTipoResidente() {
		return tipoResidente;
	}

	public void setTipoResidente(String tipoResidente) {
		this.tipoResidente = tipoResidente;
	}

	public Integer getAnoExamen() {
		return anoExamen;
	}

	public void setAnoExamen(Integer anoExamen) {
		this.anoExamen = anoExamen;
	}

	public Integer getNumOrden() {
		return numOrden;
	}

	public void setNumOrden(Integer numOrden) {
		this.numOrden = numOrden;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anoExamen == null) ? 0 : anoExamen.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((internoResidente == null) ? 0 : internoResidente.hashCode());
		result = prime * result + ((numOrden == null) ? 0 : numOrden.hashCode());
		result = prime * result + ((tipoResidente == null) ? 0 : tipoResidente.hashCode());
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
		InternoResidenteTribunal other = (InternoResidenteTribunal) obj;
		if (anoExamen == null) {
			if (other.anoExamen != null)
				return false;
		} else if (!anoExamen.equals(other.anoExamen))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (internoResidente == null) {
			if (other.internoResidente != null)
				return false;
		} else if (!internoResidente.equals(other.internoResidente))
			return false;
		if (numOrden == null) {
			if (other.numOrden != null)
				return false;
		} else if (!numOrden.equals(other.numOrden))
			return false;
		if (tipoResidente == null) {
			if (other.tipoResidente != null)
				return false;
		} else if (!tipoResidente.equals(other.tipoResidente))
			return false;
		return true;
	}
	
}
