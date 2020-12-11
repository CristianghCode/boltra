package es.sms.bolsa.service;

import java.util.List;
import java.util.Optional;

import es.sms.bolsa.model.entity.RelacionFijeza;

public interface RelacionFijezaService {
	
	RelacionFijeza save(RelacionFijeza relacionFijeza);
	
	List<RelacionFijeza> findAll();
	
	Optional<RelacionFijeza> findById(Long id);
	
	void delete(RelacionFijeza relacionFijeza);

}
