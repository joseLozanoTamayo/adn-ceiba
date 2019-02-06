package org.adn.ceiba.ceibarest.controller.impl;

import java.util.List;

import org.adn.ceiba.ceibarest.controller.IEmpleadoController;
import org.adn.ceiba.ceibarest.dto.EmpleadoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@RestController
@RequestMapping(value="/empleado")
@CrossOrigin("*")
public class EmpleadoController implements IEmpleadoController {

	@Override
	@RequestMapping(value="/obternerListaEmpleado", method = RequestMethod.GET)
	public ResponseEntity<List<EmpleadoDTO>> obtenerEmpleados() {
		return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
	}

}
