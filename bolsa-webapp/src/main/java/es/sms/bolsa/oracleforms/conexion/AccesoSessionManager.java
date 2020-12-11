package es.sms.bolsa.oracleforms.conexion;

public interface AccesoSessionManager {

	Long abrirSesion();

	void cerrarSesion(long sesion);

	String crearConexionForms(long sesion);

}
