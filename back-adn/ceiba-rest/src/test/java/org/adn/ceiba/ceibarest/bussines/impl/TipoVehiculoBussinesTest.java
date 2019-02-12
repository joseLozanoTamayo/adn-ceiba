package org.adn.ceiba.ceibarest.bussines.impl;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;

import org.adn.ceiba.ceibarest.dto.TipoVehiculoDTO;
import org.adn.ceiba.ceibarest.entity.TipoVehiculo;
import org.adn.ceiba.ceibarest.service.TipoVehiculoService;
import org.adn.ceiba.ceibarest.utils.TipoVehiculoConstante;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * 
 * @author jose.lozano
 *
 */
@RunWith(MockitoJUnitRunner.class)
public final class TipoVehiculoBussinesTest {

	@InjectMocks
	private TipoVehiculoBussines tipoVehiculoBussines;

	@Mock
	private TipoVehiculoService tipoVehiculoService; 

	private Collection<TipoVehiculo> tipoVehiculoLista = new ArrayList<>();

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		tipoVehiculoLista = TipoVehiculoConstante.getTipoVehiculoLista();
	}

	/**
	 * 
	 */
	@Test
	public void verifyObtenerTipoVehiculosNotNull() {
		when(tipoVehiculoService.obtenerTipoVehiculos()).thenReturn(tipoVehiculoLista);
		Assert.assertNotNull("La lista tipo vehiculo es empty", tipoVehiculoBussines.obtenerTipoVehiculos());
	}

	/**
	 * 
	 */
	@Test
	public void verifyTipoVehiculoVecioEmpty() {
		when(tipoVehiculoService.obtenerTipoVehiculos()).thenReturn(TipoVehiculoConstante.TIPO_VEHICULO_LISTA_NULL);
		Collection<TipoVehiculoDTO> tipoVehiculos = tipoVehiculoBussines.obtenerTipoVehiculos();
		Assert.assertTrue( tipoVehiculos.isEmpty() );
	}

	/**
	 * 
	 */
	@Test
	public void verifyTipoVehiculoValue() {
		when(tipoVehiculoService.obtenerTipoVehiculos()).thenReturn(tipoVehiculoLista);
		Collection<TipoVehiculoDTO> listaTipoVehiculo = tipoVehiculoBussines.obtenerTipoVehiculos();
		listaTipoVehiculo.forEach(tipoVehiculo -> {
			Assert.assertTrue(tipoVehiculo.getId().equals(TipoVehiculoConstante.ID) );
			Assert.assertTrue(tipoVehiculo.getCodigo().equals(TipoVehiculoConstante.CODIGO));
			Assert.assertTrue(tipoVehiculo.getCupo().equals(TipoVehiculoConstante.CUPO));
			Assert.assertTrue(tipoVehiculo.getDiasPermitidos().equals(TipoVehiculoConstante.DIAS_PERMITIDOS));
			Assert.assertTrue(tipoVehiculo.getPlacaBloqueada().equals(TipoVehiculoConstante.PLACA_BLOQUEADA));
			Assert.assertTrue(tipoVehiculo.getVehiculo().equals(TipoVehiculoConstante.VEHICULO));
		});
	}

	/**
	 * 
	 */
	@Test(expected = NullPointerException.class)
	public void verifyTipoVehiculoException() {
		when(tipoVehiculoService.obtenerTipoVehiculos())
		.thenThrow(new NullPointerException("Error occurred"));
		Collection<TipoVehiculoDTO> tipoVehiculos = tipoVehiculoBussines.obtenerTipoVehiculos();
		Assert.assertTrue( tipoVehiculos.isEmpty() );
	}

}
