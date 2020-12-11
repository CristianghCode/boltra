package es.sms.bolsa.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * Entidad donde se guardarán los puntos totales una vez esté examinados por el tribunal
 * @author Metaadmin
 *
 */
@Entity
@Table(name = "BT_PUNOBT")
@IdClass(value = PunObtPK.class)
public class PunObt implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "PO_CODBOL", insertable = false, updatable = false)
	private Long idBolsa;

	@Id
	@ManyToOne
	@JoinColumn(name = "PO_CONVID")
	private Convocatoria convocatoria;

	@Id
	@Column(name = "PO_FECVIG", insertable = false, updatable = false)
	private Date fechaVigenciaBaremo;

	@Id
	@Column(name = "PO_INID")
	private Long idInteresado;

	@Id
	@Column(name = "PO_CODMER", insertable = false, updatable = false)
	private String codigoMerito;

	@Column(name = "PO_APORTA")
	private Long cantidadHoras;

	@Column(name = "PO_PUNTOT")
	private Double puntuacionTotalObtenida;
	
	@Column(name = "PO_APORTA_OPOSITOR")
	private Long cantidadHorasOpositor;

	@Column(name = "PO_PUNTOT_OPOSITOR")
	private Double puntuacionTotalObtenidaOpositor;

	@Column(name = "PO_FECENT")
	private Date fechaEntradaRegistro;

	@Column(name = "PO_USUA")
	private String usuarioRegistro;

	@OneToOne
	@JoinColumns(value = { @JoinColumn(name = "PO_CODBOL", referencedColumnName = "ME_CODBOL"),
			@JoinColumn(name = "PO_FECVIG", referencedColumnName = "ME_FECVIG"),
			@JoinColumn(name = "PO_CODMER", referencedColumnName = "ME_CODMER") })
	private Merito merito;

	public Long getIdBolsa() {
		return idBolsa;
	}

	public void setIdBolsa(Long idBolsa) {
		this.idBolsa = idBolsa;
	}

	public Convocatoria getConvocatoria() {
		return convocatoria;
	}

	public void setConvocatoria(Convocatoria convocatoria) {
		this.convocatoria = convocatoria;
	}

	public Date getFechaVigenciaBaremo() {
		return fechaVigenciaBaremo;
	}

	public void setFechaVigenciaBaremo(Date fechaVigenciaBaremo) {
		this.fechaVigenciaBaremo = fechaVigenciaBaremo;
	}

	public Long getIdInteresado() {
		return idInteresado;
	}

	public void setIdInteresado(Long idInteresado) {
		this.idInteresado = idInteresado;
	}

	public String getCodigoMerito() {
		return codigoMerito;
	}

	public void setCodigoMerito(String codigoMerito) {
		this.codigoMerito = codigoMerito;
	}

	public Long getCantidadHoras() {
		return cantidadHoras;
	}

	public void setCantidadHoras(Long cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}

	public Double getPuntuacionTotalObtenida() {
		return puntuacionTotalObtenida;
	}

	public void setPuntuacionTotalObtenida(Double puntuacionTotalObtenida) {
		this.puntuacionTotalObtenida = puntuacionTotalObtenida;
	}
	
	public Long getCantidadHorasOpositor() {
		return cantidadHorasOpositor;
	}

	public void setCantidadHorasOpositor(Long cantidadHorasOpositor) {
		this.cantidadHorasOpositor = cantidadHorasOpositor;
	}

	public Double getPuntuacionTotalObtenidaOpositor() {
		return puntuacionTotalObtenidaOpositor;
	}

	public void setPuntuacionTotalObtenidaOpositor(Double puntuacionTotalObtenidaOpositor) {
		this.puntuacionTotalObtenidaOpositor = puntuacionTotalObtenidaOpositor;
	}

	public Date getFechaEntradaRegistro() {
		return fechaEntradaRegistro;
	}

	public void setFechaEntradaRegistro(Date fechaEntradaRegistro) {
		this.fechaEntradaRegistro = fechaEntradaRegistro;
	}

	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public Merito getMerito() {
		return merito;
	}

	public void setMerito(Merito merito) {
		this.merito = merito;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cantidadHoras == null) ? 0 : cantidadHoras.hashCode());
		result = prime * result + ((codigoMerito == null) ? 0 : codigoMerito.hashCode());
		result = prime * result + ((convocatoria == null) ? 0 : convocatoria.hashCode());
		result = prime * result + ((fechaEntradaRegistro == null) ? 0 : fechaEntradaRegistro.hashCode());
		result = prime * result + ((fechaVigenciaBaremo == null) ? 0 : fechaVigenciaBaremo.hashCode());
		result = prime * result + ((idBolsa == null) ? 0 : idBolsa.hashCode());
		result = prime * result + ((idInteresado == null) ? 0 : idInteresado.hashCode());
		result = prime * result + ((merito == null) ? 0 : merito.hashCode());
		result = prime * result + ((puntuacionTotalObtenida == null) ? 0 : puntuacionTotalObtenida.hashCode());
		result = prime * result + ((usuarioRegistro == null) ? 0 : usuarioRegistro.hashCode());
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
		PunObt other = (PunObt) obj;
		if (cantidadHoras == null) {
			if (other.cantidadHoras != null)
				return false;
		} else if (!cantidadHoras.equals(other.cantidadHoras))
			return false;
		if (codigoMerito == null) {
			if (other.codigoMerito != null)
				return false;
		} else if (!codigoMerito.equals(other.codigoMerito))
			return false;
		if (convocatoria == null) {
			if (other.convocatoria != null)
				return false;
		} else if (!convocatoria.equals(other.convocatoria))
			return false;
		if (fechaEntradaRegistro == null) {
			if (other.fechaEntradaRegistro != null)
				return false;
		} else if (!fechaEntradaRegistro.equals(other.fechaEntradaRegistro))
			return false;
		if (fechaVigenciaBaremo == null) {
			if (other.fechaVigenciaBaremo != null)
				return false;
		} else if (!fechaVigenciaBaremo.equals(other.fechaVigenciaBaremo))
			return false;
		if (idBolsa == null) {
			if (other.idBolsa != null)
				return false;
		} else if (!idBolsa.equals(other.idBolsa))
			return false;
		if (idInteresado == null) {
			if (other.idInteresado != null)
				return false;
		} else if (!idInteresado.equals(other.idInteresado))
			return false;
		if (merito == null) {
			if (other.merito != null)
				return false;
		} else if (!merito.equals(other.merito))
			return false;
		if (puntuacionTotalObtenida == null) {
			if (other.puntuacionTotalObtenida != null)
				return false;
		} else if (!puntuacionTotalObtenida.equals(other.puntuacionTotalObtenida))
			return false;
		if (usuarioRegistro == null) {
			if (other.usuarioRegistro != null)
				return false;
		} else if (!usuarioRegistro.equals(other.usuarioRegistro))
			return false;
		return true;
	}

}
