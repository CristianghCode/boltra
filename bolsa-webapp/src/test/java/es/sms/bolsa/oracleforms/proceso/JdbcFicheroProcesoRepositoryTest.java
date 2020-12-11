package es.sms.bolsa.oracleforms.proceso;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import es.carm.sms.lobo2.service.exception.FunctionalException;
import es.sms.bolsa.oracleforms.proceso.Proceso;
import es.sms.bolsa.oracleforms.proceso.fichero.FicheroProceso;
import es.sms.bolsa.oracleforms.proceso.fichero.JdbcFicheroProcesoRepository;

@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
@SpringBootTest
public class JdbcFicheroProcesoRepositoryTest {

	@Autowired
	private JdbcFicheroProcesoRepository ficheroProcesoRepository;

	@Test
	public void seRecuperaFicheroDeBDByIdOk() throws FunctionalException {
		FicheroProceso fichero = ficheroProcesoRepository.find(Proceso.create().withIdFichero(6191L).build());

		assertThat(fichero).isNotNull();
	}
	
}
