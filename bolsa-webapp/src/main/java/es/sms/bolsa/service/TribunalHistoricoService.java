package es.sms.bolsa.service;

import java.util.List;
import java.util.Optional;

import es.sms.bolsa.model.entity.TribunalHistorico;

public interface TribunalHistoricoService {
	
	TribunalHistorico save(TribunalHistorico tribunalHistorico);
	
	List<TribunalHistorico> findAll();
	
	Optional<TribunalHistorico> findById(Long id);
	
	void delete(TribunalHistorico tribunalHistorico);

}
