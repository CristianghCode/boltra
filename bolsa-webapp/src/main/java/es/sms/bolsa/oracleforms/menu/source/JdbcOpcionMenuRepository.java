package es.sms.bolsa.oracleforms.menu.source;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import es.sms.bolsa.oracleforms.menu.OpcionMenu;
import es.sms.bolsa.oracleforms.menu.OpcionMenu.Builder;

@Repository
class JdbcOpcionMenuRepository implements OpcionMenuRepository {
	private static final String PARAM_CODIGO_APP = "codigoApp";
	private static final String PARAM_ROLES = "roles";
	private static final String BUSCAR_OPCIONES = "buscarOpcionesMenuByCodigoAppAndRoles";

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
	public List<OpcionMenu> find(String codigoApp, List<String> roles) {
		Assert.notNull(codigoApp, "Se necesita un codigo de aplicacion");
		Assert.notNull(roles, "Se necesitan roles con los que filtrar");
		if (roles.isEmpty()) {
			return Collections.emptyList();
		}
		MapSqlParameterSource parameters = buildParams(codigoApp, roles);
		return jdbcTemplate.query(sql.get(BUSCAR_OPCIONES), parameters, this::resultSetToOpcionesMenu);
	}

	private List<OpcionMenu> resultSetToOpcionesMenu(ResultSet rs) throws SQLException {
		Map<Integer, OpcionMenu> mapOpcionesById = new LinkedHashMap<>();
		while (rs.next()) {
			OpcionMenu opcionMenu = buildOpcionMenu(rs);
			mapOpcionesById.put(opcionMenu.getId(), opcionMenu);
			mapOpcionesById.computeIfPresent(opcionMenu.getIdPadre(), (key, opcionMenuPadre) -> opcionMenuPadre.addOpcionHija(opcionMenu));
		}
		return mapOpcionesById.values()
				.stream()
				.filter(OpcionMenu::isRaiz)
				.collect(Collectors.toList());
	}

	private OpcionMenu buildOpcionMenu(ResultSet rs) throws SQLException {
		Builder opcionMenuBuilder = OpcionMenu.create();
		opcionMenuBuilder.withId(rs.getInt("id"));
		opcionMenuBuilder.withDescripcion(rs.getString("descripcion"));
		opcionMenuBuilder.withIdPadre(rs.getInt("idPadre"));
		opcionMenuBuilder.withOrden(rs.getInt("orden"));
		opcionMenuBuilder.withUrl(rs.getString("url"));
		opcionMenuBuilder.withTipo(rs.getString("tipo"));
		return opcionMenuBuilder.build();
	}

	private MapSqlParameterSource buildParams(String codigoApp, List<String> roles) {
		return new MapSqlParameterSource().addValue(PARAM_ROLES, toUpperCase(roles))
				.addValue(PARAM_CODIGO_APP, codigoApp);
	}

	private List<String> toUpperCase(List<String> roles) {
		return roles.stream()
				.map(String::toUpperCase)
				.collect(Collectors.toList());
	}
}
