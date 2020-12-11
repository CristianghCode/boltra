package es.sms.bolsa.oracleforms.accion;

public enum BatchRespuesta {
	LANZADO("Proceso lanzado correctamente"), LANZADO_ANTERIORMENTE("El proceso ya ha sido lanzado anteriormente"), LANZADO_ANTERIORMENTE_POR_OTRO_USUARIO("El proceso ya ha sido lanzado anteriormente por otro usuario");

	private String descripcion;

	private BatchRespuesta(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
}
