package es.sms.bolsa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import es.sms.bolsa.model.entity.Convocatoria;
import es.sms.bolsa.model.entity.PunObt;

public interface PunObtService {

	PunObt save(PunObt punObt);

	List<PunObt> findAll();

	Optional<PunObt> findOne(Long id);

	void delete(Long id);

	Integer countByConvocatoriaAndIdInteresado(Convocatoria convocatoria, Long idInteresado);

	List<PunObt> findByConvocatoriaAndIdInteresado(Convocatoria convocatoria, Long idInteresado, Pageable pageable);
	
	PunObt findPuntuacionTotal(Convocatoria convocatoria, Long idInteresado);
	
	List<PunObt> findHijo(Convocatoria convocatoria, Long idInteresado, String codigoMerito);


}
