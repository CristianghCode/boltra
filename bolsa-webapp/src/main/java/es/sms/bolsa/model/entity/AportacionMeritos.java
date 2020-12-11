package es.sms.bolsa.model.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "BTW_BT_APORTACION_MERITO")
public class AportacionMeritos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "AM_CODAPO")
    private Long codigoAportacionMeritos;
    
    @Column(name = "AM_CONVID")
    private Long identificadorConvocatoriaGestion;

    @OneToOne
    @JoinColumn(name = "AM_INID")
    private Interesado interesado;

    @ManyToOne
  	@JoinColumn(name="AM_CONVID_VALORAR")
    private Convocatoria convocatoria;
    
    @Column(name = "AM_NIF")
    private String nifInteresado;
    
    @Column(name="AM_FECHAGRA")
    private Date fechaGrabacion;
    
    @Column(name="AM_USUAGRA")
    private String usuarioGrabacion;
    
    @Column(name="AM_TICKET")
    private String ticketSIFE;

    @Column(name="AM_ASIENTO")
    private String asientoCARM;
    
    @Column(name="AM_LIBRO")
    private Integer libroRegistroCARM;

    @Column(name="AM_FECREG")
    private Date fechaRegistroEnRegistroCARM;
    
    @Column(name="AM_FECDEC")
    private Date fechaDecretadoEnRegistroCARM;
    
    @OneToMany(mappedBy="aportacionMeritos", fetch = FetchType.EAGER)
    private List<AportacionMeritosItem> aportacionMeritosItems;

	public Long getCodigoAportacionMeritos() {
		return codigoAportacionMeritos;
	}

	public void setCodigoAportacionMeritos(Long codigoAportacionMeritos) {
		this.codigoAportacionMeritos = codigoAportacionMeritos;
	}

	public Long getIdentificadorConvocatoriaGestion() {
		return identificadorConvocatoriaGestion;
	}

	public void setIdentificadorConvocatoriaGestion(Long identificadorConvocatoriaGestion) {
		this.identificadorConvocatoriaGestion = identificadorConvocatoriaGestion;
	}

	public Interesado getInteresado() {
		return interesado;
	}

	public void setInteresado(Interesado interesado) {
		this.interesado = interesado;
	}

	public Convocatoria getConvocatoria() {
		return convocatoria;
	}

	public void setConvocatoria(Convocatoria convocatoria) {
		this.convocatoria = convocatoria;
	}

	public String getNifInteresado() {
		return nifInteresado;
	}

	public void setNifInteresado(String nifInteresado) {
		this.nifInteresado = nifInteresado;
	}

	public Date getFechaGrabacion() {
		return fechaGrabacion;
	}

	public void setFechaGrabacion(Date fechaGrabacion) {
		this.fechaGrabacion = fechaGrabacion;
	}

	public String getUsuarioGrabacion() {
		return usuarioGrabacion;
	}

	public void setUsuarioGrabacion(String usuarioGrabacion) {
		this.usuarioGrabacion = usuarioGrabacion;
	}

	public String getTicketSIFE() {
		return ticketSIFE;
	}

	public void setTicketSIFE(String ticketSIFE) {
		this.ticketSIFE = ticketSIFE;
	}

	public String getAsientoCARM() {
		return asientoCARM;
	}

	public void setAsientoCARM(String asientoCARM) {
		this.asientoCARM = asientoCARM;
	}

	public Integer getLibroRegistroCARM() {
		return libroRegistroCARM;
	}

	public void setLibroRegistroCARM(Integer libroRegistroCARM) {
		this.libroRegistroCARM = libroRegistroCARM;
	}

	public Date getFechaRegistroEnRegistroCARM() {
		return fechaRegistroEnRegistroCARM;
	}

	public void setFechaRegistroEnRegistroCARM(Date fechaRegistroEnRegistroCARM) {
		this.fechaRegistroEnRegistroCARM = fechaRegistroEnRegistroCARM;
	}

	public Date getFechaDecretadoEnRegistroCARM() {
		return fechaDecretadoEnRegistroCARM;
	}

	public void setFechaDecretadoEnRegistroCARM(Date fechaDecretadoEnRegistroCARM) {
		this.fechaDecretadoEnRegistroCARM = fechaDecretadoEnRegistroCARM;
	}

	public List<AportacionMeritosItem> getAportacionMeritosItems() {
		return aportacionMeritosItems;
	}

	public void setAportacionMeritosItems(List<AportacionMeritosItem> aportacionMeritosItems) {
		this.aportacionMeritosItems = aportacionMeritosItems;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aportacionMeritosItems == null) ? 0 : aportacionMeritosItems.hashCode());
		result = prime * result + ((asientoCARM == null) ? 0 : asientoCARM.hashCode());
		result = prime * result + ((codigoAportacionMeritos == null) ? 0 : codigoAportacionMeritos.hashCode());
		result = prime * result + ((convocatoria == null) ? 0 : convocatoria.hashCode());
		result = prime * result
				+ ((fechaDecretadoEnRegistroCARM == null) ? 0 : fechaDecretadoEnRegistroCARM.hashCode());
		result = prime * result + ((fechaGrabacion == null) ? 0 : fechaGrabacion.hashCode());
		result = prime * result + ((fechaRegistroEnRegistroCARM == null) ? 0 : fechaRegistroEnRegistroCARM.hashCode());
		result = prime * result
				+ ((identificadorConvocatoriaGestion == null) ? 0 : identificadorConvocatoriaGestion.hashCode());
		result = prime * result + ((interesado == null) ? 0 : interesado.hashCode());
		result = prime * result + ((libroRegistroCARM == null) ? 0 : libroRegistroCARM.hashCode());
		result = prime * result + ((nifInteresado == null) ? 0 : nifInteresado.hashCode());
		result = prime * result + ((ticketSIFE == null) ? 0 : ticketSIFE.hashCode());
		result = prime * result + ((usuarioGrabacion == null) ? 0 : usuarioGrabacion.hashCode());
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
		AportacionMeritos other = (AportacionMeritos) obj;
		if (aportacionMeritosItems == null) {
			if (other.aportacionMeritosItems != null)
				return false;
		} else if (!aportacionMeritosItems.equals(other.aportacionMeritosItems))
			return false;
		if (asientoCARM == null) {
			if (other.asientoCARM != null)
				return false;
		} else if (!asientoCARM.equals(other.asientoCARM))
			return false;
		if (codigoAportacionMeritos == null) {
			if (other.codigoAportacionMeritos != null)
				return false;
		} else if (!codigoAportacionMeritos.equals(other.codigoAportacionMeritos))
			return false;
		if (convocatoria == null) {
			if (other.convocatoria != null)
				return false;
		} else if (!convocatoria.equals(other.convocatoria))
			return false;
		if (fechaDecretadoEnRegistroCARM == null) {
			if (other.fechaDecretadoEnRegistroCARM != null)
				return false;
		} else if (!fechaDecretadoEnRegistroCARM.equals(other.fechaDecretadoEnRegistroCARM))
			return false;
		if (fechaGrabacion == null) {
			if (other.fechaGrabacion != null)
				return false;
		} else if (!fechaGrabacion.equals(other.fechaGrabacion))
			return false;
		if (fechaRegistroEnRegistroCARM == null) {
			if (other.fechaRegistroEnRegistroCARM != null)
				return false;
		} else if (!fechaRegistroEnRegistroCARM.equals(other.fechaRegistroEnRegistroCARM))
			return false;
		if (identificadorConvocatoriaGestion == null) {
			if (other.identificadorConvocatoriaGestion != null)
				return false;
		} else if (!identificadorConvocatoriaGestion.equals(other.identificadorConvocatoriaGestion))
			return false;
		if (interesado == null) {
			if (other.interesado != null)
				return false;
		} else if (!interesado.equals(other.interesado))
			return false;
		if (libroRegistroCARM == null) {
			if (other.libroRegistroCARM != null)
				return false;
		} else if (!libroRegistroCARM.equals(other.libroRegistroCARM))
			return false;
		if (nifInteresado == null) {
			if (other.nifInteresado != null)
				return false;
		} else if (!nifInteresado.equals(other.nifInteresado))
			return false;
		if (ticketSIFE == null) {
			if (other.ticketSIFE != null)
				return false;
		} else if (!ticketSIFE.equals(other.ticketSIFE))
			return false;
		if (usuarioGrabacion == null) {
			if (other.usuarioGrabacion != null)
				return false;
		} else if (!usuarioGrabacion.equals(other.usuarioGrabacion))
			return false;
		return true;
	}
    
    
    
}
