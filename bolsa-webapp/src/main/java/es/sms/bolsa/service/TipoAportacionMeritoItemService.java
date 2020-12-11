package es.sms.bolsa.service;

import java.util.List;
import java.util.Optional;


import es.sms.bolsa.model.entity.TipoAportacionMeritosItem;

public interface TipoAportacionMeritoItemService {
	
	TipoAportacionMeritosItem save(TipoAportacionMeritosItem mi);
	
	List<TipoAportacionMeritosItem> findAll();
	
	Optional<TipoAportacionMeritosItem> findById(Long id);
	
	void delete(TipoAportacionMeritosItem mi);

}
