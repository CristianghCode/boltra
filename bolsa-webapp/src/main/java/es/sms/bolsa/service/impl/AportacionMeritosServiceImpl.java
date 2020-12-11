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
import es.sms.bolsa.model.entity.Convocatoria;
import es.sms.bolsa.repository.AportacionMeritosRepository;
import es.sms.bolsa.service.AportacionMeritosService;


@Service
@Transactional
public class AportacionMeritosServiceImpl implements AportacionMeritosService {

    private final Logger log = LoggerFactory.getLogger(AportacionMeritosServiceImpl.class);

    @Autowired
    private AportacionMeritosRepository aportacionMeritosRepository;


	@Override
	public AportacionMeritos save(AportacionMeritos aportacionMeritos) {
        log.debug("Request to save Aportacion Meritos : {}", aportacionMeritos);
		return this.aportacionMeritosRepository.save(aportacionMeritos);
	}

	@Override
	public List<AportacionMeritos> findAll() {
        log.debug("Request to get all Aportacion Meritos");
		return (List<AportacionMeritos>) this.aportacionMeritosRepository.findAll();
	}

	@Override
	public Optional<AportacionMeritos> findOne(Long id) {
        log.debug("Request to get Aportacion Meritos : {}", id);
		return this.aportacionMeritosRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
        log.debug("Request to delete Aportacion Meritos : {}", id);
        this.aportacionMeritosRepository.deleteById(id);
	}
	
	@Override
	public List<AportacionMeritos> findAllByConvocatoria(Pageable pageable, Convocatoria convocatoria) {
		return this.aportacionMeritosRepository.findByConvocatoria(convocatoria, pageable);
	}

	@Override
	public Integer countByConvocatoria(Convocatoria convocatoria) {
		return this.aportacionMeritosRepository.countByConvocatoria(convocatoria);
	}
	
	@Override
	public Integer countByConvocatoriaAndNifInteresado(Convocatoria convocatoria, String nifInteresado) {
		return this.aportacionMeritosRepository.countByConvocatoriaAndNif(convocatoria, nifInteresado);
	}

	@Override
	public List<AportacionMeritos> findByConvocatoriaAndNif(Pageable pageable, Convocatoria convocatoria, String nifInteresado) {
		return this.aportacionMeritosRepository.findByConvocatoriaAndNifInteresado(convocatoria, nifInteresado, pageable);
	}
	
	@Override
	public List<Long> findIdsByConvocatoria(Convocatoria convocatoria) {
		return this.aportacionMeritosRepository.findIdsByConvocatoria(convocatoria);
	}

	@Override
	public List<Long> findIdsByConvocatoriaAndNif(Convocatoria convocatoria, String nifInteresado) {
		return this.aportacionMeritosRepository.findIdsByConvocatoriaAndNif(convocatoria, nifInteresado);
	}
}
