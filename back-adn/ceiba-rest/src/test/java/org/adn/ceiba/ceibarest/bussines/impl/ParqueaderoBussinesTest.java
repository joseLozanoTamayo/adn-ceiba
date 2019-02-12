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
	public void verifyObtenerParqueaderos() {
		when(parqueaderoService.obtenerListaParqueadero()).thenReturn(listaParqueadero);
		Collection<ParqueaderoDTO> responseLista = parqueaderoBussines.obtenerListaParqueadero();
		log.info(" Response : " + responseLista);
		Assert.assertNotNull(responseLista);
	}

}
