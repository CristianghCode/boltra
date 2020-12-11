package es.sms.bolsa.view;

import static com.google.common.base.Predicates.equalTo;
import static com.google.common.base.Predicates.not;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.stream.Collectors;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;

import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;

import es.carm.sms.lobo2.service.exception.FunctionalException;
import es.carm.sms.lobo2.web.jsf.MessagesController;
import es.sms.bolsa.oracleforms.proceso.Proceso;
import es.sms.bolsa.oracleforms.proceso.ProcesoService;
import es.sms.bolsa.oracleforms.proceso.fichero.FicheroProceso;
import es.sms.bolsa.oracleforms.proceso.tipo.TipoProceso;

@Controller
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProcesoManagedBean {

	private static final String OPCION_MIS_PROCESOS = "misProcesos";

	private static final Logger logger = LoggerFactory.getLogger(ProcesoManagedBean.class);

	@Autowired
	private ProcesoService procesoService;
	@Autowired
	private MessagesController messagesController;

	private List<Proceso> procesos;
	private List<TipoProceso> tiposProceso;
	private TipoProceso tipoProcesoSelected;
	private String tipoBusqueda = OPCION_MIS_PROCESOS;

	public void init() {
		procesos = procesoService.recuperarByUsuarioLogado();
		tiposProceso = procesoService.recuperarTiposProceso();
	}

	public void tipoBusquedaChanged() {
		if (tipoBusqueda.equals(OPCION_MIS_PROCESOS)) {
			procesos = procesoService.recuperarByUsuarioLogado();
			tipoProcesoSelected = null;
		}
	}

	public void tipoProcesoChanged() {
		if (tipoProcesoSelected != null) {
			procesos = procesoService.recuperarByTipo(tipoProcesoSelected);
		}
	}

	public void eliminar(Proceso proceso) {
		try {
			procesoService.borrar(proceso);
			procesos = ImmutableList.copyOf(Collections2.filter(procesos, not(equalTo(proceso))));
		} catch (FunctionalException e) {
			messagesController.mostrarError(e);
		}
	}

	public boolean isMisProcesos() {
		return OPCION_MIS_PROCESOS.equals(tipoBusqueda);
	}

	public StreamedContent getFichero(Proceso peticion) {
		FicheroProceso fichero = null;
		try {
			fichero = procesoService.recuperarFichero(peticion);
		} catch (FunctionalException e) {
			logger.error("Error generando volante de petici�n", e);
			messagesController.mostrarError(e);
			return null;
		}
		return new DefaultStreamedContent(new ByteArrayInputStream(fichero.getContenido()), fichero.getMime(), peticion.getNombreReport());
	}

	public List<Proceso> getProcesosTipoInforme() {
		return procesos.stream()
				.filter(p -> !p.getTipoReport()
						.isProceso())
				.collect(Collectors.toList());
	}

	public List<Proceso> getProcesosTipoProceso() {
		return procesos.stream()
				.filter(p -> p.getTipoReport()
						.isProceso())
				.collect(Collectors.toList());
	}

	public List<Proceso> getProcesos() {
		return procesos;
	}

	public List<TipoProceso> getTiposProceso() {
		return tiposProceso;
	}

	public TipoProceso getTipoProcesoSelected() {
		return tipoProcesoSelected;
	}

	public void setTipoProcesoSelected(TipoProceso tipoProcesoSelected) {
		this.tipoProcesoSelected = tipoProcesoSelected;
	}

	public String getTipoBusqueda() {
		return tipoBusqueda;
	}

	public void setTipoBusqueda(String tipoBusqueda) {
		this.tipoBusqueda = tipoBusqueda;
	}

}
