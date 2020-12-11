package es.sms.bolsa.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import es.sms.bolsa.model.entity.TitulacionPremio;
import es.sms.bolsa.model.entity.TitulacionPremioTribunal;

@Repository
public interface TitulacionPremioTribunalRepository extends PagingAndSortingRepository<TitulacionPremioTribunal, Long> {
	
	Optional<TitulacionPremioTribunal> findByTitulacionPremio(TitulacionPremio titulacionPremio);
}
