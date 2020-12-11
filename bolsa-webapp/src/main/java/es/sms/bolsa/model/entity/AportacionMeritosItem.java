package es.sms.bolsa.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BTW_BT_APORTACION_MERITO_ITEM")
public class AportacionMeritosItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "CODAPO")
	private AportacionMeritos aportacionMeritos;

	@OneToOne
	@JoinColumn(name = "ID_ITEM")
	private Item item;

	@ManyToOne
	@JoinColumns(value = { @JoinColumn(name = "CODBOL", referencedColumnName = "ME_CODBOL"),
			@JoinColumn(name = "FECVIG", referencedColumnName = "ME_FECVIG"),
			@JoinColumn(name = "CODMER", referencedColumnName = "ME_CODMER") })
	private Merito merito;

	@ManyToOne
	@JoinColumn(name = "SITUACION")
	private Situacion situacion;

	@Column(name = "ID_ITEM_MC")
	private Long idItemMiCarpeta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AportacionMeritos getAportacionMeritos() {
		return aportacionMeritos;
	}

	public void setAportacionMeritos(AportacionMeritos aportacionMeritos) {
		this.aportacionMeritos = aportacionMeritos;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}



	public Merito getMerito() {
		return merito;
	}

	public void setMerito(Merito merito) {
		this.merito = merito;
	}

	public Situacion getSituacion() {
		return situacion;
	}

	public void setSituacion(Situacion situacion) {
		this.situacion = situacion;
	}

	public Long getIdItemMiCarpeta() {
		return idItemMiCarpeta;
	}

	public void setIdItemMiCarpeta(Long idItemMiCarpeta) {
		this.idItemMiCarpeta = idItemMiCarpeta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aportacionMeritos == null) ? 0 : aportacionMeritos.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idItemMiCarpeta == null) ? 0 : idItemMiCarpeta.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((merito == null) ? 0 : merito.hashCode());
		result = prime * result + ((situacion == null) ? 0 : situacion.hashCode());
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
		AportacionMeritosItem other = (AportacionMeritosItem) obj;
		if (aportacionMeritos == null) {
			if (other.aportacionMeritos != null)
				return false;
		} else if (!aportacionMeritos.equals(other.aportacionMeritos))
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
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (merito == null) {
			if (other.merito != null)
				return false;
		} else if (!merito.equals(other.merito))
			return false;
		if (situacion == null) {
			if (other.situacion != null)
				return false;
		} else if (!situacion.equals(other.situacion))
			return false;
		return true;
	}

}
