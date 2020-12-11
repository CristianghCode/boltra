package es.sms.bolsa.view.jsf.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.sms.bolsa.model.entity.BolsaTrab;
import es.sms.bolsa.service.BolsaTrabService;

@Component("bolsaTrabConverter")
public class BolsaTrabConverter implements Converter{

	@Autowired
	private BolsaTrabService bolsaTrabService;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value == null || value.isEmpty()) {
			return null;
		}
		else {
			return bolsaTrabService.findOne(Long.valueOf(value)).get();
		}
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value instanceof BolsaTrab){
			BolsaTrab c = (BolsaTrab) value;
			return c.getCodigo().toString();
		}
		return "";
	}

}