package es.sms.bolsa.oracleforms.conexion;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;

import es.sms.bolsa.config.common.IntegrationTest;
import es.sms.bolsa.oracleforms.conexion.AccesoSessionManager;

public class AccesoSessionManagerTest extends IntegrationTest {

	@Autowired
	private AccesoSessionManager accesoSessionManager;

	@Test
	@WithMockUser("dios")
	public void seAbreSesionOk() {

		Long sesion = accesoSessionManager.abrirSesion();

		assertThat(sesion).isNotNegative();

	}

	@Test
	@WithMockUser("dios")
	public void seCierraSesionOk() {
		Long sesion = accesoSessionManager.abrirSesion();

		accesoSessionManager.cerrarSesion(sesion);

	}

	@Test
	@WithMockUser("dios")
	public void seCreaConexionFormsOk() {
		Long sesion = accesoSessionManager.abrirSesion();

		String hashSesion = accesoSessionManager.crearConexionForms(sesion);

		assertThat(hashSesion).isNotEmpty();

	}
}
