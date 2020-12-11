package es.sms.bolsa.view;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;

import es.carm.sms.lobo2.core.Lobo2Utils;
import es.sms.bolsa.common.UsuarioLogadoHolder;
import es.sms.bolsa.config.CasConfig;

/**
 * Controlador que gestiona las partes comunes de la vista.
 */
@Controller
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LayoutManagedBean implements Serializable {

	private static final long serialVersionUID = -1089740892220055029L;

	private FacesMessage mensajeGlobal;

	@Value("${es.sms.sesamo.url}")
	private String sesamoBaseUrl;
	@Value("${es.sms.urlSolicitarContrasena}")
	private String urlSolicitarContrasena;

	@Autowired
	private CasConfig casConfig;
	@Autowired
	private UsuarioLogadoHolder usuarioLogadoHolder;
	@Value("${es.sms.formDefault:}")
	private String formDefault;
	private Boolean redirigidoFormDefault = FALSE;

	public void redirigirDefaultFormSiProcede() throws IOException {
		if (usuarioLogadoHolder.isAuthenticated() && !redirigidoFormDefault && isNotEmpty(formDefault)) {
			redirigidoFormDefault = TRUE;
			ExternalContext ec = FacesContext.getCurrentInstance()
					.getExternalContext();
			ec.redirect(ec.getRequestContextPath() + MenuManagedBean.URL_LIST_APORTACION);
		}
	}

	public String getUrlSolicitarContrasena() {
		return urlSolicitarContrasena;
	}

	public String getContexto() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		return ec.getRequestContextPath();
	}

	public String getUserName() {
		return Lobo2Utils.getLogin();
	}

	public String getFecha() {
		return "";
	}

	public String getUrlIdentificacionCas() {
		return casConfig.getUrlIdentificacionCas();
	}

	/**
	 * Permite pintar el mensaje almacenado si existe. Una vez lo hace, lo elimina.
	 */
	public void renderizaMensajes() {
		if (mensajeGlobal != null) {
			FacesContext.getCurrentInstance()
					.addMessage(null, mensajeGlobal);
			mensajeGlobal = null;
		}
	}

	/** Permite almacenar un mensaje para mostrarlo cuando se necesite */
	public void addMensaje(FacesMessage.Severity severity, String summary) {
		mensajeGlobal = new FacesMessage();
		mensajeGlobal.setSeverity(severity);
		mensajeGlobal.setSummary(summary);
	}

}
