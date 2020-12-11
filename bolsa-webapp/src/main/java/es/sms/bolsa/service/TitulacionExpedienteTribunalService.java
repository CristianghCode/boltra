package es.sms.bolsa.service;

import java.util.List;
import java.util.Optional;



import es.sms.bolsa.model.entity.TitulacionExpediente;
import es.sms.bolsa.model.entity.TitulacionExpedienteTribunal;

public interface TitulacionExpedienteTribunalService {

	
	TitulacionExpedienteTribunal save(TitulacionExpedienteTribunal titulacionExpedienteTribunal);
	
	List<TitulacionExpedienteTribunal> findAll();
	
	Optional<TitulacionExpedienteTribunal> findByTitulacionExpediente(TitulacionExpediente titulacionExpediente);

	
	Optional<TitulacionExpedienteTribunal> findById(Long id);
		
	
	void delete(TitulacionExpedienteTribunal titulacionExpedienteTribunal);
}
