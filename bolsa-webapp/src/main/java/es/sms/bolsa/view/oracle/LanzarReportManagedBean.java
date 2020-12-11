package es.sms.bolsa.view.oracle;

import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;

@Controller
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LanzarReportManagedBean {

	public void lanzar(Map<String, String> param) {
		
	}
	
}
