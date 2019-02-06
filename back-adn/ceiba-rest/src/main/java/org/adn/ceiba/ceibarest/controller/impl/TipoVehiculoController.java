package org.adn.ceiba.ceibarest.controller.impl;

import org.adn.ceiba.ceibarest.bussines.ITipoVehiculoBussines;
import org.adn.ceiba.ceibarest.controller.ITipoVehiculoController;
import org.adn.ceiba.ceibarest.dto.TipoVehiculoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
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
public class TipoVehiculoController implements ITipoVehiculoController {

	@Autowired
	private ITipoVehiculoBussines tipoVehiculoBussines;
    
	@Override
	@RequestMapping(value="/ping", method = RequestMethod.GET)
	public String ping() {
		return "Respuesta Exitosa";
	}

	
	@Override
	@RequestMapping(value="/crear", method = RequestMethod.POST)
	public ResponseEntity<TipoVehiculoDTO> create(@RequestBody TipoVehiculoDTO tipoVehiculo) {
		return new ResponseEntity<>( tipoVehiculoBussines.crear(tipoVehiculo) , HttpStatus.ACCEPTED);
	}

}
