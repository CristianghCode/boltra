package es.sms.bolsa.oracleforms.conexion;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import es.sms.bolsa.config.DataSourceConfig;
import es.sms.bolsa.oracleforms.conexion.AccesoSessionDao;
import es.sms.bolsa.oracleforms.conexion.Conexion;
import es.sms.bolsa.oracleforms.conexion.JdbcAccesoSessionDao;

@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
@JdbcTest
@AutoConfigureTestDatabase(replace = NONE)
@Import({ JdbcAccesoSessionDao.class, DataSourceConfig.class })
public class AccesoSessionDaoTest {

	@Autowired
	private AccesoSessionDao accesoSessionDao;

	@Test
	public void seAbreSesionOk() {
		Conexion conexion = new Conexion("dios", "test.test.test", "MED");

		Long sesion = accesoSessionDao.abrirSesion(conexion);

		assertThat(sesion).isNotNull();
		assertThat(sesion).isNotNegative();
	}

	@Test
	public void seCierraSesionExistenteOk() {
		Conexion conexion = new Conexion("dios", "test.test.test", "MED");
		Long sesion = accesoSessionDao.abrirSesion(conexion);

		accesoSessionDao.cerrarSesion(sesion);

	}

	@Test
	public void seCreaSesionFormsOk() {

		String hashSesion = accesoSessionDao.crearConexionForms("dios", 417542L);

		assertThat(hashSesion).isNotEmpty();
	}
}
