package es.sms.bolsa.view.jsf.paginator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import es.sms.bolsa.enumEntity.ExproNoOficioEnum;
import es.sms.bolsa.enumEntity.FormacionContinuadaEnum;
import es.sms.bolsa.enumEntity.FormacionEspecializadaEnum;
import es.sms.bolsa.enumEntity.InternoResidenteEnum;
import es.sms.bolsa.enumEntity.InvestigacionEnum;
import es.sms.bolsa.enumEntity.MasterEnum;
import es.sms.bolsa.enumEntity.RelacionFijezaEnum;
import es.sms.bolsa.enumEntity.TipoDatoEnum;
import es.sms.bolsa.enumEntity.TipoMeritosItemEnum;
import es.sms.bolsa.enumEntity.TitulacionDoctoradoEnum;
import es.sms.bolsa.enumEntity.TitulacionEnum;
import es.sms.bolsa.enumEntity.TitulacionExpedienteEnum;
import es.sms.bolsa.enumEntity.TitulacionPremioEnum;
import es.sms.bolsa.model.entity.AportacionMeritos;
import es.sms.bolsa.model.entity.AportacionMeritosItem;
import es.sms.bolsa.model.entity.ExproNoOficio;
import es.sms.bolsa.model.entity.ExproNoOficioTribunal;
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
import es.sms.bolsa.model.entity.Merito;
import es.sms.bolsa.model.entity.RelacionFijeza;
import es.sms.bolsa.model.entity.RelacionFijezaTribunal;
import es.sms.bolsa.model.entity.TipoAportacionMeritosItem;
import es.sms.bolsa.model.entity.TipoAportacionMeritosItemTribunal;
import es.sms.bolsa.model.entity.Titulacion;
import es.sms.bolsa.model.entity.TitulacionDoctorado;
import es.sms.bolsa.model.entity.TitulacionDoctoradoTribunal;
import es.sms.bolsa.model.entity.TitulacionExpediente;
import es.sms.bolsa.model.entity.TitulacionExpedienteTribunal;
import es.sms.bolsa.model.entity.TitulacionPremio;
import es.sms.bolsa.model.entity.TitulacionPremioTribunal;
import es.sms.bolsa.model.entity.TitulacionTribunal;
import es.sms.bolsa.repository.commons.PaginationResult;
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
import es.sms.bolsa.service.TitulacionDoctoradoService;
import es.sms.bolsa.service.TitulacionDoctoradoTribunalService;
import es.sms.bolsa.service.TitulacionExpedienteService;
import es.sms.bolsa.service.TitulacionExpedienteTribunalService;
import es.sms.bolsa.service.TitulacionPremioService;
import es.sms.bolsa.service.TitulacionPremioTribunalService;
import es.sms.bolsa.service.TitulacionService;
import es.sms.bolsa.service.TitulacionTribunalService;

public class AportacionMeritosItemPaginator extends LazyDataModel<AportacionMeritosItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private MasterService masterService;
	
	private MasterTribunalService masterTribunalService;

	private AportacionMeritosItemService aportacionMeritosItemService;
	
	private TitulacionExpedienteService titulacionExpedienteService;
	
	private TitulacionExpedienteTribunalService titulacionExpedienteTribunalService;
	
	private FormacionContinuadaService formacionContinuadaService;
	
	private FormacionContinuadaTribunalService formacionContinuadaTribunalService;
	
	private InvestigacionService investigacionService;
	
	private InvestigacionTribunalService investigacionTribunalService;
	
	private InternoResidenteService internoResidenteService;
	
	private InternoResidenteTribunalService internoResidenteTribunalService;
	
	private TitulacionPremioService titulacionPremioService;
	
	private TitulacionPremioTribunalService titulacionPremioTribunalService;
	
	private FormacionEspecializadaService formacionEspecializadaService;
	
	private FormacionEspecializadaTribunalService formacionEspecializadaTribunalService;

	private RelacionFijezaService relacionFijezaService;
	
	private RelacionFijezaTribunalService relacionFijezaTribunalService;
	
	private TitulacionService titulacionService;
	
	private TitulacionTribunalService titulacionTribunalService;
	
	private ExproNoOficioService exproNoOficioService;
	
	private ExproNoOficioTribunalService exproNoOficioTribunalService;
	
	private TitulacionDoctoradoService titulacionDoctoradoService;
	
	private TitulacionDoctoradoTribunalService titulacionDoctoradoTribunalService;
	
	private AportacionMeritos aportacionMeritos;
	
	private Merito merito;

	private PaginationResult<AportacionMeritosItem> paginationResult;
	
	private String tipo;
	
	private int nResultados;

	private Map<Long, String[]> mapItemValues;
	
	private Map<Long, Object> tipoMeritosItem;
	
	private List<String> nameValues;
	
	private TipoDatoEnum[] tipodeDato;
	
	private String[] arrayMeritosItemSituacion;

	private Map<Long, String[]> mapTipoMeritosItemOriginal;
	




	public String[] getArrayMeritosItemSituacion() {
		return arrayMeritosItemSituacion;
	}




	public void setArrayMeritosItemSituacion(String[] arrayMeritosItemSituacion) {
		this.arrayMeritosItemSituacion = arrayMeritosItemSituacion;
	}




	public AportacionMeritosItemPaginator(AportacionMeritosItemService aportacionMeritosItemService,  AportacionMeritos aportacionMeritos, 
			Merito merito) {
		this.aportacionMeritosItemService = aportacionMeritosItemService;
		this.aportacionMeritos = aportacionMeritos;
		this.merito = merito;	

	}


	
	
	@Override
	public List<AportacionMeritosItem> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		int pageNumber = 0;
		if (pageSize > 0) {
			pageNumber = (first / pageSize) + 1;
		}
		List<AportacionMeritosItem> result = null;
		if (aportacionMeritos == null)
			result = new ArrayList<>();
		if (first == 0) {
			result = aportacionMeritosItemService.findByAportacionMeritos(
					PageRequest.of(first, pageSize, Sort.by("id")), aportacionMeritos, merito);
		} else {
			first = first / pageSize;
			result = aportacionMeritosItemService.findByAportacionMeritos(
					PageRequest.of(first, pageSize, Sort.by("id")), aportacionMeritos, merito);
		}

		paginationResult = new PaginationResult<AportacionMeritosItem>();
		paginationResult.pageNumber(pageNumber);
		paginationResult.offset((paginationResult.getPageNumber() - 1) * pageSize);
		paginationResult.pageSize(pageSize);
		paginationResult.result(result);
		if (aportacionMeritos == null)
			paginationResult.totalResult(0);
		else
			paginationResult.totalResult((int) aportacionMeritosItemService.countByAportacionMeritosAndCodigoMerito(aportacionMeritos, merito));

		nResultados = (int) paginationResult.getTotalResult();
		super.setRowCount(nResultados);
		
		//una funcion que dado id de AportacionMeritos me de todos los tipos de meritos
		
		
		this.mapItemValues = new HashMap<Long, String[]>();
		this.tipoMeritosItem = new HashMap<Long, Object>();
		this.mapTipoMeritosItemOriginal = new HashMap<Long, String[]>();
		
		//AQUI VENDRÍA EL CASE CON EL ITEM DEPENDIENDO DEL TIPO DE MERITO SE USARÍA UN SERVICIO U OTRO
		if(result!=null && result.size()>0 && this.aportacionMeritos.getAportacionMeritosItems().get(0).getItem()!=null)
		{	
			this.tipo = result.get(0).getItem().getTipo();
			this.arrayMeritosItemSituacion = new String[result.size()];
			int i=0;
			for (AportacionMeritosItem meritosItem : result) {
				
				Item item = meritosItem.getItem();
				
				this.arrayMeritosItemSituacion[i]=meritosItem.getSituacion().getCodigo().toString();
				
				switch(TipoMeritosItemEnum.valueOf(item.getTipo()))
				{			
					case MASTER: this.gestionarMaster(item);
						this.nameValues=MasterEnum.NAME_ATRIBUTOS;
						break;
					
					case TITULACION_EXPEDIENTE: this.gestionarTitulacionExpediente(item);
						this.nameValues=TitulacionExpedienteEnum.NAME_ATRIBUTOS;
						break;
					
					case FORMACION_CONTINUADA: this.gestionarFormacionContinuada(item);
						this.nameValues= FormacionContinuadaEnum.NAME_ATRIBUTOS;
						break;
					case INVESTIGACION: this.gestionarInvestigacion(item);
						this.nameValues = InvestigacionEnum.NAME_ATRIBUTOS;
						break;
					case INTERNO_RESIDENTE: this.gestionarInternoResidente(item);
						this.nameValues = InternoResidenteEnum.NAME_ATRIBUTOS;
						break;
					case TITULACION_PREMIO: this.gestionarTitulacionPremio(item);
						this.nameValues = TitulacionPremioEnum.NAME_ATRIBUTOS;
						break;
					case FORMACION_ESPECIALIZADA: this.gestionarFormacionEspecializada(item);
						this.nameValues = FormacionEspecializadaEnum.NAME_ATRIBUTOS;
						break;
					case RELACION_FIJEZA: this.gestionarRelacionFijeza(item);
						this.nameValues = RelacionFijezaEnum.NAME_ATRIBUTOS;
						break;
					case TITULACION: this.gestionarTitulacion(item);
						this.nameValues = TitulacionEnum.NAME_ATRIBUTOS;
						break;
					case EXPRO_NO_OFICIO: this.gestionarExproNoOficio(item);
						this.nameValues = ExproNoOficioEnum.NAME_ATRIBUTOS;
						break;
					case TITULACION_DOCTORADO: this.gestionarTitulacionDoctorado(item);
						this.nameValues = TitulacionDoctoradoEnum.NAME_ATRIBUTOS;
				}
				i++;
			}
				
		}
		
	
		return this.paginationResult.getResult();
	}
	
	
	private void gestionarTitulacionDoctorado(Item item) {
		
		Optional<TitulacionDoctorado> titulacionDoctoradoOpt;
		Optional<TitulacionDoctoradoTribunal> titulacionDoctoradoTribunalOpt;
		
		titulacionDoctoradoOpt = this.titulacionDoctoradoService.findById(item.getId());
		titulacionDoctoradoTribunalOpt = this.titulacionDoctoradoTribunalService.findByTitulacionDoctorado(titulacionDoctoradoOpt.get());
		String[] originalItem = new String[TitulacionDoctoradoEnum.N_ATRIBUTOS_EDITABLES];
		
		String[] tipoMeritosValuesString = new String[ExproNoOficioEnum.N_ATRIBUTOS_EDITABLES];
		//indicamos en el array los campos especiales para las restricciones de los input en la vista
		this.tipodeDato = new TipoDatoEnum[TitulacionDoctoradoEnum.N_ATRIBUTOS_EDITABLES];
		this.tipodeDato[TitulacionDoctoradoEnum.FECHA_FINALIZACION.ordinal()]=TipoDatoEnum.DATE;
		this.tipodeDato[TitulacionDoctoradoEnum.CALIFICACION.ordinal()] = TipoDatoEnum.STRING_LIMIT_CHAR_2;
		
		if(titulacionDoctoradoTribunalOpt.isPresent())
		{
			//añadimos el item original para que pueda ser consultado	
			TitulacionDoctorado tituDoctorado = titulacionDoctoradoOpt.get();
			originalItem[TitulacionDoctoradoEnum.CENTRO_EXPEDICION.ordinal()]= tituDoctorado.getCentroExpedicion();
			originalItem[TitulacionDoctoradoEnum.FECHA_FINALIZACION.ordinal()]= this.DateToString(tituDoctorado.getFechaFinalizacion());
			originalItem[TitulacionDoctoradoEnum.CALIFICACION.ordinal()] = tituDoctorado.getCalificacion();
	
			this.mapTipoMeritosItemOriginal.put(tituDoctorado.getId(), originalItem);
			
		
			TitulacionDoctoradoTribunal tituDoctoradoTribunal = titulacionDoctoradoTribunalOpt.get();
			
			tipoMeritosValuesString[TitulacionDoctoradoEnum.CENTRO_EXPEDICION.ordinal()]= tituDoctoradoTribunal.getCentroExpedicion();
			tipoMeritosValuesString[TitulacionDoctoradoEnum.FECHA_FINALIZACION.ordinal()]= this.DateToString(tituDoctoradoTribunal.getFechaFinalizacion());
			tipoMeritosValuesString[TitulacionDoctoradoEnum.CALIFICACION.ordinal()] = tituDoctoradoTribunal.getCalificacion();
	
			tipoMeritosItem.put(tituDoctoradoTribunal.getTitulacionDoctorado().getId(), tituDoctoradoTribunal);
			mapItemValues.put(tituDoctoradoTribunal.getTitulacionDoctorado().getId(), tipoMeritosValuesString);
			
		} else if(titulacionDoctoradoOpt.isPresent())
		{
			TitulacionDoctorado tituDoctorado = titulacionDoctoradoOpt.get();
			originalItem[TitulacionDoctoradoEnum.CENTRO_EXPEDICION.ordinal()]= tituDoctorado.getCentroExpedicion();
			originalItem[TitulacionDoctoradoEnum.FECHA_FINALIZACION.ordinal()]= this.DateToString(tituDoctorado.getFechaFinalizacion());
			originalItem[TitulacionDoctoradoEnum.CALIFICACION.ordinal()] = tituDoctorado.getCalificacion();
	
			this.mapTipoMeritosItemOriginal.put(tituDoctorado.getId(), originalItem);
	
			tipoMeritosValuesString[TitulacionDoctoradoEnum.CENTRO_EXPEDICION.ordinal()]= tituDoctorado.getCentroExpedicion();
			tipoMeritosValuesString[TitulacionDoctoradoEnum.FECHA_FINALIZACION.ordinal()]= this.DateToString(tituDoctorado.getFechaFinalizacion());
			tipoMeritosValuesString[TitulacionDoctoradoEnum.CALIFICACION.ordinal()] = tituDoctorado.getCalificacion();
	
			tipoMeritosItem.put(tituDoctorado.getId(), tituDoctorado);
			mapItemValues.put(tituDoctorado.getId(), tipoMeritosValuesString);
		}
	}
	
	
	private void gestionarExproNoOficio(Item item) {
		
		Optional<ExproNoOficio> exproNoOficioOpt;
		Optional<ExproNoOficioTribunal> exproNoOficioTribunalOpt;
		
		exproNoOficioOpt = this.exproNoOficioService.findById(item.getId());
		exproNoOficioTribunalOpt = this.exproNoOficioTribunalService.findByExproNoOficio(exproNoOficioOpt.get());
		String[] originalItem = new String[ExproNoOficioEnum.N_ATRIBUTOS_EDITABLES];
		
		String[] tipoMeritosValuesString = new String[ExproNoOficioEnum.N_ATRIBUTOS_EDITABLES];
		//indicamos los campos especiales para la vista
		this.tipodeDato = new TipoDatoEnum[ExproNoOficioEnum.N_ATRIBUTOS_EDITABLES];
		this.tipodeDato[ExproNoOficioEnum.FECHADESDE.ordinal()]=TipoDatoEnum.DATE;
		this.tipodeDato[ExproNoOficioEnum.FECHAHASTA.ordinal()]=TipoDatoEnum.DATE;
		this.tipodeDato[ExproNoOficioEnum.HORAS_GUARDIA_REFUERZO.ordinal()]=TipoDatoEnum.INT;
		this.tipodeDato[ExproNoOficioEnum.TIPOCONTRATO.ordinal()]=TipoDatoEnum.STRING_LIMIT_CHAR_2;
		this.tipodeDato[ExproNoOficioEnum.CATEGORÍA.ordinal()]=TipoDatoEnum.STRING_LIMIT_CHAR_5;
		
		
		if(exproNoOficioTribunalOpt.isPresent())
		{
			//añadimos el item original para que pueda ser consultado			
			ExproNoOficio exproNoOficio = exproNoOficioOpt.get();
			originalItem[ExproNoOficioEnum.DESCRIPCION.ordinal()]=exproNoOficio.getDescripcion();
			originalItem[ExproNoOficioEnum.ADMINISTRACION.ordinal()]=exproNoOficio.getAndministracion();
			originalItem[ExproNoOficioEnum.PUNTOASISTENCIAL.ordinal()]=exproNoOficio.getPuntoAsistencial();
			originalItem[ExproNoOficioEnum.FECHADESDE.ordinal()]=this.DateToString(exproNoOficio.getFechaDesde());
			originalItem[ExproNoOficioEnum.FECHAHASTA.ordinal()]=this.DateToString(exproNoOficio.getFechaHasta());
			originalItem[ExproNoOficioEnum.TIPOCONTRATO.ordinal()]=exproNoOficio.getTipoContrato();
			originalItem[ExproNoOficioEnum.CATEGORÍA.ordinal()]= exproNoOficio.getCategoría();
			originalItem[ExproNoOficioEnum.HORAS_GUARDIA_REFUERZO.ordinal()]= this.IntegerToString(exproNoOficio.getHorasGuardiaRefuerzo());
			originalItem[ExproNoOficioEnum.COMUNIDAD_AUTONOMA.ordinal()]= exproNoOficio.getComunidadAutonoma();
			this.mapTipoMeritosItemOriginal.put(exproNoOficio.getId(), originalItem);
			
			
			ExproNoOficioTribunal exproNoOficioTribunal = exproNoOficioTribunalOpt.get();
			
			tipoMeritosValuesString[ExproNoOficioEnum.DESCRIPCION.ordinal()]=exproNoOficioTribunal.getDescripcion();
			tipoMeritosValuesString[ExproNoOficioEnum.ADMINISTRACION.ordinal()]=exproNoOficioTribunal.getAdministracion();
			tipoMeritosValuesString[ExproNoOficioEnum.PUNTOASISTENCIAL.ordinal()]=exproNoOficioTribunal.getPuntoAsistencial();
			tipoMeritosValuesString[ExproNoOficioEnum.FECHADESDE.ordinal()]=this.DateToString(exproNoOficioTribunal.getFechaDesde());
			tipoMeritosValuesString[ExproNoOficioEnum.FECHAHASTA.ordinal()]=this.DateToString(exproNoOficioTribunal.getFechaHasta());
			tipoMeritosValuesString[ExproNoOficioEnum.TIPOCONTRATO.ordinal()]=exproNoOficioTribunal.getTipoContrato();
			tipoMeritosValuesString[ExproNoOficioEnum.CATEGORÍA.ordinal()]= exproNoOficioTribunal.getCategoría();
			tipoMeritosValuesString[ExproNoOficioEnum.HORAS_GUARDIA_REFUERZO.ordinal()]= this.IntegerToString(exproNoOficioTribunal.getHorasGuardiaRefuerzo());
			tipoMeritosValuesString[ExproNoOficioEnum.COMUNIDAD_AUTONOMA.ordinal()]= exproNoOficioTribunal.getComunidadAutonoma();
			
			tipoMeritosItem.put(exproNoOficioTribunal.getExproNoOficio().getId(), exproNoOficioTribunal);
			mapItemValues.put(exproNoOficioTribunal.getExproNoOficio().getId(), tipoMeritosValuesString);
		} else if(exproNoOficioOpt.isPresent())
		{
			//añadimos el item original para que pueda ser consultado			
			ExproNoOficio exproNoOficio = exproNoOficioOpt.get();
			originalItem[ExproNoOficioEnum.DESCRIPCION.ordinal()]=exproNoOficio.getDescripcion();
			originalItem[ExproNoOficioEnum.ADMINISTRACION.ordinal()]=exproNoOficio.getAndministracion();
			originalItem[ExproNoOficioEnum.PUNTOASISTENCIAL.ordinal()]=exproNoOficio.getPuntoAsistencial();
			originalItem[ExproNoOficioEnum.FECHADESDE.ordinal()]=this.DateToString(exproNoOficio.getFechaDesde());
			originalItem[ExproNoOficioEnum.FECHAHASTA.ordinal()]=this.DateToString(exproNoOficio.getFechaHasta());
			originalItem[ExproNoOficioEnum.TIPOCONTRATO.ordinal()]=exproNoOficio.getTipoContrato();
			originalItem[ExproNoOficioEnum.CATEGORÍA.ordinal()]= exproNoOficio.getCategoría();
			originalItem[ExproNoOficioEnum.HORAS_GUARDIA_REFUERZO.ordinal()]= this.IntegerToString(exproNoOficio.getHorasGuardiaRefuerzo());
			originalItem[ExproNoOficioEnum.COMUNIDAD_AUTONOMA.ordinal()]= exproNoOficio.getComunidadAutonoma();
			this.mapTipoMeritosItemOriginal.put(exproNoOficio.getId(), originalItem);
			
			tipoMeritosValuesString[ExproNoOficioEnum.DESCRIPCION.ordinal()]=exproNoOficio.getDescripcion();
			tipoMeritosValuesString[ExproNoOficioEnum.ADMINISTRACION.ordinal()]=exproNoOficio.getAndministracion();
			tipoMeritosValuesString[ExproNoOficioEnum.PUNTOASISTENCIAL.ordinal()]=exproNoOficio.getPuntoAsistencial();
			tipoMeritosValuesString[ExproNoOficioEnum.FECHADESDE.ordinal()]=this.DateToString(exproNoOficio.getFechaDesde());
			tipoMeritosValuesString[ExproNoOficioEnum.FECHAHASTA.ordinal()]=this.DateToString(exproNoOficio.getFechaHasta());
			tipoMeritosValuesString[ExproNoOficioEnum.TIPOCONTRATO.ordinal()]=exproNoOficio.getTipoContrato();
			tipoMeritosValuesString[ExproNoOficioEnum.CATEGORÍA.ordinal()]= exproNoOficio.getCategoría();
			tipoMeritosValuesString[ExproNoOficioEnum.HORAS_GUARDIA_REFUERZO.ordinal()]= this.IntegerToString(exproNoOficio.getHorasGuardiaRefuerzo());
			tipoMeritosValuesString[ExproNoOficioEnum.COMUNIDAD_AUTONOMA.ordinal()]= exproNoOficio.getComunidadAutonoma();
	
			
			tipoMeritosItem.put(exproNoOficio.getId(), exproNoOficio);
			mapItemValues.put(exproNoOficio.getId(), tipoMeritosValuesString);
		}
	}
	
	private void gestionarTitulacion(Item item) {
		Optional<Titulacion> titulacionOpt;
		Optional<TitulacionTribunal> titulacionTribunalOpt;
		
		titulacionOpt = this.titulacionService.findById(item.getId());
		titulacionTribunalOpt = this.titulacionTribunalService.findByTitulacion(titulacionOpt.get());
		String[] originalItem = new String[TitulacionEnum.N_ATRIBUTOS_EDITABLES];
		String[] tipoMeritosValuesString = new String[TitulacionEnum.N_ATRIBUTOS_EDITABLES];
		this.tipodeDato = new TipoDatoEnum[TitulacionEnum.N_ATRIBUTOS_EDITABLES];
		this.tipodeDato[TitulacionEnum.NIVEL.ordinal()]=TipoDatoEnum.INT;
		this.tipodeDato[TitulacionEnum.RAMA.ordinal()]= TipoDatoEnum.INT;
		this.tipodeDato[TitulacionEnum.TITULACION.ordinal()] = TipoDatoEnum.INT;
		this.tipodeDato[TitulacionEnum.FECHA_FINALIZACION.ordinal()] = TipoDatoEnum.DATE;
		this.tipodeDato[TitulacionEnum.EXPEDIENTE.ordinal()] = TipoDatoEnum.INT;
		this.tipodeDato[TitulacionEnum.CALIFICACION.ordinal()] = TipoDatoEnum.INT;
		this.tipodeDato[TitulacionEnum.DOCTORADO.ordinal()] = TipoDatoEnum.INT;
		this.tipodeDato[TitulacionEnum.PREMIO.ordinal()] = TipoDatoEnum.INT;
		this.tipodeDato[TitulacionEnum.TIPO_ADJUNTO.ordinal()] = TipoDatoEnum.STRING_LIMIT_CHAR_5;
		
		if(titulacionTribunalOpt.isPresent())
		{
			//añadimos el item original para que pueda ser consultado	
			Titulacion titulacion = titulacionOpt.get();
			originalItem[TitulacionEnum.NIVEL.ordinal()]=titulacion.getNivel().toString();
			originalItem[TitulacionEnum.RAMA.ordinal()]=titulacion.getRama().toString();
			originalItem[TitulacionEnum.TITULACION.ordinal()]=titulacion.getTitulacion().toString();
			originalItem[TitulacionEnum.CENTRO_EXPEDICION.ordinal()]=titulacion.getCentroExpedicion();
			originalItem[TitulacionEnum.FECHA_FINALIZACION.ordinal()]=this.DateToString(titulacion.getFechaFinalizacion());
			originalItem[TitulacionEnum.TIPO_ADJUNTO.ordinal()]=titulacion.getTipoAdjunto();
			originalItem[TitulacionEnum.EXPEDIENTE.ordinal()]=this.IntegerToString(titulacion.getExpediente());
			originalItem[TitulacionEnum.CALIFICACION.ordinal()]=this.IntegerToString(titulacion.getCalificacion());
			originalItem[TitulacionEnum.DOCTORADO.ordinal()]=this.IntegerToString(titulacion.getDoctorado());
			originalItem[TitulacionEnum.TITULACION_TEXTO_LIBRE.ordinal()]=titulacion.getTitulacionTextoLibre();
			originalItem[TitulacionEnum.PREMIO.ordinal()]=this.IntegerToString(titulacion.getPremio());
		
			this.mapTipoMeritosItemOriginal.put(titulacion.getId(), originalItem);
		
			
			TitulacionTribunal titulacionTribunal = titulacionTribunalOpt.get();
			tipoMeritosValuesString[TitulacionEnum.NIVEL.ordinal()]=titulacionTribunal.getNivel().toString();
			tipoMeritosValuesString[TitulacionEnum.RAMA.ordinal()]=titulacionTribunal.getRama().toString();
			tipoMeritosValuesString[TitulacionEnum.TITULACION.ordinal()]=titulacionTribunal.getTitulacion().toString();
			tipoMeritosValuesString[TitulacionEnum.CENTRO_EXPEDICION.ordinal()]=titulacionTribunal.getCentroExpedicion();
			tipoMeritosValuesString[TitulacionEnum.FECHA_FINALIZACION.ordinal()]=this.DateToString(titulacionTribunal.getFechaFinalizacion());
			tipoMeritosValuesString[TitulacionEnum.TIPO_ADJUNTO.ordinal()]=titulacionTribunal.getTipoAdjunto();
			tipoMeritosValuesString[TitulacionEnum.EXPEDIENTE.ordinal()]=this.IntegerToString(titulacionTribunal.getExpediente());
			tipoMeritosValuesString[TitulacionEnum.CALIFICACION.ordinal()]=this.IntegerToString(titulacionTribunal.getCalificacion());
			tipoMeritosValuesString[TitulacionEnum.DOCTORADO.ordinal()]=this.IntegerToString(titulacionTribunal.getDoctorado());
			tipoMeritosValuesString[TitulacionEnum.TITULACION_TEXTO_LIBRE.ordinal()]=titulacionTribunal.getTitulacionTextoLibre();
			tipoMeritosValuesString[TitulacionEnum.PREMIO.ordinal()]=this.IntegerToString(titulacionTribunal.getPremio());
					
			tipoMeritosItem.put(titulacionTribunal.getTitulacion().getId(), titulacionTribunal);
			mapItemValues.put(titulacionTribunal.getTitulacion().getId(), tipoMeritosValuesString);
			
		} else if(titulacionOpt.isPresent())
		{
			
			//añadimos el item original para que pueda ser consultado	
			Titulacion titulacion = titulacionOpt.get();
			originalItem[TitulacionEnum.NIVEL.ordinal()]=titulacion.getNivel().toString();
			originalItem[TitulacionEnum.RAMA.ordinal()]=titulacion.getRama().toString();
			originalItem[TitulacionEnum.TITULACION.ordinal()]=titulacion.getTitulacion().toString();
			originalItem[TitulacionEnum.CENTRO_EXPEDICION.ordinal()]=titulacion.getCentroExpedicion();
			originalItem[TitulacionEnum.FECHA_FINALIZACION.ordinal()]=this.DateToString(titulacion.getFechaFinalizacion());
			originalItem[TitulacionEnum.TIPO_ADJUNTO.ordinal()]=titulacion.getTipoAdjunto();
			originalItem[TitulacionEnum.EXPEDIENTE.ordinal()]=this.IntegerToString(titulacion.getExpediente());
			originalItem[TitulacionEnum.CALIFICACION.ordinal()]=this.IntegerToString(titulacion.getCalificacion());
			originalItem[TitulacionEnum.DOCTORADO.ordinal()]=this.IntegerToString(titulacion.getDoctorado());
			originalItem[TitulacionEnum.TITULACION_TEXTO_LIBRE.ordinal()]=titulacion.getTitulacionTextoLibre();
			originalItem[TitulacionEnum.PREMIO.ordinal()]=this.IntegerToString(titulacion.getPremio());
		
			this.mapTipoMeritosItemOriginal.put(titulacion.getId(), originalItem);

			
			//los campos que podran ser editados
			tipoMeritosValuesString[TitulacionEnum.NIVEL.ordinal()]=titulacion.getNivel().toString();
			tipoMeritosValuesString[TitulacionEnum.RAMA.ordinal()]=titulacion.getRama().toString();
			tipoMeritosValuesString[TitulacionEnum.TITULACION.ordinal()]=titulacion.getTitulacion().toString();
			tipoMeritosValuesString[TitulacionEnum.CENTRO_EXPEDICION.ordinal()]=titulacion.getCentroExpedicion();
			tipoMeritosValuesString[TitulacionEnum.FECHA_FINALIZACION.ordinal()]=this.DateToString(titulacion.getFechaFinalizacion());
			tipoMeritosValuesString[TitulacionEnum.TIPO_ADJUNTO.ordinal()]=titulacion.getTipoAdjunto();
			tipoMeritosValuesString[TitulacionEnum.EXPEDIENTE.ordinal()]=this.IntegerToString(titulacion.getExpediente());
			tipoMeritosValuesString[TitulacionEnum.CALIFICACION.ordinal()]=this.IntegerToString(titulacion.getCalificacion());
			tipoMeritosValuesString[TitulacionEnum.DOCTORADO.ordinal()]=this.IntegerToString(titulacion.getDoctorado());
			tipoMeritosValuesString[TitulacionEnum.TITULACION_TEXTO_LIBRE.ordinal()]=titulacion.getTitulacionTextoLibre();
			tipoMeritosValuesString[TitulacionEnum.PREMIO.ordinal()]=this.IntegerToString(titulacion.getPremio());
			
			tipoMeritosItem.put(titulacion.getId(), titulacion);
			mapItemValues.put(titulacion.getId(), tipoMeritosValuesString);
		}
		
	}
	
	
	private void gestionarRelacionFijeza(Item item) {
		Optional<RelacionFijezaTribunal> relacionFijezaTribunalOpt;
		Optional<RelacionFijeza> relacionFijezaOpt;
		
		relacionFijezaOpt = this.relacionFijezaService.findById(item.getId());
		relacionFijezaTribunalOpt = this.relacionFijezaTribunalService.findByRelacionFijeza(relacionFijezaOpt.get());
		
		String[] tipoMeritosValuesString = new String[RelacionFijezaEnum.N_ATRIBUTOS_EDITABLES];
		this.tipodeDato = new TipoDatoEnum[RelacionFijezaEnum.N_ATRIBUTOS_EDITABLES];
		this.tipodeDato[RelacionFijezaEnum.FECHA_TOMA_POSESION.ordinal()]= TipoDatoEnum.DATE;
		String[] originalItem = new String[RelacionFijezaEnum.N_ATRIBUTOS_EDITABLES];
	
		
		if(relacionFijezaTribunalOpt.isPresent())
		{
			//añadimos el item original para que pueda ser consultado
			RelacionFijeza relacionFijeza = relacionFijezaOpt.get();
			originalItem[RelacionFijezaEnum.DESCRIPCION.ordinal()]=relacionFijeza.getDescripcion();
			originalItem[RelacionFijezaEnum.CATEGORIA.ordinal()] = relacionFijeza.getCategoria();
			originalItem[RelacionFijezaEnum.ADMINISTRACION.ordinal()] = relacionFijeza.getAdministracion();
			originalItem[RelacionFijezaEnum.FECHA_TOMA_POSESION.ordinal()] = this.DateToString(relacionFijeza.getFechaTomaPosesion());
			originalItem[RelacionFijezaEnum.COMUNIDAD_AUTONOMA.ordinal()] = relacionFijeza.getComunidadAutonoma();
			originalItem[RelacionFijezaEnum.PUNTO_ASISTENCIAL.ordinal()] = relacionFijeza.getPuntoAsistencial();
			this.mapTipoMeritosItemOriginal.put(relacionFijeza.getId(), originalItem);

			
			
			
			
			
			RelacionFijezaTribunal relacionFijezaTribunal = relacionFijezaTribunalOpt.get();
			tipoMeritosValuesString[RelacionFijezaEnum.DESCRIPCION.ordinal()]=relacionFijezaTribunal.getDescripcion();
			tipoMeritosValuesString[RelacionFijezaEnum.CATEGORIA.ordinal()] = relacionFijezaTribunal.getCategoria();
			tipoMeritosValuesString[RelacionFijezaEnum.ADMINISTRACION.ordinal()] = relacionFijezaTribunal.getAdministracion();
			tipoMeritosValuesString[RelacionFijezaEnum.FECHA_TOMA_POSESION.ordinal()] = this.DateToString(relacionFijezaTribunal.getFechaTomaPosesion());
			tipoMeritosValuesString[RelacionFijezaEnum.COMUNIDAD_AUTONOMA.ordinal()] = relacionFijezaTribunal.getComunidadAutonoma();
			tipoMeritosValuesString[RelacionFijezaEnum.PUNTO_ASISTENCIAL.ordinal()] = relacionFijezaTribunal.getPuntoAsistencial();
	
			this.tipoMeritosItem.put(relacionFijezaTribunal.getRelacionFijeza().getId(), relacionFijezaTribunal);
			this.mapItemValues.put(relacionFijezaTribunal.getRelacionFijeza().getId(), tipoMeritosValuesString);
			
			
		}else if(relacionFijezaOpt.isPresent())
		{
			//añadimos el item original para que pueda ser consultado
			RelacionFijeza relacionFijeza = relacionFijezaOpt.get();
			originalItem[RelacionFijezaEnum.DESCRIPCION.ordinal()]=relacionFijeza.getDescripcion();
			originalItem[RelacionFijezaEnum.CATEGORIA.ordinal()] = relacionFijeza.getCategoria();
			originalItem[RelacionFijezaEnum.ADMINISTRACION.ordinal()] = relacionFijeza.getAdministracion();
			originalItem[RelacionFijezaEnum.FECHA_TOMA_POSESION.ordinal()] = this.DateToString(relacionFijeza.getFechaTomaPosesion());
			originalItem[RelacionFijezaEnum.COMUNIDAD_AUTONOMA.ordinal()] = relacionFijeza.getComunidadAutonoma();
			originalItem[RelacionFijezaEnum.PUNTO_ASISTENCIAL.ordinal()] = relacionFijeza.getPuntoAsistencial();
			this.mapTipoMeritosItemOriginal.put(relacionFijeza.getId(), originalItem);

			
			
			
			tipoMeritosValuesString[RelacionFijezaEnum.DESCRIPCION.ordinal()]=relacionFijeza.getDescripcion();
			tipoMeritosValuesString[RelacionFijezaEnum.CATEGORIA.ordinal()] = relacionFijeza.getCategoria();
			tipoMeritosValuesString[RelacionFijezaEnum.ADMINISTRACION.ordinal()] = relacionFijeza.getAdministracion();
			tipoMeritosValuesString[RelacionFijezaEnum.FECHA_TOMA_POSESION.ordinal()] = this.DateToString(relacionFijeza.getFechaTomaPosesion());
			tipoMeritosValuesString[RelacionFijezaEnum.COMUNIDAD_AUTONOMA.ordinal()] = relacionFijeza.getComunidadAutonoma();
			tipoMeritosValuesString[RelacionFijezaEnum.PUNTO_ASISTENCIAL.ordinal()] = relacionFijeza.getPuntoAsistencial();
	
			this.tipoMeritosItem.put(relacionFijeza.getId(), relacionFijeza);
			this.mapItemValues.put(relacionFijeza.getId(), tipoMeritosValuesString);
		
		}
		
		
	}
	
	private void gestionarFormacionEspecializada(Item item) {
		Optional<FormacionEspecializada> formacionEspecializadaOpt;
		Optional<FormacionEspecializadaTribunal> formacionEspecializadaTribunalOpt;
		
		formacionEspecializadaOpt = this.formacionEspecializadaService.findById(item.getId());
		formacionEspecializadaTribunalOpt = this.formacionEspecializadaTribunalService.findByFormacionEspecializada(formacionEspecializadaOpt.get());
		String[] originalItem = new String[FormacionEspecializadaEnum.N_ATRIBUTOS_EDITABLES];
		
		String[] tipoMeritosValuesString = new String[FormacionContinuadaEnum.N_ATRIBUTOS_EDITABLES];
		this.tipodeDato = new TipoDatoEnum[FormacionEspecializadaEnum.N_ATRIBUTOS_EDITABLES];
		this.tipodeDato[FormacionEspecializadaEnum.TIPO_ESPECIALIDAD.ordinal()]= TipoDatoEnum.STRING_LIMIT_CHAR_1;
		this.tipodeDato[FormacionEspecializadaEnum.FECHA_FINALIZACION.ordinal()] = TipoDatoEnum.DATE;
		this.tipodeDato[FormacionEspecializadaEnum.VIA_ACCESO.ordinal()] = TipoDatoEnum.INT;
		this.tipodeDato[FormacionEspecializadaEnum.ESPECIALISTA.ordinal()] = TipoDatoEnum.STRING_LIMIT_CHAR_5;
		this.tipodeDato[FormacionEspecializadaEnum.TIPO_ADJUNTO.ordinal()] = TipoDatoEnum.STRING_LIMIT_CHAR_5;
		this.tipodeDato[FormacionEspecializadaEnum.VALORACION_CUANTITATIVA.ordinal()] = TipoDatoEnum.INT;
		
		if(formacionEspecializadaTribunalOpt.isPresent())
		{
			//añadimos el item original para que pueda ser consultado
			FormacionEspecializada formacionEspecializada = formacionEspecializadaOpt.get();
			originalItem[FormacionEspecializadaEnum.TIPO_ESPECIALIDAD.ordinal()] = formacionEspecializada.getTipoEspecialidad();
			originalItem[FormacionEspecializadaEnum.CENTRO_EXPEDICION.ordinal()] = formacionEspecializada.getCentroExpedicion().toString();
			originalItem[FormacionEspecializadaEnum.FECHA_FINALIZACION.ordinal()] = this.DateToString(formacionEspecializada.getFechaFinalizacion());
			originalItem[FormacionEspecializadaEnum.VIA_ACCESO.ordinal()] = formacionEspecializada.getViaAcceso().toString();
			originalItem[FormacionEspecializadaEnum.ESPECIALISTA.ordinal()] = formacionEspecializada.getEspecialista();
			originalItem[FormacionEspecializadaEnum.TIPO_ADJUNTO.ordinal()] = formacionEspecializada.getTipoAdjunto();
			originalItem[FormacionEspecializadaEnum.TIPO_VALORACION.ordinal()] = formacionEspecializada.getTipoValoracion();
			originalItem[FormacionEspecializadaEnum.VALORACION_CUANTITATIVA.ordinal()] = this.IntegerToString(formacionEspecializada.getValoracionCuantitativa());
			originalItem[FormacionEspecializadaEnum.VALORACION_CUALITATIVA.ordinal()] = formacionEspecializada.getValoracionCualitativa();
			this.mapTipoMeritosItemOriginal.put(formacionEspecializada.getId(), originalItem);
			
				
			
			FormacionEspecializadaTribunal formacionEspecializadaTribunal = formacionEspecializadaTribunalOpt.get();
			this.tipoMeritosItem.put(formacionEspecializadaTribunal.getFormacionEspecializada().getId(), formacionEspecializadaTribunal);
			
			tipoMeritosValuesString[FormacionEspecializadaEnum.TIPO_ESPECIALIDAD.ordinal()] = formacionEspecializadaTribunal.getTipoEspecialidad();
			tipoMeritosValuesString[FormacionEspecializadaEnum.CENTRO_EXPEDICION.ordinal()] = formacionEspecializadaTribunal.getCentroExpedicion().toString();
			tipoMeritosValuesString[FormacionEspecializadaEnum.FECHA_FINALIZACION.ordinal()] = this.DateToString(formacionEspecializadaTribunal.getFechaFinalizacion());
			tipoMeritosValuesString[FormacionEspecializadaEnum.VIA_ACCESO.ordinal()] = formacionEspecializadaTribunal.getViaAcceso().toString();
			tipoMeritosValuesString[FormacionEspecializadaEnum.ESPECIALISTA.ordinal()] = formacionEspecializadaTribunal.getEspecialista();
			tipoMeritosValuesString[FormacionEspecializadaEnum.TIPO_ADJUNTO.ordinal()] = formacionEspecializadaTribunal.getTipoAdjunto();
			tipoMeritosValuesString[FormacionEspecializadaEnum.TIPO_VALORACION.ordinal()] = formacionEspecializadaTribunal.getTipoValoracion();
			tipoMeritosValuesString[FormacionEspecializadaEnum.VALORACION_CUANTITATIVA.ordinal()] = this.IntegerToString(formacionEspecializadaTribunal.getValoracionCuantitativa());
			tipoMeritosValuesString[FormacionEspecializadaEnum.VALORACION_CUALITATIVA.ordinal()] = formacionEspecializadaTribunal.getValoracionCualitativa();
				
			this.mapItemValues.put(formacionEspecializadaTribunal.getFormacionEspecializada().getId(), tipoMeritosValuesString);
			
		}else if(formacionEspecializadaOpt.isPresent())
		{
			//añadimos el item original para que pueda ser consultado
			FormacionEspecializada formacionEspecializada = formacionEspecializadaOpt.get();
			originalItem[FormacionEspecializadaEnum.TIPO_ESPECIALIDAD.ordinal()] = formacionEspecializada.getTipoEspecialidad();
			originalItem[FormacionEspecializadaEnum.CENTRO_EXPEDICION.ordinal()] = formacionEspecializada.getCentroExpedicion().toString();
			originalItem[FormacionEspecializadaEnum.FECHA_FINALIZACION.ordinal()] = this.DateToString(formacionEspecializada.getFechaFinalizacion());
			originalItem[FormacionEspecializadaEnum.VIA_ACCESO.ordinal()] = formacionEspecializada.getViaAcceso().toString();
			originalItem[FormacionEspecializadaEnum.ESPECIALISTA.ordinal()] = formacionEspecializada.getEspecialista();
			originalItem[FormacionEspecializadaEnum.TIPO_ADJUNTO.ordinal()] = formacionEspecializada.getTipoAdjunto();
			originalItem[FormacionEspecializadaEnum.TIPO_VALORACION.ordinal()] = formacionEspecializada.getTipoValoracion();
			originalItem[FormacionEspecializadaEnum.VALORACION_CUANTITATIVA.ordinal()] = this.IntegerToString(formacionEspecializada.getValoracionCuantitativa());
			originalItem[FormacionEspecializadaEnum.VALORACION_CUALITATIVA.ordinal()] = formacionEspecializada.getValoracionCualitativa();
			this.mapTipoMeritosItemOriginal.put(formacionEspecializada.getId(), originalItem);

			
			//los campos que podrán ser editados
			this.tipoMeritosItem.put(formacionEspecializada.getId(), formacionEspecializada);
			
			tipoMeritosValuesString[FormacionEspecializadaEnum.TIPO_ESPECIALIDAD.ordinal()] = formacionEspecializada.getTipoEspecialidad();
			tipoMeritosValuesString[FormacionEspecializadaEnum.CENTRO_EXPEDICION.ordinal()] = formacionEspecializada.getCentroExpedicion().toString();
			tipoMeritosValuesString[FormacionEspecializadaEnum.FECHA_FINALIZACION.ordinal()] = this.DateToString(formacionEspecializada.getFechaFinalizacion());
			tipoMeritosValuesString[FormacionEspecializadaEnum.VIA_ACCESO.ordinal()] = formacionEspecializada.getViaAcceso().toString();
			tipoMeritosValuesString[FormacionEspecializadaEnum.ESPECIALISTA.ordinal()] = formacionEspecializada.getEspecialista();
			tipoMeritosValuesString[FormacionEspecializadaEnum.TIPO_ADJUNTO.ordinal()] = formacionEspecializada.getTipoAdjunto();
			tipoMeritosValuesString[FormacionEspecializadaEnum.TIPO_VALORACION.ordinal()] = formacionEspecializada.getTipoValoracion();
			tipoMeritosValuesString[FormacionEspecializadaEnum.VALORACION_CUANTITATIVA.ordinal()] = this.IntegerToString(formacionEspecializada.getValoracionCuantitativa());
			tipoMeritosValuesString[FormacionEspecializadaEnum.VALORACION_CUALITATIVA.ordinal()] = formacionEspecializada.getValoracionCualitativa();
				
			this.mapItemValues.put(formacionEspecializada.getId(), tipoMeritosValuesString);
			
		}
	}
	
	
	private void gestionarTitulacionPremio(Item item) {
		Optional<TitulacionPremio> titulacionPremioOPt;
		Optional<TitulacionPremioTribunal> titulacionPremioTribunalOpt;
		
		titulacionPremioOPt = this.titulacionPremioService.findById(item.getId());
		titulacionPremioTribunalOpt = this.titulacionPremioTribunalService.findByTitulacionPremio(titulacionPremioOPt.get());
		String[] originalItem = new String[TitulacionPremioEnum.N_ATRIBUTOS_EDITABLES];
		
		String[] tipoMeritosValuesString = new String[TitulacionPremioEnum.N_ATRIBUTOS_EDITABLES];
		
		if(titulacionPremioTribunalOpt.isPresent())
		{
			
			//añadimos el item original para que pueda ser consultado
			TitulacionPremio titulacionPremio = titulacionPremioOPt.get();
			originalItem[TitulacionPremioEnum.PREMIO_FIN_CARRERA.ordinal()]= titulacionPremio.getPremioFinCarrera();
			this.mapTipoMeritosItemOriginal.put(titulacionPremio.getId(), originalItem);
			
			//añadimos los datos que podran ser editados
			TitulacionPremioTribunal titulacionPremioTribunal = titulacionPremioTribunalOpt.get();
			this.tipoMeritosItem.put(titulacionPremioTribunal.getTitulacionPremio().getId(),titulacionPremioTribunal);
			
			tipoMeritosValuesString[TitulacionPremioEnum.PREMIO_FIN_CARRERA.ordinal()]= titulacionPremioTribunal.getPremioFinCarrera();
			
			mapItemValues.put(titulacionPremioTribunal.getTitulacionPremio().getId(),tipoMeritosValuesString);
			
				
		} else if(titulacionPremioOPt.isPresent())
		{
			//añadimos el item original para que pueda ser consultado
			TitulacionPremio titulacionPremio = titulacionPremioOPt.get();
			originalItem[TitulacionPremioEnum.PREMIO_FIN_CARRERA.ordinal()]= titulacionPremio.getPremioFinCarrera();
			this.mapTipoMeritosItemOriginal.put(titulacionPremio.getId(), originalItem);

			
			
			this.tipoMeritosItem.put(titulacionPremio.getId(),titulacionPremio);
			
			tipoMeritosValuesString[TitulacionPremioEnum.PREMIO_FIN_CARRERA.ordinal()]= titulacionPremio.getPremioFinCarrera();
			
			mapItemValues.put(titulacionPremio.getId(),tipoMeritosValuesString);	
		}
	}
	
	private void gestionarInternoResidente(Item item) {
		Optional<InternoResidente> internoResidenteOpt;
		Optional<InternoResidenteTribunal> internoResidenteTribunalOpt;
		
		internoResidenteOpt = this.internoResidenteService.findById(item.getId());
		internoResidenteTribunalOpt = this.internoResidenteTribunalService.findByInternoResidente(internoResidenteOpt.get());
		String[] originalItem = new String[InternoResidenteEnum.N_ATRIBUTOS_EDITABLES];
		
		String [] tipoMeritosValuesString = new String[InternoResidenteEnum.N_ATRIBUTOS_EDITABLES];
		this.tipodeDato = new TipoDatoEnum[InternoResidenteEnum.N_ATRIBUTOS_EDITABLES];
		this.tipodeDato[InternoResidenteEnum.TIPO_RESIDENTE.ordinal()] = TipoDatoEnum.STRING_LIMIT_CHAR_5;
		this.tipodeDato[InternoResidenteEnum.ANO_EXAMEN.ordinal()] = TipoDatoEnum.INT;
		this.tipodeDato[InternoResidenteEnum.NUM_ORDEN.ordinal()] = TipoDatoEnum.INT;
		
		if(internoResidenteTribunalOpt.isPresent())
		{

			//añadimos el item original para que pueda ser consultado
			InternoResidente internoResidente = internoResidenteOpt.get();
			
			
			
			originalItem[InternoResidenteEnum.TIPO_RESIDENTE.ordinal()]= internoResidente.getTipoResidente();
			originalItem[InternoResidenteEnum.ANO_EXAMEN.ordinal()]= internoResidente.getAnoExamen().toString();
			originalItem[InternoResidenteEnum.NUM_ORDEN.ordinal()] = internoResidente.getNumOrden().toString();
			
			this.mapTipoMeritosItemOriginal.put(internoResidente.getId(), originalItem);
			
			//añadimos los datos que podran ser editados
			InternoResidenteTribunal internoResidenteTribunal = internoResidenteTribunalOpt.get();
			this.tipoMeritosItem.put(internoResidenteTribunal.getInternoResidente().getId(),internoResidenteTribunal);
			
			tipoMeritosValuesString[InternoResidenteEnum.TIPO_RESIDENTE.ordinal()]= internoResidenteTribunal.getTipoResidente();
			tipoMeritosValuesString[InternoResidenteEnum.ANO_EXAMEN.ordinal()]= internoResidenteTribunal.getAnoExamen().toString();
			tipoMeritosValuesString[InternoResidenteEnum.NUM_ORDEN.ordinal()] = internoResidenteTribunal.getNumOrden().toString();
			
			mapItemValues.put(internoResidenteTribunal.getInternoResidente().getId(),tipoMeritosValuesString);
			
		} else if(internoResidenteOpt.isPresent())
		{
			//añadimos el item original para que pueda ser consultado
			InternoResidente internoResidente = internoResidenteOpt.get();
			
			
			originalItem[InternoResidenteEnum.TIPO_RESIDENTE.ordinal()]= internoResidente.getTipoResidente();
			originalItem[InternoResidenteEnum.ANO_EXAMEN.ordinal()]= internoResidente.getAnoExamen().toString();
			originalItem[InternoResidenteEnum.NUM_ORDEN.ordinal()] = internoResidente.getNumOrden().toString();
			
			this.mapTipoMeritosItemOriginal.put(internoResidente.getId(), originalItem);
	
			
			
			
			//añadimos los datos que podran ser editados
			this.tipoMeritosItem.put(internoResidente.getId(),internoResidente);
			
			tipoMeritosValuesString[InternoResidenteEnum.TIPO_RESIDENTE.ordinal()]= internoResidente.getTipoResidente();
			tipoMeritosValuesString[InternoResidenteEnum.ANO_EXAMEN.ordinal()]= internoResidente.getAnoExamen().toString();
			tipoMeritosValuesString[InternoResidenteEnum.NUM_ORDEN.ordinal()] = internoResidente.getNumOrden().toString();
			
			mapItemValues.put(internoResidente.getId(),tipoMeritosValuesString);

			
		}
	}
	
	
	private void gestionarInvestigacion(Item item) {
		Optional<Investigacion> investigacionOpt;
		Optional<InvestigacionTribunal> investigacionTribunalOpt;
		
		investigacionOpt = this.investigacionService.findById(item.getId());
		investigacionTribunalOpt = this.investigacionTribunalService.findByInvestigacion(investigacionOpt.get());
		String[] originalItem = new String[InvestigacionEnum.N_ATRIBUTOS_EDITABLES];
		
		String[] tipoMeritosValuesString = new String[InvestigacionEnum.N_ATRIBUTOS_EDITABLES];
		this.tipodeDato = new TipoDatoEnum[InvestigacionEnum.N_ATRIBUTOS_EDITABLES];
		this.tipodeDato[InvestigacionEnum.TIPO_ACTIVIDAD.ordinal()] = TipoDatoEnum.INT;
		this.tipodeDato[InvestigacionEnum.FIRMANTE.ordinal()] = TipoDatoEnum.STRING_LIMIT_CHAR_5;
		this.tipodeDato[InvestigacionEnum.FACTOR_IMPACTO.ordinal()] = TipoDatoEnum.INT;
		this.tipodeDato[InvestigacionEnum.FECHA_INICIO.ordinal()] = TipoDatoEnum.DATE;
		this.tipodeDato[InvestigacionEnum.FECHA_FIN.ordinal()] = TipoDatoEnum.DATE;
		
		if(investigacionTribunalOpt.isPresent())
		{	//los datos originales que después podrán ser consultados - adb86y
			Investigacion investigacion = investigacionOpt.get();
			originalItem[InvestigacionEnum.DESCRIPCION.ordinal()]= investigacion.getDescripcion();
			originalItem[InvestigacionEnum.TIPO_ACTIVIDAD.ordinal()]= investigacion.getTipoActividad().toString();
			originalItem[InvestigacionEnum.FIRMANTE.ordinal()]= investigacion.getFirmante();
			originalItem[InvestigacionEnum.PUBLICADO_EN.ordinal()] = investigacion.getPublicadoEn();
			originalItem[InvestigacionEnum.FACTOR_IMPACTO.ordinal()]= investigacion.getFactorImpacto() != null ? investigacion.getFactorImpacto().toString() : "";
			originalItem[InvestigacionEnum.FECHA_INICIO.ordinal()]= this.DateToString(investigacion.getFechaInicio());
			originalItem[InvestigacionEnum.FECHA_FIN.ordinal()]= this.DateToString(investigacion.getFechaFin());
	
			
			this.mapTipoMeritosItemOriginal.put(investigacion.getId(), originalItem);
		
			
			//RELLENAMOS EL MAPA QUE CONTENDRA LOS ITEM EDITABLES - adb86y 
			InvestigacionTribunal investigacionTribunal = investigacionTribunalOpt.get();
			this.tipoMeritosItem.put(investigacionTribunal.getInvestigacion().getId(),investigacionTribunal);
			
			tipoMeritosValuesString[InvestigacionEnum.DESCRIPCION.ordinal()]= investigacionTribunal.getDescripcion();
			tipoMeritosValuesString[InvestigacionEnum.TIPO_ACTIVIDAD.ordinal()]= investigacionTribunal.getTipoActividad().toString();
			tipoMeritosValuesString[InvestigacionEnum.FIRMANTE.ordinal()]= investigacionTribunal.getFirmante();
			tipoMeritosValuesString[InvestigacionEnum.PUBLICADO_EN.ordinal()] = investigacionTribunal.getPublicadoEn();
			tipoMeritosValuesString[InvestigacionEnum.FACTOR_IMPACTO.ordinal()]= investigacionTribunal.getFactorImpacto() != null ? investigacionTribunal.getFactorImpacto().toString() : "";
			tipoMeritosValuesString[InvestigacionEnum.FECHA_INICIO.ordinal()]= this.DateToString(investigacionTribunal.getFechaInicio());
			tipoMeritosValuesString[InvestigacionEnum.FECHA_FIN.ordinal()]= this.DateToString(investigacionTribunal.getFechaFin());
			
			mapItemValues.put(investigacionTribunal.getInvestigacion().getId(), tipoMeritosValuesString);
			
			
			
		} else if(investigacionOpt.isPresent())
		{
			//los datos originales que después podrán ser consultados
			Investigacion investigacion = investigacionOpt.get();
			originalItem[InvestigacionEnum.DESCRIPCION.ordinal()]= investigacion.getDescripcion();
			originalItem[InvestigacionEnum.TIPO_ACTIVIDAD.ordinal()]= investigacion.getTipoActividad().toString();
			originalItem[InvestigacionEnum.FIRMANTE.ordinal()]= investigacion.getFirmante();
			originalItem[InvestigacionEnum.PUBLICADO_EN.ordinal()] = investigacion.getPublicadoEn();
			originalItem[InvestigacionEnum.FACTOR_IMPACTO.ordinal()]= investigacion.getFactorImpacto() != null ? investigacion.getFactorImpacto().toString() : "";
			originalItem[InvestigacionEnum.FECHA_INICIO.ordinal()]= this.DateToString(investigacion.getFechaInicio());
			originalItem[InvestigacionEnum.FECHA_FIN.ordinal()]= this.DateToString(investigacion.getFechaFin());
	
			
			this.mapTipoMeritosItemOriginal.put(investigacion.getId(), originalItem);
		
			
			//RELLENAMOS EL MAPA QUE CONTENDRA LOS ITEM EDITABLES
				
			this.tipoMeritosItem.put(investigacion.getId(),investigacion);
			
			tipoMeritosValuesString[InvestigacionEnum.DESCRIPCION.ordinal()]= investigacion.getDescripcion();
			tipoMeritosValuesString[InvestigacionEnum.TIPO_ACTIVIDAD.ordinal()]= investigacion.getTipoActividad().toString();
			tipoMeritosValuesString[InvestigacionEnum.FIRMANTE.ordinal()]= investigacion.getFirmante();
			tipoMeritosValuesString[InvestigacionEnum.PUBLICADO_EN.ordinal()] = investigacion.getPublicadoEn();
			originalItem[InvestigacionEnum.FACTOR_IMPACTO.ordinal()]= investigacion.getFactorImpacto() != null ? investigacion.getFactorImpacto().toString() : "";
			tipoMeritosValuesString[InvestigacionEnum.FECHA_INICIO.ordinal()]= this.DateToString(investigacion.getFechaInicio());
			tipoMeritosValuesString[InvestigacionEnum.FECHA_FIN.ordinal()]= this.DateToString(investigacion.getFechaFin());
			
			mapItemValues.put(investigacion.getId(), tipoMeritosValuesString);
		}
		
	}
	
	private void gestionarFormacionContinuada(Item item) {
		
		Optional<FormacionContinuada> formacionContinuadaOpt=null;
		Optional<FormacionContinuadaTribunal> formacionContinuadaTribunalOpt=null;
		
		formacionContinuadaOpt = this.formacionContinuadaService.findById(item.getId());
		formacionContinuadaTribunalOpt = this.formacionContinuadaTribunalService.findByFormacionContinuada(formacionContinuadaOpt.get());
		String[] originalItem = new String[FormacionContinuadaEnum.N_ATRIBUTOS_EDITABLES];
			
		String[] tipoMeritosValueString = new String[FormacionContinuadaEnum.N_ATRIBUTOS_EDITABLES];
		this.tipodeDato = new TipoDatoEnum[FormacionContinuadaEnum.N_ATRIBUTOS_EDITABLES];
		this.tipodeDato[FormacionContinuadaEnum.TIPO_CENTRO.ordinal()] = TipoDatoEnum.INT;
		this.tipodeDato[FormacionContinuadaEnum.FECHA_INICIO.ordinal()] = TipoDatoEnum.DATE;
		this.tipodeDato[FormacionContinuadaEnum.FECHA_FIN.ordinal()] = TipoDatoEnum.DATE;
		this.tipodeDato[FormacionContinuadaEnum.TIPO_ADJUNTO.ordinal()] = TipoDatoEnum.STRING_LIMIT_CHAR_5;
		this.tipodeDato[FormacionContinuadaEnum.UNIDAD_VALORACION.ordinal()] = TipoDatoEnum.STRING_LIMIT_CHAR_5;
		this.tipodeDato[FormacionContinuadaEnum.VALORACION.ordinal()] = TipoDatoEnum.INT;
		
		if(formacionContinuadaTribunalOpt.isPresent())
		{
			
			//añadimos el item original
			FormacionContinuada formacionContinuada = formacionContinuadaOpt.get();
			
			originalItem[FormacionContinuadaEnum.CENTRO_EXPEDICION.ordinal()]=formacionContinuada.getCentroExpedicion();
			originalItem[FormacionContinuadaEnum.DESCRIPCION.ordinal()]=formacionContinuada.getDescripcion();
			originalItem[FormacionContinuadaEnum.FECHA_FIN.ordinal()]=this.DateToString(formacionContinuada.getFechaFin());
			originalItem[FormacionContinuadaEnum.FECHA_INICIO.ordinal()]=this.DateToString(formacionContinuada.getFechaInicio());
			originalItem[FormacionContinuadaEnum.TIPO_ADJUNTO.ordinal()]=formacionContinuada.getTipoAdjunto();
			originalItem[FormacionContinuadaEnum.TIPO_VALORACION.ordinal()]=formacionContinuada.getTipoValoracion();
			originalItem[FormacionContinuadaEnum.TIPO_CENTRO.ordinal()]=formacionContinuada.getTipoCentro().toString();
			originalItem[FormacionContinuadaEnum.UNIDAD_VALORACION.ordinal()]=formacionContinuada.getUnidadValoracion();
			originalItem[FormacionContinuadaEnum.VALORACION.ordinal()]=formacionContinuada.getValoracion().toString();
		
			this.mapTipoMeritosItemOriginal.put(formacionContinuada.getId(), originalItem);
			
			//RELLENAMOS EL MAPA QUE CONTENDRA LOS ITEM EDITABLES
			FormacionContinuadaTribunal formacionContinuadaTribunal = formacionContinuadaTribunalOpt.get();
			this.tipoMeritosItem.put(formacionContinuadaTribunal.getFormacionContinuada().getId(),formacionContinuadaTribunal);
			
			tipoMeritosValueString[FormacionContinuadaEnum.CENTRO_EXPEDICION.ordinal()]=formacionContinuadaTribunal.getCentroExpedicion();
			tipoMeritosValueString[FormacionContinuadaEnum.DESCRIPCION.ordinal()]=formacionContinuadaTribunal.getDescripcion();
			tipoMeritosValueString[FormacionContinuadaEnum.FECHA_FIN.ordinal()]=this.DateToString(formacionContinuadaTribunal.getFechaFin());
			tipoMeritosValueString[FormacionContinuadaEnum.FECHA_INICIO.ordinal()]=this.DateToString(formacionContinuadaTribunal.getFechaInicio());
			tipoMeritosValueString[FormacionContinuadaEnum.TIPO_ADJUNTO.ordinal()]=formacionContinuadaTribunal.getTipoAdjunto();
			tipoMeritosValueString[FormacionContinuadaEnum.TIPO_CENTRO.ordinal()]=formacionContinuadaTribunal.getTipoCentro().toString();
			tipoMeritosValueString[FormacionContinuadaEnum.TIPO_VALORACION.ordinal()]=formacionContinuadaTribunal.getTipoValoracion();
			tipoMeritosValueString[FormacionContinuadaEnum.UNIDAD_VALORACION.ordinal()]=formacionContinuadaTribunal.getUnidadValoracion();
			tipoMeritosValueString[FormacionContinuadaEnum.VALORACION.ordinal()]=formacionContinuadaTribunal.getValoracion().toString();
				
			mapItemValues.put(formacionContinuadaTribunal.getFormacionContinuada().getId(), tipoMeritosValueString);
			
			
		} else if(formacionContinuadaOpt.isPresent())
		{
			//añadimos el item original
			FormacionContinuada formacionContinuada = formacionContinuadaOpt.get();
			
			originalItem[FormacionContinuadaEnum.CENTRO_EXPEDICION.ordinal()]=formacionContinuada.getCentroExpedicion();
			originalItem[FormacionContinuadaEnum.DESCRIPCION.ordinal()]=formacionContinuada.getDescripcion();
			originalItem[FormacionContinuadaEnum.FECHA_FIN.ordinal()]=this.DateToString(formacionContinuada.getFechaFin());
			originalItem[FormacionContinuadaEnum.FECHA_INICIO.ordinal()]=this.DateToString(formacionContinuada.getFechaInicio());
			originalItem[FormacionContinuadaEnum.TIPO_ADJUNTO.ordinal()]=formacionContinuada.getTipoAdjunto();
			originalItem[FormacionContinuadaEnum.TIPO_VALORACION.ordinal()]=formacionContinuada.getTipoValoracion();
			originalItem[FormacionContinuadaEnum.TIPO_CENTRO.ordinal()]=formacionContinuada.getTipoCentro().toString();
			originalItem[FormacionContinuadaEnum.UNIDAD_VALORACION.ordinal()]=formacionContinuada.getUnidadValoracion();
			originalItem[FormacionContinuadaEnum.VALORACION.ordinal()]=formacionContinuada.getValoracion().toString();
		
			this.mapTipoMeritosItemOriginal.put(formacionContinuada.getId(), originalItem);
	
			
			
			//RELLENAMOS EL MAPA QUE CONTENDRA LOS ITEM EDITABLES
			this.tipoMeritosItem.put(formacionContinuada.getId(),formacionContinuada);
			
			tipoMeritosValueString[FormacionContinuadaEnum.CENTRO_EXPEDICION.ordinal()]=formacionContinuada.getCentroExpedicion();
			tipoMeritosValueString[FormacionContinuadaEnum.DESCRIPCION.ordinal()]=formacionContinuada.getDescripcion();
			tipoMeritosValueString[FormacionContinuadaEnum.FECHA_FIN.ordinal()]=this.DateToString(formacionContinuada.getFechaFin());
			tipoMeritosValueString[FormacionContinuadaEnum.FECHA_INICIO.ordinal()]=this.DateToString(formacionContinuada.getFechaInicio());
			tipoMeritosValueString[FormacionContinuadaEnum.TIPO_ADJUNTO.ordinal()]=formacionContinuada.getTipoAdjunto();
			tipoMeritosValueString[FormacionContinuadaEnum.TIPO_VALORACION.ordinal()]=formacionContinuada.getTipoValoracion();
			tipoMeritosValueString[FormacionContinuadaEnum.TIPO_CENTRO.ordinal()]=formacionContinuada.getTipoCentro().toString();
			tipoMeritosValueString[FormacionContinuadaEnum.UNIDAD_VALORACION.ordinal()]=formacionContinuada.getUnidadValoracion();
			tipoMeritosValueString[FormacionContinuadaEnum.VALORACION.ordinal()]=formacionContinuada.getValoracion().toString();
				
			mapItemValues.put(formacionContinuada.getId(), tipoMeritosValueString);
			

		}
	}
	
	private void gestionarTitulacionExpediente(Item item) {
		Optional<TitulacionExpediente> titEx=null;
		Optional<TitulacionExpedienteTribunal> titExTri=null;
		titEx = this.titulacionExpedienteService.findById(item.getId());
		
		titExTri = this.titulacionExpedienteTribunalService.findByTitulacionExpediente(titEx.get());
		String[] originalItem = new String[TitulacionExpedienteEnum.N_ATRIBUTOS_EDITABLES];
			
		String[] tipoMeritosValueString = new String[TitulacionExpedienteEnum.N_ATRIBUTOS_EDITABLES];
		this.tipodeDato = new TipoDatoEnum[TitulacionExpedienteEnum.N_ATRIBUTOS_EDITABLES];
		this.tipodeDato[TitulacionExpedienteEnum.NUMERO_ASIGNATURAS.ordinal()] = TipoDatoEnum.INT;
		this.tipodeDato[TitulacionExpedienteEnum.NUMERO_MATRICULAS.ordinal()] = TipoDatoEnum.INT;
		this.tipodeDato[TitulacionExpedienteEnum.NUMERO_SOBRESALIENTES.ordinal()] = TipoDatoEnum.INT;
		this.tipodeDato[TitulacionExpedienteEnum.NUMERO_NOTABLES.ordinal()] = TipoDatoEnum.INT;
		
		if(titExTri.isPresent())
		{
			//los datos originales que despues podran ser consultados
			TitulacionExpediente titulacionExpediente= titEx.get();
			
			originalItem[TitulacionExpedienteEnum.NUMERO_ASIGNATURAS.ordinal()]=titulacionExpediente.getNumAsignaturas().toString();
			originalItem[TitulacionExpedienteEnum.NUMERO_MATRICULAS.ordinal()]=titulacionExpediente.getNumMatriculas().toString();
			originalItem[TitulacionExpedienteEnum.NUMERO_NOTABLES.ordinal()]=titulacionExpediente.getNumNotables().toString();
			originalItem[TitulacionExpedienteEnum.NUMERO_SOBRESALIENTES.ordinal()]=titulacionExpediente.getNumSobresalientes().toString();
			
			this.mapTipoMeritosItemOriginal.put(titulacionExpediente.getId(), originalItem);
		
			
			//RELLENAMOS EL MAPA QUE CONTENDRA LOS ITEM EDITABLES
			TitulacionExpedienteTribunal titulacionExpedienteTribunal=titExTri.get();
	
			this.tipoMeritosItem.put(titulacionExpedienteTribunal.getTitulacionExpediente().getId(), titulacionExpedienteTribunal);
			
			tipoMeritosValueString[TitulacionExpedienteEnum.NUMERO_ASIGNATURAS.ordinal()]=titulacionExpedienteTribunal.getNumAsignaturas().toString();
			tipoMeritosValueString[TitulacionExpedienteEnum.NUMERO_MATRICULAS.ordinal()]=titulacionExpedienteTribunal.getNumMatriculas().toString();
			tipoMeritosValueString[TitulacionExpedienteEnum.NUMERO_NOTABLES.ordinal()]=titulacionExpedienteTribunal.getNumNotables().toString();
			tipoMeritosValueString[TitulacionExpedienteEnum.NUMERO_SOBRESALIENTES.ordinal()]=titulacionExpedienteTribunal.getNumSobresalientes().toString();
			mapItemValues.put(titulacionExpedienteTribunal.getTitulacionExpediente().getId(), tipoMeritosValueString);
		} else if(titEx.isPresent()) {
			//los datos originales que despues podran ser consultados
			TitulacionExpediente titulacionExpediente= titEx.get();
			
			originalItem[TitulacionExpedienteEnum.NUMERO_ASIGNATURAS.ordinal()]=titulacionExpediente.getNumAsignaturas().toString();
			originalItem[TitulacionExpedienteEnum.NUMERO_MATRICULAS.ordinal()]=titulacionExpediente.getNumMatriculas().toString();
			originalItem[TitulacionExpedienteEnum.NUMERO_NOTABLES.ordinal()]=titulacionExpediente.getNumNotables().toString();
			originalItem[TitulacionExpedienteEnum.NUMERO_SOBRESALIENTES.ordinal()]=titulacionExpediente.getNumSobresalientes().toString();
			
			this.mapTipoMeritosItemOriginal.put(titulacionExpediente.getId(), originalItem);

			
			
			
			
			//RELLENAMOS EL MAPA QUE CONTENDRA LOS ITEM EDITABLES
			tipoMeritosValueString[TitulacionExpedienteEnum.NUMERO_ASIGNATURAS.ordinal()]=titulacionExpediente.getNumAsignaturas().toString();
			tipoMeritosValueString[TitulacionExpedienteEnum.NUMERO_MATRICULAS.ordinal()]=titulacionExpediente.getNumMatriculas().toString();
			tipoMeritosValueString[TitulacionExpedienteEnum.NUMERO_NOTABLES.ordinal()]=titulacionExpediente.getNumNotables().toString();
			tipoMeritosValueString[TitulacionExpedienteEnum.NUMERO_SOBRESALIENTES.ordinal()]=titulacionExpediente.getNumSobresalientes().toString();
			this.mapItemValues.put(titulacionExpediente.getId(), tipoMeritosValueString);
			this.tipoMeritosItem.put(titulacionExpediente.getId(), titulacionExpediente);
			//cargar nombre de atributos
		}
	}
	
	private void gestionarMaster(Item item) {
		Optional<Master> masterOpt=null;
		Optional<MasterTribunal> masterTribunalOpt=null;
		masterOpt = masterService.findById(item.getId());
		masterTribunalOpt = masterTribunalService.findByMaster(masterOpt.get());
		String[] tipoMeritosValueString = new String[MasterEnum.N_ATRIBUTOS_EDITABLES];
		this.tipodeDato = new TipoDatoEnum[MasterEnum.N_ATRIBUTOS_EDITABLES];
		this.tipodeDato[MasterEnum.FECHA_FINALIZACION.ordinal()]=TipoDatoEnum.DATE;
		String[] originalItem = new String[MasterEnum.N_ATRIBUTOS_EDITABLES];
			
		
		if(masterTribunalOpt.isPresent())
		{
			//guardamos el item de la aportation original
			Master m = masterOpt.get();
			originalItem[MasterEnum.CENTRO_EXPEDICION.ordinal()]=m.getCentroExpedicion();
			originalItem[MasterEnum.FECHA_FINALIZACION.ordinal()]=this.DateToString(m.getFechaFinalizacion());
			originalItem[MasterEnum.DESCRIPCION.ordinal()]=m.getDescripcion();	
			this.mapTipoMeritosItemOriginal.put(m.getId(), originalItem);
			
			//RELLENAMOS EL MAPA QUE CONTENDRA LOS ITEM EDITABLES
			MasterTribunal mt=masterTribunalOpt.get();
			
			this.tipoMeritosItem.put(mt.getMaster().getId(), mt);
			
			tipoMeritosValueString[MasterEnum.CENTRO_EXPEDICION.ordinal()]=mt.getCentroExpedicion();
			 
			tipoMeritosValueString[MasterEnum.FECHA_FINALIZACION.ordinal()]=this.DateToString(mt.getFechaFinalizacion());
			tipoMeritosValueString[MasterEnum.DESCRIPCION.ordinal()]=mt.getDescripcion();
			mapItemValues.put(mt.getMaster().getId(), tipoMeritosValueString);
		} else if(masterOpt.isPresent()) {
			
			//guardamos el item de la aportation original
			Master m = masterOpt.get();
			originalItem[MasterEnum.CENTRO_EXPEDICION.ordinal()]=m.getCentroExpedicion();
			originalItem[MasterEnum.FECHA_FINALIZACION.ordinal()]=this.DateToString(m.getFechaFinalizacion());
			originalItem[MasterEnum.DESCRIPCION.ordinal()]=m.getDescripcion();	
			this.mapTipoMeritosItemOriginal.put(m.getId(), originalItem);
	
			
			
			//RELLENAMOS EL MAPA QUE CONTENDRA LOS ITEM EDITABLES	
			tipoMeritosValueString[MasterEnum.CENTRO_EXPEDICION.ordinal()]=m.getCentroExpedicion();
			tipoMeritosValueString[MasterEnum.FECHA_FINALIZACION.ordinal()]=this.DateToString(m.getFechaFinalizacion());
			tipoMeritosValueString[MasterEnum.DESCRIPCION.ordinal()]=m.getDescripcion();
			this.mapItemValues.put(m.getId(), tipoMeritosValueString);
			this.tipoMeritosItem.put(m.getId(), m);
			//cargar nombre de atributos
		}
	}
	
	private String DateToString(Date date)
	{	if(date==null) return "";
		 SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		 return format.format(date);
	}
	
	private String IntegerToString(Integer value)
	{
		if(value==null) return "";
		else return value.toString();
	}
	
	public TipoDatoEnum[] getTipodeDato() {
		return tipodeDato;
	}


	public void setTipodeDato(TipoDatoEnum[] tipodeDato) {
		this.tipodeDato = tipodeDato;
	}


	public TitulacionExpedienteService getTitulacionExpedienteService() {
		return titulacionExpedienteService;
	}


	public void setTitulacionExpedienteService(TitulacionExpedienteService titulacionExpedienteService) {
		this.titulacionExpedienteService = titulacionExpedienteService;
	}


	public List<String> getNameValues() {
		return nameValues;
	}


	public void setNameValues(List<String> nameValues) {
		this.nameValues = nameValues;
	}

	public TitulacionExpedienteTribunalService getTitulacionExpedienteTribunalService() {
		return titulacionExpedienteTribunalService;
	}


	public void setTitulacionExpedienteTribunalService(
			TitulacionExpedienteTribunalService titulacionExpedienteTribunalService) {
		this.titulacionExpedienteTribunalService = titulacionExpedienteTribunalService;
	}


	public Map<Long, String[]> getMapItemValues() {
		return mapItemValues;
	}

	public String[] getStringItemValuesCopy(Long id) {
		return  mapItemValues.get(id).clone();
	}


	public void setMapItemValues(Map<Long, String[]> mapItemValues) {
		this.mapItemValues = mapItemValues;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String[] getTipoMeritosValueString(Long id) {
		return this.mapItemValues.get(id);
	}

	public MasterService getMasterService() {
		return masterService;
	}

	public void setMasterService(MasterService masterService) {
		this.masterService = masterService;
	}

	public PaginationResult<AportacionMeritosItem> getPaginationResult() {
		return paginationResult;
	}

	public void setPaginationResult(PaginationResult<AportacionMeritosItem> paginationResult) {
		this.paginationResult = paginationResult;
	}

	public MasterTribunalService getMasterTribunalService() {
		return masterTribunalService;
	}

	public void setMasterTribunalService(MasterTribunalService masterTribunalService) {
		this.masterTribunalService = masterTribunalService;
	}


	public AportacionMeritosItemService getAportacionMeritosItemService() {
		return aportacionMeritosItemService;
	}

	public void setAportacionMeritosItemService(AportacionMeritosItemService aportacionMeritosItemService) {
		this.aportacionMeritosItemService = aportacionMeritosItemService;
	}


	public Map<Long, Object> getTipoMeritosItem() {
		return tipoMeritosItem;
	}


	public void setTipoMeritosItem(Map<Long, Object> tipoMeritosItem) {
		this.tipoMeritosItem = tipoMeritosItem;
	}


	public Map<Long, String[]> getMapTipoMeritosItemOriginal() {
		return mapTipoMeritosItemOriginal;
	}


	public void setMapTipoMeritosItemOriginal(Map<Long, String[]> mapTipoMeritosItemOriginal) {
		this.mapTipoMeritosItemOriginal = mapTipoMeritosItemOriginal;
	}


	@Override
	public AportacionMeritosItem getRowData(String rowKey) {
		List<AportacionMeritosItem> items = paginationResult.getResult();

		for (AportacionMeritosItem s : items) {
			if (String.valueOf(s.getId()).equals(rowKey)) {
				return s;
			}
		}

		return null;
	}

	@Override
	public Object getRowKey(AportacionMeritosItem solicitud1610) {
		return solicitud1610.getId();
	}




	public FormacionContinuadaService getFormacionContinuadaService() {
		return formacionContinuadaService;
	}




	public void setFormacionContinuadaService(FormacionContinuadaService formacionContinuadaService) {
		this.formacionContinuadaService = formacionContinuadaService;
	}




	public FormacionContinuadaTribunalService getFormacionContinuadaTribunalService() {
		return formacionContinuadaTribunalService;
	}




	public void setFormacionContinuadaTribunalService(
			FormacionContinuadaTribunalService formacionContinuadaTribunalService) {
		this.formacionContinuadaTribunalService = formacionContinuadaTribunalService;
	}




	public InvestigacionService getInvestigacionService() {
		return investigacionService;
	}




	public void setInvestigacionService(InvestigacionService investigacionService) {
		this.investigacionService = investigacionService;
	}




	public InvestigacionTribunalService getInvestigacionTribunalService() {
		return investigacionTribunalService;
	}




	public void setInvestigacionTribunalService(InvestigacionTribunalService investigacionTribunalService) {
		this.investigacionTribunalService = investigacionTribunalService;
	}




	public InternoResidenteService getInternoResidenteService() {
		return internoResidenteService;
	}




	public void setInternoResidenteService(InternoResidenteService internoResidenteService) {
		this.internoResidenteService = internoResidenteService;
	}




	public InternoResidenteTribunalService getInternoResidenteTribunalService() {
		return internoResidenteTribunalService;
	}




	public void setInternoResidenteTribunalService(InternoResidenteTribunalService internoResidenteTribunalService) {
		this.internoResidenteTribunalService = internoResidenteTribunalService;
	}




	public TitulacionPremioService getTitulacionPremioService() {
		return titulacionPremioService;
	}




	public void setTitulacionPremioService(TitulacionPremioService titulacionPremioService) {
		this.titulacionPremioService = titulacionPremioService;
	}




	public TitulacionPremioTribunalService getTitulacionPremioTribunalService() {
		return titulacionPremioTribunalService;
	}




	public void setTitulacionPremioTribunalService(TitulacionPremioTribunalService titulacionPremioTribunalService) {
		this.titulacionPremioTribunalService = titulacionPremioTribunalService;
	}




	public FormacionEspecializadaService getFormacionEspecializadaService() {
		return formacionEspecializadaService;
	}




	public void setFormacionEspecializadaService(FormacionEspecializadaService formacionEspecializadaService) {
		this.formacionEspecializadaService = formacionEspecializadaService;
	}




	public FormacionEspecializadaTribunalService getFormacionEspecializadaTribunalService() {
		return formacionEspecializadaTribunalService;
	}




	public void setFormacionEspecializadaTribunalService(
			FormacionEspecializadaTribunalService formacionEspecializadaTribunalService) {
		this.formacionEspecializadaTribunalService = formacionEspecializadaTribunalService;
	}




	public RelacionFijezaService getRelacionFijezaService() {
		return relacionFijezaService;
	}




	public void setRelacionFijezaService(RelacionFijezaService relacionFijezaService) {
		this.relacionFijezaService = relacionFijezaService;
	}




	public RelacionFijezaTribunalService getRelacionFijezaTribunalService() {
		return relacionFijezaTribunalService;
	}




	public void setRelacionFijezaTribunalService(RelacionFijezaTribunalService relacionFijezaTribunalService) {
		this.relacionFijezaTribunalService = relacionFijezaTribunalService;
	}




	public TitulacionService getTitulacionService() {
		return titulacionService;
	}




	public void setTitulacionService(TitulacionService titulacionService) {
		this.titulacionService = titulacionService;
	}




	public TitulacionTribunalService getTitulacionTribunalService() {
		return titulacionTribunalService;
	}




	public void setTitulacionTribunalService(TitulacionTribunalService titulacionTribunalService) {
		this.titulacionTribunalService = titulacionTribunalService;
	}




	public ExproNoOficioService getExproNoOficioService() {
		return exproNoOficioService;
	}




	public void setExproNoOficioService(ExproNoOficioService exproNoOficioService) {
		this.exproNoOficioService = exproNoOficioService;
	}




	public ExproNoOficioTribunalService getExproOficioTribunalService() {
		return exproNoOficioTribunalService;
	}




	public void setExproOficioTribunalService(ExproNoOficioTribunalService exproOficioTribunalService) {
		this.exproNoOficioTribunalService = exproOficioTribunalService;
	}




	public TitulacionDoctoradoService getTitulacionDoctoradoService() {
		return titulacionDoctoradoService;
	}




	public void setTitulacionDoctoradoService(TitulacionDoctoradoService titulacionDoctoradoService) {
		this.titulacionDoctoradoService = titulacionDoctoradoService;
	}




	public TitulacionDoctoradoTribunalService getTitulacionDoctoradoTribunalService() {
		return titulacionDoctoradoTribunalService;
	}




	public void setTitulacionDoctoradoTribunalService(
			TitulacionDoctoradoTribunalService titulacionDoctoradoTribunalService) {
		this.titulacionDoctoradoTribunalService = titulacionDoctoradoTribunalService;
	}
	
	
	


}
