package org.adn.ceiba.ceibarest.adapter;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Objects;
import java.util.Optional;

import org.adn.ceiba.ceibarest.dto.TipoVehiculoDTO;
import org.adn.ceiba.ceibarest.entity.TipoVehiculo;
import org.adn.ceiba.ceibarest.utils.TipoVehiculoConstante;
import org.apache.logging.log4j.util.Strings;
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
public class TipoVehiculoAdapterTest {

	private static TipoVehiculoDTO tipoVehiculoDTO;
	private static TipoVehiculo tipoVehiculo;
	
	/**
	 * metodo setup
	 */
	@BeforeClass
	public static void setup() {
		
		tipoVehiculoDTO = TipoVehiculoDTO.builder()
				.id(TipoVehiculoConstante.ID)
				.tipo(TipoVehiculoConstante.TIPO)
				.build();
		
		tipoVehiculo = TipoVehiculo.builder()
				.id(TipoVehiculoConstante.ID)
				.tipo(TipoVehiculoConstante.TIPO)
				.build();
		
	}

	/**
	 * metodo que convierte de dto a entidad
	 */
	@Test
	public void verifyConversionEntidad() {
		Optional<TipoVehiculo> tipoVehiculo = 
				TipoVehiculoAdapter.getInstance().obtenerEntidad(tipoVehiculoDTO);
		
		if ( !tipoVehiculo.isPresent() )
			fail("Objeto no ha sido convertido exitosamente");
		
		assertTrue(Strings.isNotBlank(tipoVehiculo.get().getTipo()));
		assertTrue(Objects.nonNull(tipoVehiculo.get().getTipo()));
	}
	
	/**
	 * 
	 */
	@Test
	public void verifyConversionDTO() {
		Optional<TipoVehiculoDTO> tipoVehiculoDTO = TipoVehiculoAdapter
				.getInstance().obtenerDTO(tipoVehiculo);
	
		if ( !tipoVehiculoDTO.isPresent() )
			fail("Objeto no ha sido convertido exitosamente");
		
		assertTrue(tipoVehiculoDTO.get().getId() == TipoVehiculoConstante.ID );
		assertTrue(Strings.isNotBlank(tipoVehiculoDTO.get().getTipo()));
		assertTrue(Objects.nonNull(tipoVehiculoDTO.get().getTipo()));
	}
	
}
