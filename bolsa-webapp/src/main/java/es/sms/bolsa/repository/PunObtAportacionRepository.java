package es.sms.bolsa.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import es.sms.bolsa.model.entity.Convocatoria;
import es.sms.bolsa.model.entity.PunObtAportacion;

@SuppressWarnings("unused")
@Repository
public interface PunObtAportacionRepository extends PagingAndSortingRepository<PunObtAportacion, Long>  {

	@Query("SELECT pa FROM PunObtAportacion pa WHERE pa.convocatoria = ?1 AND pa.idInteresado = ?2 AND pa.idAportacion=?3  AND pa.codigoMerito = 'PT'")
	PunObtAportacion findPuntuacionTotal(Convocatoria convocatoria, Long idInteresado, Long idAportacion);
}
