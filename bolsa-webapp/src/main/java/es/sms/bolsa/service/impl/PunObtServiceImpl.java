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
import es.sms.bolsa.repository.PunObtRepository;
import es.sms.bolsa.service.PunObtService;

@Service
@Transactional
public class PunObtServiceImpl implements PunObtService {

	private final Logger log = LoggerFactory.getLogger(PunObtServiceImpl.class);

	@Autowired
	private PunObtRepository punObtRepository;

	@Override
	public PunObt save(PunObt punObt) {
		log.debug("Request to save PunObt : {}", punObt);
		return this.punObtRepository.save(punObt);
	}

	@Override
	public List<PunObt> findAll() {
		log.debug("Request to get all PunObt");
		return (List<PunObt>) this.punObtRepository.findAll();
	}

	@Override
	public Optional<PunObt> findOne(Long id) {
		log.debug("Request to get PunObt : {}", id);
		return this.punObtRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		log.debug("Request to delete PunObt : {}", id);
		this.punObtRepository.deleteById(id);
	}

	@Override
	public Integer countByConvocatoriaAndIdInteresado(Convocatoria convocatoria, Long idInteresado) {
		return this.punObtRepository.countByConvocatoriaAndIdInteresado(convocatoria, idInteresado);
	}

	@Override
	public List<PunObt> findByConvocatoriaAndIdInteresado(Convocatoria convocatoria, Long idInteresado,
			Pageable pageable) {
		return this.punObtRepository.findByConvocatoriaAndIdInteresado(convocatoria, idInteresado, pageable);
	}

	@Override
	public PunObt findPuntuacionTotal(Convocatoria convocatoria, Long idInteresado) {
		return this.punObtRepository.findPuntuacionTotal(convocatoria, idInteresado);
	}

	@Override
	public List<PunObt> findHijo(Convocatoria convocatoria, Long idInteresado, String codigoMerito) {
		return this.punObtRepository.findHijo(convocatoria, idInteresado, codigoMerito);
	}

}
