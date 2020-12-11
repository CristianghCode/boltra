package es.sms.bolsa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import es.sms.bolsa.model.entity.FormacionEspecializada;


@Repository
public interface FormacionEspecializadaRepository extends PagingAndSortingRepository<FormacionEspecializada, Long> {

}
