package es.sms.bolsa.service;

import java.util.List;
import java.util.Optional;

import es.sms.bolsa.model.entity.InternoResidente;

public interface InternoResidenteService {

	InternoResidente save(InternoResidente internoResidente);
	
	List<InternoResidente> findAll();
	
	Optional<InternoResidente> findById(Long id);
	
	void delete(InternoResidente internoResidente);
	
	
}
