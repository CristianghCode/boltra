package es.sms.bolsa.service;

import java.util.List;
import java.util.Optional;


import es.sms.bolsa.model.entity.TitulacionDoctorado;
import es.sms.bolsa.model.entity.TitulacionDoctoradoTribunal;

public interface TitulacionDoctoradoTribunalService {

	
	TitulacionDoctoradoTribunal save(TitulacionDoctoradoTribunal titulacionDoctoradoTribunal);
	
	List<TitulacionDoctoradoTribunal> findAll();
	
	Optional<TitulacionDoctoradoTribunal> findByTitulacionDoctorado(TitulacionDoctorado titulacionDoctorado);
	
	Optional<TitulacionDoctoradoTribunal> findById(Long id);
			
	void delete(TitulacionDoctoradoTribunal titulacionDoctoradoTribunal);
	
}
