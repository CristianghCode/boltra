package es.sms.bolsa.oracleforms.proceso.tipo;

import java.sql.ResultSet;
import java.sql.SQLException;
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

@Repository
public class JdbcTipoProcesoRepository implements TipoProcesoRepository {

	private static final String KEY_QUERY_BUSCAR_BY_COD_APP = "tipoProceso.buscarByCodApp";
	private static final String PARAM_COD_APP = "codApp";

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
	public List<TipoProceso> findByCodigoApp(String codigoApp) {
		Assert.notNull(codigoApp, "Se necesita un código");

		MapSqlParameterSource parameters = new MapSqlParameterSource().addValue(PARAM_COD_APP, codigoApp);

		return jdbcTemplate.query(sql.get(KEY_QUERY_BUSCAR_BY_COD_APP), parameters, this::resultSetToTipoProceso);
	}

	private List<TipoProceso> resultSetToTipoProceso(ResultSet rs) throws SQLException {
		Builder<TipoProceso> procesos = new ImmutableList.Builder<>();
		while (rs.next()) {
			procesos.add(buildProceso(rs));
		}
		return procesos.build();
	}

	private TipoProceso buildProceso(ResultSet rs) throws SQLException {
		TipoProceso.Builder builder = TipoProceso.create();
		builder.withId(rs.getInt("id"));
		builder.withDescripcion(rs.getString("descripcion"));
		builder.withTipoReport(rs.getString("tipoReport"));
		return builder.build();
	}

}
