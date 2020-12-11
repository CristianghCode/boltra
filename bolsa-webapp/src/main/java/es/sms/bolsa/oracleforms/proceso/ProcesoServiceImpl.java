package es.sms.bolsa.oracleforms.proceso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.carm.sms.lobo2.service.exception.FunctionalException;
import es.sms.bolsa.common.UsuarioLogadoHolder;
import es.sms.bolsa.oracleforms.proceso.fichero.FicheroProceso;
import es.sms.bolsa.oracleforms.proceso.fichero.FicheroProcesoRepository;
import es.sms.bolsa.oracleforms.proceso.tipo.TipoProceso;
import es.sms.bolsa.oracleforms.proceso.tipo.TipoProcesoRepository;

@Service
class ProcesoServiceImpl implements ProcesoService {

	@Autowired
	private UsuarioLogadoHolder usuarioLogadoHolder;
	@Autowired
	private ProcesoRepository procesoRepository;
	@Autowired
	@Qualifier("managerFicheroProcesoRepository")
	private FicheroProcesoRepository ficheroProcesoRepository;
	@Autowired
	private TipoProcesoRepository tipoProcesoRepository;
	@Value("${es.sms.codigo}")
	private String codigoApp;

	@Override
	public List<Proceso> recuperarByUsuarioLogado() {
		return procesoRepository.findByLogin(usuarioLogadoHolder.getLogin());
	}

	@Override
	public FicheroProceso recuperarFichero(Proceso proceso) throws FunctionalException {
		return ficheroProcesoRepository.find(proceso);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void borrar(Proceso proceso) throws FunctionalException {
		procesoRepository.deleteById(proceso.getId());
		ficheroProcesoRepository.delete(proceso);
	}

	@Override
	public List<TipoProceso> recuperarTiposProceso() {
		return tipoProcesoRepository.findByCodigoApp(codigoApp);
	}

	@Override
	public List<Proceso> recuperarByTipo(TipoProceso tipo) {
		return procesoRepository.findByTipoAndCodigoApp(tipo, codigoApp);
	}
}