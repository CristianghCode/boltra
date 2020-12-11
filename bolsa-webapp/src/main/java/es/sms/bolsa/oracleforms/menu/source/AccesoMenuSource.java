package es.sms.bolsa.oracleforms.menu.source;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import es.sms.bolsa.common.UsuarioLogadoHolder;
import es.sms.bolsa.oracleforms.menu.MenuSource;
import es.sms.bolsa.oracleforms.menu.OpcionMenu;

@Component
class AccesoMenuSource implements MenuSource {

	@Autowired
	private UsuarioLogadoHolder usuarioLogadoHolder;
	@Autowired
	private OpcionMenuRepository opcionMenuRepository;
	@Value("${es.sms.codigo}")
	private String codigoApp;

	@Override
	public List<OpcionMenu> recuperar() {
		return opcionMenuRepository.find(codigoApp, usuarioLogadoHolder.getRoles());
	}

}
