package es.sms.bolsa.config;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.context.WebApplicationContext;

import es.sms.bolsa.oracleforms.conexion.AccesoSessionManager;
import es.sms.bolsa.view.FormController;

/**
 * Se encarga de registrar el fin de sesi�n <b>Forms</b> en Acceso. <br>
 * <br>
 * 
 */
@WebListener
public class CerrarAccesoFormsSessionListener extends HttpSessionEventPublisher {

	private static final Logger logger = LoggerFactory.getLogger(CerrarAccesoFormsSessionListener.class);

	@Override
	public void sessionCreated(HttpSessionEvent sessionEvent) {
		// No se precisa de acci�n cuando se crea la session.
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		cerrarSesionAcceso(sessionEvent);
		logger.info("Sesion Forms cerrada");
	}

	private void cerrarSesionAcceso(HttpSessionEvent sessionEvent) {
		ApplicationContext appContext = getApplicationContext(sessionEvent);
		AccesoSessionManager accesoSessionManager = appContext.getBean(AccesoSessionManager.class);
		FormController formController = appContext.getBean(FormController.class);
		if (formController.getFormOptions() != null) {
			accesoSessionManager.cerrarSesion(formController.getFormOptions()
					.getSesion());
		}
	}

	private ApplicationContext getApplicationContext(HttpSessionEvent event) {
		ServletContext servletContext = event.getSession()
				.getServletContext();
		return (ApplicationContext) servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
	}
}
