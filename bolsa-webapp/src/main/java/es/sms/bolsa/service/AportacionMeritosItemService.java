package es.sms.bolsa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import es.sms.bolsa.model.entity.AportacionMeritos;
import es.sms.bolsa.model.entity.AportacionMeritosItem;
import es.sms.bolsa.model.entity.Merito;

public interface AportacionMeritosItemService {

	AportacionMeritosItem save(AportacionMeritosItem aportacionMeritosItem);

	List<AportacionMeritosItem> findAll();

	Optional<AportacionMeritosItem> findOne(Long id);

	void delete(Long id);

	Integer countByAportacionMeritosAndCodigoMerito(AportacionMeritos aportacionMeritos, Merito merito);

	List<AportacionMeritosItem> findByAportacionMeritos(Pageable pageable, AportacionMeritos aportacionMeritos, Merito merito);

	int getNAportacionesMeritosItemAPortados(AportacionMeritos aportacionMeritos);
}
