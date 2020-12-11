package es.sms.bolsa.oracleforms.proceso.fichero;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.google.common.io.Files;

import es.carm.sms.lobo2.service.exception.FunctionalException;
import es.sms.bolsa.oracleforms.proceso.Proceso;

@Repository
public class FileSystemFicheroProcesoRepository implements FicheroProcesoRepository {

	@Value("${steria.reports.directorio}")
	private String directorioReport;

	@Override
	public FicheroProceso find(Proceso proceso) throws FunctionalException {
		File file = new File(directorioReport + File.separator + proceso.getNombreReport());
		byte[] contenido;
		try {
			contenido = Files.toByteArray(file);
		} catch (IOException e) {
			throw FunctionalException.builder("Error leyendo fichero", e)
					.build();
		}
		String mime = recuperarMimeFromFile(proceso);

		return FicheroProceso.create()
				.withContenido(contenido)
				.withMime(mime)
				.withNombre(proceso.getNombreReport())
				.build();
	}

	@Override
	public void delete(Proceso proceso) throws FunctionalException {
		Path path = Paths.get(directorioReport + File.separator + proceso.getNombreReport());
		try {
			java.nio.file.Files.delete(path);
		} catch (IOException e) {
			throw FunctionalException.builder("Error eliminando fichero", e)
					.build();
		}
	}
	
	private String recuperarMimeFromFile(Proceso proceso) throws FunctionalException {
		String mime;
		try {
			mime = java.nio.file.Files.probeContentType(Paths.get(directorioReport + File.separator + proceso.getNombreReport()));
		} catch (IOException e) {
			throw FunctionalException.builder("Error comprobando el tipo Mime", e)
					.build();
		}
		return mime;
	}
}
