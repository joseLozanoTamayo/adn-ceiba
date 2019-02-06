package org.adn.ceiba.ceibarest.controller;

import java.util.List;

import org.adn.ceiba.ceibarest.dto.EmpleadoDTO;
import org.springframework.http.ResponseEntity;

/**
 * 
 * @author jose.lozano
 *
 */
public interface IEmpleadoController {
	
	/**
	 *  Metodo que obtiene empleados
	 */
	public ResponseEntity<List<EmpleadoDTO>> obtenerEmpleados();

}
