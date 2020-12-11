package es.sms.bolsa.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import es.sms.bolsa.model.entity.TitulacionDoctorado;
import es.sms.bolsa.model.entity.TitulacionDoctoradoTribunal;


@Repository
public interface TitulacionDoctoradoTribunalRepository  extends PagingAndSortingRepository<TitulacionDoctoradoTribunal, Long>  {

	Optional<TitulacionDoctoradoTribunal> findByTitulacionDoctorado(TitulacionDoctorado titulacionDoctorado);
	
}
