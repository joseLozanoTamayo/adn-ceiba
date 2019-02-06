package org.adn.ceiba.ceibarest.bussines.impl;

import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.adn.ceiba.ceibarest.adapter.ParqueaderoAdapter;
import org.adn.ceiba.ceibarest.bussines.IParqueaderoBussines;
import org.adn.ceiba.ceibarest.dto.ParqueaderoDTO;
import org.adn.ceiba.ceibarest.entity.Parqueadero;
import org.adn.ceiba.ceibarest.service.ParqueaderoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * clase manejadora del negocio de tipovehiculo
 * @author jose.lozano
 *
 */
@Component
@Transactional
public class ParqueaderoBussines implements IParqueaderoBussines {

	@Autowired
	private ParqueaderoService parqueaderoService;

	@Override
	public ParqueaderoDTO crear(ParqueaderoDTO parqueaderoDTO) {
		Optional<Parqueadero> entidad = ParqueaderoAdapter.getInstance().obtenerEntidad(parqueaderoDTO);
		
		Parqueadero response = null;
		if (entidad.isPresent())
			response  = parqueaderoService.crear(entidad.get());
		
		if (Objects.nonNull(response) && Objects.nonNull(response.getId()))
			parqueaderoDTO.setId(response.getId());
		
		return parqueaderoDTO;
	}

	
	
	

}
