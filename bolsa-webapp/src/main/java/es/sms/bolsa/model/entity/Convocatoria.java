package es.sms.bolsa.model.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "BT_CONVOCATORIA")
public class Convocatoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BT_SQ_BOLSATRAB")
    @SequenceGenerator(name = "BT_SQ_BOLSATRAB")
    @Column(name = "CV_ID")
    private Long id;
    
    @ManyToOne
	@JoinColumn(name="CV_CODBOL")
    private BolsaTrab bolsaTrabajo;
    
    @Column(name = "CV_DENCON")
    private String denominacion;

    
    @Column(name = "CV_FECAPE")
    private Date fechaApertura;

    @Column(name = "CV_FECCIE")
    private Date fechaCierre;
    
    @Column(name = "CV_TIPO")
    private String tipo;
    
    @Column(name = "CV_ESTADO")
    private String estado;
    
    @Column(name = "CV_FECVIG")
    private Date fechaVig;

    @Column(name = "CV_LETDES")
    private String letraDesempate;
    
    @Column(name = "CV_FECALT")
    private Date fechaAlta;
    
    @Column(name = "CV_FECINIPRE")
    private Date fechaInicioPresentacion;
    
    @Column(name = "CV_FECFINPRE")
    private Date fechaFinPresentacion;
    
    @Column(name = "CV_FECFINSUB_INS")
    private Date fechaFinSubsanacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BolsaTrab getBolsaTrabajo() {
		return bolsaTrabajo;
	}

	public void setBolsaTrabajo(BolsaTrab bolsaTrabajo) {
		this.bolsaTrabajo = bolsaTrabajo;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public Date getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public Date getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaVig() {
		return fechaVig;
	}

	public void setFechaVig(Date fechaVig) {
		this.fechaVig = fechaVig;
	}

	public String getLetraDesempate() {
		return letraDesempate;
	}

	public void setLetraDesempate(String letraDesempate) {
		this.letraDesempate = letraDesempate;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaInicioPresentacion() {
		return fechaInicioPresentacion;
	}

	public void setFechaInicioPresentacion(Date fechaInicioPresentacion) {
		this.fechaInicioPresentacion = fechaInicioPresentacion;
	}

	public Date getFechaFinPresentacion() {
		return fechaFinPresentacion;
	}

	public void setFechaFinPresentacion(Date fechaFinPresentacion) {
		this.fechaFinPresentacion = fechaFinPresentacion;
	}

	public Date getFechaFinSubsanacion() {
		return fechaFinSubsanacion;
	}

	public void setFechaFinSubsanacion(Date fechaFinSubsanacion) {
		this.fechaFinSubsanacion = fechaFinSubsanacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bolsaTrabajo == null) ? 0 : bolsaTrabajo.hashCode());
		result = prime * result + ((denominacion == null) ? 0 : denominacion.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fechaAlta == null) ? 0 : fechaAlta.hashCode());
		result = prime * result + ((fechaApertura == null) ? 0 : fechaApertura.hashCode());
		result = prime * result + ((fechaCierre == null) ? 0 : fechaCierre.hashCode());
		result = prime * result + ((fechaFinPresentacion == null) ? 0 : fechaFinPresentacion.hashCode());
		result = prime * result + ((fechaFinSubsanacion == null) ? 0 : fechaFinSubsanacion.hashCode());
		result = prime * result + ((fechaInicioPresentacion == null) ? 0 : fechaInicioPresentacion.hashCode());
		result = prime * result + ((fechaVig == null) ? 0 : fechaVig.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((letraDesempate == null) ? 0 : letraDesempate.hashCode());
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
		Convocatoria other = (Convocatoria) obj;
		if (bolsaTrabajo == null) {
			if (other.bolsaTrabajo != null)
				return false;
		} else if (!bolsaTrabajo.equals(other.bolsaTrabajo))
			return false;
		if (denominacion == null) {
			if (other.denominacion != null)
				return false;
		} else if (!denominacion.equals(other.denominacion))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (fechaAlta == null) {
			if (other.fechaAlta != null)
				return false;
		} else if (!fechaAlta.equals(other.fechaAlta))
			return false;
		if (fechaApertura == null) {
			if (other.fechaApertura != null)
				return false;
		} else if (!fechaApertura.equals(other.fechaApertura))
			return false;
		if (fechaCierre == null) {
			if (other.fechaCierre != null)
				return false;
		} else if (!fechaCierre.equals(other.fechaCierre))
			return false;
		if (fechaFinPresentacion == null) {
			if (other.fechaFinPresentacion != null)
				return false;
		} else if (!fechaFinPresentacion.equals(other.fechaFinPresentacion))
			return false;
		if (fechaFinSubsanacion == null) {
			if (other.fechaFinSubsanacion != null)
				return false;
		} else if (!fechaFinSubsanacion.equals(other.fechaFinSubsanacion))
			return false;
		if (fechaInicioPresentacion == null) {
			if (other.fechaInicioPresentacion != null)
				return false;
		} else if (!fechaInicioPresentacion.equals(other.fechaInicioPresentacion))
			return false;
		if (fechaVig == null) {
			if (other.fechaVig != null)
				return false;
		} else if (!fechaVig.equals(other.fechaVig))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (letraDesempate == null) {
			if (other.letraDesempate != null)
				return false;
		} else if (!letraDesempate.equals(other.letraDesempate))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	

	

	
    
    
}
