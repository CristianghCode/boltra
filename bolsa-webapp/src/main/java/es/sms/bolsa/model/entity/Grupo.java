package es.sms.bolsa.model.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "BT_GRUCAT")
public class Grupo implements Serializable {

    private static final long serialVersionUID = 1L;
    

    @Id
    @Column(name = "GR_CODGRU")
    private String codigo;
    
    @Column(name = "GR_DESGRU")
    private String descripcion;

    @Column(name = "GR_DESABR")
    private String descripcionAbreviada;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcionAbreviada() {
		return descripcionAbreviada;
	}

	public void setDescripcionAbreviada(String descripcionAbreviada) {
		this.descripcionAbreviada = descripcionAbreviada;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((descripcionAbreviada == null) ? 0 : descripcionAbreviada.hashCode());
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
		Grupo other = (Grupo) obj;
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
		if (descripcionAbreviada == null) {
			if (other.descripcionAbreviada != null)
				return false;
		} else if (!descripcionAbreviada.equals(other.descripcionAbreviada))
			return false;
		return true;
	}

	
    
	
    
}
