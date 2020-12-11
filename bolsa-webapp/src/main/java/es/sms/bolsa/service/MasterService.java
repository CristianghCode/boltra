package es.sms.bolsa.service;

import java.util.List;
import java.util.Optional;

import es.sms.bolsa.model.entity.Master;

public interface MasterService {

	
	Master save(Master master);
	
	List<Master> findAll();
	
	Optional<Master> findById(Long id);
	
	void delete(Master master);
}
