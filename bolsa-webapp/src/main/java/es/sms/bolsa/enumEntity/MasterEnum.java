package es.sms.bolsa.enumEntity;

import java.util.List;

import com.google.common.collect.ImmutableList;

public enum MasterEnum {

	CENTRO_EXPEDICION, FECHA_FINALIZACION, DESCRIPCION;
	//EL ORDEN DEL ENUM DEBE SER EL MISMO QUE EL ORDEN DE LA LISTA DE NOMBRES
	public static final ImmutableList<String> NAME_ATRIBUTOS = 
			  ImmutableList.of("CENTRO DE EXPEDICIÓN", "FECHA DE FINALIZACIÓN", "DESCRIPCIÓN");
	public static final int N_ATRIBUTOS_EDITABLES = 3;  
	
	 public int getStringToOrdinal(String s)
	 {
		if(s.equals("CENTRO DE EXPEDICIÓN")) return CENTRO_EXPEDICION.ordinal();
		else if(s.equals("FECHA DE FINALIZACIÓN")) return FECHA_FINALIZACION.ordinal();
		else if(s.equals("DESCRIPCIÓN")) return DESCRIPCION.ordinal();
		
		return 0;
	 }
}
