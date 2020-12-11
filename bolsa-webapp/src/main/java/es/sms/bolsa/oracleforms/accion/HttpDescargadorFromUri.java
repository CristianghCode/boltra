package es.sms.bolsa.oracleforms.accion;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import es.sms.bolsa.view.oracle.ParametrosInvocacion;

@Service
public class HttpDescargadorFromUri implements DescargadorFromUri{
	private static final Logger logger = LoggerFactory.getLogger(HttpDescargadorFromUri.class);

	@Override
	public InputStream descargar(ParametrosInvocacion parametrosInvocacion) {
		logger.debug("Descargando from uri: {}", parametrosInvocacion);
		try {
			int port = extraerPuerto(parametrosInvocacion.getServidor());
			java.net.URL url = new java.net.URL("http", parametrosInvocacion.getServidor(), port, parametrosInvocacion.montarURI());
			java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();
			conn.setAllowUserInteraction(false);
			conn.setDoInput(true);
			conn.setDoOutput(false);
			conn.connect();
			return conn.getInputStream();
		} catch (MalformedURLException e) {
			throw new IllegalStateException("La URL para conectarse al servidor Oracle no es v�lida.", e);
		} catch (IOException e) {
			throw new IllegalStateException("No ha sido posible conectar con el servidor Oracle.", e);
		} catch (Exception e) {
			throw new IllegalStateException("No ha sido posible construir la URL para conectarse al"
					+ " servidor Oracle. Revise el par�metro de configuraci�n " + parametrosInvocacion.getServidor(), e);
		}

	}

	private int extraerPuerto(String servidor) {
		int port = -1;
		int posDosPuntos = servidor.indexOf(":");
		if (posDosPuntos != -1) {
			port = Integer.parseInt(servidor.substring(posDosPuntos + 1));
		}
		return port;
	}

}
