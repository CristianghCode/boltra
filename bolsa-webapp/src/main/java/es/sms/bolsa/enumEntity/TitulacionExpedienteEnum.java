package es.sms.bolsa.enumEntity;

import javax.persistence.Column;

import com.google.common.collect.ImmutableList;

public enum TitulacionExpedienteEnum {
	
	NUMERO_ASIGNATURAS,NUMERO_MATRICULAS,NUMERO_SOBRESALIENTES,NUMERO_NOTABLES;
	
	public static final ImmutableList<String> NAME_ATRIBUTOS = 
			  ImmutableList.of("N�mero de asignaturas", "N�mero de matr�culas", "N�mero de sobresalientes","N�mero de notables");
	public static final int N_ATRIBUTOS_EDITABLES = 4;
}
