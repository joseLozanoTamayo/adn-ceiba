package org.adn.ceiba.ceibarest.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.adn.ceiba.ceibarest.dto.ParqueaderoDTO;
import org.adn.ceiba.ceibarest.entity.Parqueadero;

/**
 * 
 * @author jose.lozano
 *
 */
public final class ParqueaderoAdapter {
	
	/**
	 * Constructor privado de la clase
	 */
	private ParqueaderoAdapter () {}
	
	/**
	 * metodo que obtiene la instancia de la clase
	 */
	public static ParqueaderoAdapter getInstance() {
		return new ParqueaderoAdapter();
	}
	
	/**
	 * transforma de objeto a entidad
	 */
	public Optional<Parqueadero> obtenerEntidad(final ParqueaderoDTO parqueaderoDTO) {
		
		Parqueadero parqueadero = Parqueadero.builder()
				.build();
		
		return Optional.of(parqueadero);
	}
	
	/**
	 * transforma de entidad a objeto
	 */
	public Optional<ParqueaderoDTO> obtenerDTO(final Parqueadero parqueadero){
		ParqueaderoDTO parqueaderoDTO = ParqueaderoDTO.builder()
				.id(parqueadero.getId())
				.build();	
		
		return Optional.of(parqueaderoDTO);
	}
	
	/**
	 * retorna Lista vehiculos
	 */
	public Optional<List<ParqueaderoDTO>> getListaParqueaderoDTO(List<Parqueadero> listaEntities) {
		
		if ( Objects.isNull(listaEntities)) 
			return Optional.of(new ArrayList<ParqueaderoDTO>());
		
		List<ParqueaderoDTO> lista = new ArrayList<ParqueaderoDTO>();
		listaEntities.forEach(entity -> {
			lista.add(ParqueaderoDTO.builder()
					.id(entity.getId())
					.build());
		});

		return Optional.of( lista );
	}

}
