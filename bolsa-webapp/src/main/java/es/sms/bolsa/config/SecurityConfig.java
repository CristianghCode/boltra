/*
 * Copyright 2016-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package es.sms.bolsa.config;

import org.jasig.cas.client.proxy.ProxyGrantingTicketStorageImpl;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.validation.Saml11TicketValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.event.LoggerListener;
import org.springframework.security.cas.ServiceProperties;
import org.springframework.security.cas.authentication.CasAuthenticationProvider;
import org.springframework.security.cas.web.CasAuthenticationEntryPoint;
import org.springframework.security.cas.web.CasAuthenticationFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.header.writers.CacheControlHeadersWriter;
import org.springframework.security.web.header.writers.DelegatingRequestMatcherHeaderWriter;
import org.springframework.security.web.header.writers.HstsHeaderWriter;
import org.springframework.security.web.header.writers.XContentTypeOptionsHeaderWriter;
import org.springframework.security.web.header.writers.XXssProtectionHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import es.carm.sms.sesamouserprincipal.profesional.SmpAttributesUserDetailsService;

/**
 * Spring Security Configuration.
 */
@Configuration
@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {

	public static final String SPRING_CAS_SECURITY_URL_CHECK = "/j_spring_cas_security_check";
	@Autowired
	private ServiceProperties serviceProperties;
	@Value("${es.sms.sesamo.url}")
	private String sesamoUrl;
	@Value("${es.sms.cas.tolerance}")
	private String tolerance;
	@Value("${es.sms.codigo}")
	private String codigoApp;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
			http
			.csrf()
				.disable()
			.userDetailsService(userDetailsService())
			.authenticationProvider(casAuthenticationProvider())
			.sessionManagement()
				.sessionFixation()
				.migrateSession()
				.and()
			.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/**.xhtml").permitAll()
				.antMatchers("/**.jsp").permitAll()
				.antMatchers("/javax.faces.resource/**").permitAll()
				.antMatchers("/secure/**").authenticated()
				.antMatchers("/actuator/**").hasRole("ADMIN")
				.and()
			.logout()
				.logoutUrl("/j_spring_security_logout")
				.logoutSuccessUrl("/home.xhtml")
				.and()
			.exceptionHandling()
				.authenticationEntryPoint(authenticationEntryPoint())
				.and()
			.addFilterAfter(casAuthenticationFilter(), CasAuthenticationFilter.class)
			.addFilterAfter(casSingleSignOutFilter(), LogoutFilter.class)
			.addFilterAfter(requestSingleLogoutFilter(), LogoutFilter.class)
			.headers()
				.defaultsDisabled()
				.frameOptions()
					.sameOrigin()
				.addHeaderWriter(cacheControlRequestMatcherHeaderWriter())
				.addHeaderWriter(xContentTypeOptionsRequestMatcherHeaderWriter())
				.addHeaderWriter(hstsRequestMatcherHeaderWriter())
				.addHeaderWriter(xxssProtectionRequestMatcherHeaderWriter());
	}

	@Bean
	public DelegatingRequestMatcherHeaderWriter xContentTypeOptionsRequestMatcherHeaderWriter() {
		return new DelegatingRequestMatcherHeaderWriter(requestMatcher(), new XContentTypeOptionsHeaderWriter());
	}

	@Bean
	public DelegatingRequestMatcherHeaderWriter hstsRequestMatcherHeaderWriter() {
		return new DelegatingRequestMatcherHeaderWriter(requestMatcher(), new HstsHeaderWriter());
	}

	@Bean
	public DelegatingRequestMatcherHeaderWriter xxssProtectionRequestMatcherHeaderWriter() {
		return new DelegatingRequestMatcherHeaderWriter(requestMatcher(), new XXssProtectionHeaderWriter());
	}

	@Bean
	public DelegatingRequestMatcherHeaderWriter cacheControlRequestMatcherHeaderWriter() {
		return new DelegatingRequestMatcherHeaderWriter(requestMatcher(), new CacheControlHeadersWriter());
	}

	@Bean
	public RequestMatcher requestMatcher() {
		return new NegatedRequestMatcher(new AntPathRequestMatcher("/resources/**"));
	}

	@Bean
	public CasAuthenticationProvider casAuthenticationProvider() {
		CasAuthenticationProvider casAuthenticationProvider = new CasAuthenticationProvider();
		casAuthenticationProvider.setAuthenticationUserDetailsService(smpAttributesUserDetailsService());
		casAuthenticationProvider.setServiceProperties(serviceProperties);
		casAuthenticationProvider.setKey("casAuthenticationProvider");
		casAuthenticationProvider.setTicketValidator(ticketValidator());
		return casAuthenticationProvider;
	}

	@Bean
	public Saml11TicketValidator ticketValidator() {
		Saml11TicketValidator saml11TicketValidator = new Saml11TicketValidator(sesamoUrl);
		saml11TicketValidator.setTolerance(Long.valueOf(tolerance));
		return saml11TicketValidator;
	}

	@Bean
	public SecurityContextHolderStrategy securityContextHolderStrategy() {
		return SecurityContextHolder.getContextHolderStrategy();
	}

	@Bean
	public LoggerListener loggerListener() {
		return new LoggerListener();
	}

	@Bean
	public LogoutFilter requestSingleLogoutFilter() {
		LogoutFilter logoutFilter = new LogoutFilter(sesamoUrl + "/logout", logoutHandler());
		logoutFilter.setFilterProcessesUrl("/j_spring_security_logout");
		return logoutFilter;
	}

	@Bean
	public SecurityContextLogoutHandler logoutHandler() {
		return new SecurityContextLogoutHandler();
	}

	@Bean
	public SingleSignOutFilter casSingleSignOutFilter() {
		return new SingleSignOutFilter();
	}

	@Bean
	public CasAuthenticationFilter casAuthenticationFilter() throws Exception {
		CasAuthenticationFilter casAuthenticationFilter = new CasAuthenticationFilter();
		casAuthenticationFilter.setAuthenticationManager(authenticationManager());
		casAuthenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler());
		casAuthenticationFilter.setFilterProcessesUrl(SPRING_CAS_SECURITY_URL_CHECK);
		casAuthenticationFilter.setProxyGrantingTicketStorage(proxyGrantingTicketStorage());
		return casAuthenticationFilter;
	}

	@Bean
	public ProxyGrantingTicketStorageImpl proxyGrantingTicketStorage() {
		return new ProxyGrantingTicketStorageImpl();
	}

	@Bean
	public SavedRequestAwareAuthenticationSuccessHandler authenticationSuccessHandler() {
		SavedRequestAwareAuthenticationSuccessHandler authenticationSuccessHandler = new SavedRequestAwareAuthenticationSuccessHandler();
		authenticationSuccessHandler.setTargetUrlParameter("spring-security-redirect");
		return authenticationSuccessHandler;
	}

	@Bean
	public CasAuthenticationEntryPoint authenticationEntryPoint() {
		CasAuthenticationEntryPoint casAuthenticationEntryPoint = new CasAuthenticationEntryPoint();
		casAuthenticationEntryPoint.setLoginUrl(sesamoUrl + "/login");
		casAuthenticationEntryPoint.setServiceProperties(serviceProperties);
		return casAuthenticationEntryPoint;
	}

	@Bean
	public SmpAttributesUserDetailsService smpAttributesUserDetailsService() {
		return new SmpAttributesUserDetailsService(codigoApp);
	}

}
