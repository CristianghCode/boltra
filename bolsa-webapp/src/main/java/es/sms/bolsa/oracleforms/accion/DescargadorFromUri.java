package es.sms.bolsa.oracleforms.accion;

import java.io.InputStream;

import es.sms.bolsa.view.oracle.ParametrosInvocacion;

public interface DescargadorFromUri {

	InputStream descargar(ParametrosInvocacion parametrosInvocacion);

}
