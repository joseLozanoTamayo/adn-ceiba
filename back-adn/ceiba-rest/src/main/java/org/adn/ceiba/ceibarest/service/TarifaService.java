package org.adn.ceiba.ceibarest.service;

import java.util.Collection;
import java.util.Optional;

import org.adn.ceiba.ceibarest.entity.Tarifa;
import org.adn.ceiba.ceibarest.repository.TarifaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * clase service para tipo vehiculo
 * 
 * @author jose.lozano
 *
 */
@Service
public class TarifaService {
	
	@Autowired
	private TarifaRepository tarifaRepository;
	
	/**
	 * metodo que consulta tarifa
	 */
	public Collection<Tarifa> obtenerTarifas() {
		return (Collection<Tarifa>) tarifaRepository.findAll();
	}
	
	/**
	 * busqueda de tarifa por medio del codigo del vehiculo
	 */
	public Optional<Tarifa> findByCodigoTipoVehiculo(String codigoTipoVehiculo){
		return tarifaRepository.findByCodigoTipoVehiculo(codigoTipoVehiculo);
	}

}
