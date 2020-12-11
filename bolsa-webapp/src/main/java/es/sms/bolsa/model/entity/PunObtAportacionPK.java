package es.sms.bolsa.model.entity;

import java.io.Serializable;
import java.util.Date;

public class PunObtAportacionPK implements Serializable {
	

	private static final long serialVersionUID = 1L;

	private Convocatoria convocatoria;

	private Date fechaVigenciaBaremo;

	private Long idInteresado;

	private String codigoMerito;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
