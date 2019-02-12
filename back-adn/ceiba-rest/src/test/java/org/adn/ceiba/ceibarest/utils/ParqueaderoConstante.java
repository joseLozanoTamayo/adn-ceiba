package org.adn.ceiba.ceibarest.utils;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

import org.adn.ceiba.ceibarest.entity.Empleado;
import org.adn.ceiba.ceibarest.entity.Parqueadero;
import org.adn.ceiba.ceibarest.entity.TipoVehiculo;

/**
 * 
 * @author jose.lozano
 *
 */
public class ParqueaderoConstante {
	
	public static final Integer ID = 1;

	public static final Long CILINDRAJE = 200L;

	public static final String NOMBRES_PROPIETARIO = "Carlos Rueda";

	public static final String PLACA_VEHICULO = "ABC-123";
	
	public static final String ESTADO_ASIGNADO = "ASIGNADO";

	public static final Timestamp HORA_INGRESO = Timestamp.from(Instant.now()) ;

	public static final Timestamp HORA_SALIDA  = Timestamp.from(Instant.now());

	public static final Long PAGO_CANCELADO = 1000L;
	
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
	
	public static final Collection<Parqueadero> obtenerListaParqueadero() {
		Collection<Parqueadero> listaParqueadero = new ArrayList<>();
		
		Parqueadero parqueadero = Parqueadero.builder()
				.id(ID)
				.cilindraje(CILINDRAJE)
				.nombresPropietario(NOMBRES_PROPIETARIO)
				.placaVehiculo(PLACA_VEHICULO)
				.estado(ESTADO_ASIGNADO)
				.horaIngreso(HORA_INGRESO)
				.horaSalida(HORA_SALIDA)
				.pagoCancelado(PAGO_CANCELADO)
				.empleado(EMPLEADO)
				.tipoVehiculo(TIPO_VEHICULO)
				.build();
		
		listaParqueadero.add(parqueadero);
		
		return listaParqueadero;
	}
	
	private ParqueaderoConstante() {}

}
