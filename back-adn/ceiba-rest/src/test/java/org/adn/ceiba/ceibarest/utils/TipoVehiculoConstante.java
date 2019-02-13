package org.adn.ceiba.ceibarest.utils;

import java.util.ArrayList;
import java.util.Collection;

import org.adn.ceiba.ceibarest.entity.TipoVehiculo;

/**
 * 
 * @author jose.lozano
 *
 */
public final class TipoVehiculoConstante {
	
	public static final Integer ID = 1;
	public static final String VEHICULO = "AUTOMOVIL";
	public static final String CODIGO_MOTO = "M1";
	public static final String CODIGO_CARRO = "C1";
	public static final Integer CUPO = 20;
	public static final String DIAS_PERMITIDOS = "LU-DO";	
	public static final String PLACA_BLOQUEADA = "A";	
	
	public static final Collection<TipoVehiculo> TIPO_VEHICULO_LISTA_NULL = null;
	
	private TipoVehiculoConstante() {}
	
	public static final TipoVehiculo TIPO_VEHICULO_MOTO = TipoVehiculo.builder()
			.id(ID)
			.vehiculo(VEHICULO)
			.codigo(CODIGO_MOTO)
			.build();
	
	public static final TipoVehiculo TIPO_VEHICULO_CARRO = TipoVehiculo.builder()
			.id(ID)
			.vehiculo(VEHICULO)
			.codigo(CODIGO_CARRO)
			.build();
	
	/**
	 * Metodo static final el cual retorna lista de tipos de vehiculo
	 */
	public static final Collection<TipoVehiculo> getTipoVehiculoLista() {
		
		Collection<TipoVehiculo> tipoVehiculoLista = new ArrayList<>();
		
		TipoVehiculo tipoVehiculo =  TipoVehiculo.builder()
				.id(ID)
				.codigo(CODIGO_MOTO)
				.cupo(CUPO)
				.diasPermitidos(DIAS_PERMITIDOS)
				.placaBloqueada(PLACA_BLOQUEADA)
				.vehiculo(VEHICULO)
				.build();
	
		tipoVehiculoLista.add(tipoVehiculo);
		
		return tipoVehiculoLista;
		
	}

}
