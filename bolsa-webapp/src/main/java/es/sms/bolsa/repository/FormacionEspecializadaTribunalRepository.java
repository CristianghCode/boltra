package es.sms.bolsa.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import es.sms.bolsa.model.entity.FormacionEspecializada;
import es.sms.bolsa.model.entity.FormacionEspecializadaTribunal;

@Repository
public interface FormacionEspecializadaTribunalRepository extends PagingAndSortingRepository<FormacionEspecializadaTribunal, Long> {

	
	Optional<FormacionEspecializadaTribunal> findByFormacionEspecializada(FormacionEspecializada formacionEspecializada);
	
}
