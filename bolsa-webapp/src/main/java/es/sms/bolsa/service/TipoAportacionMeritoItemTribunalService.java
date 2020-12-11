package es.sms.bolsa.service;

import java.util.List;
import java.util.Optional;


import es.sms.bolsa.model.entity.MasterTribunal;
import es.sms.bolsa.model.entity.TipoAportacionMeritosItemTribunal;

public interface TipoAportacionMeritoItemTribunalService {
	
	TipoAportacionMeritosItemTribunal save(TipoAportacionMeritosItemTribunal mit);
	
	List<TipoAportacionMeritosItemTribunal> findAll();
	
	Optional<TipoAportacionMeritosItemTribunal> findById(Long id);
	
	Optional<TipoAportacionMeritosItemTribunal> findByTipoMeritoId(Long id);
	
	void delete(TipoAportacionMeritosItemTribunal mi);

}
