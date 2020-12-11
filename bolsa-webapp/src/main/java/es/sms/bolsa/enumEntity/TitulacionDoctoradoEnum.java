package es.sms.bolsa.enumEntity;

import com.google.common.collect.ImmutableList;

public enum TitulacionDoctoradoEnum {
	
	CENTRO_EXPEDICION, FECHA_FINALIZACION, CALIFICACION;
	
	public static final ImmutableList<String> NAME_ATRIBUTOS = 
			  ImmutableList.of("Centro de expidicion", "Fecha de finalización", "Calificación");
	public static final int N_ATRIBUTOS_EDITABLES = 3;  


}
