package es.sms.bolsa.service;

import java.util.List;
import java.util.Optional;

import es.sms.bolsa.model.entity.TitulacionDoctorado;

public interface TitulacionDoctoradoService {
	
	TitulacionDoctorado save(TitulacionDoctorado titulacionDoctorado);
	
	List<TitulacionDoctorado> findAll();
	
	Optional<TitulacionDoctorado> findById(Long id);
	
	void delete(TitulacionDoctorado titulacionDoctorado);

}
