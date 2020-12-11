package es.sms.bolsa.oracleforms.conexion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import es.sms.bolsa.common.UsuarioLogadoHolder;

@Service
class AccesoSessionManagerImpl implements AccesoSessionManager {

	@Autowired
	private AccesoSessionDao accesoSessionDao;
	@Autowired
	private UsuarioLogadoHolder usuarioLogadoHolder;
	@Value("${es.sms.codigo}")
	private String codigoAplicacion;

	@Override
	public Long abrirSesion() {
		Conexion conexion = buildConexion();
		return accesoSessionDao.abrirSesion(conexion);
	}

	private Conexion buildConexion() {
		return new Conexion(SecurityContextHolder.getContext()
				.getAuthentication()
				.getName(), usuarioLogadoHolder.getRemoteAddr(), codigoAplicacion);
	}

	@Override
	public void cerrarSesion(long sesion) {
		accesoSessionDao.cerrarSesion(sesion);
	}

	@Override
	public String crearConexionForms(long sesion) {
		return accesoSessionDao.crearConexionForms(usuarioLogadoHolder.getLogin(), sesion);
	}

}
