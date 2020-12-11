package es.sms.bolsa.oracleforms.menu;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Interfaz para definir fuentes de men�. Para agregar opciones de men� est�ticas, din�micas o como 
 * se prefiera ser� necesario implementar esta interfaz en un {@link Component} y {@link MenuFactory} 
 * llamar� para completar el men� antes de devolverlo.
 * 
 * @author fgm27r
 */
public interface MenuSource {

	List<OpcionMenu> recuperar();

}
