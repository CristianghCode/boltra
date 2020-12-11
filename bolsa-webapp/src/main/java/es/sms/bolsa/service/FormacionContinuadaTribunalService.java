package es.sms.bolsa.service;

import java.util.List;
import java.util.Optional;

import es.sms.bolsa.model.entity.FormacionContinuada;
import es.sms.bolsa.model.entity.FormacionContinuadaTribunal;


public interface FormacionContinuadaTribunalService {

	FormacionContinuadaTribunal save(FormacionContinuadaTribunal formacionContinuadaTribunal);
	
	List<FormacionContinuadaTribunal> findAll();
	
	Optional<FormacionContinuadaTribunal> findByFormacionContinuada(FormacionContinuada formacionContinuada);

	
	Optional<FormacionContinuadaTribunal> findById(Long id);
		
	
	void delete(FormacionContinuadaTribunal formacionContinuadaTribunal);
}
