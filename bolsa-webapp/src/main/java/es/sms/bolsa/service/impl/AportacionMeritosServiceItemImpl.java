package es.sms.bolsa.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.sms.bolsa.model.entity.AportacionMeritos;
import es.sms.bolsa.model.entity.AportacionMeritosItem;
import es.sms.bolsa.model.entity.Merito;
import es.sms.bolsa.repository.AportacionMeritosItemRepository;
import es.sms.bolsa.service.AportacionMeritosItemService;


@Service
@Transactional
public class AportacionMeritosServiceItemImpl implements AportacionMeritosItemService {

    private final Logger log = LoggerFactory.getLogger(AportacionMeritosServiceItemImpl.class);

    @Autowired
    private AportacionMeritosItemRepository aportacionMeritosItemRepository;


	@Override
	public AportacionMeritosItem save(AportacionMeritosItem aportacionMeritosItem) {
        log.debug("Request to save Aportacion Meritos Item : {}", aportacionMeritosItem);
		return this.aportacionMeritosItemRepository.save(aportacionMeritosItem);
	}

	@Override
	public List<AportacionMeritosItem> findAll() {
        log.debug("Request to get all Aportacion Meritos Item");
		return (List<AportacionMeritosItem>) this.aportacionMeritosItemRepository.findAll();
	}

	@Override
	public Optional<AportacionMeritosItem> findOne(Long id) {
        log.debug("Request to get Aportacion Meritos Item: {}", id);
		return this.aportacionMeritosItemRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
        log.debug("Request to delete Aportacion Meritos Item: {}", id);
        this.aportacionMeritosItemRepository.deleteById(id);
	}

	@Override
	public Integer countByAportacionMeritosAndCodigoMerito(AportacionMeritos aportacionMeritos, Merito merito) {
		return this.aportacionMeritosItemRepository.countByAportacionMeritos(aportacionMeritos, merito);
	}

	@Override
	public List<AportacionMeritosItem> findByAportacionMeritos(Pageable pageable, AportacionMeritos aportacionMeritos, Merito merito) {
		return this.aportacionMeritosItemRepository.findByAportacionMeritosAndMerito(aportacionMeritos, merito, pageable);
	}

	@Override
	public int getNAportacionesMeritosItemAPortados(AportacionMeritos aportacionMeritos) {
		return this.aportacionMeritosItemRepository.getNAportacionesMeritosAportados(aportacionMeritos);
	}
	
    
  


   
    

}
