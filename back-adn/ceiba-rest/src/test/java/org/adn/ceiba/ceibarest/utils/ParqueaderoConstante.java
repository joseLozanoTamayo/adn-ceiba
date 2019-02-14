package org.adn.ceiba.ceibarest.utils;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.adn.ceiba.ceibarest.dto.ParqueaderoDTO;
import org.adn.ceiba.ceibarest.entity.Parqueadero;

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

	public static final Long PAGO_CANCELADO = 0L;
	
	public static final Long PAGO_CANCELAR_HORA_MOTO = 500L;
	
	public static final Long PAGO_CANCELAR_HORA_CARRO = 1000L;
	
	public static final Long PAGO_CANCELAR_DIA_MOTO = 4000L;
	
	public static final Long PAGO_CANCELAR_DIA_CARRO = 8000L;
	
	public static final Long PAGO_CILINDRAJE_HORA_MOTO = 2500L;
	
	public static final Collection<Parqueadero> PARQUEADERO_NULL = null;
	
	public static final String URL_CONTROLLER = "http://localhost:8082/";
	
	public static final String REST_GET_URL = "tipovehiculo/ping";
	
	public static final Optional<Parqueadero> PARQUEADERO_MOTO = Optional.of(Parqueadero.builder()
			.id(ID)
			.cilindraje(CILINDRAJE)
			.nombresPropietario(NOMBRES_PROPIETARIO)
			.placaVehiculo(PLACA_VEHICULO)
			.estado(ESTADO_ASIGNADO)
			.horaIngreso(HORA_INGRESO)
			.horaSalida(HORA_SALIDA)
			.empleado(EmpleadoConstante.EMPLEADO.get())
			.tipoVehiculo(TipoVehiculoConstante.TIPO_VEHICULO_MOTO)
			.pagoCancelado(PAGO_CANCELADO)
			.build());
	
	public static final Optional<Parqueadero> PARQUEADERO_CARRO = Optional.of(Parqueadero.builder()
			.id(ID)
			.cilindraje(CILINDRAJE)
			.nombresPropietario(NOMBRES_PROPIETARIO)
			.placaVehiculo(PLACA_VEHICULO)
			.estado(ESTADO_ASIGNADO)
			.horaIngreso(HORA_INGRESO)
			.horaSalida(HORA_SALIDA)
			.empleado(EmpleadoConstante.EMPLEADO.get())
			.tipoVehiculo(TipoVehiculoConstante.TIPO_VEHICULO_CARRO)
			.pagoCancelado(PAGO_CANCELADO)
			.build());
	
	public static final Optional<ParqueaderoDTO> PARQUEADERO_DTO_MOTO = Optional.of(ParqueaderoDTO.builder()
			.id(ID)
			.cilindraje(CILINDRAJE)
			.nombresPropietario(NOMBRES_PROPIETARIO)
			.placaVehiculo(PLACA_VEHICULO)
			.estado(ESTADO_ASIGNADO)
			.horaIngreso(HORA_INGRESO)
			.horaSalida(HORA_SALIDA)
			.pagoCancelado(PAGO_CANCELADO)
			.pagoCancelado(PAGO_CANCELADO)
			.tipoVehiculo(TipoVehiculoConstante.TIPO_VEHICULO_DTO_MOTO)
			.empleado(EmpleadoConstante.EMPLEADO_DTO.get())
			.build());
	
	public static final Optional<ParqueaderoDTO> PARQUEADERO_DTO_CARRO = Optional.of(ParqueaderoDTO.builder()
			.id(ID)
			.cilindraje(CILINDRAJE)
			.nombresPropietario(NOMBRES_PROPIETARIO)
			.placaVehiculo(PLACA_VEHICULO)
			.estado(ESTADO_ASIGNADO)
			.horaIngreso(HORA_INGRESO)
			.horaSalida(HORA_SALIDA)
			.pagoCancelado(PAGO_CANCELADO)
			.pagoCancelado(PAGO_CANCELADO)
			.tipoVehiculo(TipoVehiculoConstante.TIPO_VEHICULO_DTO_CARRO)
			.empleado(EmpleadoConstante.EMPLEADO_DTO.get())
			.build());
	
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
				.empleado(EmpleadoConstante.EMPLEADO.get())
				.tipoVehiculo(TipoVehiculoConstante.TIPO_VEHICULO_MOTO)
				.pagoCancelado(PAGO_CANCELADO)
				.build();
		
		listaParqueadero.add(parqueadero);
		
		return listaParqueadero;
	}
	
	private ParqueaderoConstante() {}

}
