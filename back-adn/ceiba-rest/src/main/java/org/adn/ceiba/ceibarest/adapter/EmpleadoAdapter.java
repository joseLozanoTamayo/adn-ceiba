package org.adn.ceiba.ceibarest.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.adn.ceiba.ceibarest.dto.EmpleadoDTO;
import org.adn.ceiba.ceibarest.entity.Empleado;

/**
 * 
 * @author jose.lozano
 *
 */
public final class EmpleadoAdapter {

	/**
	 * Constructor privado de la clase
	 */
	private EmpleadoAdapter () {}

	/**
	 * metodo que obtiene la instancia de la clase
	 */
	public static EmpleadoAdapter getInstance() {
		return new EmpleadoAdapter();
	}

	/**
	 * transforma de objeto a entidad
	 */
	public Optional<Empleado> obtenerEntidad(final EmpleadoDTO empleadoDTO) {
		
		if (Objects.isNull(empleadoDTO)) {
			return Optional.of(Empleado.builder().build());
		}

		Empleado empleado = Empleado.builder()
				.id(empleadoDTO.getId())
				.nombres(empleadoDTO.getNombres())
				.apellidos(empleadoDTO.getApellidos())
				.cargo(empleadoDTO.getCargo())
				.build();

		return Optional.of(empleado);
	}

	/**
	 * transforma de entidad a objeto
	 */
	public Optional<EmpleadoDTO> obtenerDTO(final Empleado empleado){
		EmpleadoDTO empleadoDTO = EmpleadoDTO.builder()
				.id(empleado.getId())
				.nombres(empleado.getNombres())
				.apellidos(empleado.getApellidos())
				.cargo(empleado.getCargo())
				.build();
		return Optional.of(empleadoDTO);
	}

	/**
	 * retorna Lista vehiculos
	 */
	public Optional<List<EmpleadoDTO>> getListaVehiculoDTO(List<Empleado> listaEntities) {

		if ( Objects.isNull(listaEntities)) 
			return Optional.of(new ArrayList<EmpleadoDTO>());

		List<EmpleadoDTO> lista = new ArrayList<>();
		listaEntities.forEach(entity -> {
			lista.add(EmpleadoDTO.builder()
					.id(entity.getId())
					.build());
		});

		return Optional.of( lista );
	}

}
