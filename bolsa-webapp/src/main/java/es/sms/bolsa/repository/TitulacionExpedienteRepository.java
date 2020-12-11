package es.sms.bolsa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import es.sms.bolsa.model.entity.TitulacionExpediente;

@Repository
public interface TitulacionExpedienteRepository extends PagingAndSortingRepository<TitulacionExpediente, Long>  {

}
