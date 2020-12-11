package es.sms.bolsa.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import es.sms.bolsa.model.entity.ExproNoOficio;
import es.sms.bolsa.model.entity.ExproNoOficioTribunal;


@Repository
public interface ExproNoOficioTribunalRepository  extends PagingAndSortingRepository<ExproNoOficioTribunal, Long> {

	
	Optional<ExproNoOficioTribunal> findByExproNoOficio(ExproNoOficio exproNoOficio);
}
