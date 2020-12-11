package es.sms.bolsa.oracleforms.proceso.fichero;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import es.carm.sms.lobo2.service.exception.FunctionalException;
import es.sms.bolsa.oracleforms.proceso.Proceso;
import es.sms.bolsa.oracleforms.proceso.tipo.TipoProceso.TipoReport;

@Repository
class ManagerFicheroProcesoRepository implements FicheroProcesoRepository {

	@Resource(name = "ficheroProcesoRepositoryMap")
	private Map<TipoReport, FicheroProcesoRepository> ficheroProcesoRepositories;

	@Override
	public FicheroProceso find(Proceso proceso) throws FunctionalException {
		return ficheroProcesoRepositories.get(proceso.getTipoReport())
				.find(proceso);
	}

	@Override
	public void delete(Proceso proceso) throws FunctionalException {
		ficheroProcesoRepositories.get(proceso.getTipoReport())
				.delete(proceso);
		
	}

}
