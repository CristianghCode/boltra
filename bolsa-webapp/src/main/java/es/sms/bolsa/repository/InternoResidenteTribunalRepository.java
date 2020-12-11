package es.sms.bolsa.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import es.sms.bolsa.model.entity.InternoResidente;
import es.sms.bolsa.model.entity.InternoResidenteTribunal;


@Repository
public interface InternoResidenteTribunalRepository extends PagingAndSortingRepository<InternoResidenteTribunal, Long> {

	
	Optional<InternoResidenteTribunal> findByInternoResidente(InternoResidente internoResidente);

}
