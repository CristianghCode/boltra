package es.sms.bolsa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import es.sms.bolsa.model.entity.Master;


@Repository
public interface MasterRepository extends PagingAndSortingRepository<Master, Long> {
	
	

}
