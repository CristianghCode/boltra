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
@Table(name = "BTW_BT_TIT_EXPEDIENTE_TRIBUNAL")
public class TitulacionExpedienteTribunal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_tit_expediente_tribunal")
	@SequenceGenerator(
			name="sec_tit_expediente_tribunal", sequenceName = "BOLTRA.SEQ_TIT_EXPEDIENTE_TRIBUNAL",
		    allocationSize = 1
		)
	@Column(name = "ID")
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "ID_TIT_EXPEDIENTE")
	private TitulacionExpediente titulacionExpediente;
	
	
	@Column(name = "NUM_ASIGNATURAS")
	private Integer numAsignaturas;
	
	@Column(name = "NUM_MATRICULAS")
	private Integer numMatriculas;

	@Column(name = "NUM_SOBRESALIENTES")
	private Integer numSobresalientes;
	
	@Column(name = "NUM_NOTABLES")
	private Integer numNotables;

	

	public TitulacionExpediente getTitulacionExpediente() {
		return titulacionExpediente;
	}

	public void setTitulacionExpediente(TitulacionExpediente titulacionExpediente) {
		this.titulacionExpediente = titulacionExpediente;
	}

	public Integer getNumAsignaturas() {
		return numAsignaturas;
	}

	public void setNumAsignaturas(Integer numAsignaturas) {
		this.numAsignaturas = numAsignaturas;
	}

	public Integer getNumMatriculas() {
		return numMatriculas;
	}

	public void setNumMatriculas(Integer numMatriculas) {
		this.numMatriculas = numMatriculas;
	}

	public Integer getNumSobresalientes() {
		return numSobresalientes;
	}

	public void setNumSobresalientes(Integer numSobresalientes) {
		this.numSobresalientes = numSobresalientes;
	}

	public Integer getNumNotables() {
		return numNotables;
	}

	public void setNumNotables(Integer numNotables) {
		this.numNotables = numNotables;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numAsignaturas == null) ? 0 : numAsignaturas.hashCode());
		result = prime * result + ((numMatriculas == null) ? 0 : numMatriculas.hashCode());
		result = prime * result + ((numNotables == null) ? 0 : numNotables.hashCode());
		result = prime * result + ((numSobresalientes == null) ? 0 : numSobresalientes.hashCode());
		result = prime * result + ((titulacionExpediente == null) ? 0 : titulacionExpediente.hashCode());
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
		TitulacionExpedienteTribunal other = (TitulacionExpedienteTribunal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numAsignaturas == null) {
			if (other.numAsignaturas != null)
				return false;
		} else if (!numAsignaturas.equals(other.numAsignaturas))
			return false;
		if (numMatriculas == null) {
			if (other.numMatriculas != null)
				return false;
		} else if (!numMatriculas.equals(other.numMatriculas))
			return false;
		if (numNotables == null) {
			if (other.numNotables != null)
				return false;
		} else if (!numNotables.equals(other.numNotables))
			return false;
		if (numSobresalientes == null) {
			if (other.numSobresalientes != null)
				return false;
		} else if (!numSobresalientes.equals(other.numSobresalientes))
			return false;
		if (titulacionExpediente == null) {
			if (other.titulacionExpediente != null)
				return false;
		} else if (!titulacionExpediente.equals(other.titulacionExpediente))
			return false;
		return true;
	}

	
	
	
}
