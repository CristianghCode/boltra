package es.sms.bolsa.view.oracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;

import es.carm.sms.lobo2.web.jsf.MessagesController;
import es.sms.bolsa.oracleforms.accion.BatchRespuesta;
import es.sms.bolsa.oracleforms.accion.HttpDescargadorFromUri;
import es.sms.bolsa.oracleforms.accion.LanzadorBatch;

@Controller
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class InvocacionDesdeFormsManagedBean {
	private static final Logger logger = LoggerFactory.getLogger(InvocacionDesdeFormsManagedBean.class);

	@Autowired
	private HttpServletRequest httpRequest;

	@Autowired
	private ReportProperties reportProperties;

	@Autowired
	private HttpDescargadorFromUri httpDescargadorFromUri;
	@Autowired
	private LanzadorBatch lanzadorBatch;

	
	private boolean esVacio;
	private String formatoSeleccionado="PDF";
	private String numeroCopias="1";

	@Autowired
	private MessagesController messagesController;

	private String tipoInforme;
	private ParametrosInvocacion parametrosInvocacion;

	public void tratarLlamada() {
		tipoInforme = httpRequest.getParameter("TIPO");
		final String TIPO_REPORT = "REPORT"; // Tipos especiales: REPORT y DOWNLOAD.
		final String TIPO_DOWNLOAD = "DOWNLOAD";

		final String[] TIPOS = { TIPO_REPORT, "BATCH", "UPLOAD", "MULTIUPLOAD", TIPO_DOWNLOAD, "COMBINAR", "PERSAN" };
		// final String[] PATHS = { "/lanzarReport.do", "/batchReport.do", "/fileUpload.do", "/multiFileUpload.do",
		// "/fileDownload.do",
		// "/prepararCombinar.do", "/persan.do" };
		String direccion = "";
		// Resto de casos...
		// boolean esReport = tipoInforme.equals(TIPO_REPORT);
		esVacio = tipoInforme.equals(TIPO_DOWNLOAD);

		// TipoProceso de informe clicado, delegar aqu�?
		tipoInforme = tipoInforme.toUpperCase();
		// for (int i = 0; i < TIPOS.length; i++) {
		// if (TIPOS[i].equals(tipoInforme)) {
		// direccion = PATHS[i];
		// break;
		// }
		// }
		parametrosInvocacion = ParametrosInvocacion.of(httpRequest.getParameterMap(), reportProperties);
		logger.debug("Lanzando acci�n {}; path = {}, par�metros = {}", tipoInforme, direccion, parametrosInvocacion);
	}

	public void botonAceptar() {
		try {
			String servidor = reportProperties.getWebServer();
			if (servidor == null) {
				// lanzar exception configuraci�n erronea.
			}
			if ("BATCH".equals(tipoInforme)) {
				BatchRespuesta respuesta = lanzadorBatch.lanzar(parametrosInvocacion);
				messagesController.mostrarInfo(respuesta.getDescripcion());
			} else {
				httpDescargadorFromUri.descargar(parametrosInvocacion);
			}
		} catch (Exception e) {
			logger.error("Error", e);
			messagesController.mostrarError(e.getMessage());
		}
	}

	/**
	 * Comprueba si debe lanzar el report o si ya se est� generando en background.<br>
	 * En el primer caso, crea el hilo que descarga el report desde el servidor Oracle (e.d. as�ncrono).<br>
	 * En el segundo, simplemente avisa al usuario.
	 */

	protected void accesoAplicacion(Connection conn, String usuario) {
		try (CallableStatement cstmt = conn.prepareCall("begin acceso.control_accesos.g_login := ?; end;")) {
			cstmt.setString(1, usuario);
			cstmt.execute();
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public boolean isMostrarOpciones() {
		return !esVacio;
	}

	public List<SelectItem> getFormatosFichero() {
		List<SelectItem> result = new ArrayList<>();
		result.add(new SelectItem("PDF", "PDF"));
		result.add(new SelectItem("HTML", "HTML"));
		result.add(new SelectItem("RTF", "RTF (MS Word)"));
		result.add(new SelectItem("DELIMITEDDATA", "Delimitado (MS Excel)"));
		result.add(new SelectItem("XML", "XML"));
		return result;
	}

	public String getFormatoSeleccionado() {
		return formatoSeleccionado;
	}

	public void setFormatoSeleccionado(String formatoSeleccionado) {
		this.formatoSeleccionado = formatoSeleccionado;
	}

	public String getNumeroCopias() {
		return numeroCopias;
	}

	public void setNumeroCopias(String numeroCopias) {
		this.numeroCopias = numeroCopias;
	}

}
