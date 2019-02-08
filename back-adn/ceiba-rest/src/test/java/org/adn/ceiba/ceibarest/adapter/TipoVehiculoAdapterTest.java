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
				.vehiculo(TipoVehiculoConstante.VEHICULO)
				.codigo(TipoVehiculoConstante.CODIGO)
				.build();
		
		tipoVehiculo = TipoVehiculo.builder()
				.id(TipoVehiculoConstante.ID)
				.vehiculo(TipoVehiculoConstante.VEHICULO)
				.build();
		
	}

	/**
	 * metodo que convierte de dto a entidad
	 */
	@Test
	public void verifyConversionEntidad() {
		Optional<TipoVehiculo> tipoVehiculoVerify = 
				TipoVehiculoAdapter.getInstance().obtenerEntidad(tipoVehiculoDTO);

		if ( !tipoVehiculoVerify.isPresent() )
			fail("Objeto no ha sido convertido exitosamente");

		assertTrue(Strings.isNotBlank(tipoVehiculoVerify.get().getVehiculo()));
		assertTrue(Objects.nonNull(tipoVehiculoVerify.get().getVehiculo()));
	}
	
	/**
	 * 
	 */
	@Test
	public void verifyConversionDTO() {
		Optional<TipoVehiculoDTO> tipoVehiculoOptional = TipoVehiculoAdapter
				.getInstance().obtenerDTO(tipoVehiculo);
	
		if ( !tipoVehiculoOptional.isPresent() )
			fail("Objeto no ha sido convertido exitosamente");
		
		assertTrue(tipoVehiculoOptional.get().getId().equals(TipoVehiculoConstante.ID)  );
		assertTrue(Strings.isNotBlank(tipoVehiculoOptional.get().getVehiculo()));
		assertTrue(Objects.nonNull(tipoVehiculoOptional.get().getVehiculo()));
	}
	
}
