package org.adn.ceiba.ceibarest.utils;

import java.util.Optional;

import org.adn.ceiba.ceibarest.entity.Empleado;

/**
 * 
 * @author jose.lozano
 *
 */
public final class EmpleadoConstante {
	
	public static final Integer ID = 1;

	public static final String APELLIDOS = "LOZANO";

	public static final String CARGO = "Vigilante";

	public static final String NOMBRES = "Negroski";
	
	private EmpleadoConstante() {}
	
	public static final Optional<Empleado> EMPLEADO = Optional.of( Empleado.builder()
			.id(ID)
			.nombres(NOMBRES)
			.apellidos(APELLIDOS)
			.cargo(CARGO)
			.build());


}
