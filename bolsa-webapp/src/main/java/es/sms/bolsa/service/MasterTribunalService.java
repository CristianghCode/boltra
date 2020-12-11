package es.sms.bolsa.service;

import java.util.List;
import java.util.Optional;

import es.sms.bolsa.model.entity.Item;
import es.sms.bolsa.model.entity.Master;
import es.sms.bolsa.model.entity.MasterTribunal;

public interface MasterTribunalService {
	
	MasterTribunal save(MasterTribunal masterTribunal);
	
	List<MasterTribunal> findAll();
	
	Optional<MasterTribunal> findByMaster(Master opositor);
	
	Optional<MasterTribunal> findById(Long id);
	
	void delete(MasterTribunal master);
	

}
