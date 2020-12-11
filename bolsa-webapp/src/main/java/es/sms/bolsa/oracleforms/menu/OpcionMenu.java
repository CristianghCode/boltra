package es.sms.bolsa.oracleforms.menu;

import java.util.ArrayList;
import java.util.List;

public class OpcionMenu {

	private Integer id;
	private String descripcion;
	private Integer idPadre;
	private String url;
	private Boolean oracleForm;
	private Integer orden;
	private List<OpcionMenu> opciones;

	private OpcionMenu(Builder builder) {
		this.id = builder.id;
		this.descripcion = builder.descripcion;
		this.idPadre = builder.idPadre;
		this.url = builder.url;
		this.oracleForm = builder.form;
		this.orden = builder.orden;
		this.opciones = builder.opciones;
	}

	public boolean tieneHijos() {
		return !opciones.isEmpty();
	}

	public OpcionMenu addOpcionHija(OpcionMenu opcion) {
		opciones.add(opcion);
		return this;
	}

	public Integer getId() {
		return id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Integer getIdPadre() {
		return idPadre;
	}

	public String getUrl() {
		return url;
	}

	public Boolean isOracleForm() {
		return oracleForm;
	}

	public Integer getOrden() {
		return orden;
	}

	public List<OpcionMenu> getOpciones() {
		return opciones;
	}

	public static Builder create() {
		return new Builder();
	}

	public static final class Builder {
		private static final String TIPO_ORACLE_FORM = "D";
		private Integer id;
		private String descripcion;
		private Integer idPadre;
		private String url;
		private Boolean form;
		private Integer orden;
		private List<OpcionMenu> opciones = new ArrayList<>();

		private Builder() {
		}

		public Builder withId(Integer id) {
			this.id = id;
			return this;
		}

		public Builder withDescripcion(String descripcion) {
			this.descripcion = descripcion;
			return this;
		}

		public Builder withIdPadre(Integer idPadre) {
			if (idPadre.equals(0)) {
				this.idPadre = null;
			} else {
				this.idPadre = idPadre;
			}
			return this;
		}

		public Builder withUrl(String url) {
			this.url = url;
			return this;
		}

		public Builder withTipo(String tipo) {
			if (TIPO_ORACLE_FORM.equals(tipo)) {
				this.form = true;
			}else {
				this.form = false;
			}
			return this;
		}

		public Builder withOrden(Integer orden) {
			this.orden = orden;
			return this;
		}

		public Builder withOpciones(List<OpcionMenu> opciones) {
			this.opciones = opciones;
			return this;
		}

		public OpcionMenu build() {
			return new OpcionMenu(this);
		}
	}

	public Boolean isRaiz() {
		return idPadre == null;
	}
}
