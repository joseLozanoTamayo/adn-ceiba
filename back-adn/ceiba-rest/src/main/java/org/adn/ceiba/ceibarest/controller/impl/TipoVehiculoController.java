package org.adn.ceiba.ceibarest.controller.impl;

import java.util.Collection;

import org.adn.ceiba.ceibarest.bussines.impl.TipoVehiculoBussines;
import org.adn.ceiba.ceibarest.dto.TipoVehiculoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 
 * @author jose.lozano
 *
 */
@RestControllerAdvice
@RestController
@RequestMapping(value="/tipovehiculo")
@CrossOrigin("*")
public class TipoVehiculoController {

	@Autowired
	private TipoVehiculoBussines tipoVehiculoBussines;
    
	@RequestMapping(value="/obtenerlista", method = RequestMethod.GET)
	public ResponseEntity<Collection<TipoVehiculoDTO>> obtenerTipoVehiculos() {
		return new ResponseEntity<>( tipoVehiculoBussines.obtenerTipoVehiculos() , HttpStatus.ACCEPTED);
	}

}
