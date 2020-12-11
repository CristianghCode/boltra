package es.sms.bolsa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import es.sms.bolsa.model.entity.AportacionMeritos;
import es.sms.bolsa.model.entity.AportacionMeritosItem;
import es.sms.bolsa.model.entity.Convocatoria;
import es.sms.bolsa.model.entity.Merito;

@SuppressWarnings("unused")
@Repository
public interface AportacionMeritosItemRepository extends PagingAndSortingRepository<AportacionMeritosItem, Long> {

	@Query("SELECT count(ami) FROM AportacionMeritosItem ami WHERE ami.aportacionMeritos = ?1 AND ami.merito = ?2")
	Integer countByAportacionMeritos(AportacionMeritos aportacionMeritos, Merito merito);

	List<AportacionMeritosItem> findByAportacionMeritosAndMerito(AportacionMeritos aportacionMeritos, Merito merito, Pageable pageable);

	/*
	 * 
	 */
	@Query("SELECT COUNT(ami) FROM AportacionMeritosItem ami WHERE ami.aportacionMeritos = ?1 AND ami.situacion.codigo=1 ")
	int getNAportacionesMeritosAportados(AportacionMeritos aportacionMeritos);
}
