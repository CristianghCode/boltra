package es.sms.bolsa.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import es.sms.bolsa.model.entity.FormacionContinuada;
import es.sms.bolsa.model.entity.FormacionContinuadaTribunal;

@Repository
public interface FormacionContinuadaTribunalRepository extends PagingAndSortingRepository<FormacionContinuadaTribunal, Long>{

	Optional<FormacionContinuadaTribunal> findByFormacionContinuada(FormacionContinuada formacionContinuada);
}
