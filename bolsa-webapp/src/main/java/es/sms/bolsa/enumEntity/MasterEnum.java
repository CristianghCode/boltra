package es.sms.bolsa.enumEntity;

import java.util.List;

import com.google.common.collect.ImmutableList;

public enum MasterEnum {

	CENTRO_EXPEDICION, FECHA_FINALIZACION, DESCRIPCION;
	//EL ORDEN DEL ENUM DEBE SER EL MISMO QUE EL ORDEN DE LA LISTA DE NOMBRES
	public static final ImmutableList<String> NAME_ATRIBUTOS = 
			  ImmutableList.of("CENTRO DE EXPEDICI�N", "FECHA DE FINALIZACI�N", "DESCRIPCI�N");
	public static final int N_ATRIBUTOS_EDITABLES = 3;  
	
	 public int getStringToOrdinal(String s)
	 {
		if(s.equals("CENTRO DE EXPEDICI�N")) return CENTRO_EXPEDICION.ordinal();
		else if(s.equals("FECHA DE FINALIZACI�N")) return FECHA_FINALIZACION.ordinal();
		else if(s.equals("DESCRIPCI�N")) return DESCRIPCION.ordinal();
		
		return 0;
	 }
}
