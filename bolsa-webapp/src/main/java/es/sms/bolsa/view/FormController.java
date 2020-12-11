package es.sms.bolsa.view;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;

@Controller
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class FormController {

	private static final String PARAM_FORM = "form";
	
	@Autowired
	private FormOptionsFactory formOptionsFactory;
	@Value("${es.sms.formDefault}")
	private String formDefault;
	
	private FormOptions formOptions;

	@Autowired
	private HttpServletRequest request;

	public void init() {
		formOptions = formOptionsFactory.crear(request.getParameter(PARAM_FORM));
	}

	public FormOptions getFormOptions() {
		return formOptions;
	}

}