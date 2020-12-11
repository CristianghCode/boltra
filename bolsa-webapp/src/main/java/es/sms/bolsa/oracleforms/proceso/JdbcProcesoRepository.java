package es.sms.bolsa.oracleforms.proceso;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

import es.sms.bolsa.oracleforms.proceso.tipo.TipoProceso;

@Repository
class JdbcProcesoRepository implements ProcesoRepository {

	private static final String KEY_QUERY_BUSCAR_BY_LOGIN = "procesos.buscarByLogin";
	private static final String KEY_QUERY_BUSCAR_BY_TIPO_AND_CODIGO_APP = "procesos.buscarByTipoAndCodigoApp";
	private static final Object KEY_QUERY_DELETE_BY_ID = "procesos.eliminarById";
	private static final String PARAM_LOGIN = "login";
	private static final String PARAM_COD_APP = "codApp";
	private static final String PARAM_ID = "id";

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
	public List<Proceso> findByLogin(String login) {
		Assert.notNull(login, "Se necesita un login");

		MapSqlParameterSource parameters = new MapSqlParameterSource().addValue(PARAM_LOGIN, login);

		return jdbcTemplate.query(sql.get(KEY_QUERY_BUSCAR_BY_LOGIN), parameters, this::resultSetToProceso);
	}

	@Override
	public List<Proceso> findByTipoAndCodigoApp(TipoProceso tipo, String codigoApp) {
		Assert.notNull(tipo, "Se necesita un tipo");
		Assert.notNull(codigoApp, "Se necesita un c�digo");

		MapSqlParameterSource parameters = new MapSqlParameterSource().addValue(PARAM_COD_APP, codigoApp)
				.addValue(PARAM_ID, tipo.getId());

		return jdbcTemplate.query(sql.get(KEY_QUERY_BUSCAR_BY_TIPO_AND_CODIGO_APP), parameters, this::resultSetToProceso);
	}

	@Override
	public void deleteById(Long id) {
		Assert.notNull(id, "Se necesita un id");

		MapSqlParameterSource parameters = new MapSqlParameterSource().addValue(PARAM_ID, id);

		jdbcTemplate.update(sql.get(KEY_QUERY_DELETE_BY_ID), parameters);
	}

	private List<Proceso> resultSetToProceso(ResultSet rs) throws SQLException {
		Builder<Proceso> procesos = new ImmutableList.Builder<>();
		while (rs.next()) {
			procesos.add(buildProceso(rs));
		}
		return procesos.build();
	}

	private Proceso buildProceso(ResultSet rs) throws SQLException {
		Proceso.Builder builder = Proceso.create();
		builder.withId(rs.getLong("id"));
		builder.withDescripcion(rs.getString("descripcion"));
		builder.withLogin(rs.getString(PARAM_LOGIN));
		builder.withFechaLanzamiento(toDate(rs, "fechaLanzamiento"));
		builder.withFechaEjecucion(toDate(rs, "fechaejecucion"));
		builder.withFechaFin(toDate(rs, "fechafin"));
		builder.withHuboError(rs.getString("error"));
		builder.withDescripcionError(rs.getString("descripcionerror"));
		builder.withNombreReport(rs.getString("nombrereport"));
		if (rs.getString("nombreFicheroBd") != null) {
			builder.withNombreReport(rs.getString("nombreFicheroBd"));
		}
		builder.withIdFichero(rs.getLong("idfichero"));
		builder.withTipo(buildTipo(rs));
		return builder.build();
	}

	private Date toDate(ResultSet rs, String column) throws SQLException {
		Timestamp timestamp = rs.getTimestamp(column);
		if (timestamp == null) {
			return null;
		}
		return new Date(timestamp.getTime());

	}

	private TipoProceso buildTipo(ResultSet rs) throws SQLException {
		TipoProceso.Builder builder = TipoProceso.create();
		builder.withId(rs.getInt("idTipo"));
		builder.withDescripcion(rs.getString("tipoDescripcion"));
		builder.withTipoReport(rs.getString("tipoReport"));
		return builder.build();
	}

}