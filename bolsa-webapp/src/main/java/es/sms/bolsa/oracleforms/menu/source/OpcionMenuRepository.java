package es.sms.bolsa.oracleforms.menu.source;

import java.util.List;

import es.sms.bolsa.oracleforms.menu.OpcionMenu;

public interface OpcionMenuRepository {

	List<OpcionMenu> find(String codigoApp, List<String> roles);

}
