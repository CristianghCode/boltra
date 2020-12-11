package es.sms.bolsa.view.jsf.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.sms.bolsa.model.entity.Situacion;
import es.sms.bolsa.service.SituacionService;

@Component("situacionConverter")
public class SituacionConverter implements Converter{

	@Autowired
	private SituacionService situacionService;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value == null || value.isEmpty()) {
			return null;
		}
		else {
			return situacionService.findOne(Long.valueOf(value)).get();
		}
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value instanceof Situacion){
			Situacion s = (Situacion) value;
			return s.getCodigo().toString();
		}
		return "";
	}

}