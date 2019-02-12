package org.adn.ceiba.ceibarest.adapter;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
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
				.cilindraje(parqueaderoDTO.getCilindraje())
				.estado(parqueaderoDTO.getEstado())
				.horaIngreso(Objects.isNull(parqueaderoDTO.getHoraIngreso()) ? Timestamp.from(Instant.now())  : parqueaderoDTO.getHoraIngreso())
				.horaSalida(parqueaderoDTO.getHoraSalida())
				.nombresPropietario(parqueaderoDTO.getNombresPropietario())
				.placaVehiculo(parqueaderoDTO.getPlacaVehiculo())
				.empleado(EmpleadoAdapter.getInstance().obtenerEntidad(parqueaderoDTO.getEmpleado()).get())
				.tipoVehiculo(TipoVehiculoAdapter.getInstance().obtenerEntidad(parqueaderoDTO.getTipoVehiculo()).get())
				.build();
		
		return Optional.of(parqueadero);
	}
	
	/**
	 * transforma de entidad a objeto
	 */
	public Optional<ParqueaderoDTO> obtenerDTO(final Parqueadero parqueadero){
		ParqueaderoDTO parqueaderoDTO = ParqueaderoDTO.builder()
				.id(parqueadero.getId())
				.cilindraje(parqueadero.getCilindraje())
				.estado(parqueadero.getEstado())
				.horaIngreso(Objects.isNull(parqueadero.getHoraIngreso()) ? Timestamp.from(Instant.now())  : parqueadero.getHoraIngreso())
				.horaSalida(parqueadero.getHoraSalida())
				.nombresPropietario(parqueadero.getNombresPropietario())
				.placaVehiculo(parqueadero.getPlacaVehiculo())
				.empleado(EmpleadoAdapter.getInstance().obtenerDTO(parqueadero.getEmpleado()).get())
				.tipoVehiculo(TipoVehiculoAdapter.getInstance().obtenerDTO(parqueadero.getTipoVehiculo()).get())
				.build();	
		
		return Optional.of(parqueaderoDTO);
	}
	
	/**
	 * retorna Lista vehiculos
	 */
	public Optional<Collection<ParqueaderoDTO>> getListaParqueaderoDTO(Collection<Parqueadero> listaEntities) {
		
		if ( Objects.isNull(listaEntities)) 
			return Optional.of(new ArrayList<ParqueaderoDTO>());
		
		List<ParqueaderoDTO> lista = new ArrayList<ParqueaderoDTO>();
		listaEntities.forEach(entity -> {
			lista.add(ParqueaderoDTO.builder()
					.id(entity.getId())
					.cilindraje(entity.getCilindraje())
					.estado(entity.getEstado())
					.horaIngreso(Objects.isNull(entity.getHoraIngreso()) ? Timestamp.from(Instant.now())  : entity.getHoraIngreso())
					.horaSalida(Objects.isNull(entity.getHoraSalida()) ? Timestamp.from(Instant.now())  : entity.getHoraSalida())
					.nombresPropietario(entity.getNombresPropietario())
					.placaVehiculo(entity.getPlacaVehiculo())
					.empleado(EmpleadoAdapter.getInstance().obtenerDTO(entity.getEmpleado()).get())
					.tipoVehiculo(TipoVehiculoAdapter.getInstance().obtenerDTO(entity.getTipoVehiculo()).get())
					.pagoCancelado( Objects.isNull(entity.getPagoCancelado()) ? 0 : entity.getPagoCancelado() )
					.build());
		});

		return Optional.of( lista );
	}

}
