package es.sms.bolsa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import es.sms.bolsa.model.entity.ExproNoOficio;


@Repository
public interface ExproNoOficioRepository  extends PagingAndSortingRepository<ExproNoOficio, Long>  {

}
