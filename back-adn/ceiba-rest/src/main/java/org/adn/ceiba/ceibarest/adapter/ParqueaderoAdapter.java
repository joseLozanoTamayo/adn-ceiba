package org.adn.ceiba.ceibarest.adapter;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.adn.ceiba.ceibarest.dto.EmpleadoDTO;
import org.adn.ceiba.ceibarest.dto.ParqueaderoDTO;
import org.adn.ceiba.ceibarest.dto.TipoVehiculoDTO;
import org.adn.ceiba.ceibarest.entity.Empleado;
import org.adn.ceiba.ceibarest.entity.Parqueadero;
import org.adn.ceiba.ceibarest.entity.TipoVehiculo;

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
	public Optional<Parqueadero> obtenerEntidad(ParqueaderoDTO parqueaderoDTO) {

		TipoVehiculo tipoVehiculo = TipoVehiculo.builder().build();
		Empleado empleado = Empleado.builder().build();

		Optional<TipoVehiculo> tipoVehiculoOptional = TipoVehiculoAdapter
				.getInstance().obtenerEntidad(parqueaderoDTO.getTipoVehiculo());

		if ( tipoVehiculoOptional.isPresent() ) {
			tipoVehiculo = tipoVehiculoOptional.get();
		}
		Optional<Empleado> empleadoOptional = EmpleadoAdapter.getInstance().obtenerEntidad(parqueaderoDTO.getEmpleado());
		if ( empleadoOptional.isPresent()) {
			empleado = empleadoOptional.get();
		}

		Parqueadero parqueadero = Parqueadero.builder()
				.cilindraje(parqueaderoDTO.getCilindraje())
				.estado(parqueaderoDTO.getEstado())
				.horaIngreso(Objects.isNull(parqueaderoDTO.getHoraIngreso()) ? Timestamp.from(Instant.now())  : parqueaderoDTO.getHoraIngreso())
				.horaSalida(parqueaderoDTO.getHoraSalida())
				.nombresPropietario(parqueaderoDTO.getNombresPropietario())
				.placaVehiculo(parqueaderoDTO.getPlacaVehiculo())
				.empleado(empleado)
				.tipoVehiculo(tipoVehiculo)
				.build();

		return Optional.of(parqueadero);
	}

	/**
	 * transforma de entidad a objeto
	 */
	public Optional<ParqueaderoDTO> obtenerDTO(final Optional<Parqueadero> parqueadero){

		EmpleadoDTO empleadoDTO = EmpleadoDTO.builder().build();
		TipoVehiculoDTO tipoVehiculoDTO = TipoVehiculoDTO.builder().build();

		if ( !parqueadero.isPresent()) {
			return Optional.of(ParqueaderoDTO.builder().build());
		}
		
		Optional<EmpleadoDTO> empleadoDTOOptional = EmpleadoAdapter.getInstance().obtenerDTO(parqueadero.get().getEmpleado());

		if ( empleadoDTOOptional.isPresent()) {
			empleadoDTO = empleadoDTOOptional.get();
		}

		Optional<TipoVehiculoDTO> tipoVehiculoOptional = TipoVehiculoAdapter.getInstance().obtenerDTO(parqueadero.get().getTipoVehiculo());
		if ( tipoVehiculoOptional.isPresent() ) {
			tipoVehiculoDTO = tipoVehiculoOptional.get();
		}


		return Optional.of(ParqueaderoDTO.builder()
				.id(parqueadero.get().getId())
				.cilindraje(parqueadero.get().getCilindraje())
				.estado(parqueadero.get().getEstado())
				.horaIngreso(Objects.isNull(parqueadero.get().getHoraIngreso()) ? Timestamp.from(Instant.now())  : parqueadero.get().getHoraIngreso())
				.horaSalida(parqueadero.get().getHoraSalida())
				.nombresPropietario(parqueadero.get().getNombresPropietario())
				.placaVehiculo(parqueadero.get().getPlacaVehiculo())
				.empleado(empleadoDTO)
				.tipoVehiculo(tipoVehiculoDTO)
				.build());
	}

	/**
	 * retorna Lista vehiculos
	 */
	public Optional<Collection<ParqueaderoDTO>> getListaParqueaderoDTO(Collection<Parqueadero> listaEntities) {

		if ( Objects.isNull(listaEntities)) 
			return Optional.of(new ArrayList<ParqueaderoDTO>());


		List<ParqueaderoDTO> lista = new ArrayList<>();
		listaEntities.forEach(entity -> {
			
			EmpleadoDTO empleadoDTO = EmpleadoDTO.builder().build();
			TipoVehiculoDTO tipoVehiculoDTO = TipoVehiculoDTO.builder().build();
			
			Optional<EmpleadoDTO> empleadoDTOOptional = EmpleadoAdapter.getInstance().obtenerDTO(entity.getEmpleado());
			
			if ( empleadoDTOOptional.isPresent()) {
				empleadoDTO = empleadoDTOOptional.get();
			}

			Optional<TipoVehiculoDTO> tipoVehiculoOptional = TipoVehiculoAdapter.getInstance().obtenerDTO(entity.getTipoVehiculo());
			if ( tipoVehiculoOptional.isPresent() ) {
				tipoVehiculoDTO = tipoVehiculoOptional.get();
			}
			
			lista.add(ParqueaderoDTO.builder()
					.id(entity.getId())
					.cilindraje(entity.getCilindraje())
					.estado(entity.getEstado())
					.horaIngreso(Objects.isNull(entity.getHoraIngreso()) ? Timestamp.from(Instant.now())  : entity.getHoraIngreso())
					.horaSalida(Objects.isNull(entity.getHoraSalida()) ? Timestamp.from(Instant.now())  : entity.getHoraSalida())
					.nombresPropietario(entity.getNombresPropietario())
					.placaVehiculo(entity.getPlacaVehiculo())
					.empleado(empleadoDTO)
					.tipoVehiculo(tipoVehiculoDTO)
					.pagoCancelado( Objects.isNull(entity.getPagoCancelado()) ? 0 : entity.getPagoCancelado() )
					.build());
		});

		return Optional.of( lista );
	}

}
