package org.adn.ceiba.ceibarest.controller;

import org.adn.ceiba.ceibarest.dto.ParqueaderoDTO;
import org.springframework.http.ResponseEntity;

/**
 * 
 * @author jose.lozano
 *
 */
public interface IParqueaderoController {
	
	public ResponseEntity<ParqueaderoDTO> crear(ParqueaderoDTO parqueaderoDTO);

}
