package es.sms.bolsa.service;

import java.util.List;
import java.util.Optional;


import es.sms.bolsa.model.entity.RelacionFijeza;
import es.sms.bolsa.model.entity.RelacionFijezaTribunal;

public interface RelacionFijezaTribunalService {
	
	RelacionFijezaTribunal save(RelacionFijezaTribunal relacionFijezaTribunal);
	
	List<RelacionFijezaTribunal> findAll();
	
	Optional<RelacionFijezaTribunal> findByRelacionFijeza(RelacionFijeza relacionFijeza);
	
	Optional<RelacionFijezaTribunal> findById(Long id);
			
	void delete(RelacionFijezaTribunal relacionFijezaTribunal);

}
