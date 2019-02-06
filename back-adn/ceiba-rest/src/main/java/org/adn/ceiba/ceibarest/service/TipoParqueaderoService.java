package org.adn.ceiba.ceibarest.service;

import java.util.List;

import org.adn.ceiba.ceibarest.entity.TipoParqueadero;
import org.adn.ceiba.ceibarest.entity.TipoVehiculo;
import org.adn.ceiba.ceibarest.repository.TipoParqueaderoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * clase service para tipo vehiculo
 * 
 * @author jose.lozano
 *
 */
@Service
public class TipoParqueaderoService {
	
	@Autowired
	private TipoParqueaderoRepository tipoParqueaderoRepository;
	
//	/**
//	 * metodo que registra tipo vehiculo
//	 */
//	public TipoVehiculo crear(final TipoVehiculo entity) {
//		return tipoParqueaderoRepository.save(entity);
//	}
	
	/**
	 * metodo que registra tipo vehiculo
	 */
	public List<TipoParqueadero> obtenerTipoParqueaderos() {
		return (List<TipoParqueadero>) tipoParqueaderoRepository.findAll();
	}

}
