package es.sms.bolsa.enumEntity;

import com.google.common.collect.ImmutableList;

public enum InvestigacionEnum {
	
	DESCRIPCION, TIPO_ACTIVIDAD, FIRMANTE, PUBLICADO_EN, FACTOR_IMPACTO, FECHA_INICIO, FECHA_FIN;
	
	public static final ImmutableList<String> NAME_ATRIBUTOS = 
			  ImmutableList.of("Descripcion", "Tipo de actividad", "Firmante","Publicado en",
					  "Factor de impacto","Fecha de inicio", "Fecha de fin");
	public static final int N_ATRIBUTOS_EDITABLES = 7;
	
	
	


}
