package es.sms.bolsa.service;

import java.util.List;
import java.util.Optional;

import es.sms.bolsa.model.entity.FormacionEspecializada;

public interface FormacionEspecializadaService {
	
	FormacionEspecializada save(FormacionEspecializada formacionEspecializada);
	
	List<FormacionEspecializada> findAll();
	
	Optional<FormacionEspecializada> findById(Long id);
	
	void delete(FormacionEspecializada formacionEspecializada);
	

}
