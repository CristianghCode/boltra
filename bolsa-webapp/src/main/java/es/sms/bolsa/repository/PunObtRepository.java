package es.sms.bolsa.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import es.sms.bolsa.model.entity.Convocatoria;
import es.sms.bolsa.model.entity.PunObt;

@SuppressWarnings("unused")
@Repository
public interface PunObtRepository extends PagingAndSortingRepository<PunObt, Long> {

	@Query("SELECT count(po) FROM PunObt po WHERE po.convocatoria = ?1 AND po.idInteresado = ?2")
	Integer countByConvocatoriaAndIdInteresado(Convocatoria convocatoria, Long idInteresado);

	List<PunObt> findByConvocatoriaAndIdInteresado(Convocatoria convocatoria, Long idInteresado, Pageable pageable);

	@Query("SELECT po FROM PunObt po WHERE po.convocatoria = ?1 AND po.idInteresado = ?2 AND po.codigoMerito = 'PT'")
	PunObt findPuntuacionTotal(Convocatoria convocatoria, Long idInteresado);

	@Query("SELECT po FROM PunObt po WHERE po.convocatoria = ?1 AND po.idInteresado = ?2 AND po.merito.padre.idMeritos = ?3 ORDER BY po.codigoMerito")
	List<PunObt> findHijo(Convocatoria convocatoria, Long idInteresado, String codigoMerito);

}
