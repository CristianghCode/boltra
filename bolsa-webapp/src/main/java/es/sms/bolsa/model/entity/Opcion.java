package es.sms.bolsa.model.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "BT_OPCION")
public class Opcion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "OP_CODOPC")
    private String codigo;
    
    @Column(name = "OP_DESOPC")
    private String descripcion;


    @Column(name = "OP_TITULO")
    private String titulo;
    
    @Column(name = "OP_TIPOPC")
    private String tipoOpcion;
    
    @ManyToOne
    @JoinColumn(name = "OP_CODCAT")
    private CategoriaBolsa categoria;



	public String getDescripcion() {
		return descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTipoOpcion() {
		return tipoOpcion;
	}

	public void setTipoOpcion(String tipoOpcion) {
		this.tipoOpcion = tipoOpcion;
	}

	public CategoriaBolsa getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaBolsa categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((tipoOpcion == null) ? 0 : tipoOpcion.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Opcion other = (Opcion) obj;
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
		if (tipoOpcion == null) {
			if (other.tipoOpcion != null)
				return false;
		} else if (!tipoOpcion.equals(other.tipoOpcion))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
    
 

	
}
