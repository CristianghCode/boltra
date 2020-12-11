package es.sms.bolsa.view.oracle;

import static com.google.common.collect.ImmutableMap.toImmutableMap;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ParametrosInvocacion {

	private ReportProperties reportProperties;
	private Map<String, String> mapa;
	private static final String[][] TIPOS_REPORTS = { { "PDF", "application/pdf", "pdf" }, { "HTML", "text/html", "html" },
			{ "RTF", "text/rtf", "rtf" }, { "DELIMITEDDATA", "application/vnd.ms-excel", "xls" }, { "XML", "text/xml", "xml" } };

	private ParametrosInvocacion(Map<String, String[]> params, ReportProperties reportProperties) {
		mapa = params.entrySet()
				.stream()
				.collect(toImmutableMap(Entry::getKey, entry -> entry.getValue()[0]));
		this.reportProperties = reportProperties;
	}

	public String getServidor() {
		return reportProperties.getWebServer();
	}

	public static ParametrosInvocacion of(Map<String, String[]> params, ReportProperties reportProperties) {
		return new ParametrosInvocacion(params, reportProperties);
	}

	public String montarTipoMIME() {
		String formato = mapa.getOrDefault("formato", "PDF");
		for (int i = 0; i < TIPOS_REPORTS.length; i++) {
			if (formato.equals(TIPOS_REPORTS[i][0])) {
				return TIPOS_REPORTS[i][1];
			}
		}
		return null;
	}

	public String construirNombreFichero() {
		String formato = mapa.getOrDefault("formato", "PDF");
		String nombre = ObjectUtils.firstNonNull(mapa.get("destino"), mapa.get("report"));
		int pos = nombre.lastIndexOf('.');
		if (pos != -1) { // Quita extensi�n '.rep'.
			nombre = nombre.substring(0, pos);
		}

		for (int i = 0; i < TIPOS_REPORTS.length; i++) {
			if (formato.equals(TIPOS_REPORTS[i][0])) {
				nombre += "." + TIPOS_REPORTS[i][2];
				break;
			}
		}
		return nombre;
	}

	/**
	 * Construye la URI para llamar al servidor Oracle Reports a partir de los par�metros dados por el usuario, la
	 * aplicaci�n y los par�metros de configuraci�n de la aplicaci�n.
	 */
	public String montarURI() {
		String desType = "CACHE";
		// String desType = mapa.getOrDefault("TIPO", "CACHE");
		// TODO no est� en el mapa
		String desFormat = mapa.getOrDefault("formato", "PDF");
		// TODO no est� en el mapa
		String orientation = (mapa.get("orientacion") != null ? (mapa.get("orientacion")
				.equals("V") ? "PORTRAIT" : "LANDSCAPE") : "DEFAULT");
		int copies = Integer.parseInt(mapa.getOrDefault("copias", "1"));

		if (reportProperties.getServer() == null || reportProperties.getUserId() == null) {
			throw new IllegalStateException("No se encuentran algunos de los par�metros steria.reports.*.");
		}
		if (reportProperties.getWebCGI() == null) {
			// cgi = "/dev60cgi/rwcgi60";
		}

		String uri = reportProperties.getWebCGI() + "?server=" + reportProperties.getServer() + "&userid=" + reportProperties.getUserId() + "&report="
				+ mapa.get("report") + "&destype=" + desType + "&desformat=" + desFormat;
		if (desFormat.equalsIgnoreCase("DELIMITEDDATA")) { // Par�metros especiales para Excel.
			uri += "&delimiter=\\t&delimited_hdr=NO&mimetype=application/vnd.ms-excel";
		} else if (mapa.get("tipoProceso") == null) { // Lanzamiento as�ncrono no admite esto.
			uri += "&orientation=" + orientation + "&copies=" + copies;
		}
		for (Iterator<String> i = mapa.keySet()
				.iterator(); i.hasNext();) {
			String clave = i.next();
			String valor = mapa.get(clave);
			try {
				valor = URLEncoder.encode(valor, "ISO-8859-1");
			} catch (UnsupportedEncodingException e) {
				// Ignorar (se utilizar� valor directamente sin codificar).
			}
			uri += "&" + clave + "=" + valor;
		}
		return uri;
		// "/reports/rwservlet?server=rep_perdiguera_MED&userid=con_medicamento/alcor1@farmadesa&report=FAC2402.rep&destype=CACHE&desformat=PDF&MES_PERIODO=01&TIPO=BATCH&descrProceso=Informes+Calidad&TIPO_LISTADO=C&SENTENCIA=SELECT+++tc.cod_tipo_control+cod_tipo_control%2C+tc.des_tipo_control+des_tipo_control%2C+COUNT+%28*%29+num_recetas%2C+SUM+%28b.precio_fac%29+precio_fact%2C+SUM++%28+b.precio_fac++-+bolsa.pq_con_factura_c.f_calc_aportacion_tsi+%28b.a%F1o_bolsa%2Cb.mes_bolsa%2Cb.cod_tsi%2Cb.cn_dispensado%2Cb.cod_regimen_receta%2Cb.precio_fac%2Cb.cod_gf%29%29+gasto_previo+FROM+bolsa.fac_controles_receta+a%2C+bolsa.fac_recetas_c+b%2C+bolsa.fac_tipos_control+tc+WHERE+a.a%F1o_bolsa+%3D+b.a%F1o_bolsa+AND+a.mes_bolsa+%3D+b.mes_bolsa+AND+a.cod_tipo_recepcion+%3D+b.cod_tipo_recepcion+AND+a.num_orden+%3D+b.num_orden+AND+a.cod_tipo_control+%3D+tc.cod_tipo_control++and+a.a%F1o_bolsa+%3D+2018+AND+a.mes_bolsa+%3D+01+AND+a.cod_tipo_recepcion+%3D+1+GROUP+BY+tc.cod_tipo_control%2C+tc.des_tipo_control&ANO_PERIODO=2018&report=FAC2402.rep&DETALLE_RESUMEN=R&guardarParams=%7CANO_PERIODO%3D2018%7CMES_PERIODO%3D01%7CCOD_TIPO_RECEPCION%3D1%7CTIPO_LISTADO%3DC%7CDETALLE_RESUMEN%3DR%7CCONTROL%3D%7C&tipoProceso=6&COD_TIPO_RECEPCION=1&CONTROL=";
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		if (reportProperties != null)
			builder.append("reportProperties", reportProperties);
		if (mapa != null)
			builder.append("mapa", mapa);
		return builder.toString();
	}

	public Map<String, String> getMapa() {
		return mapa;
	}

	/**
	 * Los par�metros que determinan el contenido del report son los dados por la aplicaci�n en
	 * {@linkplain LanzarReportForm#getGuardarParams <code>guardarParams</code>} y el formato del fichero.
	 */
	public String montarParamsGuardar() {
		String params = "desFormat=" + mapa.getOrDefault("formato", "PDF");
		if (mapa.get("guardarParams") != null) {
			String[] arrayParams = mapa.get("guardarParams")
					.split("\\|");// FIXME separador pipe configurable?
			for (int i = 0; i < arrayParams.length; i++) {
				String param = arrayParams[i].trim();
				// String valor = form.getParam(param);
				params += "&" + param;// + "=" + valor;
			}
		}
		return params;
		// return
		// "desFormat=PDF&|ANO_PERIODO=2018|MES_PERIODO=01|COD_TIPO_RECEPCION=1|TIPO_LISTADO=C|DETALLE_RESUMEN=R|CONTROL=|=null";
	}

}
