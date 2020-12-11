package es.sms.bolsa.service;

import java.util.List;
import java.util.Optional;

import es.sms.bolsa.model.entity.Titulacion;

public interface TitulacionService {
	
	Titulacion save(Titulacion titulacion);
	
	List<Titulacion> findAll();
	
	Optional<Titulacion> findById(Long id);
	
	void delete(Titulacion titulacion);

}
