package org.adn.ceiba.ceibarest.utils;

import org.adn.ceiba.ceibarest.entity.Empleado;
import org.adn.ceiba.ceibarest.entity.TipoVehiculo;

/**
 * 
 * @author jose.lozano
 *
 */
public class ParqueaderoConstante {
	
	public static Integer ID = 1;

	public static Integer CILINDRAJE = 200;

	public static String NOMBRES_PROPIETARIO = "Carlos Rueda";

	public static String PLACA_VEHICULO = "ABC-123";

	public static Empleado EMPLEADO = Empleado.builder()
			.id(EmpleadoConstante.ID)
			.nombres(EmpleadoConstante.NOMBRES)
			.apellidos(EmpleadoConstante.APELLIDOS)
			.cargo(EmpleadoConstante.CARGO)
			.build();

	public static TipoVehiculo TIPO_VEHICULO = TipoVehiculo.builder()
			.id(TipoVehiculoConstante.ID)
			.vehiculo(TipoVehiculoConstante.VEHICULO)
			.build();

}
