package es.sms.bolsa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import es.sms.bolsa.model.entity.AportacionMeritos;
import es.sms.bolsa.model.entity.Convocatoria;

public interface AportacionMeritosService {

	AportacionMeritos save(AportacionMeritos convocatoria);

	List<AportacionMeritos> findAll();

	Optional<AportacionMeritos> findOne(Long id);

	void delete(Long id);

	Integer countByConvocatoria(Convocatoria convocatoria);

	Integer countByConvocatoriaAndNifInteresado(Convocatoria convocatoria, String nifInteresado);

	List<AportacionMeritos> findAllByConvocatoria(Pageable pageable, Convocatoria convocatoria);

	List<AportacionMeritos> findByConvocatoriaAndNif(Pageable pageable, Convocatoria convocatoria,
			String nifInteresado);
	
	List<Long> findIdsByConvocatoria(Convocatoria convocatoria);
	
	List<Long> findIdsByConvocatoriaAndNif(Convocatoria convocatoria, String nifInteresado);

}
