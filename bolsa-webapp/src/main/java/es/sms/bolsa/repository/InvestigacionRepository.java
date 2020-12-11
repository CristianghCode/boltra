package es.sms.bolsa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import es.sms.bolsa.model.entity.Investigacion;

@Repository
public interface InvestigacionRepository extends PagingAndSortingRepository<Investigacion, Long> {

}
