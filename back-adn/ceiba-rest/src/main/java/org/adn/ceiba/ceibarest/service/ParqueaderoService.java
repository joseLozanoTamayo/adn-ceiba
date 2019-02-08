package org.adn.ceiba.ceibarest.service;

import java.util.Collection;
import java.util.Optional;

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

	/**
	 * 
	 */
	public Collection<Parqueadero> obtenerListaParqueadero(){
		return (Collection<Parqueadero>) parqueaderoRepository.findAll();
	}

	/**
	 * 
	 */
	public Optional<Parqueadero> obtenerParqueadero(Integer id) {
		return parqueaderoRepository.findById(id);
	}
	
	/**
	 * 
	 */
	public int obtenerCupoParqueadero(String estado, Integer idTipoVehiculo) {
		return parqueaderoRepository.obtenerCupoParqueadero(estado, idTipoVehiculo);
	}
	
	/**
	 * metodo que registra parqueadero
	 */
	public Parqueadero registrarPago(Parqueadero entity) {
		return parqueaderoRepository.save(entity);
	}
	
}
