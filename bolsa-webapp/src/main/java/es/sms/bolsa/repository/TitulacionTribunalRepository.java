package es.sms.bolsa.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import es.sms.bolsa.model.entity.Titulacion;
import es.sms.bolsa.model.entity.TitulacionTribunal;


@Repository
public interface TitulacionTribunalRepository  extends PagingAndSortingRepository<TitulacionTribunal, Long>  {

	
	Optional<TitulacionTribunal> findByTitulacion(Titulacion titulacion);
}
