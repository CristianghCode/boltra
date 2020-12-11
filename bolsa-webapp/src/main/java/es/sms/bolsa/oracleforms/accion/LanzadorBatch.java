package es.sms.bolsa.oracleforms.accion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.sms.bolsa.common.UsuarioLogadoHolder;
import es.sms.bolsa.view.oracle.ParametrosInvocacion;
import es.sms.bolsa.view.oracle.ReportProperties;

@Service
public class LanzadorBatch {
	private static final Logger logger = LoggerFactory.getLogger(LanzadorBatch.class);

	@Autowired
	private UsuarioLogadoHolder usuarioLogadoHolder;
	@Autowired
	private HttpDescargadorFromUri httpDescargadorFromUri;
	@Autowired
	private ReportProperties reportProperties;
	@Resource(name = "accesoDataSource")
	private DataSource dataSource;

	public BatchRespuesta lanzar(ParametrosInvocacion parametrosInvocacion) {
		int tipo = Integer.parseInt(parametrosInvocacion.getMapa()
				.get("tipoProceso"));
		String descr = parametrosInvocacion.getMapa()
				.get("descrProceso");
		String params = parametrosInvocacion.montarParamsGuardar();
		String login = usuarioLogadoHolder.getLogin();
		int result;
		try (Connection connection = dataSource.getConnection();
				CallableStatement cstmt = connection.prepareCall("{? = call ACCESO.PQ_LOG_PROCESOS.F_LANZA_INFORME(?, ?, ?, ?, ?, ?, ?)}")) {
			accesoAplicacion(connection, login);
			cstmt.registerOutParameter(1, Types.INTEGER);
			cstmt.setInt(2, tipo);
			cstmt.setString(3, params);
			cstmt.setString(4, descr);
			cstmt.setString(5, parametrosInvocacion.construirNombreFichero());
			cstmt.registerOutParameter(5, Types.VARCHAR);
			cstmt.setString(6, "N");
			cstmt.setString(7, login);
			cstmt.registerOutParameter(8, Types.INTEGER);
			// cstmt = prepararLlamadaPLSQL(tipo, descr, params, nombreparam, login);
			cstmt.execute();
			result = cstmt.getInt(1);
			String nombreparam = cstmt.getString(5);
			int codigo = cstmt.getInt(8);
			if (logger.isDebugEnabled()) {
				logger.debug("{" + result + " = call ACCESO.PQ_LOG_PROCESOS.F_LANZA_INFORME(" + tipo + ", '" + params + "', '" + descr + "', '"
						+ nombreparam + "', 'N', '" + login + "', " + codigo + ")}");
			}
			String mensaje = "mensaje.ok";
			logger.info("Result: {}", result);
			switch (result) {
			case 0: // Lanzar report.
				HiloReport hilo = new HiloReport(dataSource, reportProperties, nombreparam, codigo, parametrosInvocacion, httpDescargadorFromUri);
				hilo.start();
				return BatchRespuesta.LANZADO;
			case -1: // Report lanzado por este usuario.
				return BatchRespuesta.LANZADO_ANTERIORMENTE;
			case -2: // Report lanzado por otro usuario.
				return BatchRespuesta.LANZADO_ANTERIORMENTE_POR_OTRO_USUARIO;
			default:
				throw new IllegalStateException("PLSQL F_LANZA_INFORME retorno un c�digo contemplado: " + result);
			}
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	protected void accesoAplicacion(Connection conn, String usuario) {
		try (CallableStatement cstmt = conn.prepareCall("begin acceso.control_accesos.g_login := ?; end;")) {
			cstmt.setString(1, usuario);
			cstmt.execute();
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
}
