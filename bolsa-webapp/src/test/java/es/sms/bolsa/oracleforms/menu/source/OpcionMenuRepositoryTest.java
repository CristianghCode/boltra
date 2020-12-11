package es.sms.bolsa.oracleforms.menu.source;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.collect.ImmutableList;

import es.sms.bolsa.oracleforms.menu.OpcionMenu;
import es.sms.bolsa.oracleforms.menu.source.OpcionMenuRepository;

@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
@SpringBootTest
public class OpcionMenuRepositoryTest {

	@Autowired
	private OpcionMenuRepository opcionMenuRepository;

	@Test
	public void seRecuperanOpcionesOk() {
		List<OpcionMenu> opciones = opcionMenuRepository.find("MED",
				ImmutableList.of("Administrador del sistema", "FARMAC�UTICOS DEL SERVICIO DE FARMACIA"));

		assertThat(opciones).isNotEmpty();
	}

	@Test
	public void seRecuperanOpcionesOkRolCaseInsensitive() {
		List<OpcionMenu> opciones = opcionMenuRepository.find("MED", ImmutableList.of("ADMINIStRADOR DEL sistema"));

		assertThat(opciones).isNotEmpty();
	}

	@Test
	public void noSeRecuperaNingunaOpcionOk() {
		List<OpcionMenu> opciones = opcionMenuRepository.find("MED", ImmutableList.of());

		assertThat(opciones).isEmpty();
	}

}
