package es.sms.bolsa.enumEntity;

import com.google.common.collect.ImmutableList;

public enum FormacionEspecializadaEnum {
	
	TIPO_ESPECIALIDAD, CENTRO_EXPEDICION, FECHA_FINALIZACION, VIA_ACCESO, ESPECIALISTA, 
		TIPO_ADJUNTO, TIPO_VALORACION, VALORACION_CUANTITATIVA, VALORACION_CUALITATIVA;
	
	public static final ImmutableList<String> NAME_ATRIBUTOS = 
			  ImmutableList.of("Tipo de especialidad", "Centro de expedici�n", "Fecha de finalizaci�n", 
					  "Via de acceso", "Especialista", "Tipo de adjunto", "Tipo de valoraci�n", "Valoracion cuantitativa", "Valoracion cualitativa");
	public static final int N_ATRIBUTOS_EDITABLES = 9;  


}
