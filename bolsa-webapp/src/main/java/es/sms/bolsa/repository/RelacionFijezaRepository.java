package es.sms.bolsa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import es.sms.bolsa.model.entity.RelacionFijeza;


@Repository
public interface RelacionFijezaRepository extends PagingAndSortingRepository<RelacionFijeza, Long> {

}
