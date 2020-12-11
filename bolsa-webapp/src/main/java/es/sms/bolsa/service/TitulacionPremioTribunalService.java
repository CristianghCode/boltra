package es.sms.bolsa.service;

import java.util.List;
import java.util.Optional;


import es.sms.bolsa.model.entity.TitulacionPremio;
import es.sms.bolsa.model.entity.TitulacionPremioTribunal;

public interface TitulacionPremioTribunalService {
	
	TitulacionPremioTribunal save(TitulacionPremioTribunal TitulacionPremioTribunal);
	
	List<TitulacionPremioTribunal> findAll();
	
	Optional<TitulacionPremioTribunal> findByTitulacionPremio(TitulacionPremio titulacionPremio);
	
	Optional<TitulacionPremioTribunal> findById(Long id);
			
	void delete(TitulacionPremioTribunal titulacionPremioTribunal);

}
