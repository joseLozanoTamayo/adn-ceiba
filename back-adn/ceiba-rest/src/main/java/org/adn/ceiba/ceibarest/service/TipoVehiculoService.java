package org.adn.ceiba.ceibarest.service;

import java.util.Collection;

import org.adn.ceiba.ceibarest.entity.TipoVehiculo;
import org.adn.ceiba.ceibarest.repository.TipoVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * clase service para tipo vehiculo
 * 
 * @author jose.lozano
 *
 */
@Service
public class TipoVehiculoService {
	
	@Autowired
	private TipoVehiculoRepository tipoVehiculoRepository;

	/**
	 * metodo que registra tipo vehiculo
	 */
	public Collection<TipoVehiculo> obtenerTipoVehiculos() {
		return (Collection<TipoVehiculo>) tipoVehiculoRepository.findAll();
	}

}
