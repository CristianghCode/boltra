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
@Table(name = "BTW_BT_INV_TRIBUNAL")
public class InvestigacionTribunal {
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_inv_trib")
	@SequenceGenerator(
			name="sec_inv_trib", sequenceName = "BOLTRA.SEQ_INV_TRIBUNAL",
		    allocationSize = 1
		)
	@Column(name = "ID")
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "ID_INVESTIGACION")
	private Investigacion investigacion;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@Column(name = "TIPO_ACTIVIDAD")
	private Integer tipoActividad;
	
	@Column(name = "FIRMANTE")
	private String firmante;
	
	@Column(name = "PUBLICADO_EN")
	private String publicadoEn;
	
	@Column(name = "FACTOR_IMPACTO")
	private Integer factorImpacto;

	@Column(name = "FECHA_INICIO")
	private Date fechaInicio;
	
	@Column(name = "FECHA_FIN")
	private Date fechaFin;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Investigacion getInvestigacion() {
		return investigacion;
	}

	public void setInvestigacion(Investigacion investigacion) {
		this.investigacion = investigacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getTipoActividad() {
		return tipoActividad;
	}

	public void setTipoActividad(Integer tipoActividad) {
		this.tipoActividad = tipoActividad;
	}

	public String getFirmante() {
		return firmante;
	}

	public void setFirmante(String firmante) {
		this.firmante = firmante;
	}

	

	public String getPublicadoEn() {
		return publicadoEn;
	}

	public void setPublicadoEn(String publicadoEn) {
		this.publicadoEn = publicadoEn;
	}

	public Integer getFactorImpacto() {
		return factorImpacto;
	}

	public void setFactorImpacto(Integer factorImpacto) {
		this.factorImpacto = factorImpacto;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((factorImpacto == null) ? 0 : factorImpacto.hashCode());
		result = prime * result + ((fechaFin == null) ? 0 : fechaFin.hashCode());
		result = prime * result + ((fechaInicio == null) ? 0 : fechaInicio.hashCode());
		result = prime * result + ((firmante == null) ? 0 : firmante.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((investigacion == null) ? 0 : investigacion.hashCode());
		result = prime * result + ((publicadoEn == null) ? 0 : publicadoEn.hashCode());
		result = prime * result + ((tipoActividad == null) ? 0 : tipoActividad.hashCode());
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
		InvestigacionTribunal other = (InvestigacionTribunal) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (factorImpacto == null) {
			if (other.factorImpacto != null)
				return false;
		} else if (!factorImpacto.equals(other.factorImpacto))
			return false;
		if (fechaFin == null) {
			if (other.fechaFin != null)
				return false;
		} else if (!fechaFin.equals(other.fechaFin))
			return false;
		if (fechaInicio == null) {
			if (other.fechaInicio != null)
				return false;
		} else if (!fechaInicio.equals(other.fechaInicio))
			return false;
		if (firmante == null) {
			if (other.firmante != null)
				return false;
		} else if (!firmante.equals(other.firmante))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (investigacion == null) {
			if (other.investigacion != null)
				return false;
		} else if (!investigacion.equals(other.investigacion))
			return false;
		if (publicadoEn == null) {
			if (other.publicadoEn != null)
				return false;
		} else if (!publicadoEn.equals(other.publicadoEn))
			return false;
		if (tipoActividad == null) {
			if (other.tipoActividad != null)
				return false;
		} else if (!tipoActividad.equals(other.tipoActividad))
			return false;
		return true;
	}


	
	

}
