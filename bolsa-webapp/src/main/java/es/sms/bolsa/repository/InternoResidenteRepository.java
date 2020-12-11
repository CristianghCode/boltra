package es.sms.bolsa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import es.sms.bolsa.model.entity.InternoResidente;


@Repository
public interface InternoResidenteRepository extends PagingAndSortingRepository<InternoResidente, Long> {

	
	
	
	
}
