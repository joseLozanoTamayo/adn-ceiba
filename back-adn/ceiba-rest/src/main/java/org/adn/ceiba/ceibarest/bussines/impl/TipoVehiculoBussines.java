package org.adn.ceiba.ceibarest.bussines.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.adn.ceiba.ceibarest.adapter.TipoVehiculoAdapter;
import org.adn.ceiba.ceibarest.bussines.ITipoVehiculoBussines;
import org.adn.ceiba.ceibarest.dto.TipoVehiculoDTO;
import org.adn.ceiba.ceibarest.entity.TipoVehiculo;
import org.adn.ceiba.ceibarest.service.TipoVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * clase manejadora del negocio de tipovehiculo
 * @author jose.lozano
 *
 */
@Component
@Transactional
public class TipoVehiculoBussines implements ITipoVehiculoBussines {

	@Autowired
	private TipoVehiculoService tipoVehiculoService;

	@Override
	public TipoVehiculoDTO crear(TipoVehiculoDTO tipoVehiculoDTO) {
		
//		Optional<TipoVehiculo> tipoVehiculo 
//			= TipoVehiculoAdapter.getInstance().obtenerEntidad(tipoVehiculoDTO);
//		
//		//TipoVehiculo responseEntity = tipoVehiculoService.crear(tipoVehiculo.get());
//		
//		if ( Objects.nonNull(responseEntity) 
//				&& Objects.nonNull(responseEntity.getId()))
//			tipoVehiculoDTO.setId(responseEntity.getId());
			
		return null;
	}

	@Override
	public List<TipoVehiculoDTO> obtenerTipoVehiculos() {
		
		List<TipoVehiculo> listaEntities = tipoVehiculoService.obtenerTipoVehiculos();
		List<TipoVehiculoDTO> listaVehiculos = TipoVehiculoAdapter
				.getInstance().getListaVehiculoDTO(listaEntities).get();
		
		return listaVehiculos;
	}
	
	

}
