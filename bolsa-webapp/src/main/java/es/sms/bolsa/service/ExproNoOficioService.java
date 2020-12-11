package es.sms.bolsa.service;

import java.util.List;
import java.util.Optional;

import es.sms.bolsa.model.entity.ExproNoOficio;

public interface ExproNoOficioService {
	
	
	ExproNoOficio save(ExproNoOficio exproNoOficio);
	
	List<ExproNoOficio> findAll();
	
	Optional<ExproNoOficio> findById(Long id);
	
	void delete(ExproNoOficio exproNoOficio);

}
