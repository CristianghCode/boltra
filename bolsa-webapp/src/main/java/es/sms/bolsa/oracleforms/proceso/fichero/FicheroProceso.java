package es.sms.bolsa.oracleforms.proceso.fichero;

public class FicheroProceso {

	private String nombre;
	private String mime;
	private byte[] contenido;

	private FicheroProceso(Builder builder) {
		this.nombre = builder.nombre;
		this.mime = builder.mime;
		this.contenido = builder.contenido;
	}

	public FicheroProceso() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public String getMime() {
		return mime;
	}

	public byte[] getContenido() {
		return contenido;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setMime(String mime) {
		this.mime = mime;
	}

	public void setContenido(byte[] contenido) {
		this.contenido = contenido;
	}

	public static Builder create() {
		return new Builder();
	}

	public static final class Builder {
		private String nombre;
		private String mime;
		private byte[] contenido;

		private Builder() {
		}

		public Builder withNombre(String nombre) {
			this.nombre = nombre;
			return this;
		}

		public Builder withMime(String mime) {
			this.mime = mime;
			return this;
		}

		public Builder withContenido(byte[] contenido) {
			this.contenido = contenido;
			return this;
		}

		public FicheroProceso build() {
			return new FicheroProceso(this);
		}
	}
}