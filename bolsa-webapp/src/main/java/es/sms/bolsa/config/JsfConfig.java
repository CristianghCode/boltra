package es.sms.bolsa.config;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import com.google.common.collect.ImmutableMap;
import com.sun.faces.config.ConfigureListener;

import es.carm.sms.lobo2.web.jsf.scope.ViewScope;

@Configuration
class JsfConfig implements ServletContextInitializer {
	@Value("${es.sms.web.timeout-in-minutes:30}")
	private Integer webTimeout;
	@Value("${es.sms.sesamo.url}")
	private String sesamoUrl;

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
		servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", "true");
		servletContext.setInitParameter("javax.faces.FACELETS_LIBRARIES", "/WEB-INF/springsecurity.taglib.xml");
		servletContext.setInitParameter("javax.faces.DEFAULT_SUFFIX", ".xhtml");
		servletContext.setInitParameter("javax.faces.FACELETS_REFRESH_PERIOD", "1");
		servletContext.setInitParameter("ErrorPathExceptionHandlerJsf", "/error/errorInterno?faces-redirect=true");

		servletContext.setInitParameter("casServerUrlPrefix", sesamoUrl);

		servletContext.addListener(ConfigureListener.class);
		servletContext.addListener(new TimeoutSessionListener(webTimeout));
		servletContext.addListener(SingleSignOutHttpSessionListener.class);
	}

	@Bean
	public ServletRegistrationBean<FacesServlet> facesServletRegistrationBean() {
		ServletRegistrationBean<FacesServlet> registration = new ServletRegistrationBean<>(new FacesServlet(), "*.xhtml");
		registration.setLoadOnStartup(1);
		return registration;
	}

	@Bean
	public static CustomScopeConfigurer viewScope() {
		CustomScopeConfigurer configurer = new CustomScopeConfigurer();
		configurer.setScopes(ImmutableMap.of("view", new ViewScope()));
		return configurer;
	}

	@Bean
	public ErrorPageRegistrar errorPageRegistrar() {
		return new MyErrorPageRegistrar();
	}

	private static class MyErrorPageRegistrar implements ErrorPageRegistrar {
		@Override
		public void registerErrorPages(ErrorPageRegistry registry) {
			registry.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/error/404.xhtml"));
			registry.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN, "/error/403.xhtml"));
			registry.addErrorPages(new ErrorPage(HttpStatus.UNAUTHORIZED, "/error/401.xhtml"));
			registry.addErrorPages(new ErrorPage(Exception.class, "/error/errorInterno.xhtml"));
		}
	}

	public static class TimeoutSessionListener implements HttpSessionListener {
		private static final int SEG_IN_MINUTE = 60;
		private Integer timeout;

		public TimeoutSessionListener(Integer timeout) {
			super();
			this.timeout = timeout;
		}

		@Override
		public void sessionCreated(HttpSessionEvent event) {
			event.getSession()
					.setMaxInactiveInterval(timeout * SEG_IN_MINUTE);
		}

		@Override
		public void sessionDestroyed(HttpSessionEvent event) {
		}
	}
}
