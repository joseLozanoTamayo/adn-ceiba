package org.adn.ceiba.ceibarest.service;

import java.util.List;

import org.adn.ceiba.ceibarest.entity.Empleado;
import org.adn.ceiba.ceibarest.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * clase service para tipo vehiculo
 * 
 * @author jose.lozano
 *
 */
@Service
public class EmpleadoService {
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	/**
	 * metodo que registra tipo vehiculo
	 */
	public List<Empleado> obtenerEmpleados() {
		return (List<Empleado>) empleadoRepository.findAll();
	}

}
