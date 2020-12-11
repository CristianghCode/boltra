package es.sms.bolsa.oracleforms.menu;

import static com.google.common.collect.ImmutableList.toImmutableList;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class DynamicMenuFactory implements MenuFactory {

	@Autowired
	private List<MenuSource> menuSources;

	@Override
	public List<OpcionMenu> construir() {
		return menuSources.stream()
				.flatMap(menuSource -> menuSource.recuperar()
						.stream())
				.sorted(Comparator.comparingInt(OpcionMenu::getOrden))
				.collect(toImmutableList());
	}
}
