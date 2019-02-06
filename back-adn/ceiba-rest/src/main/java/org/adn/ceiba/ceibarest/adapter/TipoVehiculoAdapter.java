package org.adn.ceiba.ceibarest.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.adn.ceiba.ceibarest.dto.TipoVehiculoDTO;
import org.adn.ceiba.ceibarest.entity.TipoVehiculo;

/**
 * 
 * @author jose.lozano
 *
 */
public final class TipoVehiculoAdapter {
	
	/**
	 * Constructor privado de la clase
	 */
	private TipoVehiculoAdapter () {}
	
	/**
	 * metodo que obtiene la instancia de la clase
	 */
	public static TipoVehiculoAdapter getInstance() {
		return new TipoVehiculoAdapter();
	}
	
	/**
	 * transforma de objeto a entidad
	 */
	public Optional<TipoVehiculo> obtenerEntidad(final TipoVehiculoDTO tipoVehiculoDTO) {
		
		TipoVehiculo tipoVehiculo = TipoVehiculo.builder()
				.tipo(tipoVehiculoDTO.getTipo())
				.build();
		
		return Optional.of(tipoVehiculo);
	}
	
	/**
	 * transforma de entidad a objeto
	 */
	public Optional<TipoVehiculoDTO> obtenerDTO(final TipoVehiculo tipoVehiculo){
		TipoVehiculoDTO tipoVehiculoDTO = TipoVehiculoDTO.builder()
				.id(tipoVehiculo.getId())
				.tipo(tipoVehiculo.getTipo())
				.build();
		
		return Optional.of(tipoVehiculoDTO);
	}
	
	/**
	 * retorna Lista vehiculos
	 */
	public Optional<List<TipoVehiculoDTO>> getListaVehiculoDTO(List<TipoVehiculo> listaEntities) {
		
		if ( Objects.isNull(listaEntities)) 
			return Optional.of(new ArrayList<TipoVehiculoDTO>());
		
		List<TipoVehiculoDTO> lista = new ArrayList<TipoVehiculoDTO>();
		listaEntities.forEach(entity -> {
			lista.add(TipoVehiculoDTO.builder()
					.id(entity.getId())
					.tipo(entity.getTipo())
					.build());
		});

		return Optional.of( lista );
	}

}
