package es.sms.bolsa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.request.RequestContextListener;

import es.carm.sms.lobo2.service.ViewContext;
import es.carm.sms.lobo2.service.ViewContextImpl;
import es.carm.sms.lobo2.web.jsf.MessagesController;

@Configuration
class BeansConfiguration {

	@Bean
	@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public MessagesController messagesController() {
		return new MessagesController(viewContext());
	}

	@Bean(name = "viewContext")
	@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
	public ViewContext viewContext() {
		return new ViewContextImpl();
	}

	@Bean
	public RequestContextListener requestContextListener() {
		return new RequestContextListener();
	}
}
