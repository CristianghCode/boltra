package es.sms.bolsa.service;

import java.util.List;
import java.util.Optional;


import es.sms.bolsa.model.entity.FormacionEspecializada;
import es.sms.bolsa.model.entity.FormacionEspecializadaTribunal;

public interface FormacionEspecializadaTribunalService {
	
	FormacionEspecializadaTribunal save(FormacionEspecializadaTribunal FormacionEspecializadaTribunal);
	
	List<FormacionEspecializadaTribunal> findAll();
	
	Optional<FormacionEspecializadaTribunal> findByFormacionEspecializada(FormacionEspecializada formacionEspecializada);
	
	Optional<FormacionEspecializadaTribunal> findById(Long id);
			
	void delete(FormacionEspecializadaTribunal FormacionEspecializadaTribunal);

}
