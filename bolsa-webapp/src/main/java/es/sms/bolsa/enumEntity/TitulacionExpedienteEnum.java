package es.sms.bolsa.enumEntity;

import javax.persistence.Column;

import com.google.common.collect.ImmutableList;

public enum TitulacionExpedienteEnum {
	
	NUMERO_ASIGNATURAS,NUMERO_MATRICULAS,NUMERO_SOBRESALIENTES,NUMERO_NOTABLES;
	
	public static final ImmutableList<String> NAME_ATRIBUTOS = 
			  ImmutableList.of("Número de asignaturas", "Número de matrículas", "Número de sobresalientes","Número de notables");
	public static final int N_ATRIBUTOS_EDITABLES = 4;
}
