package es.sms.bolsa.oracleforms.conexion;

public class Conexion {

	private String ip;
	private String usuario;
	private String aplicacion;

	public Conexion(String usuario, String ip, String aplicacion) {
		super();
		this.ip = ip;
		this.usuario = usuario;
		this.aplicacion = aplicacion;
	}

	public String getIp() {
		return ip;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getAplicacion() {
		return aplicacion;
	}

}
