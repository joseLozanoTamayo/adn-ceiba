package org.adn.ceiba.ceibarest.bussines.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.adn.ceiba.ceibarest.adapter.TipoVehiculoAdapter;
import org.adn.ceiba.ceibarest.dto.TipoVehiculoDTO;
import org.adn.ceiba.ceibarest.entity.TipoVehiculo;
import org.adn.ceiba.ceibarest.repository.TipoVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * clase manejadora del negocio de tipovehiculo
 * @author jose.lozano
 *
 */
@Service
public class TipoVehiculoBussines {

	@Autowired
	private TipoVehiculoRepository tipoVehiculoRepository;

	public Collection<TipoVehiculoDTO> obtenerTipoVehiculos() {
		Collection<TipoVehiculo> listaEntities = (Collection<TipoVehiculo>) tipoVehiculoRepository.findAll();
		
		Optional<Collection<TipoVehiculoDTO>> listaOptional = TipoVehiculoAdapter
		.getInstance().getListaVehiculoDTO(listaEntities);
		
		return listaOptional.orElse(new ArrayList<>());
	}
}
