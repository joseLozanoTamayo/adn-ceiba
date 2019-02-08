package org.adn.ceiba.ceibarest.controller;

import java.util.Collection;

import org.adn.ceiba.ceibarest.dto.TipoVehiculoDTO;
import org.springframework.http.ResponseEntity;

/**
 * 
 * interface para tipo vehiculo controlador
 * 
 * @author jose.lozano
 *
 */
public interface ITipoVehiculoController {
	
	/**
     * metodo de prueba
     */
	public String ping();
	
	/**
	 * metodo que obtiene registro de tipo vehiculo
	 */
	public ResponseEntity<Collection<TipoVehiculoDTO>> obtenerTipoVehiculos();

}
