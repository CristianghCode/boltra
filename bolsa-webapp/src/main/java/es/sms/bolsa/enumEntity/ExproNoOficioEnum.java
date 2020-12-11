package es.sms.bolsa.enumEntity;

import com.google.common.collect.ImmutableList;

public enum ExproNoOficioEnum {
	
	DESCRIPCION, ADMINISTRACION, PUNTOASISTENCIAL, FECHADESDE, 
		FECHAHASTA, TIPOCONTRATO, CATEGOR�A, HORAS_GUARDIA_REFUERZO,COMUNIDAD_AUTONOMA;
	
	public static final ImmutableList<String> NAME_ATRIBUTOS = 
			  ImmutableList.of("DESCRIPCI�N", "ADMINISTRACI�N", "PUNTOA SISTENCIAL", 
					  "FECHA DE INICIO", "FECHA DE FIN", "TIPO DE CONTRATO", "CATEGOR�A", "HORAS DE GUARDIA DE REFUERZO", "COMUNIDAD AUTONOMA");
	public static final int N_ATRIBUTOS_EDITABLES = 9;  


}
