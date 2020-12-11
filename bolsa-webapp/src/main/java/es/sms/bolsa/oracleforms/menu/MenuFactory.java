package es.sms.bolsa.oracleforms.menu;

import java.util.List;

public interface MenuFactory {

	/**
	 * Para poder extender el men� ser� necesario implementar {@link MenuSource}.
	 * 
	 * @return Una lista de primer nivel de OpcionMenu con N hijos.
	 */
	List<OpcionMenu> construir();

}