package es.sms.bolsa.service;



import java.util.List;
import java.util.Optional;

import es.sms.bolsa.model.entity.BolsaTrab;
import es.sms.bolsa.model.entity.Convocatoria;


public interface ConvocatoriaService {


	Convocatoria save(Convocatoria convocatoria);

    List<Convocatoria> findAll();

    Optional<Convocatoria> findOne(Long id);

    void delete(Long id);
    
    List<Convocatoria> findByBolsaTrab(BolsaTrab bolsaTrab);
    
    Convocatoria findByIdAndBolsaTrab(Long id, BolsaTrab bolsaTrab);
}
