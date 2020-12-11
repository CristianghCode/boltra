package es.sms.bolsa.enumEntity;

import com.google.common.collect.ImmutableList;

public enum TitulacionEnum {
	
	NIVEL, RAMA, TITULACION, CENTRO_EXPEDICION, FECHA_FINALIZACION, TIPO_ADJUNTO, 
	EXPEDIENTE, CALIFICACION, DOCTORADO, TITULACION_TEXTO_LIBRE, PREMIO;
	
	public static final ImmutableList<String> NAME_ATRIBUTOS = 
			  ImmutableList.of("Nivel", "Rama", "Titulaci�n","Centro de expedici�n", "Fecha de finalizaci�n", "Tipo de adjunto", "Expediente", "Calificacion", "Doctorado", "Titulacion texto libre", "Premio" );
	public static final int N_ATRIBUTOS_EDITABLES = 11;  


}
