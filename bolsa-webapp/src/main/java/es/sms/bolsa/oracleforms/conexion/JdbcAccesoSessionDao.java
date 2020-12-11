package es.sms.bolsa.oracleforms.conexion;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
class JdbcAccesoSessionDao implements AccesoSessionDao {

	private static final String FUNCTION_CREAR_SESION_FORMS = "{? = call ACCESO.SESION.CREAR_SESION(?, ?)}";
	private static final String FUNCTION_CERRAR_SESION_WEB = "{? = call ACCESO.SESION.CERRAR_SESION_WEB(?)}";
	private static final String FUNCTION_CREAR_SESION_WEB = "{? = call ACCESO.SESION.CREAR_SESION_WEB(?, ?, ?)}";
	private static final Logger logger = LoggerFactory.getLogger(JdbcAccesoSessionDao.class);

	@Resource(name = "accesoDataSource")
	private DataSource dataSource;

	@Override
	public Long abrirSesion(Conexion conexion) {
		Long resultado = -1L;
		try (CallableStatement cstmt = dataSource.getConnection()
				.prepareCall(FUNCTION_CREAR_SESION_WEB)) {
			cstmt.registerOutParameter(1, Types.BIGINT);
			cstmt.setString(2, conexion.getUsuario());
			cstmt.setString(3, conexion.getAplicacion());
			cstmt.setString(4, conexion.getIp());
			cstmt.execute();
			resultado = cstmt.getLong(1);

		} catch (SQLException e) {
			logger.error("Error abriendo session acceso", e);
		}

		return resultado;
	}

	@Override
	public void cerrarSesion(Long sesion) {
		try (CallableStatement cstmt = dataSource.getConnection()
				.prepareCall(FUNCTION_CERRAR_SESION_WEB)) {
			cstmt.registerOutParameter(1, Types.INTEGER);
			cstmt.setLong(2, sesion);
			cstmt.execute();
		} catch (SQLException e) {
			logger.error("Error cerrando session acceso", e);
		}

	}

	@Override
	public String crearConexionForms(String usuario, long sesion) {
		String resultado = "";
		try (CallableStatement cstmt = dataSource.getConnection()
				.prepareCall(FUNCTION_CREAR_SESION_FORMS)) {
			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.setString(2, usuario);
			cstmt.setString(3, String.valueOf(sesion));
			cstmt.execute();
			resultado = cstmt.getString(1);
		} catch (SQLException e) {
			logger.error("Error creando conexion forms acceso", e);
		}
		return resultado;
	}

}