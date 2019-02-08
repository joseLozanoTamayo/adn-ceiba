package org.adn.ceiba.ceibarest.utils;

import org.adn.ceiba.ceibarest.entity.Empleado;
import org.adn.ceiba.ceibarest.entity.TipoVehiculo;

/**
 * 
 * @author jose.lozano
 *
 */
public class ParqueaderoConstante {
	
	public static final Integer ID = 1;

	public static final Integer CILINDRAJE = 200;

	public static final String NOMBRES_PROPIETARIO = "Carlos Rueda";

	public static final String PLACA_VEHICULO = "ABC-123";

	public static final Empleado EMPLEADO = Empleado.builder()
			.id(EmpleadoConstante.ID)
			.nombres(EmpleadoConstante.NOMBRES)
			.apellidos(EmpleadoConstante.APELLIDOS)
			.cargo(EmpleadoConstante.CARGO)
			.build();

	public static final TipoVehiculo TIPO_VEHICULO = TipoVehiculo.builder()
			.id(TipoVehiculoConstante.ID)
			.vehiculo(TipoVehiculoConstante.VEHICULO)
			.build();
	
	private ParqueaderoConstante() {}

}
