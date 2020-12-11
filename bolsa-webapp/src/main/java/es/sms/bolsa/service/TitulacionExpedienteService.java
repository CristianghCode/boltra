package es.sms.bolsa.service;

import java.util.List;
import java.util.Optional;

import es.sms.bolsa.model.entity.TitulacionExpediente;

public interface TitulacionExpedienteService {
	
	TitulacionExpediente save(TitulacionExpediente titulacionExpediente);
	
	List<TitulacionExpediente> findAll();
	
	Optional<TitulacionExpediente> findById(Long id);
	
	void delete(TitulacionExpediente titulacionExpediente);

}
