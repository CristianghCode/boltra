package es.sms.bolsa.model.entity;
import java.io.Serializable;

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
@Table(name = "BT_BOLSATRAB")
public class BolsaTrab implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BT_SQ_BOLSATRAB")
    @SequenceGenerator(name = "BT_SQ_BOLSATRAB")
    @Column(name = "BT_CODBOL")
    private Long codigo;
    
    @Column(name = "BT_DENBOL")
    private String descripcion;

    @Column(name = "BT_DENCOR")
    private String descripcionCorta;

    @Column(name = "BT_CERTAPTO")
    private String btCertApto;
    
    @ManyToOne
    @JoinColumn(name = "BT_CODOPC")
    private Opcion opcion;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getBtCertApto() {
		return btCertApto;
	}

	public void setBtCertApto(String btCertApto) {
		this.btCertApto = btCertApto;
	}

	public Opcion getOpcion() {
		return opcion;
	}

	public void setOpcion(Opcion opcion) {
		this.opcion = opcion;
	}
	
	

	public String getDescripcionCorta() {
		return descripcionCorta;
	}

	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((btCertApto == null) ? 0 : btCertApto.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((descripcionCorta == null) ? 0 : descripcionCorta.hashCode());
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
		BolsaTrab other = (BolsaTrab) obj;
		if (btCertApto == null) {
			if (other.btCertApto != null)
				return false;
		} else if (!btCertApto.equals(other.btCertApto))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (descripcionCorta == null) {
			if (other.descripcionCorta != null)
				return false;
		} else if (!descripcionCorta.equals(other.descripcionCorta))
			return false;
		return true;
	}

	

	
    
    
}
