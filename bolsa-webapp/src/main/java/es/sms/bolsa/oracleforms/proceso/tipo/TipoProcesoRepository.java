package es.sms.bolsa.oracleforms.proceso.tipo;

import java.util.List;

public interface TipoProcesoRepository {

	List<TipoProceso> findByCodigoApp(String codigoApp);

}
