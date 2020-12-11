package es.sms.bolsa.oracleforms.accion;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.CallableStatement;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.sms.bolsa.view.oracle.ParametrosInvocacion;
import es.sms.bolsa.view.oracle.ReportProperties;

/**
 * Hilo responsable de descargar el report del servidor Oracle y guardarlo en un directorio local dado por el par�metro
 * {@link Constantes#REPORTS_DIRECTORIO}.
 */
public class HiloReport extends Thread {
	private static final Logger logger = LoggerFactory.getLogger(HiloReport.class);
	private ReportProperties reportProperties;
	private String nombreparam;
	private int codigo;
	private ParametrosInvocacion parametrosInvocacion;
	private HttpDescargadorFromUri httpDescargadorFromUri;
	private DataSource dataSource;

	public HiloReport(DataSource dataSource, ReportProperties reportProperties, String nombreparam, int codigo,
			ParametrosInvocacion parametrosInvocacion, HttpDescargadorFromUri httpDescargadorFromUri) {
		super();
		this.reportProperties = reportProperties;
		this.nombreparam = nombreparam;
		this.codigo = codigo;
		this.parametrosInvocacion = parametrosInvocacion;
		this.httpDescargadorFromUri = httpDescargadorFromUri;
		this.dataSource = dataSource;
	}

	@Override
	public void run() {
		final int TAM_BUFFER_DEFECTO = 4096;
		String error = null;
		String path = reportProperties.getDirectorio() + File.separatorChar + nombreparam;
		try (InputStream entrada = httpDescargadorFromUri.descargar(parametrosInvocacion); OutputStream salida = new FileOutputStream(path, false);) {

			logger.info("Descargando report en hilo desde http://{}", parametrosInvocacion.montarURI());

			BufferedInputStream in = new BufferedInputStream(entrada, TAM_BUFFER_DEFECTO);
			BufferedOutputStream out = new BufferedOutputStream(salida, TAM_BUFFER_DEFECTO);
			byte[] buffer = new byte[TAM_BUFFER_DEFECTO];
			int num = 0;
			while ((num = in.read(buffer)) > 0) {
				out.write(buffer, 0, num);
			}
		} catch (Exception e) {
			logger.error("HiloReport: " + e, e);
			error = e.getMessage();
		}
		guardarEstadoEjecucionPLSQL(codigo, error);
	}

	public void guardarEstadoEjecucionPLSQL(int codigo, String error) {
		try (CallableStatement cstmt = dataSource.getConnection()
				.prepareCall("{call ACCESO.PQ_LOG_PROCESOS." + (error != null ? "P_FIN_ANORMAL(?, ?)" : "P_FIN_NORMAL(?)") + "}")) {
			cstmt.setInt(1, codigo);
			if (error != null) {
				cstmt.setString(2, error);
			}
			cstmt.execute();
		} catch (Exception e) {
			logger.error("HiloReport: " + e, e);
		}
	}
}
