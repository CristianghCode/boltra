package es.sms.bolsa.view.jsf.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;

@Controller
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SesionBean extends MasterBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(SesionBean.class);
	
	private List<Long> listaIdsAportaciones;
	
	private boolean isUltimo;
	
	private boolean isPrimero;
	
	private String numRegistros;
	

	@PostConstruct
	public void init() {
		listaIdsAportaciones = new ArrayList<Long>();

	}

	public List<Long> getListaIdsAportaciones() {
		return listaIdsAportaciones;
	}


	public void setListaIdsAportaciones(List<Long> listaIdsAportaciones) {
		this.listaIdsAportaciones = listaIdsAportaciones;
	}
	
	public boolean isUltimo() {
		return isUltimo;
	}


	public void setUltimo(boolean isUltimo) {
		this.isUltimo = isUltimo;
	}


	public boolean isPrimero() {
		return isPrimero;
	}


	public void setPrimero(boolean isPrimero) {
		this.isPrimero = isPrimero;
	}
	
	public String getNumRegistroActual(Long codAportacionMeritos) {
		int size = listaIdsAportaciones.size();
		int posActual = listaIdsAportaciones.indexOf(codAportacionMeritos)+1;
		return posActual+"/"+size;
	}


	public Long siguiente(Long codAportacionMeritos) {
		int posicionActual = listaIdsAportaciones.indexOf(codAportacionMeritos);
		int posicionSiguiente = posicionActual +1;
		if(posicionSiguiente == listaIdsAportaciones.size()-1) isUltimo = true;
		else isUltimo = false;
		if(posicionSiguiente == 0) isPrimero = true;
		else isPrimero = false;
		Long codAportacionMeritosSiguiente = listaIdsAportaciones.get(posicionSiguiente);
		return codAportacionMeritosSiguiente;
	}
	
	public Long anterior(Long codAportacionMeritos) {
		int posicionActual = listaIdsAportaciones.indexOf(codAportacionMeritos);
		int posicionSiguiente = posicionActual - 1;
		if(posicionSiguiente == 0) isPrimero = true;
		else isPrimero = false;
		if(posicionSiguiente == listaIdsAportaciones.size()-1) isUltimo = true;
		else isUltimo = false;
		Long codAportacionMeritosAnterior = listaIdsAportaciones.get(posicionSiguiente);
		return codAportacionMeritosAnterior;
	
	}
	
	public void actualizaNavegacion(Long codAportacionMeritos) {
		int posicionActual = listaIdsAportaciones.indexOf(codAportacionMeritos);
		if(posicionActual == 0) isPrimero = true;
		else isPrimero= false;
		if(posicionActual == this.listaIdsAportaciones.size()-1) isUltimo = true;
		else isUltimo= false;
	}
	
	
	public void ir(String ruta) {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(ruta);
		} catch (IOException e1) {
			logger.error(e1.getMessage(), e1);
			super.addError(e1.getMessage());
		}
		FacesContext.getCurrentInstance().responseComplete();
	}
	
	
	


}
