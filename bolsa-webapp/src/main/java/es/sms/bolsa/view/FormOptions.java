package es.sms.bolsa.view;

public class FormOptions {

	private Long sesion;
	private String hashSesion;
	private String formsWebServer;
	private String formsSid;
	private String proxyHost;
	private String proxyPort;
	private String codigoAplicacion;
	private String nombreForm;
	private String usuarioLogado;
	private String urlVuelta;

	private FormOptions(Builder builder) {
		this.sesion = builder.sesion;
		this.hashSesion = builder.hashSesion;
		this.formsWebServer = builder.formsWebServer;
		this.formsSid = builder.formsSid;
		this.proxyHost = builder.proxyHost;
		this.proxyPort = builder.proxyPort;
		this.codigoAplicacion = builder.codigoAplicacion;
		this.nombreForm = builder.nombreForm;
		this.usuarioLogado = builder.usuarioLogado;
		this.urlVuelta = builder.urlVuelta;
	}
	
	public Long getSesion() {
		return sesion;
	}
	public String getHashSesion() {
		return hashSesion;
	}
	public String getFormsWebServer() {
		return formsWebServer;
	}
	public String getFormsSid() {
		return formsSid;
	}
	public String getProxyHost() {
		return proxyHost;
	}
	public String getProxyPort() {
		return proxyPort;
	}
	public String getCodigoAplicacion() {
		return codigoAplicacion;
	}
	public String getNombreForm() {
		return nombreForm;
	}
	public String getUsuarioLogado() {
		return usuarioLogado;
	}
	public String getUrlVuelta() {
		return urlVuelta;
	}
	public static Builder create() {
		return new Builder();
	}
	public static final class Builder {
		private Long sesion;
		private String hashSesion;
		private String formsWebServer;
		private String formsSid;
		private String proxyHost;
		private String proxyPort;
		private String codigoAplicacion;
		private String nombreForm;
		private String usuarioLogado;
		private String urlVuelta;

		private Builder() {
		}

		public Builder withSesion(Long sesion) {
			this.sesion = sesion;
			return this;
		}

		public Builder withHashSesion(String hashSesion) {
			this.hashSesion = hashSesion;
			return this;
		}

		public Builder withFormsWebServer(String formsWebServer) {
			this.formsWebServer = formsWebServer;
			return this;
		}

		public Builder withFormsSid(String formsSid) {
			this.formsSid = formsSid;
			return this;
		}

		public Builder withProxyHost(String proxyHost) {
			this.proxyHost = proxyHost;
			return this;
		}

		public Builder withProxyPort(String proxyPort) {
			this.proxyPort = proxyPort;
			return this;
		}

		public Builder withCodigoAplicacion(String codigoAplicacion) {
			this.codigoAplicacion = codigoAplicacion;
			return this;
		}

		public Builder withNombreForm(String nombreForm) {
			this.nombreForm = nombreForm;
			return this;
		}

		public Builder withUsuarioLogado(String usuarioLogado) {
			this.usuarioLogado = usuarioLogado;
			return this;
		}

		public Builder withUrlVuelta(String urlVuelta) {
			this.urlVuelta = urlVuelta;
			return this;
		}

		public FormOptions build() {
			return new FormOptions(this);
		}
	}
}
