package es.sms.bolsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.sms.bolsa.model.entity.BolsaTrab;
import es.sms.bolsa.model.entity.Convocatoria;


@SuppressWarnings("unused")
@Repository
public interface ConvocatoriaRepository extends JpaRepository<Convocatoria, Long> {
	
	@Query("SELECT c FROM Convocatoria c WHERE c.bolsaTrabajo = ?1 AND c.estado = 3 ORDER BY c.id ASC")
	List<Convocatoria> findByBolsaTrabAndEstado(BolsaTrab bolsaTrab);
	
	@Query("SELECT c FROM Convocatoria c WHERE c.id = ?1 AND c.bolsaTrabajo = ?2 AND c.estado = 3 ORDER BY c.id ASC")
	Convocatoria findByIdAndBolsaTrabAndEstado(Long id, BolsaTrab bolsaTrab);
	

}
