package org.adn.ceiba.ceibarest.bussines;

import java.util.List;

import org.adn.ceiba.ceibarest.dto.TipoVehiculoDTO;

/**
 * Interface para tipo vehiculo
 * 
 * @author jose.lozano
 *
 */
public interface ITipoVehiculoBussines {
	
	/**
	 * metodo que registra tipovehiculo
	 */
	public TipoVehiculoDTO crear(TipoVehiculoDTO tipoVehiculoDTO);
	
	/**
	 * 
	 */
	public List<TipoVehiculoDTO> obtenerTipoVehiculos();
}
