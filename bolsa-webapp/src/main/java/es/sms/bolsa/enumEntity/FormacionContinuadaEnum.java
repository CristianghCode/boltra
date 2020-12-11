package es.sms.bolsa.enumEntity;

import com.google.common.collect.ImmutableList;

public enum FormacionContinuadaEnum {
	
	TIPO_CENTRO, CENTRO_EXPEDICION, DESCRIPCION, FECHA_INICIO, FECHA_FIN, TIPO_ADJUNTO, TIPO_VALORACION, UNIDAD_VALORACION, VALORACION;
	
	public static final ImmutableList<String> NAME_ATRIBUTOS = 
			  ImmutableList.of("Tipo de Centro", "Centro de expedición", "Descripción","Fecha de inicio",
					  "Fecha de fin","Tipo de adjunto", "Tipo de valoración", "Unidad de valoracion","Valoracion");
	public static final int N_ATRIBUTOS_EDITABLES = 9;  


	
	
}
