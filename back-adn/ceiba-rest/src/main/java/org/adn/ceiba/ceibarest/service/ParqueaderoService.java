package org.adn.ceiba.ceibarest.service;

import java.util.List;

import org.adn.ceiba.ceibarest.entity.Parqueadero;
import org.adn.ceiba.ceibarest.repository.ParqueaderoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * clase service para Parqueadero
 * 
 * @author jose.lozano
 *
 */
@Service
public class ParqueaderoService {
	
	@Autowired
	private ParqueaderoRepository parqueaderoRepository;
	
	/**
	 * metodo que registra parqueadero
	 */
	public Parqueadero crear(Parqueadero entity) {
		return parqueaderoRepository.save(entity);
	}

}
