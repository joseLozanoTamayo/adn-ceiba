package org.adn.ceiba.ceibarest.bussines;

import org.adn.ceiba.ceibarest.dto.ParqueaderoDTO;

/**
 * Interface para Parqueadero
 * 
 * @author jose.lozano
 *
 */
public interface IParqueaderoBussines {

	/**
	 * metodo que registra tipovehiculo
	 */
	public ParqueaderoDTO crear(ParqueaderoDTO parqueaderoDTO);

}
