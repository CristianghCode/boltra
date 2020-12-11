package es.sms.bolsa.common;

import java.util.List;

public interface UsuarioLogadoHolder {

	String getLogin();

	String getRemoteAddr();

	List<String> getRoles();

	boolean isAuthenticated();

}
