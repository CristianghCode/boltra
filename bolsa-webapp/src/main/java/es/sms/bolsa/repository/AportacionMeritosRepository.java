package es.sms.bolsa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import es.sms.bolsa.model.entity.AportacionMeritos;
import es.sms.bolsa.model.entity.Convocatoria;

@SuppressWarnings("unused")
@Repository
public interface AportacionMeritosRepository extends PagingAndSortingRepository<AportacionMeritos, Long> {

	
	@Query("SELECT count(am) FROM AportacionMeritos am "
			+ "JOIN PunObt pt on am.convocatoria=pt.convocatoria AND am.convocatoria=?1 AND pt.codigoMerito='PT' AND am.interesado = pt.idInteresado "
			+ "LEFT JOIN PunObtAportacion pa on am.codigoAportacionMeritos=pa.idAportacion AND pa.convocatoria=pt.convocatoria  AND pa.codigoMerito=pt.codigoMerito AND pa.idInteresado=pt.idInteresado ORDER BY pa.puntuacionTotalObtenida desc nulls last, pt.puntuacionTotalObtenida desc")
	Integer countByConvocatoria(Convocatoria convocatoria);

	@Query("SELECT count(am) FROM AportacionMeritos am "
			+ "JOIN PunObt pt on am.convocatoria=pt.convocatoria AND am.convocatoria=?1 AND pt.codigoMerito='PT' AND am.nifInteresado=?2 AND am.interesado = pt.idInteresado "
			+ "LEFT JOIN PunObtAportacion pa on am.codigoAportacionMeritos=pa.idAportacion AND pa.convocatoria=pt.convocatoria  AND pa.codigoMerito=pt.codigoMerito AND pa.idInteresado=pt.idInteresado ORDER BY pa.puntuacionTotalObtenida desc nulls last, pt.puntuacionTotalObtenida desc")
	Integer countByConvocatoriaAndNif(Convocatoria convocatoria, String nifInteresado);
	
		
	@Query("SELECT am FROM AportacionMeritos am "
			+ "JOIN PunObt pt on am.convocatoria=pt.convocatoria AND am.convocatoria=?1 AND pt.codigoMerito='PT' AND am.interesado = pt.idInteresado "
			+ "LEFT JOIN PunObtAportacion pa on am.codigoAportacionMeritos=pa.idAportacion AND pa.convocatoria=pt.convocatoria  AND pa.codigoMerito=pt.codigoMerito AND pa.idInteresado=pt.idInteresado ORDER BY pa.puntuacionTotalObtenida desc nulls last, pt.puntuacionTotalObtenida desc")
	List<AportacionMeritos> findByConvocatoria(Convocatoria convocatoria, Pageable pageable);
	
	
//	List<AportacionMeritos> findByConvocatoria(Convocatoria convocatoria, Pageable pageable);

	@Query("SELECT am FROM AportacionMeritos am "
			+ "JOIN PunObt pt on am.convocatoria=pt.convocatoria AND am.convocatoria=?1 AND pt.codigoMerito='PT' AND am.nifInteresado=?2 AND am.interesado = pt.idInteresado "
			+ "LEFT JOIN PunObtAportacion pa on am.codigoAportacionMeritos=pa.idAportacion AND pa.convocatoria=pt.convocatoria  AND pa.codigoMerito=pt.codigoMerito AND pa.idInteresado=pt.idInteresado ORDER BY pa.puntuacionTotalObtenida desc nulls last, pt.puntuacionTotalObtenida desc")
	List<AportacionMeritos> findByConvocatoriaAndNifInteresado(Convocatoria convocatoria, String nifInteresado, Pageable pageable);

	
	@Query("SELECT am.codigoAportacionMeritos FROM AportacionMeritos am "
			+ "JOIN PunObt pt on am.convocatoria=pt.convocatoria AND am.convocatoria=?1 AND pt.codigoMerito='PT' AND am.interesado = pt.idInteresado "
			+ "LEFT JOIN PunObtAportacion pa on am.codigoAportacionMeritos=pa.idAportacion AND pa.convocatoria=pt.convocatoria  AND pa.codigoMerito=pt.codigoMerito AND pa.idInteresado=pt.idInteresado ORDER BY pa.puntuacionTotalObtenida desc nulls last, pt.puntuacionTotalObtenida desc")
	List<Long> findIdsByConvocatoria(Convocatoria convocatoria);
	
	
	@Query("SELECT am.codigoAportacionMeritos FROM AportacionMeritos am "
			+ "JOIN PunObt pt on am.convocatoria=pt.convocatoria AND am.convocatoria=?1 AND pt.codigoMerito='PT' AND am.nifInteresado=?2 AND am.interesado = pt.idInteresado "
			+ "LEFT JOIN PunObtAportacion pa on am.codigoAportacionMeritos=pa.idAportacion AND pa.convocatoria=pt.convocatoria  AND pa.codigoMerito=pt.codigoMerito AND pa.idInteresado=pt.idInteresado ORDER BY pa.puntuacionTotalObtenida desc nulls last, pt.puntuacionTotalObtenida desc")
	List<Long> findIdsByConvocatoriaAndNif(Convocatoria convocatoria, String nifInteresado);


	//metodos anteriores a que se tuviera en cuenta la puntuacion del tribunal
	/*
	@Query("SELECT a.codigoAportacionMeritos FROM AportacionMeritos a WHERE a.convocatoria = ?1 ORDER BY a.codigoAportacionMeritos")
	List<Long> findIdsByConvocatoria(Convocatoria convocatoria);
	
	@Query("SELECT a.codigoAportacionMeritos FROM AportacionMeritos a WHERE a.convocatoria = ?1 AND a.nifInteresado = ?2 ORDER BY a.codigoAportacionMeritos")
	List<Long> findIdsByConvocatoriaAndNif(Convocatoria convocatoria, String nifInteresado);
*/
	/*
	@Query("SELECT count(a) FROM AportacionMeritos a WHERE a.convocatoria = ?1")
	Integer countByConvocatoria(Convocatoria convocatoria);

	@Query("SELECT count(a) FROM AportacionMeritos a WHERE a.convocatoria = ?1 AND a.nifInteresado = ?2")
	Integer countByConvocatoriaAndNif(Convocatoria convocatoria, String nifInteresado);
*/

}
