package es.sms.bolsa.oracleforms.conexion;

public interface AccesoSessionDao {

	Long abrirSesion(Conexion conexion);

	void cerrarSesion(Long sesion);

	String crearConexionForms(String usuario, long sesion);

}
