package org.adn.ceiba.ceibarest.bussines;

import java.util.Collection;

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
	
	/**
	 * metodo que obtiene lista de parqueadero
	 */
	public Collection<ParqueaderoDTO> obtenerListaParqueadero();

	/**
	 * metodo que obtiene paqueadero por medio de su id
	 */
	public ParqueaderoDTO obtenerParqueadero(ParqueaderoDTO parqueaderoDTO);
	
	/**
	 * metodo que registra pago del paqueadero
	 */
	public ParqueaderoDTO registrarPago(ParqueaderoDTO parqueaderoDTO);
	
}
