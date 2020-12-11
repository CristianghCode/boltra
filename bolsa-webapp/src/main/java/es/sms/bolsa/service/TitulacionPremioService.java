package es.sms.bolsa.service;

import java.util.List;
import java.util.Optional;

import es.sms.bolsa.model.entity.TitulacionPremio;

public interface TitulacionPremioService {
	
	TitulacionPremio save(TitulacionPremio titulacionPremio);
	
	List<TitulacionPremio> findAll();
	
	Optional<TitulacionPremio> findById(Long id);
	
	void delete(TitulacionPremio titulacionPremio);
	

}
