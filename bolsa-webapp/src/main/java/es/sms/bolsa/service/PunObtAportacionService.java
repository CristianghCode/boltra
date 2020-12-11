package es.sms.bolsa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import es.sms.bolsa.model.entity.Convocatoria;
import es.sms.bolsa.model.entity.PunObtAportacion;

public interface PunObtAportacionService {
		
	PunObtAportacion findPuntuacionTotal(Convocatoria convocatoria, Long idInteresado, Long idAportacion);
	
	

}
