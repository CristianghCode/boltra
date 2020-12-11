package es.sms.bolsa.service;

import java.util.List;
import java.util.Optional;


import es.sms.bolsa.model.entity.ExproNoOficio;
import es.sms.bolsa.model.entity.ExproNoOficioTribunal;

public interface ExproNoOficioTribunalService {
	
	ExproNoOficioTribunal save(ExproNoOficioTribunal exproNoOficioTribunal);
	
	List<ExproNoOficioTribunal> findAll();
	
	Optional<ExproNoOficioTribunal> findByExproNoOficio(ExproNoOficio exproNoOficio);
	
	Optional<ExproNoOficioTribunal> findById(Long id);
			
	void delete(ExproNoOficioTribunal exproNoOficioTribunal);

}
