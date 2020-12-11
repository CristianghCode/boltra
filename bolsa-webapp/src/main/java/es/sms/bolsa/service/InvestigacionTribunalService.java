package es.sms.bolsa.service;

import java.util.List;
import java.util.Optional;


import es.sms.bolsa.model.entity.Investigacion;
import es.sms.bolsa.model.entity.InvestigacionTribunal;

public interface InvestigacionTribunalService {
	
	InvestigacionTribunal save(InvestigacionTribunal investigacionTribunal);
	
	List<InvestigacionTribunal> findAll();
	
	Optional<InvestigacionTribunal> findByInvestigacion(Investigacion investigacion);
	
	Optional<InvestigacionTribunal> findById(Long id);
			
	void delete(InvestigacionTribunal investigacionTribunal);

}
