package es.sms.bolsa.service;

import java.util.List;
import java.util.Optional;

import es.sms.bolsa.model.entity.Investigacion;

public interface InvestigacionService {

	Investigacion save(Investigacion investigacion);
	
	List<Investigacion> findAll();
	
	Optional<Investigacion> findById(Long id);
	
	void delete(Investigacion investigacion);
}
