package es.sms.bolsa.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.sms.bolsa.model.entity.Situacion;
import es.sms.bolsa.repository.SituacionRepository;
import es.sms.bolsa.service.SituacionService;


@Service
@Transactional
public class SituacionServiceImpl implements SituacionService {

    private final Logger log = LoggerFactory.getLogger(SituacionServiceImpl.class);

    @Autowired
    private SituacionRepository situacionRepository;


    /**
     * Save a anexo.
     *
     * @param anexo the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Situacion save(Situacion bolsaTrab) {
        log.debug("Request to save Situacion : {}", bolsaTrab);
        return situacionRepository.save(bolsaTrab);
    }

    /**
     * Get all the anexos.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Situacion> findAll() {
        log.debug("Request to get all Situacion");
        return situacionRepository.findAll();
    }


    /**
     * Get one anexo by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Situacion> findOne(Long id) {
        log.debug("Request to get Situacion : {}", id);
        return situacionRepository.findById(id);
    }

    /**
     * Delete the anexo by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Situacion : {}", id);
        situacionRepository.deleteById(id);
    }

    

}
