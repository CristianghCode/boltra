package es.sms.bolsa.oracleforms.menu;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;

import es.sms.bolsa.config.common.IntegrationTest;
import es.sms.bolsa.oracleforms.menu.MenuFactory;
import es.sms.bolsa.oracleforms.menu.OpcionMenu;

public class MenuFactoryTest extends IntegrationTest {

	@Autowired
	private MenuFactory menuFactory;

	@Test
	@WithMockUser(authorities = { "Administrador del sistema", "Farmaceuticos del Servicio de Farmacia", "Administrativos del Servicio de Farmacia", "Perfil de consulta", "Pruebas" })
	public void seRecuperanOpcionesDeMenuAsociadaAlUsuarioLogado() {
		List<OpcionMenu> opciones = menuFactory.construir();

		assertThat(opciones).isNotEmpty();
	}
}
