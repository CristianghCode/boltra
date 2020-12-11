package es.sms.bolsa.enumEntity;

import com.google.common.collect.ImmutableList;

public enum RelacionFijezaEnum {
	
	DESCRIPCION, CATEGORIA, ADMINISTRACION, FECHA_TOMA_POSESION, COMUNIDAD_AUTONOMA, PUNTO_ASISTENCIAL;
	
	public static final ImmutableList<String> NAME_ATRIBUTOS = 
	  ImmutableList.of("Descripci�n", "Categoria", "Administracion", "Fecha de toma de posesi�n", "Comunidad autonoma", "Punto asistencial");
	public static final int N_ATRIBUTOS_EDITABLES = 6;


}
