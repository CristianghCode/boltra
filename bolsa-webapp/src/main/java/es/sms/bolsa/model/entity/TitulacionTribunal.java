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
@Table(name = "BTW_BT_TITULACION_TRIBUNAL")
public class TitulacionTribunal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_titulacion_tribunal")
	@SequenceGenerator(
			name="sec_titulacion_tribunal", sequenceName = "BOLTRA.SEQ_TITULACION_TRIBUNAL",
		    allocationSize = 1
		)
	@Column(name = "ID")
	private Long id;
		
	@OneToOne
	@JoinColumn(name = "ID_TITULACION")
	private TitulacionTribunal titulacionTribunal;
	
	@Column(name = "NIVEL")
	private Integer nivel;
	
	@Column(name = "RAMA")
	private Integer rama;

	@OneToOne
	@JoinColumn(name = "ID_TIT_PREMIO")
	private Titulacion titulacion;
	
	@Column(name = "CENTRO_EXPEDICION")
	private String centroExpedicion;
	
	@Column(name = "FECHA_FINALIZACION")
	private Date fechaFinalizacion;

	@Column(name = "TIPO_ADJUNTO")
	private String tipoAdjunto;
	
	@Column(name = "EXPEDIENTE")
	private Integer expediente;
	
	@Column(name = "CALIFICACION")
	private Integer calificacion;
	
	@Column(name = "DOCTORADO")
	private Integer doctorado;
	
	@Column(name = "TITULACION_TEXTO_LIBRE")
	private String titulacionTextoLibre;
	
	@Column(name = "PREMIO")
	private Integer premio;

	public Long getId() {
		return id;
	}

	public void setId(Long iD) {
		id = iD;
	}

	public TitulacionTribunal getTitulacionTribunal() {
		return titulacionTribunal;
	}

	public void setTitulacionTribunal(TitulacionTribunal titulacionTribunal) {
		this.titulacionTribunal = titulacionTribunal;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public Integer getRama() {
		return rama;
	}

	public void setRama(Integer rama) {
		this.rama = rama;
	}


	public Titulacion getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(Titulacion titulacion) {
		this.titulacion = titulacion;
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

	public String getTipoAdjunto() {
		return tipoAdjunto;
	}

	public void setTipoAdjunto(String tipoAdjunto) {
		this.tipoAdjunto = tipoAdjunto;
	}

	public Integer getExpediente() {
		return expediente;
	}

	public void setExpediente(Integer expediente) {
		this.expediente = expediente;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}

	public Integer getDoctorado() {
		return doctorado;
	}

	public void setDoctorado(Integer doctorado) {
		this.doctorado = doctorado;
	}

	public String getTitulacionTextoLibre() {
		return titulacionTextoLibre;
	}

	public void setTitulacionTextoLibre(String titulacionTextoLibre) {
		this.titulacionTextoLibre = titulacionTextoLibre;
	}

	public Integer getPremio() {
		return premio;
	}

	public void setPremio(Integer premio) {
		this.premio = premio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((calificacion == null) ? 0 : calificacion.hashCode());
		result = prime * result + ((centroExpedicion == null) ? 0 : centroExpedicion.hashCode());
		result = prime * result + ((doctorado == null) ? 0 : doctorado.hashCode());
		result = prime * result + ((expediente == null) ? 0 : expediente.hashCode());
		result = prime * result + ((fechaFinalizacion == null) ? 0 : fechaFinalizacion.hashCode());
		result = prime * result + ((nivel == null) ? 0 : nivel.hashCode());
		result = prime * result + ((premio == null) ? 0 : premio.hashCode());
		result = prime * result + ((rama == null) ? 0 : rama.hashCode());
		result = prime * result + ((tipoAdjunto == null) ? 0 : tipoAdjunto.hashCode());
		result = prime * result + ((titulacion == null) ? 0 : titulacion.hashCode());
		result = prime * result + ((titulacionTextoLibre == null) ? 0 : titulacionTextoLibre.hashCode());
		result = prime * result + ((titulacionTribunal == null) ? 0 : titulacionTribunal.hashCode());
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
		TitulacionTribunal other = (TitulacionTribunal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
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
		if (doctorado == null) {
			if (other.doctorado != null)
				return false;
		} else if (!doctorado.equals(other.doctorado))
			return false;
		if (expediente == null) {
			if (other.expediente != null)
				return false;
		} else if (!expediente.equals(other.expediente))
			return false;
		if (fechaFinalizacion == null) {
			if (other.fechaFinalizacion != null)
				return false;
		} else if (!fechaFinalizacion.equals(other.fechaFinalizacion))
			return false;
		if (nivel == null) {
			if (other.nivel != null)
				return false;
		} else if (!nivel.equals(other.nivel))
			return false;
		if (premio == null) {
			if (other.premio != null)
				return false;
		} else if (!premio.equals(other.premio))
			return false;
		if (rama == null) {
			if (other.rama != null)
				return false;
		} else if (!rama.equals(other.rama))
			return false;
		if (tipoAdjunto == null) {
			if (other.tipoAdjunto != null)
				return false;
		} else if (!tipoAdjunto.equals(other.tipoAdjunto))
			return false;
		if (titulacion == null) {
			if (other.titulacion != null)
				return false;
		} else if (!titulacion.equals(other.titulacion))
			return false;
		if (titulacionTextoLibre == null) {
			if (other.titulacionTextoLibre != null)
				return false;
		} else if (!titulacionTextoLibre.equals(other.titulacionTextoLibre))
			return false;
		if (titulacionTribunal == null) {
			if (other.titulacionTribunal != null)
				return false;
		} else if (!titulacionTribunal.equals(other.titulacionTribunal))
			return false;
		return true;
	}


	
	


}
