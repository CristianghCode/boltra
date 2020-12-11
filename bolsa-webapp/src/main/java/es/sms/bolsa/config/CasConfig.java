package es.sms.bolsa.config;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.cas.ServiceProperties;
import org.springframework.stereotype.Service;

/**
 * Realiza la configuraciï¿½n complementaria necesaria para CAS. <br>
 * <br>
 * El login y logout se delegan en el servicio CAS del SMS (SeSamO) con el fin de contar con la funcionalidad de Single
 * Sign On. <br>
 * El resto de la seguridad se implementa con Spring Security. <br>
 * <br>
 * La configuraciï¿½n de Spring Security y su integraciï¿½n con CAS se realiza en el fichero
 * WEB-INF/application-security.xml <br>
 * <br>
 * Para delegar el login a CAS la aplicaciï¿½n debe redirigir al usuario a una URL del tipo
 * https://url_sesamo?service=url_servicio_seguridad_de_la_aplicacion <br>
 * Ejemplo: <i>https://www-pre.sms.carm.es/sesamo?service=http://11.0-SNAPSHOT81.34.124:8080
 * /directorioweb/j_spring_cas_security_check</i> * <br>
 * <br>
 * Estas URLs se pueden configurar como variables de la aplicaciï¿½n (en application-config.properties) o del entorno
 * (variable de sistema o fichero service-properties.xml del JBoss). <br>
 * Sus nombres son <i>sms.gestorpeticiones.sesamo.url</i> y <i>sms.gestorpeticiones.service.url</i>. <br>
 * La primera estï¿½ configurada inicialmente con el valor del servicio SeSamO del entorno de Preproducciï¿½n:
 * <i>https://www-pre.sms.carm.es/sesamo</i>. <br>
 * La segunda no estï¿½ configurada inicialmente y si no se define explicitamente se construye dinamicamente con la
 * forma <i>http://ip_servidor:8080/nombre_app//j_spring_cas_security_check</i>. <br>
 * <br>
 *
 */
@Service
public class CasConfig implements Serializable {

	private static final long serialVersionUID = 301196171922520057L;
	private static final Logger LOGGER = LoggerFactory.getLogger(CasConfig.class);

	@Value("${es.sms.puertoLocal:8080}")
	private String puertoLocal;
	@Value("${es.sms.protocoloLocal:http}")
	private String protocoloLocal;

	@Value("${es.sms.service.url}")
	private String serviceUrl;
	@Value("${es.sms.sesamo.url}")
	private String sesamoUrl;
	@Value("#{servletContext.contextPath}")
	private String contextoAplicacion;

	private String urlIdentificacionCas;

	/**
	 * Construye dinï¿½micamente el bean ServiceProperties utilizado por los beans casEntryPoint y
	 * casAuthenticationProvider.
	 *
	 * @return
	 */
	@Bean
	public ServiceProperties serviceProperties() {
		ServiceProperties serviceProperties = new ServiceProperties();
		serviceProperties.setSendRenew(false);
		serviceProperties.setService(generarServiceUrl());
		return serviceProperties;
	}

	public String getUrlIdentificacionCas() {
		return urlIdentificacionCas;
	}

	/**
	 * Genera la URL donde se identifica un usuario con CAS
	 */
	@PostConstruct
	public void setUp() {
		serviceUrl = generarServiceUrl();
		LOGGER.info("Se usará la service url definida {}", serviceUrl);
		urlIdentificacionCas = generarUrlIdentificacionEnCas();
	}

	protected String generarUrlIdentificacionEnCas() {
		String url = new StringBuilder().append(sesamoUrl)
				.append("/login?service=")
				.append(serviceUrl)
				.toString();
		LOGGER.info("URL login CAS generada={}", url);
		return url;
	}

	protected String generarServiceUrl() {
		if (!StringUtils.isEmpty(serviceUrl)) {
			return serviceUrl;
		}
		LOGGER.info("No se encontró una service url definida");
		String serviceUrlLocal = generarServiceUrlLocal();
		LOGGER.info("Se generó la siguiente service url local {}", serviceUrlLocal);
		return serviceUrlLocal;
	}

	protected String generarServiceUrlLocal() {
		return new StringBuilder().append(protocoloLocal)
				.append("://")
				.append(obtenerDireccionIpPublica())
				.append(":")
				.append(puertoLocal)
				.append(contextoAplicacion)
				.append(SecurityConfig.SPRING_CAS_SECURITY_URL_CHECK)
				.toString();
	}

	private String obtenerDireccionIpPublica() {
		Enumeration<NetworkInterface> eths;

		try {
			eths = NetworkInterface.getNetworkInterfaces();
		} catch (SocketException e) {
			throw new IllegalStateException("No se pudo obtener la ip pública del servidor", e);
		}

		while (eths.hasMoreElements()) {
			Enumeration<InetAddress> inetAddresses = eths.nextElement()
					.getInetAddresses();
			while (inetAddresses.hasMoreElements()) {
				InetAddress inetAddress = inetAddresses.nextElement();
				if (!inetAddress.isLoopbackAddress()) {
					return inetAddress.getHostAddress();
				}
			}
		}

		throw new IllegalStateException("No se encontró un interfaz de red en el servidor");
	}
}
