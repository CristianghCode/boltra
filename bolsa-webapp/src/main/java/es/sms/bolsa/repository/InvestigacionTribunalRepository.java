package es.sms.bolsa.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import es.sms.bolsa.model.entity.Investigacion;
import es.sms.bolsa.model.entity.InvestigacionTribunal;

@Repository
public interface InvestigacionTribunalRepository extends PagingAndSortingRepository<InvestigacionTribunal, Long> {
	
	Optional<InvestigacionTribunal> findByInvestigacion(Investigacion investigacion);

}
