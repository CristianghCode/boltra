package es.sms.bolsa.common;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
class UsuarioLogadoHolderImpl implements UsuarioLogadoHolder {
	@Autowired
	private HttpServletRequest request;

	@Override
	public String getLogin() {
		return SecurityContextHolder.getContext()
				.getAuthentication()
				.getName();
	}

	@Override
	public String getRemoteAddr() {
		return request.getRemoteAddr();
	}

	@Override
	public List<String> getRoles() {
		return SecurityContextHolder.getContext()
				.getAuthentication()
				.getAuthorities()
				.stream()
				.map(GrantedAuthority::getAuthority)
				.collect(Collectors.toList());
	}

	@Override
	public boolean isAuthenticated() {
		SecurityContext context = SecurityContextHolder.getContext();
		return !(context.getAuthentication() instanceof AnonymousAuthenticationToken) && context.getAuthentication()
				.isAuthenticated();
	}

}
