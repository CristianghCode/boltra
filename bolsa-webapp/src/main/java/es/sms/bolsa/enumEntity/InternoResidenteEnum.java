package es.sms.bolsa.enumEntity;

import com.google.common.collect.ImmutableList;

public enum InternoResidenteEnum {
	
	TIPO_RESIDENTE, ANO_EXAMEN, NUM_ORDEN;
	
	public static final ImmutableList<String> NAME_ATRIBUTOS = 
			  ImmutableList.of("Tipo de residente", "Año del examen", "Número de orden");
	public static final int N_ATRIBUTOS_EDITABLES = 3;

}
