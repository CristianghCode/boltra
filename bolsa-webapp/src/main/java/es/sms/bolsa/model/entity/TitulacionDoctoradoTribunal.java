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

@Entity
@Table(name = "BTW_BT_TIT_DOCT_TRIBUNAL")
public class TitulacionDoctoradoTribunal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_tit_doct_tribunal")
	@SequenceGenerator(
			name="sec_tit_doct_tribunal", sequenceName = "BOLTRA.SEQ_TIT_DOCT_TRIBUNAL",
		    allocationSize = 1
		)
	@Column(name = "ID")
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "ID_TIT_DOCT")
	private TitulacionDoctorado titulacionDoctorado;
	
	@Column(name = "CENTRO_EXPEDICION")
	private String centroExpedicion;

	@Column(name = "FECHA_FINALIZACION")
	private Date fechaFinalizacion;
	
	@Column(name = "CALIFICACION")
	private String calificacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TitulacionDoctorado getTitulacionDoctorado() {
		return titulacionDoctorado;
	}

	public void setTitulacionDoctorado(TitulacionDoctorado titulacionDoctorado) {
		this.titulacionDoctorado = titulacionDoctorado;
	}

	public String getCentroExpedicion() {
		return centroExpedicion;
	}

	public void setCentroExpedicion(String centroExpedicion) {
		this.centroExpedicion = centroExpedicion;
	}

	public Date getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(Date fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((calificacion == null) ? 0 : calificacion.hashCode());
		result = prime * result + ((centroExpedicion == null) ? 0 : centroExpedicion.hashCode());
		result = prime * result + ((fechaFinalizacion == null) ? 0 : fechaFinalizacion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((titulacionDoctorado == null) ? 0 : titulacionDoctorado.hashCode());
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
		TitulacionDoctoradoTribunal other = (TitulacionDoctoradoTribunal) obj;
		if (calificacion == null) {
			if (other.calificacion != null)
				return false;
		} else if (!calificacion.equals(other.calificacion))
			return false;
		if (centroExpedicion == null) {
			if (other.centroExpedicion != null)
				return false;
		} else if (!centroExpedicion.equals(other.centroExpedicion))
			return false;
		if (fechaFinalizacion == null) {
			if (other.fechaFinalizacion != null)
				return false;
		} else if (!fechaFinalizacion.equals(other.fechaFinalizacion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (titulacionDoctorado == null) {
			if (other.titulacionDoctorado != null)
				return false;
		} else if (!titulacionDoctorado.equals(other.titulacionDoctorado))
			return false;
		return true;
	}
	
	

}
