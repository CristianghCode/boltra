package es.sms.bolsa.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.sms.bolsa.model.entity.Convocatoria;
import es.sms.bolsa.model.entity.PunObt;
import es.sms.bolsa.model.entity.PunObtAportacion;
import es.sms.bolsa.repository.PunObtAportacionRepository;
import es.sms.bolsa.service.PunObtAportacionService;

@Service
@Transactional
public class PunObtAportacionServiceImpl implements PunObtAportacionService{

	private final Logger log = LoggerFactory.getLogger(PunObtServiceImpl.class);

	@Autowired
	private PunObtAportacionRepository punObtAportacionRepository;

	@Override
	public PunObtAportacion findPuntuacionTotal(Convocatoria convocatoria, Long idInteresado, Long idAportacion) {
		return punObtAportacionRepository.findPuntuacionTotal(convocatoria, idInteresado, idAportacion);
	}




	
	

}
