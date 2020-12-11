package es.sms.bolsa.enumEntity;

import com.google.common.collect.ImmutableList;

public enum ExproNoOficioEnum {
	
	DESCRIPCION, ADMINISTRACION, PUNTOASISTENCIAL, FECHADESDE, 
		FECHAHASTA, TIPOCONTRATO, CATEGORÍA, HORAS_GUARDIA_REFUERZO,COMUNIDAD_AUTONOMA;
	
	public static final ImmutableList<String> NAME_ATRIBUTOS = 
			  ImmutableList.of("DESCRIPCIÓN", "ADMINISTRACIÓN", "PUNTOA SISTENCIAL", 
					  "FECHA DE INICIO", "FECHA DE FIN", "TIPO DE CONTRATO", "CATEGORÍA", "HORAS DE GUARDIA DE REFUERZO", "COMUNIDAD AUTONOMA");
	public static final int N_ATRIBUTOS_EDITABLES = 9;  


}
