package es.sms.bolsa.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BTW_BT_TIT_EXPEDIENTE")
public class TitulacionExpediente {

	
	@Id
	@Column(name = "ID")
	private Long id;
	
	
	@Column(name = "NUMERO_ASIGNATURAS")
	private Integer numAsignaturas;
	
	@Column(name = "NUMERO_MATRICULAS")
	private Integer numMatriculas;

	@Column(name = "NUMERO_SOBRESALIENTES")
	private Integer numSobresalientes;
	
	@Column(name = "NUMERO_NOTABLES")
	private Integer numNotables;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numAsignaturas == null) ? 0 : numAsignaturas.hashCode());
		result = prime * result + ((numMatriculas == null) ? 0 : numMatriculas.hashCode());
		result = prime * result + ((numNotables == null) ? 0 : numNotables.hashCode());
		result = prime * result + ((numSobresalientes == null) ? 0 : numSobresalientes.hashCode());
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
		TitulacionExpediente other = (TitulacionExpediente) obj;
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
		return true;
	}



}
