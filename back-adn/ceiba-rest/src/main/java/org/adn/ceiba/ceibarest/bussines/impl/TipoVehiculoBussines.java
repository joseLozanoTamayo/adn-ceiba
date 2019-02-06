package org.adn.ceiba.ceibarest.bussines.impl;

import java.util.Collection;
import java.util.List;

import org.adn.ceiba.ceibarest.adapter.TipoVehiculoAdapter;
import org.adn.ceiba.ceibarest.bussines.ITipoVehiculoBussines;
import org.adn.ceiba.ceibarest.dto.TipoVehiculoDTO;
import org.adn.ceiba.ceibarest.entity.TipoVehiculo;
import org.adn.ceiba.ceibarest.service.TipoVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * clase manejadora del negocio de tipovehiculo
 * @author jose.lozano
 *
 */
@Repository
public class TipoVehiculoBussines implements ITipoVehiculoBussines {

	@Autowired
	private TipoVehiculoService tipoVehiculoService;

	@Override
	public Collection<TipoVehiculoDTO> obtenerTipoVehiculos() {
		List<TipoVehiculo> listaEntities = tipoVehiculoService.obtenerTipoVehiculos();
		List<TipoVehiculoDTO> listaVehiculos = TipoVehiculoAdapter
				.getInstance().getListaVehiculoDTO(listaEntities).get();
		return listaVehiculos;
	}
}
