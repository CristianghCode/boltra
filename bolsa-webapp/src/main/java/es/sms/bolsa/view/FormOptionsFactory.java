package es.sms.bolsa.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import es.sms.bolsa.common.UsuarioLogadoHolder;
import es.sms.bolsa.oracleforms.conexion.AccesoSessionManager;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
class FormOptionsFactory {

	@Autowired
	private AccesoSessionManager accesoSessionManager;
	@Autowired
	private UsuarioLogadoHolder usuarioLogadoHolder;

	@Value("${es.sms.codigo}")
	private String codigoAplicacion;
	@Value("${es.sms.formsWebServer}")
	private String formsWebServer;
	@Value("${es.sms.formsSid}")
	private String formsSid;
	@Value("${es.sms.proxyHost}")
	private String proxyHost;
	@Value("${es.sms.proxyPort}")
	private String proxyPort;
	@Value("#{servletContext.contextPath}")
	private String contextoAplicacion;

	// Session-safe: Se supone que para cada sesion de usuario hay que abrir una en acceso.
	private Long sesion;
	private String hashSesion;

	public FormOptions crear(String nombreForms) {
		return FormOptions.create()
				.withCodigoAplicacion(codigoAplicacion)
				.withFormsSid(formsSid)
				.withProxyHost(proxyHost)
				.withProxyPort(proxyPort)
				.withFormsWebServer(formsWebServer)
				.withSesion(recuperarSesionForms())
				.withHashSesion(recuperarHashSesion())
				.withNombreForm(nombreForms)
				.withUrlVuelta(contextoAplicacion)
				.withUsuarioLogado(usuarioLogadoHolder.getLogin())
				.build();
	}

	private Long recuperarSesionForms() {
		if (sesion == null) {
			sesion = accesoSessionManager.abrirSesion();
		}
		return sesion;
	}

	private String recuperarHashSesion() {
		if (hashSesion == null) {
			hashSesion = accesoSessionManager.crearConexionForms(sesion);
		}
		return hashSesion;
	}

}
