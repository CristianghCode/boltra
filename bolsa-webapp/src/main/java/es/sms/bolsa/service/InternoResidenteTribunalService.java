package es.sms.bolsa.service;

import java.util.List;
import java.util.Optional;


import es.sms.bolsa.model.entity.InternoResidente;
import es.sms.bolsa.model.entity.InternoResidenteTribunal;

public interface InternoResidenteTribunalService {

	InternoResidenteTribunal save(InternoResidenteTribunal internoResidenteTribunal);
	
	List<InternoResidenteTribunal> findAll();
	
	Optional<InternoResidenteTribunal> findByInternoResidente(InternoResidente internoResidente);
	
	Optional<InternoResidenteTribunal> findById(Long id);
			
	void delete(InternoResidenteTribunal internoResidenteTribunal);
}
