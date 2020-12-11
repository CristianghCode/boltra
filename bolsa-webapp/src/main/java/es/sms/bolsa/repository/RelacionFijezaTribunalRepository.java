package es.sms.bolsa.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import es.sms.bolsa.model.entity.RelacionFijeza;
import es.sms.bolsa.model.entity.RelacionFijezaTribunal;



@Repository
public interface RelacionFijezaTribunalRepository extends PagingAndSortingRepository<RelacionFijezaTribunal, Long> {

	
	Optional<RelacionFijezaTribunal> findByRelacionFijeza(RelacionFijeza relacionFijeza);
}
