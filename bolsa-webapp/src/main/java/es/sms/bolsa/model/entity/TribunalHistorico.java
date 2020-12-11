package es.sms.bolsa.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "BTW_BT_TRIBUNAL_HISTORICO")
public class TribunalHistorico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_tribunal_hist")
	@SequenceGenerator(
			name="sec_tribunal_hist", sequenceName = "BOLTRA.SEQ_TRIBUNAL_HISTORICO",
		    allocationSize = 1
		)
	@Column(name = "ID")
	private Long id;

	@Column(name = "ID_TRIBUNAL")
	private Long idTribunal;
	
	@Column(name = "ID_USUARIO")
	private String idUsuario;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHA_MODIFICACION", insertable=false)
	private Date fechaModificacion;
	
	@Column(name = "TIPO_MERITO")
	private String tipoMerito;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdTribunal() {
		return idTribunal;
	}

	public void setIdTribunal(Long idTribunal) {
		this.idTribunal = idTribunal;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getTipoMerito() {
		return tipoMerito;
	}

	public void setTipoMerito(String tipoMerito) {
		this.tipoMerito = tipoMerito;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechaModificacion == null) ? 0 : fechaModificacion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idTribunal == null) ? 0 : idTribunal.hashCode());
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		result = prime * result + ((tipoMerito == null) ? 0 : tipoMerito.hashCode());
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
		TribunalHistorico other = (TribunalHistorico) obj;
		if (fechaModificacion == null) {
			if (other.fechaModificacion != null)
				return false;
		} else if (!fechaModificacion.equals(other.fechaModificacion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idTribunal == null) {
			if (other.idTribunal != null)
				return false;
		} else if (!idTribunal.equals(other.idTribunal))
			return false;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		if (tipoMerito == null) {
			if (other.tipoMerito != null)
				return false;
		} else if (!tipoMerito.equals(other.tipoMerito))
			return false;
		return true;
	}
	
	
	
	

}
