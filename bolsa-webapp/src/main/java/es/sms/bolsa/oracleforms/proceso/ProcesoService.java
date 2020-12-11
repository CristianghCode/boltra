package es.sms.bolsa.oracleforms.proceso;

import java.util.List;

import es.carm.sms.lobo2.service.exception.FunctionalException;
import es.sms.bolsa.oracleforms.proceso.fichero.FicheroProceso;
import es.sms.bolsa.oracleforms.proceso.tipo.TipoProceso;

public interface ProcesoService {

	List<Proceso> recuperarByUsuarioLogado();

	List<TipoProceso> recuperarTiposProceso();

	List<Proceso> recuperarByTipo(TipoProceso tipoDeBusqueda);

	FicheroProceso recuperarFichero(Proceso proceso) throws FunctionalException;

	void borrar(Proceso proceso) throws FunctionalException;


}
