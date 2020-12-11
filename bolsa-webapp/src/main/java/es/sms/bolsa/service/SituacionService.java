package es.sms.bolsa.service;



import java.util.List;
import java.util.Optional;

import es.sms.bolsa.model.entity.Situacion;


public interface SituacionService {


	Situacion save(Situacion anexo);

    List<Situacion> findAll();
    
    Optional<Situacion> findOne(Long id);

    void delete(Long id);
}
