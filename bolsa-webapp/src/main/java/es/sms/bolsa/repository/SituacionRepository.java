package es.sms.bolsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.sms.bolsa.model.entity.Situacion;

@SuppressWarnings("unused")
@Repository
public interface SituacionRepository extends JpaRepository<Situacion, Long> {

	
	

}
