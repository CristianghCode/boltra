package es.sms.bolsa.view.jsf.bean;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.primefaces.event.SelectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;

import es.carm.sms.lobo2.web.jsf.MessagesController;
import es.sms.bolsa.model.entity.AportacionMeritos;
import es.sms.bolsa.model.entity.BolsaTrab;
import es.sms.bolsa.model.entity.Convocatoria;
import es.sms.bolsa.model.entity.PunObt;
import es.sms.bolsa.model.entity.PunObtAportacion;
import es.sms.bolsa.service.AportacionMeritosService;
import es.sms.bolsa.service.BolsaTrabService;
import es.sms.bolsa.service.ConvocatoriaService;
import es.sms.bolsa.service.MasterService;
import es.sms.bolsa.service.PunObtAportacionService;
import es.sms.bolsa.service.PunObtService;
import es.sms.bolsa.view.jsf.paginator.AportacionMeritosPaginator;

@Controller
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ListadoAportacionMeritosBean extends MasterBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(ListadoAportacionMeritosBean.class);

	@Autowired
	private SesionBean sesionBean;

	@Autowired
	private BolsaTrabService bolsaTrabService;

	@Autowired
	private ConvocatoriaService convocatoriaService;

	@Autowired
	private AportacionMeritosService aportacionMeritosService;
	
	@Autowired
	private PunObtService punObtService;
	
	@Autowired
	private PunObtAportacionService punObtAportacionService;

	@Autowired
	private MessagesController messagesController;
	
	@Autowired
	private MasterService masterService;

	@Value("${es.sms.boltra.url}")
	private String rutaIntranet;

	private List<BolsaTrab> listBolsaTrab;

	private BolsaTrab bolsaTrabSeleccionada;

	private String idBolsaIntroducido;

	private String idConvocatoriaIntroducido;

	private Convocatoria convocatoriaSeleccionada;

	private List<Convocatoria> listConvocatorias;

	private AportacionMeritosPaginator listAportacionMeritos;

	private String nifInteresadoIntroducido;

	private int pageSize = 5;

	@PostConstruct
	public void init() {
		listBolsaTrab = bolsaTrabService.findAllOrderByCodigo();
		this.idBolsaIntroducido = null;
		this.bolsaTrabSeleccionada = null;
		this.idConvocatoriaIntroducido = null;
		this.convocatoriaSeleccionada = null;
		this.nifInteresadoIntroducido = null;
		this.listAportacionMeritos = new AportacionMeritosPaginator(aportacionMeritosService, convocatoriaSeleccionada,
				this.nifInteresadoIntroducido);
	}

	public double getPuntuacionTotalTribunal(AportacionMeritos aportacionMeritos) {
		PunObt p = this.punObtService.findPuntuacionTotal(aportacionMeritos.getConvocatoria(),
				aportacionMeritos.getInteresado().getId());
		
		if(p!=null) return p.getPuntuacionTotalObtenida();
			return 0.0;
	}
	
	public double getPuntuacionTotalOpositor(AportacionMeritos aportacionMeritos) {
		PunObtAportacion p = this.punObtAportacionService.findPuntuacionTotal(aportacionMeritos.getConvocatoria(),
				aportacionMeritos.getInteresado().getId(), aportacionMeritos.getCodigoAportacionMeritos());
		if(p!=null) return p.getPuntuacionTotalObtenida();
		return 0.0;
	}
	
	public List<BolsaTrab> getListBolsaTrab() {
		return listBolsaTrab;
	}

	public void setListBolsaTrab(List<BolsaTrab> listBolsaTrab) {
		this.listBolsaTrab = listBolsaTrab;
	}

	public BolsaTrab getBolsaTrabSeleccionada() {
		return bolsaTrabSeleccionada;
	}

	public void setBolsaTrabSeleccionada(BolsaTrab bolsaTrabSeleccionada) {
		this.bolsaTrabSeleccionada = bolsaTrabSeleccionada;
	}

	public String getIdBolsaIntroducido() {
		return idBolsaIntroducido;
	}

	public void setidBolsaIntroducido(String idBolsaIntroducido) {
		this.idBolsaIntroducido = idBolsaIntroducido;
	}

	public String getIdConvocatoriaIntroducido() {
		return idConvocatoriaIntroducido;
	}

	public void setIdConvocatoriaIntroducido(String idConvocatoriaIntroducido) {
		this.idConvocatoriaIntroducido = idConvocatoriaIntroducido;
	}

	public Convocatoria getConvocatoriaSeleccionada() {
		return convocatoriaSeleccionada;
	}

	public void setConvocatoriaSeleccionada(Convocatoria convocatoriaSeleccionada) {
		this.convocatoriaSeleccionada = convocatoriaSeleccionada;
	}

	public List<Convocatoria> getListConvocatorias() {
		return listConvocatorias;
	}

	public void setListConvocatorias(List<Convocatoria> listConvocatorias) {
		this.listConvocatorias = listConvocatorias;
	}

	public AportacionMeritosPaginator getListAportacionMeritos() {
		return listAportacionMeritos;
	}

	public void setListAportacionMeritos(AportacionMeritosPaginator listAportacionMeritos) {
		this.listAportacionMeritos = listAportacionMeritos;
	}

	public String getNifInteresadoIntroducido() {
		return nifInteresadoIntroducido;
	}

	public void setNifInteresadoIntroducido(String nifInteresadoIntroducido) {
		this.nifInteresadoIntroducido = nifInteresadoIntroducido;
	}

	public void buscarBolsaPorId() {
		if (idBolsaIntroducido == null || idBolsaIntroducido.isEmpty()) {
			this.addError("es.sms.aportacion.meritos.filtro.bolsa.error");
			limpiarCampos();
			this.listConvocatorias = null;
			return;
		}
		Long id = null;
		try {
			id = Long.parseLong(idBolsaIntroducido);
			if (id < 0)
				throw new NumberFormatException();
		} catch (NumberFormatException e) {
			this.addError("es.sms.aportacion.meritos.filtro.bolsa.error");
			limpiarCampos();
			this.listConvocatorias = null;
			return;
		}
		Optional<BolsaTrab> result = this.bolsaTrabService.findOne(id);
		this.bolsaTrabSeleccionada = (result.isPresent()) ? result.get() : null;
		if (this.bolsaTrabSeleccionada == null) {
			this.addWarning("es.sms.aportacion.meritos.filtro.bolsa.identificador.no.existe");
			this.idConvocatoriaIntroducido = null;
			this.convocatoriaSeleccionada = null;
			this.listAportacionMeritos.setConvocatoria(null);
			limpiarNifInteresado();
			this.listConvocatorias = null;
			return;
		}
		this.listConvocatorias = this.convocatoriaService.findByBolsaTrab(bolsaTrabSeleccionada);
		if (!listConvocatorias.isEmpty() && listConvocatorias.size() == 1) {
			this.convocatoriaSeleccionada = listConvocatorias.get(0);
			this.idConvocatoriaIntroducido = this.convocatoriaSeleccionada.getId().toString();
			this.listAportacionMeritos.setConvocatoria(convocatoriaSeleccionada);
			this.listAportacionMeritos.setNifInteresado(this.nifInteresadoIntroducido);
			cargarIdsAportaciones(convocatoriaSeleccionada, this.nifInteresadoIntroducido);

		} else {
			this.idConvocatoriaIntroducido = null;
			this.convocatoriaSeleccionada = null;
			this.listAportacionMeritos.setConvocatoria(null);
			limpiarNifInteresado();
		}
	}

	public void buscarConvocatoriaPorIdAndBolsa() {
		if (this.bolsaTrabSeleccionada == null || idConvocatoriaIntroducido == null
				|| idConvocatoriaIntroducido.isEmpty()) {
			this.addError("es.sms.aportacion.meritos.filtro.convocatoria.error");
			this.convocatoriaSeleccionada = null;
			this.listAportacionMeritos.setConvocatoria(null);
			return;
		}
		Long id = null;
		try {
			id = Long.parseLong(idConvocatoriaIntroducido);
			if (id < 0)
				throw new NumberFormatException();
		} catch (NumberFormatException e) {
			this.addError("es.sms.aportacion.meritos.filtro.convocatoria.error");
			this.idConvocatoriaIntroducido = null;
			this.convocatoriaSeleccionada = null;
			this.listAportacionMeritos.setConvocatoria(null);
			limpiarNifInteresado();
			return;
		}

		this.convocatoriaSeleccionada = this.convocatoriaService.findByIdAndBolsaTrab(id, bolsaTrabSeleccionada);
		if (this.convocatoriaSeleccionada == null) {
			this.addWarning("es.sms.aportacion.meritos.filtro.convocatoria.identificador.no.existe");
		}
		this.listAportacionMeritos.setConvocatoria(convocatoriaSeleccionada);
		this.listAportacionMeritos.setNifInteresado(this.nifInteresadoIntroducido);
		cargarIdsAportaciones(convocatoriaSeleccionada, nifInteresadoIntroducido);

	}

	public void buscarConvocatoriaPorIdAndBolsaAndNif() {
		if (this.bolsaTrabSeleccionada == null || idConvocatoriaIntroducido == null
				|| idConvocatoriaIntroducido.isEmpty() || this.nifInteresadoIntroducido == null
				|| this.nifInteresadoIntroducido.isEmpty()) {
			this.addError("es.sms.aportacion.meritos.filtro.nif.interesado.error");
			return;
		}

		this.listAportacionMeritos.setNifInteresado(nifInteresadoIntroducido);
		cargarIdsAportaciones(convocatoriaSeleccionada, nifInteresadoIntroducido);

	}

	public void actualizaInputBolsaTrab() {
		if (this.bolsaTrabSeleccionada != null) {
			this.idBolsaIntroducido = this.bolsaTrabSeleccionada.getCodigo().toString();
			this.listConvocatorias = this.convocatoriaService.findByBolsaTrab(bolsaTrabSeleccionada);
			if (!listConvocatorias.isEmpty() && listConvocatorias.size() == 1) {
				this.convocatoriaSeleccionada = listConvocatorias.get(0);
				this.idConvocatoriaIntroducido = this.convocatoriaSeleccionada.getId().toString();
				this.listAportacionMeritos.setConvocatoria(convocatoriaSeleccionada);
				this.listAportacionMeritos.setNifInteresado(nifInteresadoIntroducido);
				cargarIdsAportaciones(convocatoriaSeleccionada, nifInteresadoIntroducido);

			} else {
				this.idConvocatoriaIntroducido = null;
				this.convocatoriaSeleccionada = null;
				this.listAportacionMeritos.setConvocatoria(null);
				limpiarNifInteresado();

			}
		} else {
			this.idBolsaIntroducido = null;
			this.listConvocatorias = null;
			this.idConvocatoriaIntroducido = null;
			this.convocatoriaSeleccionada = null;
			this.listAportacionMeritos.setConvocatoria(null);
			limpiarNifInteresado();

		}
	}

	public void actualizaInputConvocatoria() {
		if (this.convocatoriaSeleccionada != null) {
			this.idConvocatoriaIntroducido = this.convocatoriaSeleccionada.getId().toString();
			this.listAportacionMeritos.setConvocatoria(convocatoriaSeleccionada);
			this.listAportacionMeritos.setNifInteresado(nifInteresadoIntroducido);
			cargarIdsAportaciones(convocatoriaSeleccionada, nifInteresadoIntroducido);
		} else {
			this.idConvocatoriaIntroducido = null;
			this.listAportacionMeritos.setConvocatoria(null);
			limpiarNifInteresado();

		}
	}

	public void limpiarCampos() {
		this.idBolsaIntroducido = null;
		this.bolsaTrabSeleccionada = null;
		this.convocatoriaSeleccionada = null;
		this.idConvocatoriaIntroducido = null;
		this.listAportacionMeritos.setConvocatoria(null);
	}

	public void onRowDblClckSelect(SelectEvent e) {
		String ruta = "";
		AportacionMeritos aportacionMeritos = (AportacionMeritos) e.getObject();
		sesionBean.actualizaNavegacion(aportacionMeritos.getCodigoAportacionMeritos());
		ruta = rutaIntranet + "/secure/bolsaTrab/detalle-aportacion-meritos.xhtml?idbolsa=" + this.idBolsaIntroducido
				+ "&idconvocatoria=" + this.idConvocatoriaIntroducido + "&idaportacionmeritos="
				+ aportacionMeritos.getCodigoAportacionMeritos();
		sesionBean.ir(ruta);
	}

	public void limpiarNifInteresado() {
		this.nifInteresadoIntroducido = null;
		this.listAportacionMeritos.setNifInteresado(null);
		cargarIdsAportaciones(convocatoriaSeleccionada, nifInteresadoIntroducido);
	}
	
	

	public void cargarIdsAportaciones(Convocatoria convocatoria, String nifInteresado) {
		List<Long> listaIdsAportaciones = null;
		if (nifInteresado == null || nifInteresado.isEmpty()) {
			listaIdsAportaciones = this.aportacionMeritosService.findIdsByConvocatoria(convocatoria);
		} else {
			listaIdsAportaciones = this.aportacionMeritosService.findIdsByConvocatoriaAndNif(convocatoria,
					nifInteresado);
		}
		sesionBean.setListaIdsAportaciones(listaIdsAportaciones);
	}

}
