package org.adn.ceiba.ceibarest.bussines.impl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.adn.ceiba.ceibarest.adapter.ParqueaderoAdapter;
import org.adn.ceiba.ceibarest.bussines.IParqueaderoBussines;
import org.adn.ceiba.ceibarest.dto.ParqueaderoDTO;
import org.adn.ceiba.ceibarest.entity.Parqueadero;
import org.adn.ceiba.ceibarest.entity.Tarifa;
import org.adn.ceiba.ceibarest.service.ParqueaderoService;
import org.adn.ceiba.ceibarest.service.TarifaService;
import org.adn.ceiba.ceibarest.utils.ConstantesParqueadero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * clase manejadora del negocio de tipovehiculo
 * @author jose.lozano
 *
 */
@Component
@Transactional
@Slf4j
public class ParqueaderoBussines implements IParqueaderoBussines {

	@Autowired
	private ParqueaderoService parqueaderoService;

	@Autowired
	private TarifaService tarifaService;

	/**
	 * 
	 */
	@Override
	public ParqueaderoDTO crear(ParqueaderoDTO parqueaderoDTO) {

		if(!existeCupoParqueadero(parqueaderoDTO))
			return null;

		if (!verificarIngresoPlaca(parqueaderoDTO))
			return null;

		Optional<Parqueadero> entidad = ParqueaderoAdapter.getInstance().obtenerEntidad(parqueaderoDTO);

		Parqueadero response = null;
		if (entidad.isPresent())
			response  = parqueaderoService.crear(entidad.get());

		if (Objects.nonNull(response) && Objects.nonNull(response.getId())) {
			parqueaderoDTO.setId(response.getId());
			parqueaderoDTO.setHoraIngreso(response.getHoraIngreso());
		}

		return parqueaderoDTO;
	}

	/**
	 * 
	 */
	@Override
	public Collection<ParqueaderoDTO> obtenerListaParqueadero() {
		Collection<Parqueadero> listaEntities = parqueaderoService.obtenerListaParqueadero();
		Optional<Collection<ParqueaderoDTO>> parqueaderoDtoLista = ParqueaderoAdapter
				.getInstance().getListaParqueaderoDTO(listaEntities);
		return parqueaderoDtoLista.get();
	}

	/**
	 * 
	 */
	@Override
	public ParqueaderoDTO obtenerParqueadero(ParqueaderoDTO parqueaderoDTO) {

		Tarifa tarifa = tarifaService.findByCodigoTipoVehiculo(parqueaderoDTO.getTipoVehiculo().getCodigo()).get();

		Optional<Parqueadero> entity = parqueaderoService.obtenerParqueadero(parqueaderoDTO.getId());
		Optional<ParqueaderoDTO> parqueadero = ParqueaderoAdapter
						.getInstance().obtenerDTO(entity.get());
		
		parqueadero.get().setPagoCancelado(calcularMontoFecha(
				parqueadero.get().getHoraIngreso().toLocalDateTime(), 
				LocalDateTime.now(), 
				ConstantesParqueadero.CERO, 
				tarifa));
		
		if(tarifa.getCilindroVehiculo() < parqueaderoDTO.getCilindraje())
			parqueadero.get().setValorCilindraje(tarifa.getPrecioCilindro());
		
		parqueadero.get().setPagoTotal(parqueadero.get().getPagoCancelado() +parqueadero.get().getValorCilindraje() );
		return parqueadero.get();
	}

	/**
	 * resgistra la salida del auto en el parqueadero
	 */
	@Override
	public ParqueaderoDTO registrarPago(ParqueaderoDTO parqueaderoDTO) {

		Optional<Parqueadero> entidad = ParqueaderoAdapter.getInstance().obtenerEntidad(parqueaderoDTO);

		Parqueadero response = null;
		if (entidad.isPresent())
			response  = parqueaderoService.crear(entidad.get());

		if (Objects.nonNull(response) && Objects.nonNull(response.getId()))
			parqueaderoDTO.setId(response.getId());

		return parqueaderoDTO;
	}

	/**
	 * verifica el ingreso de la placa
	 */
	private boolean verificarIngresoPlaca(ParqueaderoDTO parqueaderoDTO) {

		if ( !parqueaderoDTO.getPlacaVehiculo()
				.startsWith(parqueaderoDTO.getTipoVehiculo().getPlacaBloqueada()))
			return Boolean.TRUE;

		if (!parqueaderoDTO.getTipoVehiculo()
				.getDiasPermitidos().contains(ConstantesParqueadero.DIA_SEMANA()))
			return Boolean.FALSE;

		return Boolean.TRUE;
	}

	/**
	 * 
	 */
	private boolean existeCupoParqueadero(ParqueaderoDTO parqueaderoDTO) {
		int cupoVehiculo = parqueaderoService
				.obtenerCupoParqueadero(ConstantesParqueadero.ASIGNADO, parqueaderoDTO.getTipoVehiculo().getId());
		if (cupoVehiculo >= parqueaderoDTO.getTipoVehiculo().getCupo())
			return Boolean.FALSE;
		return Boolean.TRUE;
	}

	/**
	 * 
	 */
	private Long calcularMontoFecha(LocalDateTime fechaEntrada, LocalDateTime fechaSalida, Long saldo, Tarifa tarifa) {
		long horas = ChronoUnit.HOURS.between(fechaEntrada, fechaSalida);
		
		if (horas <= 0) {
			horas = ChronoUnit.SECONDS.between(fechaEntrada, fechaSalida) > 0 ? 
					ConstantesParqueadero.UNO: ConstantesParqueadero.CERO;
		}
		
		if (  horas > 0 && horas <= tarifa.getDia()) {
			long calculoHoras = tarifa.getValorHora() * horas;
			saldo = saldo + calculoHoras;
			return saldo;
		}
		
		if(ChronoUnit.HOURS .between(fechaEntrada, fechaSalida) > 9) {
			fechaEntrada = fechaEntrada.plusHours(ConstantesParqueadero.DIA_HORAS);
			saldo += tarifa.getValorDia();
			return calcularMontoFecha(fechaEntrada, fechaSalida, saldo, tarifa);
		}
		
		return saldo;
	}

}