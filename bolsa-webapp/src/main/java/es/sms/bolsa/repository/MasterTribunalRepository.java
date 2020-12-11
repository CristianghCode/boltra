package es.sms.bolsa.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import es.sms.bolsa.model.entity.Item;
import es.sms.bolsa.model.entity.Master;
import es.sms.bolsa.model.entity.MasterTribunal;

@SuppressWarnings("unused")
@Repository
public interface MasterTribunalRepository extends PagingAndSortingRepository<MasterTribunal, Long>{
	
	Optional<MasterTribunal> findByMaster(Master opositor);


}
