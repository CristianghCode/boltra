package es.sms.bolsa.service;



import java.util.List;
import java.util.Optional;

import es.sms.bolsa.model.entity.BolsaTrab;


public interface BolsaTrabService {


	BolsaTrab save(BolsaTrab anexo);

    List<BolsaTrab> findAll();
    
    List<BolsaTrab> findAllOrderByCodigo();

    Optional<BolsaTrab> findOne(Long id);

    void delete(Long id);
}
