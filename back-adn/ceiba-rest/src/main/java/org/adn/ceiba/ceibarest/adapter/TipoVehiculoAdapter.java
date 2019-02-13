package org.adn.ceiba.ceibarest.adapter;

import java.util.ArrayList;
import java.util.Collection;
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
				.id(tipoVehiculoDTO.getId())
				.vehiculo(tipoVehiculoDTO.getVehiculo())
				.codigo(tipoVehiculoDTO.getCodigo())
				.cupo(tipoVehiculoDTO.getCupo())
				.placaBloqueada(tipoVehiculoDTO.getPlacaBloqueada())
				.diasPermitidos(tipoVehiculoDTO.getDiasPermitidos())
				.build();
		
		return Optional.of(tipoVehiculo);
	}
	
	/**
	 * transforma de entidad a objeto
	 */
	public Optional<TipoVehiculoDTO> obtenerDTO(final TipoVehiculo tipoVehiculo){
		TipoVehiculoDTO tipoVehiculoDTO = TipoVehiculoDTO.builder()
				.id(tipoVehiculo.getId())
				.vehiculo(tipoVehiculo.getVehiculo())
				.codigo(tipoVehiculo.getCodigo())
				.cupo(tipoVehiculo.getCupo())
				.placaBloqueada(tipoVehiculo.getPlacaBloqueada())
				.diasPermitidos(tipoVehiculo.getDiasPermitidos())
				.build();
		
		return Optional.of(tipoVehiculoDTO);
	}
	
	/**
	 * retorna Lista vehiculos
	 */
	public Optional<Collection<TipoVehiculoDTO>> getListaVehiculoDTO(Collection<TipoVehiculo> listaEntities) {
		
		if ( Objects.isNull(listaEntities)) 
			return Optional.of(new ArrayList<TipoVehiculoDTO>());
		
		List<TipoVehiculoDTO> lista = new ArrayList<>();
		listaEntities.forEach(entity -> 
			lista.add(TipoVehiculoDTO.builder()
					.id(entity.getId())
					.vehiculo(entity.getVehiculo())
					.codigo(entity.getCodigo())
					.cupo(entity.getCupo())
					.placaBloqueada(entity.getPlacaBloqueada())
					.diasPermitidos(entity.getDiasPermitidos())
					.build())
		);

		return Optional.of( lista );
	}

}
