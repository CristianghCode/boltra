package es.sms.bolsa.oracleforms.proceso;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import es.carm.sms.lobo2.service.exception.FunctionalException;
import es.sms.bolsa.oracleforms.proceso.Proceso;
import es.sms.bolsa.oracleforms.proceso.ProcesoService;
import es.sms.bolsa.oracleforms.proceso.fichero.FicheroProceso;
import es.sms.bolsa.oracleforms.proceso.tipo.TipoProceso;

@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
@SpringBootTest
public class ProcesoServiceImplTest {

	@Autowired
	private ProcesoService procesoService;

	@Test
	public void seRecuperanTiposProcesoOk() {
		// Given tipos en BD.

		List<TipoProceso> tipos = procesoService.recuperarTiposProceso();

		assertThat(tipos).isNotNull();
		assertThat(tipos).hasSize(8);
	}

	@Test
	@WithMockUser("dios")
	public void seRecuperanProcesosOk() {
		// Given procesos en BD.

		List<Proceso> procesos = procesoService.recuperarByUsuarioLogado();

		assertThat(procesos).isNotEmpty();
	}

	@Test
	public void seRecuperanProcesosByTipo() {
		TipoProceso tipoDeBusqueda = TipoProceso.create()
				.withId(6)
				.build();

		List<Proceso> procesos = procesoService.recuperarByTipo(tipoDeBusqueda);

		assertThat(procesos).isNotEmpty();
		assertThat(procesos).extracting("tipoProceso")
				.extracting("id")
				.containsOnly(tipoDeBusqueda.getId());
	}

	@Test
	@Ignore("Poner con rule")
	public void seRecuperanFicheroInformeDeFileSystemOk() throws FunctionalException {
		Proceso proceso = Proceso.create()
				.withNombreReport("6138_FAC2402.pdf")
				.withTipo(TipoProceso.create()
						.withTipoReport("I")
						.build())
				.build();

		FicheroProceso fichero = procesoService.recuperarFichero(proceso);

		assertThat(fichero.getContenido()).isNotNull();
	}

	@Test
	public void seRecuperanFicheroProcesoDeBDOk() throws FunctionalException {
		Proceso proceso = Proceso.create()
				.withIdFichero(6193L)
				.withTipo(TipoProceso.create()
						.withTipoReport("P")
						.build())
				.build();

		FicheroProceso fichero = procesoService.recuperarFichero(proceso);

		assertThat(fichero.getContenido()).isNotNull();
	}

	@Test
	public void seLanzaExceptionSiFicheroFileSystemNoExiste() {
		Proceso proceso = Proceso.create()
				.withNombreReport("NO_EXISTE.pdf")
				.withTipo(TipoProceso.create()
						.withTipoReport("I")
						.build())
				.build();

		Throwable thrown = catchThrowable(() -> {
			procesoService.recuperarFichero(proceso);
		});

		assertThat(thrown).isInstanceOf(FunctionalException.class)
				.hasMessageContaining("Error leyendo fichero");
	}

	@Test
	@Ignore("rules para ficheros")
	public void seBorraInformeOk() throws FunctionalException {
		Proceso procesoABorrar = Proceso.create()
				.withId(1L)
				.withTipo(TipoProceso.create()
						.withTipoReport("I")
						.build())
				.withNombreReport("0_FAC2402.pdf")
				.build();

		procesoService.borrar(procesoABorrar);
	}

	@Test
	@Ignore("rules para ficheros, sin tiempo")
	public void seBorraProcesoOk() throws FunctionalException {
		Proceso procesoABorrar = Proceso.create()
				.withId(1L)
				.withTipo(TipoProceso.create()
						.withTipoReport("P")
						.build())
				.withIdFichero(1L)
				.build();

		procesoService.borrar(procesoABorrar);
	}

}