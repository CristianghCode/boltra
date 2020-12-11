package es.sms.bolsa.oracleforms.proceso.fichero;

import es.carm.sms.lobo2.service.exception.FunctionalException;
import es.sms.bolsa.oracleforms.proceso.Proceso;

public interface FicheroProcesoRepository {

	FicheroProceso find(Proceso proceso) throws FunctionalException;

	void delete(Proceso proceso) throws FunctionalException;

}