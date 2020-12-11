package es.sms.bolsa.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BTW_BT_FICHERO")
public class Fichero implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "DNI")
	private String dni;

	@Column(name = "NOMBRE_CARPETA")
	private String nombreCarpeta;

	@Column(name = "NOMBRE_ORIGINAL")
	private String nombreOriginal;
	
	@Column(name = "ID_FICHERO_MC")
	private Long idFicheroMC;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombreCarpeta() {
		return nombreCarpeta;
	}

	public void setNombreCarpeta(String nombreCarpeta) {
		this.nombreCarpeta = nombreCarpeta;
	}

	public String getNombreOriginal() {
		return nombreOriginal;
	}

	public void setNombreOriginal(String nombreOriginal) {
		this.nombreOriginal = nombreOriginal;
	}

	public Long getIdFicheroMC() {
		return idFicheroMC;
	}

	public void setIdFicheroMC(Long idFicheroMC) {
		this.idFicheroMC = idFicheroMC;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idFicheroMC == null) ? 0 : idFicheroMC.hashCode());
		result = prime * result + ((nombreCarpeta == null) ? 0 : nombreCarpeta.hashCode());
		result = prime * result + ((nombreOriginal == null) ? 0 : nombreOriginal.hashCode());
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
		Fichero other = (Fichero) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idFicheroMC == null) {
			if (other.idFicheroMC != null)
				return false;
		} else if (!idFicheroMC.equals(other.idFicheroMC))
			return false;
		if (nombreCarpeta == null) {
			if (other.nombreCarpeta != null)
				return false;
		} else if (!nombreCarpeta.equals(other.nombreCarpeta))
			return false;
		if (nombreOriginal == null) {
			if (other.nombreOriginal != null)
				return false;
		} else if (!nombreOriginal.equals(other.nombreOriginal))
			return false;
		return true;
	}
	
	
	
	

}
