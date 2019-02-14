package org.adn.ceiba.ceibarest.adapter;

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
		return Optional.of(Empleado.builder()
				.id(empleadoDTO.getId())
				.nombres(empleadoDTO.getNombres())
				.apellidos(empleadoDTO.getApellidos())
				.cargo(empleadoDTO.getCargo())
				.build());
	}

	/**
	 * transforma de entidad a objeto
	 */
	public Optional<EmpleadoDTO> obtenerDTO(final Empleado empleado){
		return Optional.of(EmpleadoDTO.builder()
				.id(empleado.getId())
				.nombres(empleado.getNombres())
				.apellidos(empleado.getApellidos())
				.cargo(empleado.getCargo())
				.build());
	}

}
