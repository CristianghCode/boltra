package es.sms.bolsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import es.sms.bolsa.model.entity.BolsaTrab;


@SuppressWarnings("unused")
@Repository
public interface BolsaTrabRepository extends JpaRepository<BolsaTrab, Long> {
    
	@Query("SELECT b FROM BolsaTrab b ORDER BY b.codigo ASC")
	List<BolsaTrab> findAllOrderByCodigo();

}
