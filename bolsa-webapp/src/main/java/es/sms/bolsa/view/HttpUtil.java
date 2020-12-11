package es.sms.bolsa.view;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Incluye m�todos est�ticos de ayuda para servlets y JSPs.
 * <br><br>
 * Publicado por: $Author: ora9i $
 * Revision: $Revision: 1.2 $
 */
public class HttpUtil
{
	/**
	 * Tama�o por defecto del buffer para la descarga de ficheros al navegador.
	 */
	public static final int TAM_BUFFER_DEFECTO = 4096;


	/**
	 * Establece las cabeceras HTTP adecuadas para poder descargar un
	 * fichero desde el servidor al navegador.
	 * @param salida respuesta HTTP.
	 * @param nombreparam nombreparam del fichero (para que el usuario lo pueda guardar as�).
	 * @param tipoMime tipo MIME; null si no se conoce.
	 * @param inline si es true se intentar� abrir el fichero dentro del navegador;
	 *               si es false se obliga al usuario a guardar
	 *               el fichero o abrirlo en otra ventana.
	 */
	public static void setHeadersDownload(HttpServletResponse salida,
		String nombre, String tipoMime, boolean inline)
	{
		salida.reset();	// Elimina cabeceras de JBoss/Tomcat (provocan fallo en IE).
		salida.setContentType(getString(tipoMime, "application/octet-stream"));
		salida.addHeader("Content-Disposition",
			(inline ? "inline" : "attachment") + "; filename=\"" + nombre + "\"");
	}


	/**
	 * Descarga un fichero desde el canal de entrada dado hacia el navegador cliente.<br>
	 * Este m�todo es responsable de cerrar el canal de entrada y de gestionar
	 * toda la salida ({@link HttpServletResponse}) estableciendo cabeceras HTTP,
	 * enviando el fichero y cerrando el canal de salida.
	 * @param nombreparam el usuario podr� guardar el fichero con este nombreparam.
	 * @param tipoMime tipo MIME del fichero; si es null: "application/octect-stream".
	 * @param entrada canal de entrada desde donde se leen los datos.
	 * @param salida respuesta HTTP usada como canal de salida.
	 * @param inline si es true se intentar� abrir el fichero dentro del navegador;
	 *               si es false se obliga al usuario a guardar
	 *               el fichero o abrirlo en otra ventana.
	 * @throws AplicacionException si se produce alg�n error.
	 */
	public static void download(String nombre, String tipoMime,
		InputStream entrada, HttpServletResponse salida, boolean inline)
	{
		try {
			setHeadersDownload(salida, nombre, tipoMime, inline);
			int tamBuffer = salida.getBufferSize();
			if (tamBuffer == 0) {
				tamBuffer = TAM_BUFFER_DEFECTO;
				salida.setBufferSize(tamBuffer);
			}
			BufferedInputStream in = new BufferedInputStream(entrada, tamBuffer);
			OutputStream out = salida.getOutputStream();
			byte buffer[] = new byte[tamBuffer];
			int num = 0;
			while ((num = in.read(buffer)) > 0) {
				out.write(buffer, 0, num);
			}
			in.close();
			out.close();
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}


	/**
	 * Descarga un fichero desde el canal de entrada dado hacia el navegador cliente
	 * forzando al usuario a guardarlo o abrirlo en otra ventana.<br>
	 * Este m�todo es responsable de cerrar el canal de entrada y de gestionar
	 * toda la salida ({@link HttpServletResponse}) estableciendo cabeceras HTTP,
	 * enviando el fichero y cerrando el canal de salida.
	 * @param nombreparam el usuario podr� guardar el fichero con este nombreparam.
	 * @param tipoMime tipo MIME del fichero; si es null: "application/octect-stream".
	 * @param entrada canal de entrada desde donde se leen los datos.
	 * @param salida respuesta HTTP usada como canal de salida.
	 * @throws AplicacionException si se produce alg�n error.
	 */
	public static void download(String nombre, String tipoMime,
		InputStream entrada, HttpServletResponse salida)
	{
		download(nombre, tipoMime, entrada, salida, false);
	}






	/**
	 * Obtiene el par�metro indicado de la petici�n y lo intenta convertir a entero.
	 * @param request petici�n.
	 * @param nombreparam nombreparam del par�metro.
	 * @return valor entero del par�metro o 0 si no existe o no es un entero.
	 */
	public static int getIntParameter(HttpServletRequest request, String nombre)
	{
		return getIntParameter(request, nombre, 0);
	}


	/**
	 * Obtiene el par�metro indicado de la petici�n y lo intenta convertir a entero.
	 * @param request petici�n.
	 * @param nombreparam nombreparam del par�metro.
	 * @param defecto valor por defecto en caso de error.
	 * @return valor entero del par�metro o el valor por defecto si no existe o no es un entero.
	 */
	public static int getIntParameter(HttpServletRequest request, String nombre, int defecto)
	{
		int val = defecto;
		try {
			val = Integer.parseInt(request.getParameter(nombre));
		} catch (Exception e) {
		}
		return val;
	}


	/**
	 * Permite obtener todos los valores enteros de un par�metro multi-valor de la petici�n.<br>
	 * Se debe usar este m�todo cuando el par�metro pueda contener m�s de un valor.
	 * @param request petici�n.
	 * @param nombreparam nombreparam del par�metro.
	 * @return array de valores enteros del par�metro; null si el par�metro no existe.
	 *         Si algun valor no es entero, se asigna 0.
	 */
	public static int[] getIntParameterValues(HttpServletRequest request, String nombre)
	{
		return getIntParameterValues(request, nombre, 0);
	}


	/**
	 * Permite obtener todos los valores enteros de un par�metro multi-valor de la petici�n.<br>
	 * Se debe usar este m�todo cuando el par�metro pueda contener m�s de un valor.
	 * @param request petici�n.
	 * @param nombreparam nombreparam del par�metro.
	 * @param defecto valor por defecto en caso de error.
	 * @return array de valores enteros del par�metro; null si el par�metro no existe.
	 *         Si algun valor no es entero, se asigna el valor por defecto.
	 */
	public static int[] getIntParameterValues(HttpServletRequest request, String nombre, int defecto)
	{
		int[] vals = null;
		String[] cads = request.getParameterValues(nombre);
		if (cads != null) {
			vals = new int[cads.length];
			for (int i = 0; i < cads.length; i++) {
				try {
					vals[i] = Integer.parseInt(cads[i]);
				} catch (Exception e) {
					vals[i] = defecto;
				}
			}
			return vals;
		}
		return vals;
	}


	/**
	 * Equivale al tag <code>&lt;logic:empty&gt;</code> de Struts.<br>
	 * @param cadena cadena a evaluar si es vac�a (null o de longitud cero).
	 * @return true si la cadena es null o tiene longitud cero; false si
	 *         es una cadena con al menos un caracter.
	 */
	public static boolean isEmpty(String cadena)
	{
		return cadena == null || cadena.length() == 0;
	}


	/**
	 * Devuelve la cadena dada sin modificar excepto si es una
	 * cadena {@linkplain #isEmpty vac�a}, en cuyo caso devuelve
	 * el valor por defecto.
	 * @param cadena cadena a evaluar y devolver.
	 * @param valorDefecto valor por defecto en caso de la cadena
	 *                     sea {@linkplain #isEmpty vac�a}.
	 * @return la misma cadena si no es {@linkplain #isEmpty vac�a}
	 *         o el valor por defecto en otro caso.
	 */
	public static String getString(String cadena, String valorDefecto)
	{
		return (isEmpty(cadena) ? valorDefecto : cadena);
	}
}
