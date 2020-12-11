package es.sms.bolsa.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.sms.bolsa.model.entity.BolsaTrab;
import es.sms.bolsa.repository.BolsaTrabRepository;
import es.sms.bolsa.service.BolsaTrabService;


@Service
@Transactional
public class BolsaTrabServiceImpl implements BolsaTrabService {

    private final Logger log = LoggerFactory.getLogger(BolsaTrabServiceImpl.class);

    @Autowired
    private BolsaTrabRepository bolsaTrabRepository;


    /**
     * Save a anexo.
     *
     * @param anexo the entity to save.
     * @return the persisted entity.
     */
    @Override
    public BolsaTrab save(BolsaTrab bolsaTrab) {
        log.debug("Request to save Bolsa de trabajo : {}", bolsaTrab);
        return bolsaTrabRepository.save(bolsaTrab);
    }

    /**
     * Get all the anexos.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<BolsaTrab> findAll() {
        log.debug("Request to get all Bolsa de trabajo");
        return bolsaTrabRepository.findAll();
    }


    /**
     * Get one anexo by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<BolsaTrab> findOne(Long id) {
        log.debug("Request to get Bolsa de trabajo : {}", id);
        return bolsaTrabRepository.findById(id);
    }

    /**
     * Delete the anexo by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Bolsa de trabajo : {}", id);
        bolsaTrabRepository.deleteById(id);
    }

	@Override
	public List<BolsaTrab> findAllOrderByCodigo() {
		log.debug("Request to get all Bolsa de trabajo order by codigo");
		return bolsaTrabRepository.findAllOrderByCodigo();
	}
    

}
