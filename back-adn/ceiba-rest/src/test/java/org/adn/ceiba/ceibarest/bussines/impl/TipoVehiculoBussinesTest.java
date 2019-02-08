package org.adn.ceiba.ceibarest.bussines.impl;

import java.util.Collection;
import java.util.Objects;

import org.adn.ceiba.ceibarest.bussines.ITipoVehiculoBussines;
import org.adn.ceiba.ceibarest.dto.TipoVehiculoDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
 * @author jose.lozano
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public final class TipoVehiculoBussinesTest {

	@Autowired
	private ITipoVehiculoBussines tipoVehiculoBussines;

	@Before
	public void setup() {
		//throw new UnsupportedOperationException("metodo no usado");
	}

	@Test
	public void verifyObtenerTipoVehiculos() {
		Collection<TipoVehiculoDTO> responseLista = tipoVehiculoBussines.obtenerTipoVehiculos();
		Assert.assertTrue(Objects.nonNull(responseLista));
	}
}
