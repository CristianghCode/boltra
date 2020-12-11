package es.sms.bolsa.oracleforms.proceso.fichero;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.ImmutableMap;

import es.sms.bolsa.oracleforms.proceso.tipo.TipoProceso.TipoReport;

@Configuration
class FicheroConfiguration {

	@Autowired
	private JdbcFicheroProcesoRepository jdbcFicheroProcesoRepository;
	@Autowired
	private FileSystemFicheroProcesoRepository fileSystemFicheroProcesoRepository;

	@Bean
	public Map<TipoReport, FicheroProcesoRepository> ficheroProcesoRepositoryMap() {
		return ImmutableMap.of(TipoReport.INFORME, fileSystemFicheroProcesoRepository, TipoReport.PROCESO, jdbcFicheroProcesoRepository);
	}
}
