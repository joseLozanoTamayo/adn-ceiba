package org.adn.ceiba.ceibarest.controller;

import java.util.Collection;

import org.adn.ceiba.ceibarest.dto.ParqueaderoDTO;
import org.springframework.http.ResponseEntity;

/**
 * 
 * @author jose.lozano
 *
 */
public interface IParqueaderoController {
	
	/**
	 * Metodo echo test 
	 */
	public String ping();
	
	/**
	 * Metodo que permite crear la solicitud del parqueadero
	 */
	public ResponseEntity<ParqueaderoDTO> crear(ParqueaderoDTO parqueaderoDTO);
	
	/**
	 * 
	 */
	public ResponseEntity<Collection<ParqueaderoDTO>> obtenerListaPaequeadero();
	
	/**
	 * 
	 */
	public ResponseEntity<ParqueaderoDTO> obtenerParqueadero(ParqueaderoDTO parqueaderoDTO);
	
	/**
	 * 
	 */
	public ResponseEntity<ParqueaderoDTO> registrarPago(ParqueaderoDTO parqueaderoDTO);

}
