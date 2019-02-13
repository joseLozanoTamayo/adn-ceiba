package org.adn.ceiba.ceibarest.utils;

import java.util.Optional;

import org.adn.ceiba.ceibarest.entity.Tarifa;

/**
 * 
 * @author jose.lozano
 *
 */
public final class TarifaConstantes {

	public static final Long ID = 1L;

	public static final Long CILINDRO_VEHICULO = 500L;

	public static final String CODIGO = "T1";

	public static final String CODIGO_TIPO_MOTO = "M1";
	
	public static final String CODIGO_TIPO_CARRO = "C1";

	public static final Long DIA = 9L;

	public static final Long HORA = 1L;

	public static final Long PRECIO_CILINDRO_MOTO  = 2000L;
	
	public static final Long PRECIO_CILINDRO_CARRO  = 0L;

	public static final Long VALOR_DIA_MOTO   = 4000L;

	public static final Long VALOR_HORA_MOTO  = 500L;

	public static final Long VALOR_DIA_CARRO  = 8000L;

	public static final Long VALOR_HORA_CARRO = 1000L;
	
	/**
	 * public constructor
	 */
	private TarifaConstantes() {}
	
	public static final Optional<Tarifa> TARIFA_MOTO = Optional.of(Tarifa.builder()
			.id(ID)
			.cilindroVehiculo(CILINDRO_VEHICULO)
			.codigo(CODIGO)
			.codigoTipoVehiculo(CODIGO_TIPO_MOTO)
			.dia(DIA)
			.hora(HORA)
			.precioCilindro(PRECIO_CILINDRO_MOTO)
			.valorDia(VALOR_DIA_MOTO)
			.valorHora(VALOR_HORA_MOTO)
			.build());
	
	public static final Optional<Tarifa> TARIFA_CARRO =Optional.of(
			Tarifa.builder()
			.id(ID)
			.cilindroVehiculo(CILINDRO_VEHICULO)
			.codigo(CODIGO)
			.codigoTipoVehiculo(CODIGO_TIPO_CARRO)
			.dia(DIA)
			.hora(HORA)
			.precioCilindro(PRECIO_CILINDRO_CARRO)
			.valorDia(VALOR_DIA_CARRO)
			.valorHora(VALOR_HORA_CARRO)
			.build());

}
