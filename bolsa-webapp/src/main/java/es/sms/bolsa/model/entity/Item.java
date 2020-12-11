package es.sms.bolsa.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BTW_BT_ITEM")
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "DNI")
	private String dni;

	@Column(name = "ID_ITEM_MC")
	private Long idItemMiCarpeta;

	@Column(name = "FECHA_GRABACION")
	private Date fechaGrabacion;
	
	@OneToOne
	@JoinColumn(name = "ADJUNTO")
	private Fichero fichero;
	
	
	@Column(name = "TIPO")
	private String tipo;

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

	public Long getIdItemMiCarpeta() {
		return idItemMiCarpeta;
	}

	public void setIdItemMiCarpeta(Long idItemMiCarpeta) {
		this.idItemMiCarpeta = idItemMiCarpeta;
	}

	public Date getFechaGrabacion() {
		return fechaGrabacion;
	}

	public void setFechaGrabacion(Date fechaGrabacion) {
		this.fechaGrabacion = fechaGrabacion;
	}

	public Fichero getFichero() {
		return fichero;
	}

	public void setFichero(Fichero fichero) {
		this.fichero = fichero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((fechaGrabacion == null) ? 0 : fechaGrabacion.hashCode());
		result = prime * result + ((fichero == null) ? 0 : fichero.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idItemMiCarpeta == null) ? 0 : idItemMiCarpeta.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Item other = (Item) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (fechaGrabacion == null) {
			if (other.fechaGrabacion != null)
				return false;
		} else if (!fechaGrabacion.equals(other.fechaGrabacion))
			return false;
		if (fichero == null) {
			if (other.fichero != null)
				return false;
		} else if (!fichero.equals(other.fichero))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idItemMiCarpeta == null) {
			if (other.idItemMiCarpeta != null)
				return false;
		} else if (!idItemMiCarpeta.equals(other.idItemMiCarpeta))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	

	

}
