package es.sms.bolsa.service;

import java.util.List;
import java.util.Optional;


import es.sms.bolsa.model.entity.Titulacion;
import es.sms.bolsa.model.entity.TitulacionTribunal;

public interface TitulacionTribunalService {
	
	TitulacionTribunal save(TitulacionTribunal titulacionTribunal);
	
	List<TitulacionTribunal> findAll();
	
	Optional<TitulacionTribunal> findByTitulacion(Titulacion titulacion);
	
	Optional<TitulacionTribunal> findById(Long id);
			
	void delete(TitulacionTribunal titulacionTribunal);

}
