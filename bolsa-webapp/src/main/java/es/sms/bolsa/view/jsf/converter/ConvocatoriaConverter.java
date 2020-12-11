package es.sms.bolsa.view.jsf.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.sms.bolsa.model.entity.Convocatoria;
import es.sms.bolsa.service.ConvocatoriaService;

@Component("convocatoriaConverter")
public class ConvocatoriaConverter implements Converter{

	@Autowired
	private ConvocatoriaService convocatoriaService;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value == null || value.isEmpty()) {
			return null;
		}
		else {
			return convocatoriaService.findOne(Long.valueOf(value)).get();
		}
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value instanceof Convocatoria){
			Convocatoria c = (Convocatoria) value;
			return c.getId().toString();
		}
		return "";
	}

}