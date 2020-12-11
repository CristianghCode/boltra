package es.sms.bolsa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import es.sms.bolsa.model.entity.TitulacionPremio;

@Repository
public interface TitulacionPremioRepository extends PagingAndSortingRepository<TitulacionPremio, Long> {

}
