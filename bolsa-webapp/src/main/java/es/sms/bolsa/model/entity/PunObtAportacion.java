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
/*
 * Entidad donde se guardarán los puntos totales del opositor (antes de ser examinados por el tribunal)
 */
@Entity
@Table(name = "BTW_BT_PUNOBT_APORTACION")
@IdClass(value = PunObtAportacionPK.class)
public class PunObtAportacion implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Column(name = "PO_CODAPO", insertable = false, updatable = false)
	private Long idAportacion;

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

	@Column(name = "PO_FECENT")
	private Date fechaEntradaRegistro;

	@Column(name = "PO_USUA")
	private String usuarioRegistro;

	@OneToOne
	@JoinColumns(value = { @JoinColumn(name = "PO_CODBOL", referencedColumnName = "ME_CODBOL"),
			@JoinColumn(name = "PO_FECVIG", referencedColumnName = "ME_FECVIG"),
			@JoinColumn(name = "PO_CODMER", referencedColumnName = "ME_CODMER") })
	private Merito merito;
	
	
	
	
	
	
	public Long getIdAportacion() {
		return idAportacion;
	}

	public void setIdAportacion(Long idAportacion) {
		this.idAportacion = idAportacion;
	}

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

	
}
