package es.sms.bolsa.view.jsf.bean;



import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.model.StreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import es.carm.sms.lobo2.core.Lobo2Utils;
import es.sms.bolsa.enumEntity.ExproNoOficioEnum;
import es.sms.bolsa.enumEntity.FormacionContinuadaEnum;
import es.sms.bolsa.enumEntity.FormacionEspecializadaEnum;
import es.sms.bolsa.enumEntity.InternoResidenteEnum;
import es.sms.bolsa.enumEntity.InvestigacionEnum;
import es.sms.bolsa.enumEntity.MasterEnum;
import es.sms.bolsa.enumEntity.RelacionFijezaEnum;
import es.sms.bolsa.enumEntity.TipoMeritosItemEnum;
import es.sms.bolsa.enumEntity.TitulacionDoctoradoEnum;
import es.sms.bolsa.enumEntity.TitulacionEnum;
import es.sms.bolsa.enumEntity.TitulacionExpedienteEnum;
import es.sms.bolsa.enumEntity.TitulacionPremioEnum;
import es.sms.bolsa.model.entity.AportacionMeritos;
import es.sms.bolsa.model.entity.AportacionMeritosItem;
import es.sms.bolsa.model.entity.Convocatoria;
import es.sms.bolsa.model.entity.ExproNoOficio;
import es.sms.bolsa.model.entity.ExproNoOficioTribunal;
import es.sms.bolsa.model.entity.Fichero;
import es.sms.bolsa.model.entity.FormacionContinuada;
import es.sms.bolsa.model.entity.FormacionContinuadaTribunal;
import es.sms.bolsa.model.entity.FormacionEspecializada;
import es.sms.bolsa.model.entity.FormacionEspecializadaTribunal;
import es.sms.bolsa.model.entity.InternoResidente;
import es.sms.bolsa.model.entity.InternoResidenteTribunal;
import es.sms.bolsa.model.entity.Investigacion;
import es.sms.bolsa.model.entity.InvestigacionTribunal;
import es.sms.bolsa.model.entity.Item;
import es.sms.bolsa.model.entity.Master;
import es.sms.bolsa.model.entity.MasterTribunal;
import es.sms.bolsa.model.entity.PunObt;
import es.sms.bolsa.model.entity.RelacionFijeza;
import es.sms.bolsa.model.entity.RelacionFijezaTribunal;
import es.sms.bolsa.model.entity.Situacion;
import es.sms.bolsa.model.entity.Titulacion;
import es.sms.bolsa.model.entity.TitulacionDoctorado;
import es.sms.bolsa.model.entity.TitulacionDoctoradoTribunal;
import es.sms.bolsa.model.entity.TitulacionExpediente;
import es.sms.bolsa.model.entity.TitulacionExpedienteTribunal;
import es.sms.bolsa.model.entity.TitulacionPremio;
import es.sms.bolsa.model.entity.TitulacionPremioTribunal;
import es.sms.bolsa.model.entity.TitulacionTribunal;
import es.sms.bolsa.model.entity.TribunalHistorico;
import es.sms.bolsa.service.AportacionMeritosItemService;
import es.sms.bolsa.service.ExproNoOficioService;
import es.sms.bolsa.service.ExproNoOficioTribunalService;
import es.sms.bolsa.service.FormacionContinuadaService;
import es.sms.bolsa.service.FormacionContinuadaTribunalService;
import es.sms.bolsa.service.FormacionEspecializadaService;
import es.sms.bolsa.service.FormacionEspecializadaTribunalService;
import es.sms.bolsa.service.InternoResidenteService;
import es.sms.bolsa.service.InternoResidenteTribunalService;
import es.sms.bolsa.service.InvestigacionService;
import es.sms.bolsa.service.InvestigacionTribunalService;
import es.sms.bolsa.service.MasterService;
import es.sms.bolsa.service.MasterTribunalService;
import es.sms.bolsa.service.RelacionFijezaService;
import es.sms.bolsa.service.RelacionFijezaTribunalService;
import es.sms.bolsa.service.SituacionService;
import es.sms.bolsa.service.TitulacionDoctoradoService;
import es.sms.bolsa.service.TitulacionDoctoradoTribunalService;
import es.sms.bolsa.service.TitulacionExpedienteService;
import es.sms.bolsa.service.TitulacionExpedienteTribunalService;
import es.sms.bolsa.service.TitulacionPremioService;
import es.sms.bolsa.service.TitulacionPremioTribunalService;
import es.sms.bolsa.service.TitulacionService;
import es.sms.bolsa.service.TitulacionTribunalService;
import es.sms.bolsa.service.TribunalHistoricoService;
import es.sms.bolsa.view.jsf.paginator.AportacionMeritosItemPaginator;






@Controller
@Scope(value = "view", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DetalleAportacionMeritosItemBean extends MasterBean {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(DetalleAportacionMeritosItemBean.class);


	
	@Autowired
	private SesionBean sesionBean;
 
	@Autowired
	private AportacionMeritosItemService aportacionMeritosItemService;
	
	@Autowired
	private SituacionService situacionService;
	
	@Autowired
	private MasterService masterService;
	
	@Autowired
	private MasterTribunalService masterTribunalService;
	
	@Autowired
	private TribunalHistoricoService tribunalHistoricoService;
	
	@Autowired
	private TitulacionExpedienteService titulacionExpedienteService;
	
	@Autowired
	private TitulacionExpedienteTribunalService titulacionExpedienteTribunalService;
	
	@Autowired
	private FormacionContinuadaService formacionContinuadaService;
	
	@Autowired
	private FormacionContinuadaTribunalService formacionContinuadaTribunalService;
	
	@Autowired
	private InvestigacionService investigacionService;
	
	@Autowired
	private InvestigacionTribunalService investigacionTribunalService;
	
	@Autowired
	private InternoResidenteService internoResidenteService;
	
	@Autowired
	private InternoResidenteTribunalService internoResidenteTribunalService;
	
	@Autowired
	private TitulacionPremioService titulacionPremioService;
	
	@Autowired
	private TitulacionPremioTribunalService titulacionPremioTribunalService;
	
	@Autowired
	private FormacionEspecializadaService formacionEspecializadaService;
	
	@Autowired
	private FormacionEspecializadaTribunalService formacionEspecializadaTribunalService;

	@Autowired
	private RelacionFijezaService relacionFijezaService;
	
	@Autowired
	private RelacionFijezaTribunalService relacionFijezaTribunalService;
	
	@Autowired
	private TitulacionService titulacionService;
	
	@Autowired
	private TitulacionTribunalService titulacionTribunalService;
	
	@Autowired
	private ExproNoOficioService exproNoOficioService;
	
	@Autowired
	private ExproNoOficioTribunalService exproNoOficioTribunalService;
	
	@Autowired
	private TitulacionDoctoradoService titulacionDoctoradoService;
	
	@Autowired
	private TitulacionDoctoradoTribunalService titulacionDoctoradoTribunalService;


	

	@Value("${es.sms.boltra.ruta.nfs}")
	private String rutaNFS;
	
	@Value("${es.sms.boltra.url}")
	private String rutaIntranet;

	
	
	
	private AportacionMeritosItemPaginator aportacionMeritosItemPaginator;
	
	private AportacionMeritos aportacionMeritos;
	
	private String tipo;
	   
	private String rutaPDF;
	
	private String nombrePDFEnCarpeta;
	
	private PunObt punObtSeleccionado;
	
	/**
	 * Variable que controla el renderizado de los botones de edicon
	 */
	private boolean[] isEditing;
	
	
	private StreamedContent tmpPDF;
	
	
	private String[] tipoMeritosValuesString;
	
	/**
	 * Variable que controla que solo se pueda editar una fila a la vez
	 */
	private boolean editing;
	
	private Map<Long, String[]> mapaValues;
		
	private Map<Long,Situacion> mapaSituacion;

	private Map<String, Long> mapaSituacionId;
	
	private String[] arrayIdSituacion;
	
	private String[] arrayTipoMeritosItemOriginalSeleccionado;
	
	private AportacionMeritosItem aportacionMeritosItemSeleccionada;
	
	
 

	


	public AportacionMeritosItem getAportacionMeritosItemSeleccionada() {
		return aportacionMeritosItemSeleccionada;
	}


	public void setAportacionMeritosItemSeleccionada(AportacionMeritosItem aportacionMeritosItemSeleccionada) {
		this.aportacionMeritosItemSeleccionada = aportacionMeritosItemSeleccionada;
	}


	@PostConstruct
	public void init() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		ExternalContext ec = ctx.getExternalContext();
		Map<String, Object> mapa = ec.getSessionMap();
		this.punObtSeleccionado = (PunObt) mapa.get("pubObtSeleccionado");
		this.aportacionMeritosItemPaginator = (AportacionMeritosItemPaginator) mapa.get("aportacionMeritosItemPaginator");
		this.aportacionMeritos = (AportacionMeritos) mapa.get("aportacionMeritos");
	
	
		this.aportacionMeritosItemPaginator = new AportacionMeritosItemPaginator(this.aportacionMeritosItemService,
				this.aportacionMeritos, this.punObtSeleccionado.getMerito());
	
		
		//habría que hacer un case y según un merito u otro cargar el servicio
		//también podríamos hacerlo con ligadura dinámica

		this.aportacionMeritosItemPaginator.setMasterService(this.masterService);
		this.aportacionMeritosItemPaginator.setMasterTribunalService(this.masterTribunalService);
		this.aportacionMeritosItemPaginator.setTitulacionExpedienteService(titulacionExpedienteService);
		this.aportacionMeritosItemPaginator.setTitulacionExpedienteTribunalService(titulacionExpedienteTribunalService);
		this.aportacionMeritosItemPaginator.setFormacionContinuadaService(formacionContinuadaService);
		this.aportacionMeritosItemPaginator.setFormacionContinuadaTribunalService(formacionContinuadaTribunalService);
		this.aportacionMeritosItemPaginator.setInvestigacionService(this.investigacionService);
		this.aportacionMeritosItemPaginator.setInvestigacionTribunalService(this.investigacionTribunalService);
		this.aportacionMeritosItemPaginator.setInternoResidenteService(internoResidenteService);
		this.aportacionMeritosItemPaginator.setInternoResidenteTribunalService(internoResidenteTribunalService);
		this.aportacionMeritosItemPaginator.setTitulacionPremioService(titulacionPremioService);
		this.aportacionMeritosItemPaginator.setTitulacionPremioTribunalService(titulacionPremioTribunalService);
		this.aportacionMeritosItemPaginator.setFormacionEspecializadaService(formacionEspecializadaService);
		this.aportacionMeritosItemPaginator.setFormacionEspecializadaTribunalService(formacionEspecializadaTribunalService);
		this.aportacionMeritosItemPaginator.setRelacionFijezaService(relacionFijezaService);
		this.aportacionMeritosItemPaginator.setRelacionFijezaTribunalService(relacionFijezaTribunalService);
		this.aportacionMeritosItemPaginator.setTitulacionService(titulacionService);
		this.aportacionMeritosItemPaginator.setTitulacionTribunalService(titulacionTribunalService);
		this.aportacionMeritosItemPaginator.setExproNoOficioService(exproNoOficioService);
		this.aportacionMeritosItemPaginator.setExproOficioTribunalService(exproNoOficioTribunalService);
		this.aportacionMeritosItemPaginator.setExproOficioTribunalService(exproNoOficioTribunalService);
		this.aportacionMeritosItemPaginator.setTitulacionDoctoradoService(titulacionDoctoradoService);
		this.aportacionMeritosItemPaginator.setTitulacionDoctoradoTribunalService(titulacionDoctoradoTribunalService);
//		this.listValues = new LinkedList<String[]>();
		
		
	
				
		mapaSituacionId  = new HashMap<String, Long>();
		this.mapaSituacion = new HashMap<Long, Situacion>();
			
		//esto se tiene que pasar a aportacionpaginator y que el id sea el de el item
		for (Situacion situacion : this.situacionService.findAll()) {
			mapaSituacion.put(situacion.getCodigo(), situacion);
			//limpiamos la descripcion de las situaciones
			String regex = "</*br\\s*/*>";
				String cadenaLimpia = situacion.getDescripcion().replaceAll(regex, " ");
				situacion.setDescripcion(cadenaLimpia);
			this.mapaSituacionId.put(situacion.getNombre()+" - "+situacion.getDescripcion(), situacion.getCodigo());
			
		}

	}
	

	public String[] getArrayIdSituacion() {
		if(this.arrayIdSituacion==null)     this.arrayIdSituacion = this.aportacionMeritosItemPaginator.getArrayMeritosItemSituacion();
		return arrayIdSituacion;
	}


	public void setArrayIdSituacion(String[] arrayIdSituacion) {
		this.arrayIdSituacion = arrayIdSituacion;
	}


	public Map<String, Long> getMapaSituacionId() {
		return mapaSituacionId;
	}



	public void setMapaSituacionId(Map<String, Long> mapaSituacionId) {
		this.mapaSituacionId = mapaSituacionId;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public Map<Long, Situacion> getMapaSituacion() {
		return mapaSituacion;
	}

	public String getNombreSituacionSeleccionada(AportacionMeritosItem aportacionMeritosItem)
	{
		return aportacionMeritosItem.getSituacion().getNombre();
	}



	public void setMapaSituacion(Map<Long, Situacion> mapaSituacion) {
		this.mapaSituacion = mapaSituacion;
	}

/*
	public String[] getListValues(int index) {
		return listValues.get(index);
	}


	public void setListValues(List<String[]> listValues) {
		this.listValues = listValues;
	}
*/

	public Map<Long, String[]> getMapaValues() {
		return mapaValues;
	}

	public void setMapaValues(Map<Long, String[]> mapaValues) {
		this.mapaValues = mapaValues;
	}





	public boolean isEditing() {
		return editing;
	}





	public void setEditing(boolean editing) {
		this.editing = editing;
	}





	public String[] getValuesEdit() {
		return tipoMeritosValuesString;
	}





	public void setValuesEdit(String[] valuesEdit) {
		this.tipoMeritosValuesString = valuesEdit;
	}
	
	 public void modificarSituacion(AportacionMeritosItem aportacionMeritoItem, int index) {
		 	
			aportacionMeritoItem.setSituacion(this.mapaSituacion.get(Long.parseLong(this.arrayIdSituacion[index])));
			this.aportacionMeritosItemService.save(aportacionMeritoItem);
		     FacesContext context = FacesContext.getCurrentInstance();
		         
		     context.addMessage(null, new FacesMessage("La situación ha sido modificada con éxito"));
		 
		
	    }
	
	public String formatDateString(String date) {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			return format.format(format.parse(date));
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void setTmpPDF(StreamedContent tmpPDF) {
		this.tmpPDF = tmpPDF;
	}


	public AportacionMeritosItemService getAportacionMeritosItemService() {
		return aportacionMeritosItemService;
	}

	public void setAportacionMeritosItemService(AportacionMeritosItemService aportacionMeritosItemService) {
		this.aportacionMeritosItemService = aportacionMeritosItemService;
	}

	private Situacion situacionSeleccionada;
	
	public Situacion getSituacionSeleccionada() {
		
		return situacionSeleccionada;
	}
	

	public void setSituacionSeleccionada(Situacion situacion) {
		this.situacionSeleccionada = situacion;
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


////String regex = "</*br\\s*/*>";
/*
	public void limpiarEtiquetasHTMLSituaciones() {
	
		for (Situacion s : this.situaciones) {
			String cadenaLimpia = s.getDescripcion().replaceAll(regex, " ");
			s.setDescripcion(cadenaLimpia);
		}
	}
*/	
	
	public boolean puedeDescargarFichero(String nombreFichero) {
		boolean puedeDescargar = false;
		String rutaFichero = rutaNFS + "mi-carpeta/" + aportacionMeritos.getNifInteresado() + "/" + nombreFichero;
		File file = new File(rutaFichero);
		if (file.exists())
			puedeDescargar = true;
		return puedeDescargar;

	}
	
	public void volverAtras() {
		String ruta = "";
		sesionBean.actualizaNavegacion(aportacionMeritos.getCodigoAportacionMeritos());
		Convocatoria c = this.aportacionMeritos.getConvocatoria();
		ruta = rutaIntranet + "/secure/bolsaTrab/detalle-aportacion-meritos.xhtml?idbolsa=" + c.getBolsaTrabajo().getCodigo() 
				+ "&idconvocatoria=" + c.getId() + "&idaportacionmeritos="
				+ aportacionMeritos.getCodigoAportacionMeritos();
		sesionBean.ir(ruta);

	}
	
	public AportacionMeritos getAportacionMeritos() {
		return aportacionMeritos;
	}

	public void setAportacionMeritos(AportacionMeritos aportacionMeritos) {
		this.aportacionMeritos = aportacionMeritos;
	}

	public String getRutaPDF() {
		return rutaPDF;
	}

	public void setRutaPDF(String rutaPDF) {
		this.rutaPDF = rutaPDF;
	}

	public String getNombrePDFEnCarpeta() {
		return nombrePDFEnCarpeta;
	}

	public void setNombrePDFEnCarpeta(String nombrePDFEnCarpeta) {
		this.nombrePDFEnCarpeta = nombrePDFEnCarpeta;
	}

	public void cargarFichero(Fichero fichero) {
		
		String rutaFichero = rutaNFS + "mi-carpeta/" + fichero.getDni() + "/" + fichero.getNombreCarpeta();
		this.rutaPDF=rutaFichero;
		this.nombrePDFEnCarpeta=fichero.getNombreCarpeta();
	    this.setRutaPDF(this.rutaPDF);
	    this.setNombrePDFEnCarpeta(this.nombrePDFEnCarpeta);
		this.openDialog("pdf");
	}
	
	public String[] getArrayTipoMeritosItemOriginalSeleccionado()
	{
		return this.arrayTipoMeritosItemOriginalSeleccionado;
	}
	
	
	public void setArrayTipoMeritosItemOriginalSeleccionado(String[] arrayTipoMeritosItemOriginalSeleecionado) {
		this.arrayTipoMeritosItemOriginalSeleccionado = arrayTipoMeritosItemOriginalSeleecionado;
	}
	
	public void abrirDialogoItemOriginal(Item item) {
		
		this.arrayTipoMeritosItemOriginalSeleccionado = this.aportacionMeritosItemPaginator.getMapTipoMeritosItemOriginal().get(item.getId());
		this.openDialog("item-original");
	}
	
	public void cargarString(Item item) {
	Object tipoMeritoItem = this.aportacionMeritosItemPaginator.getTipoMeritosItem().get(item.getId());
		
		//cambiar por un case	
	}
	

	/**
	 * Comprueba si el item está siendo editado
	 * @return
	 */
    public boolean isItemEditing(int index) {
    	
    	if(this.aportacionMeritosItemPaginator.getMapItemValues().size()!=0)
    	{
    		if(this.isEditing==null)
        	{
        		this.isEditing=new boolean[this.aportacionMeritosItemPaginator.getMapItemValues().size()];
        	}
        	return this.isEditing[index];       
    	}   	
    	return false; 	
    }

    
	public void itemEdit(int index, Long id) {

    	this.tipoMeritosValuesString = this.aportacionMeritosItemPaginator.getMapItemValues().get(id).clone();
    	
    	this.editing=true;
	
		this.isEditing[index]=true;    
	 }
	

	
	public void editingDecline(int index, Long id) {
		this.tipoMeritosValuesString = this.aportacionMeritosItemPaginator.getMapItemValues().get(id).clone();
		this.editing=false;
		
		for(int i=0;i<this.isEditing.length;i++)
			this.isEditing[i]=false;   
	}

	
	/**
	 * Función que se ejecuta cuando se acepta la edición del item
	 */
	public void editingAccept(int index, Item item) {
		
		for(int i=0;i<this.isEditing.length;i++)
			this.isEditing[i]=false;   

		this.editing=false;
		Object tipoMeritoItem = this.aportacionMeritosItemPaginator.getTipoMeritosItem().get(item.getId());
			
		//cambiar por un case
		switch(TipoMeritosItemEnum.valueOf(item.getTipo()))
		{
			case MASTER: this.actualizarMaster(index, item);
				break;
			case TITULACION_EXPEDIENTE: this.actualizarTitulacionExpediente(index,item);
				break;
			case FORMACION_CONTINUADA:this.actualizarFormacionContinuada(index, item);
				break;
			case INVESTIGACION: this.actualizarInvestigacion(index, item);
				break;
			case INTERNO_RESIDENTE: this.actualizarInternoResidente(index, item);
				break;
			case TITULACION_PREMIO: this.actualizarTitulacionPremio(index, item);
				break;
			case FORMACION_ESPECIALIZADA: this.actualizarFormacionEspecializada(index, item);
				break;
			case RELACION_FIJEZA: this.actualizarRelacionFijeza(index, item);
				break;
			case TITULACION: this.actualizarTitulacion(index, item);
				break;
			case EXPRO_NO_OFICIO: this.actualizarExproNoOficio(index, item);
				break;
			case TITULACION_DOCTORADO: this.actualizarTitulacionDoctorado(index, item);
		
		}
		
        FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage("La edición del item ha sido correcta") );

	}
	
	private void actualizarTitulacionDoctorado(int index, Item item) {
		Object tipoMeritoItem = this.aportacionMeritosItemPaginator.getTipoMeritosItem().get(item.getId());
		TitulacionDoctoradoTribunal titulacionDoctoradoTribunal = new TitulacionDoctoradoTribunal();
		TribunalHistorico tribunalHistorico = new TribunalHistorico();
		
		
		titulacionDoctoradoTribunal.setCentroExpedicion(tipoMeritosValuesString[TitulacionDoctoradoEnum.CENTRO_EXPEDICION.ordinal()]);
		titulacionDoctoradoTribunal.setCalificacion(tipoMeritosValuesString[TitulacionDoctoradoEnum.CALIFICACION.ordinal()]);	
		titulacionDoctoradoTribunal.setFechaFinalizacion(this.stringToDate(tipoMeritosValuesString[TitulacionDoctoradoEnum.FECHA_FINALIZACION.ordinal()]));
		
		
		tribunalHistorico.setIdUsuario(Lobo2Utils.getLogin());
		tribunalHistorico.setTipoMerito(item.getTipo());
		tribunalHistorico.setFechaModificacion(new Date());
	
		
		if(tipoMeritoItem instanceof TitulacionDoctoradoTribunal)
		{
			
			this.titulacionDoctoradoTribunalService.delete((TitulacionDoctoradoTribunal)tipoMeritoItem);
			titulacionDoctoradoTribunal.setTitulacionDoctorado(((TitulacionDoctoradoTribunal)tipoMeritoItem).getTitulacionDoctorado());
			this.titulacionDoctoradoTribunalService.save(titulacionDoctoradoTribunal);
			tribunalHistorico.setIdTribunal(titulacionDoctoradoTribunal.getId());
			this.tribunalHistoricoService.save(tribunalHistorico);

			
		} else if(tipoMeritoItem instanceof TitulacionDoctorado)
		{
			
			titulacionDoctoradoTribunal.setTitulacionDoctorado((TitulacionDoctorado)tipoMeritoItem);
			this.titulacionDoctoradoTribunalService.save(titulacionDoctoradoTribunal);
			tribunalHistorico.setIdTribunal(titulacionDoctoradoTribunal.getId());
			this.tribunalHistoricoService.save(tribunalHistorico);
			
		}
		
	}

	
	private void actualizarExproNoOficio(int index, Item item) {
		
		Object tipoMeritoItem = this.aportacionMeritosItemPaginator.getTipoMeritosItem().get(item.getId());
		ExproNoOficioTribunal exproNoOficioTribunal = new ExproNoOficioTribunal();
		TribunalHistorico tribunalHistorico = new TribunalHistorico();
		
		
		exproNoOficioTribunal.setDescripcion(tipoMeritosValuesString[ExproNoOficioEnum.DESCRIPCION.ordinal()]);
		exproNoOficioTribunal.setAdministracion(tipoMeritosValuesString[ExproNoOficioEnum.ADMINISTRACION.ordinal()]);
		exproNoOficioTribunal.setPuntoAsistencial(tipoMeritosValuesString[ExproNoOficioEnum.PUNTOASISTENCIAL.ordinal()]);
		exproNoOficioTribunal.setFechaDesde(this.stringToDate(tipoMeritosValuesString[ExproNoOficioEnum.FECHADESDE.ordinal()]));
		exproNoOficioTribunal.setFechaHasta(this.stringToDate(tipoMeritosValuesString[ExproNoOficioEnum.FECHAHASTA.ordinal()]));
		exproNoOficioTribunal.setTipoContrato(tipoMeritosValuesString[ExproNoOficioEnum.TIPOCONTRATO.ordinal()]);
		exproNoOficioTribunal.setCategoría(tipoMeritosValuesString[ExproNoOficioEnum.CATEGORÍA.ordinal()]);
		exproNoOficioTribunal.setHorasGuardiaRefuerzo(this.stringToInteger(tipoMeritosValuesString[ExproNoOficioEnum.HORAS_GUARDIA_REFUERZO.ordinal()]));
		exproNoOficioTribunal.setComunidadAutonoma(tipoMeritosValuesString[ExproNoOficioEnum.COMUNIDAD_AUTONOMA.ordinal()]);
		
			tribunalHistorico.setIdUsuario(Lobo2Utils.getLogin());
		tribunalHistorico.setTipoMerito(item.getTipo());
		tribunalHistorico.setFechaModificacion(new Date());
		
		if(tipoMeritoItem instanceof ExproNoOficioTribunal)
		{
			this.exproNoOficioTribunalService.delete((ExproNoOficioTribunal)tipoMeritoItem);
			exproNoOficioTribunal.setExproNoOficio(((ExproNoOficioTribunal)tipoMeritoItem).getExproNoOficio());
			this.exproNoOficioTribunalService.save(exproNoOficioTribunal);
			tribunalHistorico.setIdTribunal(exproNoOficioTribunal.getId());
			this.tribunalHistoricoService.save(tribunalHistorico);		
		} else if(tipoMeritoItem instanceof ExproNoOficio)
		{
			exproNoOficioTribunal.setExproNoOficio((ExproNoOficio)tipoMeritoItem);
			this.exproNoOficioTribunalService.save(exproNoOficioTribunal);
			tribunalHistorico.setIdTribunal(exproNoOficioTribunal.getId());
			this.tribunalHistoricoService.save(tribunalHistorico);
		}
	}

	
	
	private void actualizarTitulacion(int index, Item item) {
		
		Object tipoMeritoItem = this.aportacionMeritosItemPaginator.getTipoMeritosItem().get(item.getId());
		TitulacionTribunal titulacionTribunal = new TitulacionTribunal();
		TribunalHistorico tribunalHistorico = new TribunalHistorico();
		
		
		
		titulacionTribunal.setNivel(Integer.parseInt(tipoMeritosValuesString[TitulacionEnum.NIVEL.ordinal()]));
		
		titulacionTribunal.setRama(Integer.parseInt(tipoMeritosValuesString[TitulacionEnum.RAMA.ordinal()]));
		titulacionTribunal.setCentroExpedicion(tipoMeritosValuesString[TitulacionEnum.CENTRO_EXPEDICION.ordinal()]);
		titulacionTribunal.setFechaFinalizacion(this.stringToDate(tipoMeritosValuesString[TitulacionEnum.FECHA_FINALIZACION.ordinal()]));
		titulacionTribunal.setTipoAdjunto(tipoMeritosValuesString[TitulacionEnum.TIPO_ADJUNTO.ordinal()]);
		titulacionTribunal.setExpediente(this.stringToInteger(tipoMeritosValuesString[TitulacionEnum.EXPEDIENTE.ordinal()]));
		titulacionTribunal.setCalificacion(this.stringToInteger(tipoMeritosValuesString[TitulacionEnum.CALIFICACION.ordinal()]));
		titulacionTribunal.setDoctorado(this.stringToInteger(tipoMeritosValuesString[TitulacionEnum.DOCTORADO.ordinal()]));
		titulacionTribunal.setTitulacionTextoLibre(tipoMeritosValuesString[TitulacionEnum.TITULACION_TEXTO_LIBRE.ordinal()]);
		titulacionTribunal.setPremio(this.stringToInteger(tipoMeritosValuesString[TitulacionEnum.PREMIO.ordinal()]));
	
		
		tribunalHistorico.setIdUsuario(Lobo2Utils.getLogin());
		tribunalHistorico.setTipoMerito(item.getTipo());
		tribunalHistorico.setFechaModificacion(new Date());
		
	
		
		if(tipoMeritoItem instanceof TitulacionTribunal)
		{
			this.titulacionTribunalService.delete((TitulacionTribunal)tipoMeritoItem);
			titulacionTribunal.setTitulacion(((TitulacionTribunal)tipoMeritoItem).getTitulacion());
			this.titulacionTribunalService.save(titulacionTribunal);
			tribunalHistorico.setIdTribunal(titulacionTribunal.getId());
			this.tribunalHistoricoService.save(tribunalHistorico);
			
		} else if(tipoMeritoItem instanceof Titulacion)
		{
			titulacionTribunal.setTitulacion((Titulacion)tipoMeritoItem);
			this.titulacionTribunalService.save(titulacionTribunal);
			tribunalHistorico.setIdTribunal(titulacionTribunal.getId());
			this.tribunalHistoricoService.save(tribunalHistorico);
		}
		
	}

	
	
	private void actualizarRelacionFijeza(int index, Item item) {		
		Object tipoMeritoItem = this.aportacionMeritosItemPaginator.getTipoMeritosItem().get(item.getId());
		RelacionFijezaTribunal relacionFijezaTribunal = new RelacionFijezaTribunal();
		TribunalHistorico tribunalHistorico = new TribunalHistorico();
		
		relacionFijezaTribunal.setDescripcion(this.tipoMeritosValuesString[RelacionFijezaEnum.DESCRIPCION.ordinal()]);
		relacionFijezaTribunal.setCategoria(this.tipoMeritosValuesString[RelacionFijezaEnum.CATEGORIA.ordinal()]);
		relacionFijezaTribunal.setAdministracion(this.tipoMeritosValuesString[RelacionFijezaEnum.ADMINISTRACION.ordinal()]);
		relacionFijezaTribunal.setFechaTomaPosesion(this.stringToDate(this.tipoMeritosValuesString[RelacionFijezaEnum.FECHA_TOMA_POSESION.ordinal()]));
		relacionFijezaTribunal.setComunidadAutonoma(this.tipoMeritosValuesString[RelacionFijezaEnum.COMUNIDAD_AUTONOMA.ordinal()]);
		relacionFijezaTribunal.setPuntoAsistencial(this.tipoMeritosValuesString[RelacionFijezaEnum.PUNTO_ASISTENCIAL.ordinal()]);
		
		
		
		tribunalHistorico.setIdUsuario(Lobo2Utils.getLogin());
		tribunalHistorico.setTipoMerito(item.getTipo());
		tribunalHistorico.setFechaModificacion(new Date());
		
		
		
		if(tipoMeritoItem instanceof RelacionFijezaTribunal)
		{
			this.relacionFijezaTribunalService.delete((RelacionFijezaTribunal)tipoMeritoItem);
			relacionFijezaTribunal.setRelacionFijeza(((RelacionFijezaTribunal)tipoMeritoItem).getRelacionFijeza());
			this.relacionFijezaTribunalService.save(relacionFijezaTribunal);
			tribunalHistorico.setIdTribunal(relacionFijezaTribunal.getId());
			this.tribunalHistoricoService.save(tribunalHistorico);
			
		} else if (tipoMeritoItem instanceof RelacionFijeza)
		{
			relacionFijezaTribunal.setRelacionFijeza(((RelacionFijezaTribunal)tipoMeritoItem).getRelacionFijeza());
			this.relacionFijezaTribunalService.save(relacionFijezaTribunal);
			tribunalHistorico.setIdTribunal(relacionFijezaTribunal.getId());
			this.tribunalHistoricoService.save(tribunalHistorico);
	
			
		}
	}

	
	private void actualizarFormacionEspecializada(int index, Item item) {
		
		Object tipoMeritoItem = this.aportacionMeritosItemPaginator.getTipoMeritosItem().get(item.getId());
		FormacionEspecializadaTribunal formacionEspecializadaTribunal = new FormacionEspecializadaTribunal();
		TribunalHistorico tribunalHistorico = new TribunalHistorico();
		
		formacionEspecializadaTribunal.setTipoEspecialidad(this.tipoMeritosValuesString[FormacionEspecializadaEnum.TIPO_ESPECIALIDAD.ordinal()]);
		formacionEspecializadaTribunal.setCentroExpedicion(this.tipoMeritosValuesString[FormacionEspecializadaEnum.CENTRO_EXPEDICION.ordinal()]);
		formacionEspecializadaTribunal.setFechaFinalizacion(this.stringToDate(this.tipoMeritosValuesString[FormacionEspecializadaEnum.FECHA_FINALIZACION.ordinal()]));
		formacionEspecializadaTribunal.setViaAcceso(this.stringToInteger(this.tipoMeritosValuesString[FormacionEspecializadaEnum.VIA_ACCESO.ordinal()]));
		formacionEspecializadaTribunal.setEspecialista(this.tipoMeritosValuesString[FormacionEspecializadaEnum.ESPECIALISTA.ordinal()]);
		formacionEspecializadaTribunal.setTipoAdjunto(this.tipoMeritosValuesString[FormacionEspecializadaEnum.TIPO_ADJUNTO.ordinal()]);
		formacionEspecializadaTribunal.setTipoValoracion(this.tipoMeritosValuesString[FormacionEspecializadaEnum.TIPO_VALORACION.ordinal()]);
		formacionEspecializadaTribunal.setValoracionCuantitativa(this.stringToInteger(this.tipoMeritosValuesString[FormacionEspecializadaEnum.VALORACION_CUANTITATIVA.ordinal()]));
		formacionEspecializadaTribunal.setValoracionCualitativa(this.tipoMeritosValuesString[FormacionEspecializadaEnum.VALORACION_CUALITATIVA.ordinal()]);
		
		
		tribunalHistorico.setIdUsuario(Lobo2Utils.getLogin());
		tribunalHistorico.setTipoMerito(item.getTipo());
	
		
		if(tipoMeritoItem instanceof FormacionEspecializadaTribunal)
		{
			this.formacionEspecializadaTribunalService.delete((FormacionEspecializadaTribunal)tipoMeritoItem);
			formacionEspecializadaTribunal.setFormacionEspecializada(((FormacionEspecializadaTribunal)tipoMeritoItem).getFormacionEspecializada());
			
			this.formacionEspecializadaTribunalService.save(formacionEspecializadaTribunal);
			tribunalHistorico.setIdTribunal(formacionEspecializadaTribunal.getId());
			this.tribunalHistoricoService.save(tribunalHistorico);
			
		} else if(tipoMeritoItem instanceof FormacionEspecializada)
		{
			formacionEspecializadaTribunal.setFormacionEspecializada(((FormacionEspecializada)tipoMeritoItem));
			
			this.formacionEspecializadaTribunalService.save(formacionEspecializadaTribunal);
			tribunalHistorico.setIdTribunal(formacionEspecializadaTribunal.getId());
			this.tribunalHistoricoService.save(tribunalHistorico);
		}	
	}
	
	private void actualizarTitulacionPremio(int index, Item item) {
		
		Object tipoMeritoItem = this.aportacionMeritosItemPaginator.getTipoMeritosItem().get(item.getId());
		TitulacionPremioTribunal titulacionPremioTribunal = new TitulacionPremioTribunal();
		TribunalHistorico tribunalHistorico = new TribunalHistorico();

		
		titulacionPremioTribunal.setPremioFinCarrera(this.tipoMeritosValuesString[TitulacionPremioEnum.PREMIO_FIN_CARRERA.ordinal()]);
		tribunalHistorico.setIdUsuario(Lobo2Utils.getLogin());
		tribunalHistorico.setTipoMerito(item.getTipo());
		
		if(tipoMeritoItem instanceof TitulacionPremioTribunal)
		{
			this.titulacionPremioTribunalService.delete((TitulacionPremioTribunal)tipoMeritoItem);
			titulacionPremioTribunal.setTitulacionPremio(((TitulacionPremioTribunal)tipoMeritoItem).getTitulacionPremio());
			this.titulacionPremioTribunalService.save(titulacionPremioTribunal);
			//es importante que el seteo del idTribunal se haga después de guardar la nueva fila en la bd
			tribunalHistorico.setIdTribunal(titulacionPremioTribunal.getId());
			this.tribunalHistoricoService.save(tribunalHistorico);
			
		} else if(tipoMeritoItem instanceof TitulacionPremio)
		{
			titulacionPremioTribunal.setTitulacionPremio((TitulacionPremio)tipoMeritoItem);
			this.titulacionPremioTribunalService.save(titulacionPremioTribunal);
			//es importante que el seteo del idTribunal se haga después de guardar la nueva fila en la bd
			tribunalHistorico.setIdTribunal(titulacionPremioTribunal.getId());
			this.tribunalHistoricoService.save(tribunalHistorico);
			
		}
		
	}
	
	
	private void actualizarInternoResidente(int index,Item item) {
		Object tipoMeritoItem = this.aportacionMeritosItemPaginator.getTipoMeritosItem().get(item.getId());
		InternoResidenteTribunal internoResidenteTribunal = new InternoResidenteTribunal();
		TribunalHistorico tribunalHistorico = new TribunalHistorico();
		
		internoResidenteTribunal.setTipoResidente(this.tipoMeritosValuesString[InternoResidenteEnum.TIPO_RESIDENTE.ordinal()]);
		internoResidenteTribunal.setAnoExamen(Integer.parseInt(this.tipoMeritosValuesString[InternoResidenteEnum.ANO_EXAMEN.ordinal()]));
		internoResidenteTribunal.setNumOrden(Integer.parseInt(this.tipoMeritosValuesString[InternoResidenteEnum.NUM_ORDEN.ordinal()]));
		
		
		tribunalHistorico.setIdUsuario(Lobo2Utils.getLogin());
		tribunalHistorico.setTipoMerito(item.getTipo());
	
		
		if(tipoMeritoItem instanceof InternoResidenteTribunal)
		{
			
			this.internoResidenteTribunalService.delete((InternoResidenteTribunal)tipoMeritoItem);
			internoResidenteTribunal.setInternoResidente(((InternoResidenteTribunal)tipoMeritoItem).getInternoResidente());
			
			this.internoResidenteTribunalService.save(internoResidenteTribunal);
			//es importante que el seteo del idTribunal se haga después de guardar la nueva fila en la bd
			tribunalHistorico.setIdTribunal(internoResidenteTribunal.getId());		
			this.tribunalHistoricoService.save(tribunalHistorico);
			
		} else if(tipoMeritoItem instanceof InternoResidente)
		{
			internoResidenteTribunal.setInternoResidente(((InternoResidente)tipoMeritoItem));
			this.internoResidenteTribunalService.save(internoResidenteTribunal);
			//es importante que el seteo del idTribunal se haga después de guardar la nueva fila en la bd
			tribunalHistorico.setIdTribunal(internoResidenteTribunal.getId());		
			this.tribunalHistoricoService.save(tribunalHistorico);
		}
	
		
	}
	
	private void actualizarInvestigacion(int index, Item item) {
		Object tipoMeritoItem = this.aportacionMeritosItemPaginator.getTipoMeritosItem().get(item.getId());
		
		InvestigacionTribunal investigacionTribunal = new InvestigacionTribunal();
		TribunalHistorico tribunalHistorico = new TribunalHistorico();
		
		investigacionTribunal.setDescripcion(this.tipoMeritosValuesString[InvestigacionEnum.DESCRIPCION.ordinal()]);
		investigacionTribunal.setTipoActividad(Integer.parseInt(this.tipoMeritosValuesString[InvestigacionEnum.TIPO_ACTIVIDAD.ordinal()]));
		investigacionTribunal.setFirmante(this.tipoMeritosValuesString[InvestigacionEnum.FIRMANTE.ordinal()]);
		investigacionTribunal.setPublicadoEn(this.tipoMeritosValuesString[InvestigacionEnum.PUBLICADO_EN.ordinal()]);
		Integer factorImpacto =this.tipoMeritosValuesString[InvestigacionEnum.FACTOR_IMPACTO.ordinal()]=="" ? null : Integer.parseInt(this.tipoMeritosValuesString[InvestigacionEnum.FACTOR_IMPACTO.ordinal()]);
		investigacionTribunal.setFactorImpacto(factorImpacto);
		investigacionTribunal.setFechaInicio(this.stringToDate(this.tipoMeritosValuesString[InvestigacionEnum.FECHA_INICIO.ordinal()]));
		investigacionTribunal.setFechaFin(this.stringToDate(this.tipoMeritosValuesString[InvestigacionEnum.FECHA_FIN.ordinal()]));
	
	
		tribunalHistorico.setIdUsuario(Lobo2Utils.getLogin());
		tribunalHistorico.setTipoMerito(item.getTipo());
	
		
		if(tipoMeritoItem instanceof InvestigacionTribunal)
		{
			this.investigacionTribunalService.delete((InvestigacionTribunal)tipoMeritoItem);
			investigacionTribunal.setInvestigacion(((InvestigacionTribunal)tipoMeritoItem).getInvestigacion());
		
			
			//es importante que el seteo del idTribunal se haga después de guardar la nueva fila en la bd
			this.investigacionTribunalService.save(investigacionTribunal);
			tribunalHistorico.setIdTribunal(investigacionTribunal.getId());
			this.tribunalHistoricoService.save(tribunalHistorico);
		}else if(tipoMeritoItem instanceof Investigacion)
		{
			investigacionTribunal.setInvestigacion((Investigacion)tipoMeritoItem);
			investigacionTribunal.setFechaInicio(((Investigacion)tipoMeritoItem).getFechaInicio());
	
			//es importante que el seteo del idTribunal se haga después de guardar la nueva fila en la bd
			this.investigacionTribunalService.save(investigacionTribunal);
			tribunalHistorico.setIdTribunal(investigacionTribunal.getId());
			this.tribunalHistoricoService.save(tribunalHistorico);
		}
	}
	
	private void actualizarFormacionContinuada(int index, Item item) {
		
		Object tipoMeritoItem = this.aportacionMeritosItemPaginator.getTipoMeritosItem().get(item.getId());
		
		FormacionContinuadaTribunal formacionContinuadaTribunal = new FormacionContinuadaTribunal();
		TribunalHistorico tribunalHistorico = new TribunalHistorico();
		
		formacionContinuadaTribunal.setTipoCentro(Integer.parseInt(this.tipoMeritosValuesString[FormacionContinuadaEnum.TIPO_CENTRO.ordinal()]));
		formacionContinuadaTribunal.setCentroExpedicion(this.tipoMeritosValuesString[FormacionContinuadaEnum.CENTRO_EXPEDICION.ordinal()]);
		formacionContinuadaTribunal.setDescripcion(this.tipoMeritosValuesString[FormacionContinuadaEnum.DESCRIPCION.ordinal()]);
		formacionContinuadaTribunal.setFechaInicio(this.stringToDate(this.tipoMeritosValuesString[FormacionContinuadaEnum.FECHA_INICIO.ordinal()]));
		formacionContinuadaTribunal.setFechaFin(this.stringToDate(this.tipoMeritosValuesString[FormacionContinuadaEnum.FECHA_FIN.ordinal()]));
		
		formacionContinuadaTribunal.setTipoAdjunto(this.tipoMeritosValuesString[FormacionContinuadaEnum.TIPO_ADJUNTO.ordinal()]);
		formacionContinuadaTribunal.setTipoValoracion(this.tipoMeritosValuesString[FormacionContinuadaEnum.TIPO_VALORACION.ordinal()]);
		formacionContinuadaTribunal.setUnidadValoracion(this.tipoMeritosValuesString[FormacionContinuadaEnum.UNIDAD_VALORACION.ordinal()]);
		formacionContinuadaTribunal.setValoracion(Integer.parseInt(this.tipoMeritosValuesString[FormacionContinuadaEnum.VALORACION.ordinal()]));

		tribunalHistorico.setIdUsuario(Lobo2Utils.getLogin());
		tribunalHistorico.setTipoMerito(item.getTipo());
	
		
		if(tipoMeritoItem instanceof FormacionContinuadaTribunal)
		{
			this.formacionContinuadaTribunalService.delete((FormacionContinuadaTribunal)tipoMeritoItem);
			formacionContinuadaTribunal.setFormacionContinuada(((FormacionContinuadaTribunal)tipoMeritoItem).getFormacionContinuada());
			this.formacionContinuadaTribunalService.save(formacionContinuadaTribunal);
			tribunalHistorico.setIdTribunal(formacionContinuadaTribunal.getId());
			this.tribunalHistoricoService.save(tribunalHistorico);
		} else if(tipoMeritoItem instanceof FormacionContinuada)
		{
			formacionContinuadaTribunal.setFormacionContinuada((FormacionContinuada)tipoMeritoItem);
			this.formacionContinuadaTribunalService.save(formacionContinuadaTribunal);
			tribunalHistorico.setIdTribunal(formacionContinuadaTribunal.getId());
			this.tribunalHistoricoService.save(tribunalHistorico);
		}
	}
	
	
	private void actualizarTitulacionExpediente(int index, Item item)
	{
		
				Object tipoMeritoItem = this.aportacionMeritosItemPaginator.getTipoMeritosItem().get(item.getId());			
				
				TitulacionExpedienteTribunal titulacionExpedienteTribunal = new TitulacionExpedienteTribunal();
				TribunalHistorico tribunalHistorico = new TribunalHistorico();
	
				
				if ( tipoMeritoItem instanceof TitulacionExpedienteTribunal) {		
					//eliminamos el que hubiera antes
					this.titulacionExpedienteTribunalService.delete((TitulacionExpedienteTribunal)tipoMeritoItem);
					
					titulacionExpedienteTribunal.setTitulacionExpediente(((TitulacionExpedienteTribunal)tipoMeritoItem).getTitulacionExpediente());		
					titulacionExpedienteTribunal.setNumAsignaturas(		
							Integer.parseInt(this.tipoMeritosValuesString[TitulacionExpedienteEnum.NUMERO_ASIGNATURAS.ordinal()]));	
					titulacionExpedienteTribunal.setNumMatriculas(	
							Integer.parseInt(this.tipoMeritosValuesString[TitulacionExpedienteEnum.NUMERO_MATRICULAS.ordinal()]));	
					titulacionExpedienteTribunal.setNumNotables(	
							Integer.parseInt(this.tipoMeritosValuesString[TitulacionExpedienteEnum.NUMERO_NOTABLES.ordinal()]));		
					titulacionExpedienteTribunal.setNumSobresalientes(	
							Integer.parseInt(this.tipoMeritosValuesString[TitulacionExpedienteEnum.NUMERO_SOBRESALIENTES.ordinal()]));
								
					this.titulacionExpedienteTribunalService.save(titulacionExpedienteTribunal);
							
				} else if ( tipoMeritoItem instanceof TitulacionExpediente) {
						titulacionExpedienteTribunal.setNumAsignaturas(	
								Integer.parseInt(this.tipoMeritosValuesString[TitulacionExpedienteEnum.NUMERO_ASIGNATURAS.ordinal()]));			
					titulacionExpedienteTribunal.setTitulacionExpediente((TitulacionExpediente)tipoMeritoItem);
					titulacionExpedienteTribunal.setNumMatriculas(	
							Integer.parseInt(this.tipoMeritosValuesString[TitulacionExpedienteEnum.NUMERO_MATRICULAS.ordinal()]));
					titulacionExpedienteTribunal.setNumNotables(	
							Integer.parseInt(this.tipoMeritosValuesString[TitulacionExpedienteEnum.NUMERO_NOTABLES.ordinal()]));
					titulacionExpedienteTribunal.setNumSobresalientes(	
							Integer.parseInt(this.tipoMeritosValuesString[TitulacionExpedienteEnum.NUMERO_SOBRESALIENTES.ordinal()]));
	
					
					this.titulacionExpedienteTribunalService.save(titulacionExpedienteTribunal);

				
				}	
				tribunalHistorico.setIdTribunal(titulacionExpedienteTribunal.getId());
				tribunalHistorico.setIdUsuario(Lobo2Utils.getLogin());
				tribunalHistorico.setTipoMerito(item.getTipo());
				
				this.tribunalHistoricoService.save(tribunalHistorico);
	}
	
	
	private void actualizarMaster(int index, Item item) {
		
		// "CENTRO DE EXPEDICIÓN", "FECHA DE FINALIZACIÓN", "DESCRIPCIÓN" | NO QUITAR LOS ACENTOS
		//si ya había un objeto en la tabla tribunal
		Object tipoMeritoItem = this.aportacionMeritosItemPaginator.getTipoMeritosItem().get(item.getId());
		
		
		MasterTribunal masterTribunal = new MasterTribunal();
		TribunalHistorico tribunalHistorico = new TribunalHistorico();
		masterTribunal.setCentroExpedicion(this.tipoMeritosValuesString[MasterEnum.CENTRO_EXPEDICION.ordinal()]);
		masterTribunal.setDescripcion(this.tipoMeritosValuesString[MasterEnum.DESCRIPCION.ordinal()]);	
		
		
	
		masterTribunal.setFechaFinalizacion(this.stringToDate(this.tipoMeritosValuesString[MasterEnum.FECHA_FINALIZACION.ordinal()]));
	
		tribunalHistorico.setIdUsuario(Lobo2Utils.getLogin());
		
		tribunalHistorico.setTipoMerito(item.getTipo());
		
		if ( tipoMeritoItem instanceof MasterTribunal) {		
			this.masterTribunalService.delete((MasterTribunal)tipoMeritoItem);
			masterTribunal.setMaster(((MasterTribunal)tipoMeritoItem).getMaster());
			
			//esto no esta bien tiene que guardar la nueva fecha
			//TODO cambiar esto para que transforme la fecha bien
		
			//hasta que no guardamos masterTribunal no tiene id.
			this.masterTribunalService.save(masterTribunal);
			tribunalHistorico.setIdTribunal(masterTribunal.getId());
			this.tribunalHistoricoService.save(tribunalHistorico);
			
		//si es la primera entrada
		} else if ( tipoMeritoItem instanceof Master) {
			masterTribunal.setMaster((Master)tipoMeritoItem);
			
			//hasta que no guardamos masterTribunal no tiene id.
			this.masterTribunalService.save(masterTribunal);
			tribunalHistorico.setIdTribunal(masterTribunal.getId());
			this.tribunalHistoricoService.save(tribunalHistorico);	
		}	
		//guardamos en el historico
		
	
		
			
		
	}
	
	private Date stringToDate(String fecha)
	{
		if (fecha=="") return null;
		SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
		
		try {
			return format.parse(fecha);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private Integer stringToInteger(String value) {
		if(value=="") return null;
		else return Integer.parseInt(value);
	}
	
	
	/**
	 * Esta función nos devuelve los atributos del tipo de item en funcion de su tipo de item
	 * @param aportacionMeritosItem
	 * @param index
	 * @return
	 */
	public String getAtributeColumnValue(Long id,int columnIndex) {		
	//	this.listValues.add(this.aportacionMeritosItemPaginator.getMapItemValues().get(id).clone());
		
		return this.aportacionMeritosItemPaginator.getMapItemValues().get(id)[columnIndex];
	}
	
	
	
	/**
	 * Esta funcion nos devuelve el nombre de los atributos editables segun el tipo de merito
	 * @return
	 */	
	public List<String> getNameColumns() {

		return this.aportacionMeritosItemPaginator.getNameValues();
	}

	
}