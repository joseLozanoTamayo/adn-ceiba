package org.adn.ceiba.ceibarest.controller.impl;

import org.adn.ceiba.ceibarest.controller.ITipoParqueaderoController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@RestController
@RequestMapping(value="/tipoparqueadero")
@CrossOrigin("*")
public class TipoParqueaderoController implements ITipoParqueaderoController {

//	@Override
//	@RequestMapping(value="/ping", method = RequestMethod.GET)
//	public String ping() {
//		return "Respuesta Exitosa";
//	}
//
//	@Override
//	@RequestMapping(value="/crear", method = RequestMethod.POST)
//	public ResponseEntity<TipoVehiculoDTO> create(@RequestBody TipoVehiculoDTO tipoVehiculo) {
//		
//		return new ResponseEntity<>( null , HttpStatus.BAD_REQUEST);
//	}

}
