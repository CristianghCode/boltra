package es.sms.bolsa.service;

import java.util.List;
import java.util.Optional;

import es.sms.bolsa.model.entity.FormacionContinuada;

public interface FormacionContinuadaService {
	
	FormacionContinuada save(FormacionContinuada formacionContinuada);
	
	List<FormacionContinuada> findAll();
	
	Optional<FormacionContinuada> findById(Long id);
	
	void delete(FormacionContinuada formacionContinuada);

}
