package es.sms.bolsa.oracleforms.proceso.fichero;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import es.carm.sms.lobo2.service.exception.FunctionalException;
import es.sms.bolsa.oracleforms.proceso.Proceso;

@Repository
public class JdbcFicheroProcesoRepository implements FicheroProcesoRepository {

	private static final String PARAM_ID = "id";
	private static final String KEY_QUERY_BUSCAR_FICHERO_BY_ID = "ficheros.buscarById";
	private static final String KEY_QUERY_DELETE_BY_ID = "ficheros.eliminarById";

	@Resource(name = "accesoDataSource")
	private DataSource dataSource;
	@Resource(name = "sqlQueries")
	private Map<String, String> sql;
	private NamedParameterJdbcOperations jdbcTemplate;

	@PostConstruct
	public void init() {
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public FicheroProceso find(Proceso proceso) {
		Assert.notNull(proceso.getIdFichero(), "Se necesita un id");
		MapSqlParameterSource parameters = new MapSqlParameterSource().addValue(PARAM_ID, proceso.getIdFichero());
		return jdbcTemplate.queryForObject(sql.get(KEY_QUERY_BUSCAR_FICHERO_BY_ID), parameters, new BeanPropertyRowMapper<>(FicheroProceso.class));
	}

	@Override
	public void delete(Proceso proceso) throws FunctionalException {
		Assert.notNull(proceso.getIdFichero(), "Se necesita un id");
		MapSqlParameterSource parameters = new MapSqlParameterSource().addValue(PARAM_ID, proceso.getIdFichero());
		jdbcTemplate.update(sql.get(KEY_QUERY_DELETE_BY_ID), parameters);
	}
}
