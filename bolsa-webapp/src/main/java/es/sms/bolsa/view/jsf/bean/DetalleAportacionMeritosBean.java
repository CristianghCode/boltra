package es.sms.bolsa.view.jsf.bean;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.hibernate.validator.internal.util.privilegedactions.GetClassLoader;
import org.primefaces.PrimeFaces;
import org.primefaces.event.NodeExpandEvent;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;

import es.carm.sms.lobo2.web.jsf.MessagesController;
import es.sms.bolsa.model.entity.AportacionMeritos;
import es.sms.bolsa.model.entity.AportacionMeritosItem;
import es.sms.bolsa.model.entity.BolsaTrab;
import es.sms.bolsa.model.entity.Convocatoria;
import es.sms.bolsa.model.entity.Fichero;
import es.sms.bolsa.model.entity.Master;
import es.sms.bolsa.model.entity.PunObt;
import es.sms.bolsa.model.entity.Situacion;
import es.sms.bolsa.service.AportacionMeritosItemService;
import es.sms.bolsa.service.AportacionMeritosService;
import es.sms.bolsa.service.BolsaTrabService;
import es.sms.bolsa.service.ConvocatoriaService;
import es.sms.bolsa.service.MasterService;
import es.sms.bolsa.service.PunObtService;
import es.sms.bolsa.service.SituacionService;
import es.sms.bolsa.view.jsf.paginator.AportacionMeritosItemPaginator;
import es.sms.bolsa.view.jsf.paginator.PunObtPaginator;

@Controller
@Scope(value = "view", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DetalleAportacionMeritosBean extends MasterBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(DetalleAportacionMeritosBean.class);

	@Autowired
	private SesionBean sesionBean;
	
	
	@Autowired
	private BolsaTrabService bolsaTrabService;

	@Autowired
	private ConvocatoriaService convocatoriaService;

	@Autowired
	private AportacionMeritosService aportacionMeritosService;

	@Autowired
	private AportacionMeritosItemService aportacionMeritosItemService;

	@Autowired
	private PunObtService punObtService;

	@Autowired
	private SituacionService situacionService;
	
	@Autowired
	private MasterService masterService;

	@Autowired
	private MessagesController messagesController;
	
	@Autowired
	private DetalleAportacionMeritosItemBean detallesAPortacionMeritosItem;

	@Value("${es.sms.boltra.url}")
	private String rutaIntranet;

	@Value("${es.sms.boltra.ruta.nfs}")
	private String rutaNFS;

	private Master master;
	
	private List<BolsaTrab> listBolsaTrab;

	private BolsaTrab bolsaTrabSeleccionada;

	private Convocatoria convocatoriaSeleccionada;

	private AportacionMeritos aportacionMeritos;

	private PunObtPaginator punObtPaginator;

	private PunObt puntuacionTotal;

	private PunObt punObtSeleccionado;

	private AportacionMeritosItemPaginator aportacionMeritosItemPaginator;

	private List<Situacion> situaciones;

	private Situacion situacionSeleccionada;

	private AportacionMeritosItem aportacionMeritosItemSeleccionada;

	private TreeNode arbolMeritos;

	/*

	private String nombreFichero;
	
	private String rutaPDF;
	
	private String nombrePDFEnCarpeta;

	private List<String> atributesColumns;
	
	private List<String> atributeColumnValue;
	
	private List<String> itemDetallesInput = new LinkedList<String>();
	
	private String[][] bufferColumnsTipoItem;
	
	private boolean itemEditing;
	
	*/

	

	private String tipoAportacion;

	private int nAportacionesMeritosAportados;




	
	@PostConstruct
	public void init() {
		
		
		FacesContext ctx = FacesContext.getCurrentInstance();
		ExternalContext ec = ctx.getExternalContext();
		Map<String, String> mapa = ec.getRequestParameterMap();
		String idBolsa = mapa.get("idbolsa");
		String idConvocatoria = mapa.get("idconvocatoria");
		String idAportacionMeritos = mapa.get("idaportacionmeritos");
		if (idBolsa == null || idBolsa.isEmpty() || idConvocatoria == null || idConvocatoria.isEmpty()
				|| idAportacionMeritos == null || idAportacionMeritos.isEmpty()) {

		}
		
		
		Long idBolsaLong = Long.parseLong(idBolsa);
		this.bolsaTrabSeleccionada = this.bolsaTrabService.findOne(idBolsaLong).get();
		Long idConvocatoriaLong = Long.parseLong(idConvocatoria);
		this.convocatoriaSeleccionada = this.convocatoriaService.findOne(idConvocatoriaLong).get();
		Long idAportacionMeritosLong = Long.parseLong(idAportacionMeritos);
		this.aportacionMeritos = this.aportacionMeritosService.findOne(idAportacionMeritosLong).get();
		
		comprobarTipoMerito(this.aportacionMeritos);
		
		// this.punObtPaginator = new PunObtPaginator(punObtService,
		// convocatoriaSeleccionada, aportacionMeritos.getInteresado().getId());
		this.puntuacionTotal = this.punObtService.findPuntuacionTotal(convocatoriaSeleccionada,
				aportacionMeritos.getInteresado().getId());
		
		
		this.situaciones = this.situacionService.findAll();
		limpiarEtiquetasHTMLSituaciones();

		this.arbolMeritos = new DefaultTreeNode(new PunObt(), null);
		TreeNode ramaPT = new DefaultTreeNode(puntuacionTotal, arbolMeritos);
		ramaPT.setExpanded(true);
		if(this.puntuacionTotal!=null)
		{
			List<PunObt> hijos = this.punObtService.findHijo(convocatoriaSeleccionada,
					aportacionMeritos.getInteresado().getId(), puntuacionTotal.getCodigoMerito());
			for (PunObt hijo : hijos) {
				TreeNode ramaHijo = new DefaultTreeNode(hijo, ramaPT);
				new DefaultTreeNode(null, ramaHijo);
			}
			if (this.sesionBean.getListaIdsAportaciones().isEmpty()) {
				List<Long> listaIdsAportaciones = this.aportacionMeritosService
						.findIdsByConvocatoria(convocatoriaSeleccionada);
				sesionBean.setListaIdsAportaciones(listaIdsAportaciones);
			}	
		}
	}
	
	
	private void comprobarTipoMerito(AportacionMeritos aportacionMeritos) {
		if(aportacionMeritos.getFechaRegistroEnRegistroCARM()!=null 
				&& aportacionMeritos.getAsientoCARM()!=null && aportacionMeritos.getTicketSIFE()!=null)
		{
			this.tipoAportacion="TELEMÁTICA";
		} else if(aportacionMeritos.getFechaRegistroEnRegistroCARM()==null)
		{
			this.tipoAportacion="NO REGISTRADA";
		} else {
			this.tipoAportacion="PRESENCIAL";
		}
	}


	public String getTipoAportacion() {
		return tipoAportacion;
	}


	public void setTipoAportacion(String tipoAportacion) {
		this.tipoAportacion = tipoAportacion;
	}


	

	public String getBaremada() {
		this.nAportacionesMeritosAportados = this.aportacionMeritosItemService
				.getNAportacionesMeritosItemAPortados(aportacionMeritos);

		if (this.nAportacionesMeritosAportados > 0)
			return "No";
		return "Sí";
	}
	
		
	
	
	public void reload() {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.remove("DetalleAportacionMeritosBean");
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

	public Convocatoria getConvocatoriaSeleccionada() {
		return convocatoriaSeleccionada;
	}

	public void setConvocatoriaSeleccionada(Convocatoria convocatoriaSeleccionada) {
		this.convocatoriaSeleccionada = convocatoriaSeleccionada;
	}

	public AportacionMeritos getAportacionMeritos() {
		return aportacionMeritos;
	}

	public void setAportacionMeritos(AportacionMeritos aportacionMeritos) {
		this.aportacionMeritos = aportacionMeritos;
	}

	public PunObtPaginator getPunObtPaginator() {
		return punObtPaginator;
	}

	public void setPunObtPaginator(PunObtPaginator punObtPaginator) {
		this.punObtPaginator = punObtPaginator;
	}

	public PunObt getPuntuacionTotal() {
		return puntuacionTotal;
	}

	public TreeNode getArbolMeritos() {
		return arbolMeritos;
	}

	public void setArbolMeritos(TreeNode arbolMeritos) {
		this.arbolMeritos = arbolMeritos;
	}

	public void setPuntuacionTotal(PunObt puntuacionTotal) {
		this.puntuacionTotal = puntuacionTotal;
	}

	public AportacionMeritosItemPaginator getAportacionMeritosItemPaginator() {
		return aportacionMeritosItemPaginator;
	}

	public void setAportacionMeritosItemPaginator(AportacionMeritosItemPaginator aportacionMeritosItemPaginator) {
		this.aportacionMeritosItemPaginator = aportacionMeritosItemPaginator;
	}

	public PunObt getPunObtSeleccionado() {
		return punObtSeleccionado;
	}

	public void setPunObtSeleccionado(PunObt punObtSeleccionado) {
		this.punObtSeleccionado = punObtSeleccionado;
	}

	public List<Situacion> getSituaciones() {
		return situaciones;
	}

	public void setSituaciones(List<Situacion> situaciones) {
		this.situaciones = situaciones;
	}

	public Situacion getSituacionSeleccionada() {
		return situacionSeleccionada;
	}

	public void setSituacionSeleccionada(Situacion situacionSeleccionada) {
		this.situacionSeleccionada = situacionSeleccionada;
	}

	public void volverListadoAportaciones() {
		String ruta = rutaIntranet + "/secure/bolsaTrab/listado-aportacion-meritos.xhtml";
		sesionBean.ir(ruta);
	}
	

	public void siguienteListaAportaciones() {
		Long codigo = this.aportacionMeritos.getCodigoAportacionMeritos();
		Long siguienteCodigo = sesionBean.siguiente(codigo);
		
			
		String ruta = rutaIntranet + "/secure/bolsaTrab/detalle-aportacion-meritos.xhtml?idbolsa="
				+ this.bolsaTrabSeleccionada.getCodigo() + "&idconvocatoria=" + this.convocatoriaSeleccionada.getId()
				+ "&idaportacionmeritos=" + siguienteCodigo;
		sesionBean.ir(ruta);

	}

	public void anteriorListaAportaciones() {
		Long codigo = this.aportacionMeritos.getCodigoAportacionMeritos();
		Long anteriorCodigo = sesionBean.anterior(codigo);
		String ruta = rutaIntranet + "/secure/bolsaTrab/detalle-aportacion-meritos.xhtml?idbolsa="
				+ this.bolsaTrabSeleccionada.getCodigo() + "&idconvocatoria=" + this.convocatoriaSeleccionada.getId()
				+ "&idaportacionmeritos=" + anteriorCodigo;
		sesionBean.ir(ruta);
	}

	public void onNodeExpandMeritos(NodeExpandEvent event) {
		TreeNode nodo = event.getTreeNode();
		PunObt punObt = (PunObt) nodo.getData();
		List<PunObt> hijos = this.punObtService.findHijo(this.convocatoriaSeleccionada,
				this.aportacionMeritos.getInteresado().getId(), punObt.getMerito().getIdMeritos());
		nodo.getChildren().clear();
		for (PunObt hijo : hijos) {
			TreeNode ramaHijo = new DefaultTreeNode(hijo, nodo);
			new DefaultTreeNode(null, ramaHijo);
		}
	}

	public void onNodeSelect(NodeSelectEvent event) {
		this.punObtSeleccionado = (PunObt) event.getTreeNode().getData();
		
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.put("pubObtSeleccionado", this.punObtSeleccionado);
		sessionMap.put("aportacionMeritosItemPaginator", this.aportacionMeritosItemPaginator);
		sessionMap.put("aportacionMeritos", this.aportacionMeritos);
		
		String ruta = rutaIntranet + "/secure/bolsaTrab/detalle-items-meritos.xhtml";
		sesionBean.ir(ruta);
	//	this.openDialog("itemsMeritosdlg");
	}
	
	
	public Master getMaster(AportacionMeritosItem aportacionMeritosItem) {
		this.master = masterService.findById(aportacionMeritosItem.getItem().getId()).get();
		
		return this.master;
	}
	


	public void guardarAportacionMeritoItem(AportacionMeritosItem aportacionMeritosItem) {
		this.aportacionMeritosItemService.save(aportacionMeritosItem);
	}

	public void expandirArbol() {
		TreeNode n = arbolMeritos.getChildren().get(0);
		PunObt aux = (PunObt) n.getData();
		List<PunObt> hijos = this.punObtService.findHijo(this.convocatoriaSeleccionada,
				this.aportacionMeritos.getInteresado().getId(), aux.getMerito().getIdMeritos());
		n.getChildren().clear();
		for (PunObt hijo : hijos) {
			TreeNode ramaHijo = new DefaultTreeNode(hijo, n);
			new DefaultTreeNode(null, ramaHijo);
			recorrerArbol(ramaHijo);
		}

	}

	public void recorrerArbol(TreeNode nodo) {
		PunObt aux = (PunObt) nodo.getData();
		List<PunObt> hijos = this.punObtService.findHijo(this.convocatoriaSeleccionada,
				this.aportacionMeritos.getInteresado().getId(), aux.getMerito().getIdMeritos());
		if (hijos.isEmpty())
			return;
		nodo.getChildren().clear();
		for (PunObt hijo : hijos) {
			TreeNode ramaHijo = new DefaultTreeNode(hijo, nodo);
			recorrerArbol(ramaHijo);
			ramaHijo.setExpanded(true);
		}
		nodo.setExpanded(true);

	}

	public boolean puedeDescargarFichero(String nombreFichero) {
		boolean puedeDescargar = false;
		String rutaFichero = rutaNFS + "mi-carpeta/" + aportacionMeritos.getNifInteresado() + "/" + nombreFichero;
		File file = new File(rutaFichero);
		if (file.exists())
			puedeDescargar = true;
		return puedeDescargar;

	}

	public StreamedContent descargarFichero(String nombreFichero) {
		StreamedContent value = null;
		String rutaFichero = rutaNFS + "mi-carpeta/" + aportacionMeritos.getNifInteresado() + "/" + nombreFichero;
		byte[] contenido = null;
		try {
			contenido = Files.readAllBytes(Paths.get(rutaFichero));
			value = new DefaultStreamedContent(new ByteArrayInputStream(contenido), "text/pdf", nombreFichero);
		} catch (IOException e) {
			this.addError("es.sms.aportacion.meritos.item.fichero.descargar.no.existe");
			logger.info(e.getCause().getLocalizedMessage());

		}
		return value;
	}


	public void editarSituacion(AportacionMeritosItem aportacionMeritosItem) {
		this.aportacionMeritosItemSeleccionada = aportacionMeritosItem;
		this.situacionSeleccionada = this.aportacionMeritosItemSeleccionada.getSituacion();
		this.openDialog("situacionesdlg");
	}

	public void actualizarSituacion() {
		this.aportacionMeritosItemSeleccionada.setSituacion(situacionSeleccionada);
		this.aportacionMeritosItemService.save(aportacionMeritosItemSeleccionada);
		this.closeDialog("situacionesdlg");
	}

	public void limpiarEtiquetasHTMLSituaciones() {
		String regex = "</*br\\s*/*>";
		for (Situacion s : this.situaciones) {
			String cadenaLimpia = s.getDescripcion().replaceAll(regex, " ");
			s.setDescripcion(cadenaLimpia);
		}
	}
}
