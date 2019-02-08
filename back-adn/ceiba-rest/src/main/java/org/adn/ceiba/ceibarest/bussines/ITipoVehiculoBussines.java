package org.adn.ceiba.ceibarest.bussines;

import java.util.Collection;

import org.adn.ceiba.ceibarest.dto.TipoVehiculoDTO;

/**
 * Interface para tipo vehiculo
 * 
 * @author jose.lozano
 *
 */
public interface ITipoVehiculoBussines {
	
	/**
	 * 
	 */
	public Collection<TipoVehiculoDTO> obtenerTipoVehiculos();
}
