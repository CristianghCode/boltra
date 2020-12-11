package es.sms.bolsa.view;

import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;

import es.sms.bolsa.oracleforms.menu.MenuFactory;
import es.sms.bolsa.oracleforms.menu.OpcionMenu;

@Controller
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MenuManagedBean {

	public static final String URL_FORMS = "/secure/forms.xhtml?form=";
	public static final String URL_LIST_APORTACION = "/secure/bolsaTrab/listado-aportacion-meritos.xhtml";

	@Autowired
	private MenuFactory menuFactory;

	private MenuModel modelRaiz;

	@PostConstruct
	public void init() {
		modelRaiz = new DefaultMenuModel();
		crearOpcionesVistaFromModelo();
	}

	private void crearOpcionesVistaFromModelo() {
		List<OpcionMenu> opciones = menuFactory.construir();
		for (OpcionMenu opcion : opciones) {
			DefaultSubMenu firstSubmenu = new DefaultSubMenu(opcion.getDescripcion());
			agregarHijos(firstSubmenu, opcion.getOpciones());
			modelRaiz.addElement(firstSubmenu);
		}
	}

	private void agregarHijos(DefaultSubMenu menuPadre, List<OpcionMenu> opcionesHijas) {
		for (OpcionMenu opcion : opcionesHijas) {
			if (opcion.tieneHijos()) {
				DefaultSubMenu menuConHijos = new DefaultSubMenu(opcion.getDescripcion());
				agregarHijos(menuConHijos, opcion.getOpciones());
				menuPadre.addElement(menuConHijos);
			} else {
				buildMenuHoja(menuPadre, opcion);
			}
		}
	}

	private void buildMenuHoja(DefaultSubMenu menuPadre, OpcionMenu opcion) {
		DefaultMenuItem menuHoja = new DefaultMenuItem(opcion.getDescripcion());
		if (opcion.isOracleForm()) {
			menuHoja.setUrl(URL_FORMS + opcion.getUrl());
		} else {
			menuHoja.setUrl(opcion.getUrl());
		}
		menuPadre.addElement(menuHoja);
	}

	public MenuModel getModelRaiz() {
		return modelRaiz;
	}

}
