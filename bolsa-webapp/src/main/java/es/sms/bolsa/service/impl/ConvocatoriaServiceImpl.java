package es.sms.bolsa.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.sms.bolsa.model.entity.BolsaTrab;
import es.sms.bolsa.model.entity.Convocatoria;
import es.sms.bolsa.repository.ConvocatoriaRepository;
import es.sms.bolsa.service.ConvocatoriaService;


@Service
@Transactional
public class ConvocatoriaServiceImpl implements ConvocatoriaService {

    private final Logger log = LoggerFactory.getLogger(ConvocatoriaServiceImpl.class);

    @Autowired
    private ConvocatoriaRepository convocatoriaRepository;


    /**
     * Save a anexo.
     *
     * @param anexo the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Convocatoria save(Convocatoria convocatoria) {
        log.debug("Request to save Bolsa de trabajo : {}", convocatoria);
        return convocatoriaRepository.save(convocatoria);
    }

    /**
     * Get all the anexos.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Convocatoria> findAll() {
        log.debug("Request to get all Convocatorias");
        return convocatoriaRepository.findAll();
    }


    /**
     * Get one anexo by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Convocatoria> findOne(Long id) {
        log.debug("Request to get Convocatoria : {}", id);
        return convocatoriaRepository.findById(id);
    }

    /**
     * Delete the anexo by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Convocatoria : {}", id);
        convocatoriaRepository.deleteById(id);
    }

	@Override
    @Transactional(readOnly = true)
	public List<Convocatoria> findByBolsaTrab(BolsaTrab bolsaTrab) {
        log.debug("Request to get Convocatoria by bolsaTrab : {}", bolsaTrab.getCodigo());
		return convocatoriaRepository.findByBolsaTrabAndEstado(bolsaTrab);
	}

	@Override
	public Convocatoria findByIdAndBolsaTrab(Long id, BolsaTrab bolsaTrab) {
		return this.convocatoriaRepository.findByIdAndBolsaTrabAndEstado(id, bolsaTrab);
	}
    

}
