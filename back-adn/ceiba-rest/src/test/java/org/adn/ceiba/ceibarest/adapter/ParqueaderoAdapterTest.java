package org.adn.ceiba.ceibarest.adapter;

import org.adn.ceiba.ceibarest.dto.ParqueaderoDTO;
import org.adn.ceiba.ceibarest.entity.Parqueadero;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
 * @author jose.lozano
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ParqueaderoAdapterTest {

	private static ParqueaderoDTO parqueaderoDTO;
	private static Parqueadero parqueadero;
	
	/**
	 * metodo setup
	 */
	@BeforeClass
	public static void setup() {
		
//		parqueaderoDTO = TipoVehiculoDTO.builder()
//				.id(TipoVehiculoConstante.ID)
//				.build();

	}

	/**
	 * metodo que convierte de dto a entidad
	 */
	@Test
	public void verifyConversionEntidad() {

	}
	
	/**
	 * 
	 */
	@Test
	public void verifyConversionDTO() {

	}
	
}
