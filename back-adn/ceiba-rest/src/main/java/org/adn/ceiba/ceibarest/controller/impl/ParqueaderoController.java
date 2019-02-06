package org.adn.ceiba.ceibarest.controller.impl;

import org.adn.ceiba.ceibarest.bussines.IParqueaderoBussines;
import org.adn.ceiba.ceibarest.controller.IParqueaderoController;
import org.adn.ceiba.ceibarest.dto.ParqueaderoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@RestController
@RequestMapping(value="/parqueadero")
@CrossOrigin("*")
public class ParqueaderoController implements IParqueaderoController {
	
	@Autowired
	private IParqueaderoBussines parqueaderoBussines;

//	@Override
//	@RequestMapping(value="/ping", method = RequestMethod.GET)
//	public String ping() {
//		return "Respuesta Exitosa";
//	}

	@Override
	@RequestMapping(value="/crear", method = RequestMethod.POST)
	public ResponseEntity<ParqueaderoDTO> crear(@RequestBody ParqueaderoDTO parqueaderoDTO) {
		return new ResponseEntity<>( parqueaderoBussines.crear(parqueaderoDTO) , HttpStatus.ACCEPTED);
	}



}
