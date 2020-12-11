package es.sms.bolsa.oracleforms.proceso;

import java.util.List;

import es.sms.bolsa.oracleforms.proceso.tipo.TipoProceso;

interface ProcesoRepository {

	List<Proceso> findByLogin(String login);

	void deleteById(Long id);

	List<Proceso> findByTipoAndCodigoApp(TipoProceso tipo, String codigoApp);

}
