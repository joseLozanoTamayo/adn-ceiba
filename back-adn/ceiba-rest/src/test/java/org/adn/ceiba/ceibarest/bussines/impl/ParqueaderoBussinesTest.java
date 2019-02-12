package org.adn.ceiba.ceibarest.bussines.impl;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;

import org.adn.ceiba.ceibarest.dto.ParqueaderoDTO;
import org.adn.ceiba.ceibarest.entity.Parqueadero;
import org.adn.ceiba.ceibarest.service.ParqueaderoService;
import org.adn.ceiba.ceibarest.service.TarifaService;
import org.adn.ceiba.ceibarest.utils.ParqueaderoConstante;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import lombok.extern.slf4j.Slf4j;


/**
 * 
 * @author jose.lozano
 *
 */
@RunWith(MockitoJUnitRunner.class)
@Slf4j
public final class ParqueaderoBussinesTest {

	@InjectMocks
	private ParqueaderoBussines parqueaderoBussines;

	@Mock
	private ParqueaderoService parqueaderoService;

	@Mock
	private TarifaService tarifaService;
	
	private Collection<Parqueadero> listaParqueadero = new ArrayList<>();
	
	/**
	 * 
	 */
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		listaParqueadero = ParqueaderoConstante.obtenerListaParqueadero();
	}

	/**
	 * 
	 */
	@Test
	public void verifyObtenerParqueaderoLista() {
		when(parqueaderoService.obtenerListaParqueadero()).thenReturn(listaParqueadero);
		Collection<ParqueaderoDTO> responseLista = parqueaderoBussines.obtenerListaParqueadero();
		log.info(" Response : " + responseLista);
		Assert.assertNotNull(responseLista);
	}
	
	/**
	 * 
	 */
	@Test
	public void verifyParqueaderoListaEmpty() {
		when(parqueaderoService.obtenerListaParqueadero()).thenReturn(ParqueaderoConstante.PARQUEADERO_NULL);
		Collection<ParqueaderoDTO> lista = parqueaderoBussines.obtenerListaParqueadero();
		Assert.assertTrue( lista.isEmpty() );
	}

	/**
	 * 
	 */
	@Test
	public void verifyParqueaderoListaValue() {
		when(parqueaderoService.obtenerListaParqueadero()).thenReturn(listaParqueadero);
		Collection<ParqueaderoDTO> parqueaderos = parqueaderoBussines.obtenerListaParqueadero();
		parqueaderos.forEach(parqueadero -> {
			Assert.assertTrue(parqueadero.getId().equals(ParqueaderoConstante.ID) );
			Assert.assertTrue(parqueadero.getCilindraje().equals(ParqueaderoConstante.CILINDRAJE));
			Assert.assertTrue(parqueadero.getNombresPropietario().equals(ParqueaderoConstante.NOMBRES_PROPIETARIO));
			Assert.assertTrue(parqueadero.getPlacaVehiculo().equals(ParqueaderoConstante.PLACA_VEHICULO));
			Assert.assertTrue(parqueadero.getEstado().equals(ParqueaderoConstante.ESTADO_ASIGNADO));
			Assert.assertTrue(parqueadero.getPagoCancelado().equals(ParqueaderoConstante.PAGO_CANCELADO));
			
			Assert.assertNotNull(parqueadero.getTipoVehiculo());
			Assert.assertNotNull(parqueadero.getEmpleado());
			
		});
	}

	/**
	 * 
	 */
	@Test(expected = NullPointerException.class)
	public void verifyParqueaderoListaException() {
		when(parqueaderoService.obtenerListaParqueadero())
		.thenThrow(new NullPointerException("Error occurred"));
		Collection<ParqueaderoDTO> parqueaderos = parqueaderoBussines.obtenerListaParqueadero();
		Assert.assertTrue( parqueaderos.isEmpty() );
	}

}
