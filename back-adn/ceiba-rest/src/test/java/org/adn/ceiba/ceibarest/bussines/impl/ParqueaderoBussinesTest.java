package org.adn.ceiba.ceibarest.bussines.impl;

import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.adn.ceiba.ceibarest.dto.ParqueaderoDTO;
import org.adn.ceiba.ceibarest.entity.Parqueadero;
import org.adn.ceiba.ceibarest.exception.ParqueaderoException;
import org.adn.ceiba.ceibarest.repository.ParqueaderoRepository;
import org.adn.ceiba.ceibarest.repository.TarifaRepository;
import org.adn.ceiba.ceibarest.utils.ParqueaderoConstante;
import org.adn.ceiba.ceibarest.utils.TarifaConstantes;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


/**
 * 
 * @author jose.lozano
 *
 */
@RunWith(MockitoJUnitRunner.class)
public final class ParqueaderoBussinesTest {

	@InjectMocks
	private ParqueaderoBussines parqueaderoBussines;

	@Mock
	private ParqueaderoRepository parqueaderoService;

	@Mock
	private TarifaRepository tarifaService;
	
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
		when(parqueaderoService.findByEstado(Mockito.anyString())).thenReturn(listaParqueadero);
		Collection<ParqueaderoDTO> responseLista = parqueaderoBussines.obtenerListaParqueadero();
		Assert.assertNotNull(responseLista);
	}
	
	/**
	 * 
	 */
	@Test
	public void verifyParqueaderoListaEmpty() {
		when(parqueaderoService.findByEstado(Mockito.anyString())).thenReturn(ParqueaderoConstante.PARQUEADERO_NULL);
		Collection<ParqueaderoDTO> lista = parqueaderoBussines.obtenerListaParqueadero();
		Assert.assertTrue( lista.isEmpty() );
	}

	/**
	 * 
	 */
	@Test
	public void verifyParqueaderoListaValue() {
		when(parqueaderoService.findByEstado(Mockito.anyString())).thenReturn(listaParqueadero);
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
		when(parqueaderoService.findByEstado(Mockito.anyString()))
		.thenThrow(new NullPointerException("Error occurred"));
		Collection<ParqueaderoDTO> parqueaderos = parqueaderoBussines.obtenerListaParqueadero();
		Assert.assertTrue( parqueaderos.isEmpty() );
	}
	
	/**
	 * 
	 */
	@Test
	public void verifyObtenerParqueadero() {
		
		when(parqueaderoService.findById(Mockito.anyInt())).thenReturn(ParqueaderoConstante.PARQUEADERO_MOTO);
		when(tarifaService.findByCodigoTipoVehiculo(Mockito.anyString())).thenReturn(TarifaConstantes.TARIFA_MOTO);
		
		ParqueaderoDTO response = parqueaderoBussines.obtenerParqueadero(ParqueaderoConstante.PARQUEADERO_DTO_MOTO.get());

		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getId());
		
	}
	
	@Test
	public void verifySaldoHoraParqueaderoMoto() {
				
		ParqueaderoConstante.PARQUEADERO_MOTO.get()
		.setHoraSalida(Timestamp.valueOf(
				ParqueaderoConstante.PARQUEADERO_MOTO.get().getHoraIngreso().toLocalDateTime().plusMinutes(5)));
				
		when(parqueaderoService.findById(Mockito.anyInt())).thenReturn(ParqueaderoConstante.PARQUEADERO_MOTO);
		when(tarifaService.findByCodigoTipoVehiculo(Mockito.anyString())).thenReturn(TarifaConstantes.TARIFA_MOTO);

		ParqueaderoDTO response = parqueaderoBussines.obtenerParqueadero(ParqueaderoConstante.PARQUEADERO_DTO_MOTO.get());
		
		Assert.assertNotNull( response.getId() );
		Assert.assertTrue(response.getPagoCancelado().compareTo( ParqueaderoConstante.PAGO_CANCELAR_HORA_MOTO) == 0);
		
	}
	
	@Test
	public void verifySaldoDiaParqueaderoMoto() {
				
		ParqueaderoConstante.PARQUEADERO_MOTO.get()
		.setHoraSalida(Timestamp.valueOf(
				ParqueaderoConstante.PARQUEADERO_MOTO.get().getHoraIngreso().toLocalDateTime().plusDays(1)));
		
		ParqueaderoConstante.PARQUEADERO_MOTO.get().setCilindraje(400L);
		ParqueaderoConstante.PARQUEADERO_MOTO.get().setPagoCancelado(0L);
		
		when(parqueaderoService.findById(Mockito.anyInt())).thenReturn(ParqueaderoConstante.PARQUEADERO_MOTO);
		when(tarifaService.findByCodigoTipoVehiculo(Mockito.anyString())).thenReturn(TarifaConstantes.TARIFA_MOTO);
		
		ParqueaderoDTO response = parqueaderoBussines.obtenerParqueadero(ParqueaderoConstante.PARQUEADERO_DTO_MOTO.get());
		
		Assert.assertNotNull("Id objeto Vacio", response.getId());
		Assert.assertTrue(response.getPagoCancelado().compareTo( ParqueaderoConstante.PAGO_CANCELAR_DIA_MOTO) == 0);
		
	}
	
	/**
	 * 
	 */
	@Test
	public void verifySaldoCilindrajeHoraParqueaderoMoto() {
				
		ParqueaderoConstante.PARQUEADERO_MOTO.get()
		.setHoraSalida(Timestamp.valueOf(
				ParqueaderoConstante.PARQUEADERO_MOTO.get().getHoraIngreso().toLocalDateTime().plusMinutes(1)));

		ParqueaderoConstante.PARQUEADERO_MOTO.get().setCilindraje(700L);
		ParqueaderoConstante.PARQUEADERO_MOTO.get().setPagoCancelado(0L);

		when(parqueaderoService.findById(Mockito.anyInt())).thenReturn(ParqueaderoConstante.PARQUEADERO_MOTO);
		when(tarifaService.findByCodigoTipoVehiculo(Mockito.anyString())).thenReturn(TarifaConstantes.TARIFA_MOTO);
		
		ParqueaderoDTO response = parqueaderoBussines.obtenerParqueadero(ParqueaderoConstante.PARQUEADERO_DTO_MOTO.get());
		
		Assert.assertNotNull("Id objeto Vacio", response.getId());
		Assert.assertTrue(response.getPagoTotal().compareTo( ParqueaderoConstante.PAGO_CILINDRAJE_HORA_MOTO) == 0);
		
	}
	
	/**
	 * 
	 */
	@Test
	public void verifySaldoHoraParqueaderoCarro() {
				
		ParqueaderoConstante.PARQUEADERO_CARRO.get()
		.setHoraSalida(Timestamp.valueOf(
				ParqueaderoConstante.PARQUEADERO_CARRO.get().getHoraIngreso().toLocalDateTime().plusMinutes(5)));
				
		when(parqueaderoService.findById(Mockito.anyInt())).thenReturn(ParqueaderoConstante.PARQUEADERO_CARRO);
		when(tarifaService.findByCodigoTipoVehiculo(Mockito.anyString())).thenReturn(TarifaConstantes.TARIFA_CARRO);

		ParqueaderoDTO response = parqueaderoBussines.obtenerParqueadero(ParqueaderoConstante.PARQUEADERO_DTO_CARRO.get());
		
		Assert.assertNotNull( response.getId() );
		Assert.assertTrue(response.getPagoCancelado().compareTo( ParqueaderoConstante.PAGO_CANCELAR_HORA_CARRO) == 0);
		
	}
	

	/**
	 * 
	 */
	@Test
	public void verifySaldoDiaParqueaderoCarro() {
				
		ParqueaderoConstante.PARQUEADERO_CARRO.get()
		.setHoraSalida(Timestamp.valueOf(
				ParqueaderoConstante.PARQUEADERO_CARRO.get().getHoraIngreso().toLocalDateTime().plusDays(1)));
		
		ParqueaderoConstante.PARQUEADERO_CARRO.get().setCilindraje(0L);
		ParqueaderoConstante.PARQUEADERO_CARRO.get().setPagoCancelado(0L);
		
		when(parqueaderoService.findById(Mockito.anyInt())).thenReturn(ParqueaderoConstante.PARQUEADERO_CARRO);
		when(tarifaService.findByCodigoTipoVehiculo(Mockito.anyString())).thenReturn(TarifaConstantes.TARIFA_CARRO);
		
		ParqueaderoDTO response = parqueaderoBussines.obtenerParqueadero(ParqueaderoConstante.PARQUEADERO_DTO_CARRO.get());
		
		Assert.assertNotNull("Id objeto Vacio", response.getId());
		Assert.assertTrue(response.getPagoCancelado().compareTo( ParqueaderoConstante.PAGO_CANCELAR_DIA_CARRO) == 0);
		
	}
	
	/**
	 * 
	 */
	@Test
	public void verifyPlacaNoExisteCarroNoBloqueada() {
		
		ParqueaderoConstante.PARQUEADERO_CARRO.get().setCilindraje(0L);
		ParqueaderoConstante.PARQUEADERO_CARRO.get().setPagoCancelado(0L);

		when(parqueaderoService.obtenerCupoParqueadero(Mockito.anyString(), Mockito.anyInt())).thenReturn(Optional.of(0));
		when(parqueaderoService.save(Mockito.any())).thenReturn(ParqueaderoConstante.PARQUEADERO_CARRO.get());
		
		ParqueaderoConstante.PARQUEADERO_DTO_CARRO.get().getTipoVehiculo().setDiasPermitidos("LU-MA-MI-JU-VI-SA-DO");
		ParqueaderoDTO response = parqueaderoBussines.crear(ParqueaderoConstante.PARQUEADERO_DTO_CARRO.get());
		
		Assert.assertNotNull("Id objeto Vacio", ((ParqueaderoDTO)response).getId());
	}
	
	/**
	 * 
	 */
	@Test
	public void verifyPlacaNoExisteMotoNobloqueo() {

		ParqueaderoConstante.PARQUEADERO_MOTO.get().setCilindraje(400L);
		ParqueaderoConstante.PARQUEADERO_MOTO.get().setPagoCancelado(0L);

		when(parqueaderoService.obtenerCupoParqueadero(Mockito.anyString(), Mockito.anyInt())).thenReturn(Optional.of(0));
		when(parqueaderoService.save(Mockito.any())).thenReturn(ParqueaderoConstante.PARQUEADERO_MOTO.get());

		ParqueaderoConstante.PARQUEADERO_DTO_MOTO.get().getTipoVehiculo().setDiasPermitidos("LU-MA-MI-JU-VI-SA-DO");
		ParqueaderoDTO response = parqueaderoBussines.crear(ParqueaderoConstante.PARQUEADERO_DTO_MOTO.get());

		Assert.assertNotNull("Id objeto Vacio", response.getId());
	}
	
	/**
	 * 
	 */
	@Test(expected = ParqueaderoException.class)
	public void obtenerParqueaderoException () {
		when(parqueaderoService.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(null));
		
		ParqueaderoDTO response = parqueaderoBussines.obtenerParqueadero(ParqueaderoConstante.PARQUEADERO_DTO_MOTO.get());

		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getId());
		
	}
	
	/**
	 * 
	 */
	@Test(expected = ParqueaderoException.class)
	public void verifyObtenerParqueaderoExceptionTarifa() {
		
		when(parqueaderoService.findById(Mockito.anyInt())).thenReturn(ParqueaderoConstante.PARQUEADERO_MOTO);
		when(tarifaService.findByCodigoTipoVehiculo(Mockito.anyString())).thenReturn(Optional.ofNullable(null));
		
		ParqueaderoDTO response = parqueaderoBussines.obtenerParqueadero(ParqueaderoConstante.PARQUEADERO_DTO_MOTO.get());

		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getId());
		
	}
	
	/**
	 * 
	 */
	@Test(expected = ParqueaderoException.class)
	public void verifyPlacaException() {
		
		ParqueaderoConstante.PARQUEADERO_DTO_CARRO.get().getTipoVehiculo().setDiasPermitidos("");
		when(parqueaderoService.obtenerCupoParqueadero(Mockito.anyString(), Mockito.anyInt())).thenReturn(Optional.of(5));
		
		Assert.assertNotNull(parqueaderoBussines.crear(ParqueaderoConstante.PARQUEADERO_DTO_CARRO.get()));
	}
	
	/**
	 * 
	 */
	@Test
	public void verifyRegistrarpago() {
		
		when(parqueaderoService.save(Mockito.any())).thenReturn(ParqueaderoConstante.PARQUEADERO_CARRO.get());
		ParqueaderoDTO response = parqueaderoBussines.registrarPago(ParqueaderoConstante.PARQUEADERO_DTO_CARRO.get());
		
		Assert.assertNotNull("Id objeto Vacio", response.getId());
	}
	
	/**
	 * 
	 */
	@Test(expected = ParqueaderoException.class)
	public void verifyPlacaBloqueo() {
		
		ParqueaderoConstante.PARQUEADERO_DTO_CARRO.get().getTipoVehiculo().setDiasPermitidos("");
		when(parqueaderoService.obtenerCupoParqueadero(Mockito.anyString(), Mockito.anyInt())).thenReturn(Optional.of(5));
		
		ParqueaderoConstante.PARQUEADERO_DTO_CARRO.get().setPlacaVehiculo("ABC-123");
		
		Assert.assertNotNull(parqueaderoBussines.crear(ParqueaderoConstante.PARQUEADERO_DTO_CARRO.get()));
	}
	
	/**
	 * 
	 */
	@Test(expected = ParqueaderoException.class)
	public void verifyPlacaBloqueoMoto() {
		
		ParqueaderoConstante.PARQUEADERO_DTO_MOTO.get().getTipoVehiculo().setDiasPermitidos("");
		when(parqueaderoService.obtenerCupoParqueadero(Mockito.anyString(), Mockito.anyInt())).thenReturn(Optional.of(5));
		
		ParqueaderoConstante.PARQUEADERO_DTO_MOTO.get().setPlacaVehiculo("ABC-123");
		
		Assert.assertNotNull(parqueaderoBussines.crear(ParqueaderoConstante.PARQUEADERO_DTO_MOTO.get()));
	}
}
