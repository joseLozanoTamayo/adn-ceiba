package org.adn.ceiba.ceibarest.bussines.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.adn.ceiba.ceibarest.adapter.TipoVehiculoAdapter;
import org.adn.ceiba.ceibarest.bussines.ITipoVehiculoBussines;
import org.adn.ceiba.ceibarest.dto.TipoVehiculoDTO;
import org.adn.ceiba.ceibarest.entity.TipoVehiculo;
import org.adn.ceiba.ceibarest.service.TipoVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * clase manejadora del negocio de tipovehiculo
 * @author jose.lozano
 *
 */
@Service
public class TipoVehiculoBussines implements ITipoVehiculoBussines {

	@Autowired
	private TipoVehiculoService tipoVehiculoService;

	@Override
	public Collection<TipoVehiculoDTO> obtenerTipoVehiculos() {
		Collection<TipoVehiculo> listaEntities = tipoVehiculoService.obtenerTipoVehiculos();
		
		Optional<Collection<TipoVehiculoDTO>> listaOptional = TipoVehiculoAdapter
		.getInstance().getListaVehiculoDTO(listaEntities);
		
		if ( !listaOptional.isPresent())
			return new ArrayList<>();
		
		return listaOptional.get();
	}
}
