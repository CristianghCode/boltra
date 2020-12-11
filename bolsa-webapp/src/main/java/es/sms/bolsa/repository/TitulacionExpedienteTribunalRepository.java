package es.sms.bolsa.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import es.sms.bolsa.model.entity.TitulacionExpediente;
import es.sms.bolsa.model.entity.TitulacionExpedienteTribunal;


@Repository
public interface TitulacionExpedienteTribunalRepository extends PagingAndSortingRepository<TitulacionExpedienteTribunal, Long> {

	
	Optional<TitulacionExpedienteTribunal> findByTitulacionExpediente(TitulacionExpediente titulacionExpediente);
}
