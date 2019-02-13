package org.adn.ceiba.ceibarest.bussines.impl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.adn.ceiba.ceibarest.adapter.ParqueaderoAdapter;
import org.adn.ceiba.ceibarest.bussines.IParqueaderoBussines;
import org.adn.ceiba.ceibarest.dto.ParqueaderoDTO;
import org.adn.ceiba.ceibarest.entity.Parqueadero;
import org.adn.ceiba.ceibarest.entity.Tarifa;
import org.adn.ceiba.ceibarest.exception.DetailError;
import org.adn.ceiba.ceibarest.exception.ParqueaderoException;
import org.adn.ceiba.ceibarest.service.ParqueaderoService;
import org.adn.ceiba.ceibarest.service.TarifaService;
import org.adn.ceiba.ceibarest.utils.ConstantesParqueadero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * clase manejadora del negocio de tipovehiculo
 * @author jose.lozano
 *
 */
@Component
@Transactional
public class ParqueaderoBussines implements IParqueaderoBussines {

	@Autowired
	private ParqueaderoService parqueaderoService;

	@Autowired
	private TarifaService tarifaService;

	/**
	 * Metodo que registra parqueadero
	 */
	@Override
	public ParqueaderoDTO crear(ParqueaderoDTO parqueaderoDTO) {

		existeCupoParqueadero(parqueaderoDTO);
		verificarIngresoPlaca(parqueaderoDTO);

		Optional<Parqueadero> entidad = ParqueaderoAdapter.getInstance().obtenerEntidad(parqueaderoDTO);

		Parqueadero response = Parqueadero.builder().build();
		if (entidad.isPresent())
			response  = parqueaderoService.crear(entidad.get());

		if (Objects.nonNull(response) && Objects.nonNull(response.getId())) {
			parqueaderoDTO.setId(response.getId());
			parqueaderoDTO.setHoraIngreso(response.getHoraIngreso());
		}

		return parqueaderoDTO;
	}

	/**
	 * obtiene lista de parqueaderos
	 */
	@Override
	public Collection<ParqueaderoDTO> obtenerListaParqueadero() {
		Collection<Parqueadero> listaEntities = parqueaderoService.obtenerListaParqueadero();
		
		Optional<Collection<ParqueaderoDTO>> listaOptional = ParqueaderoAdapter.getInstance()
				.getListaParqueaderoDTO(listaEntities);
		
		return listaOptional.isPresent() ? listaOptional.get() : new ArrayList<>();
	}

	/**
	 * obtener parqueadero por medio del id
	 */
	@Override
	public ParqueaderoDTO obtenerParqueadero(ParqueaderoDTO parqueaderoDTO) {

		Optional<Parqueadero> entity = parqueaderoService.obtenerParqueadero(parqueaderoDTO.getId());
		Optional<ParqueaderoDTO> parqueaderoOptional = ParqueaderoAdapter.getInstance().obtenerDTO(entity);
		
		if (!parqueaderoOptional.isPresent())
			return ParqueaderoDTO.builder().build();
		
		ParqueaderoDTO parqueadero = parqueaderoOptional.get();
		
		Optional< Tarifa > tarifaOptional = tarifaService.findByCodigoTipoVehiculo(
				parqueadero.getTipoVehiculo().getCodigo());

		if ( !tarifaOptional.isPresent())
			return ParqueaderoDTO.builder().build();
		
		Tarifa tarifa = tarifaOptional.get();
			
		parqueadero.setPagoCancelado(calcularMontoFecha(
				parqueadero.getHoraIngreso().toLocalDateTime(), 
				parqueadero.getHoraSalida().toLocalDateTime(), 
				ConstantesParqueadero.CERO, 
				tarifa));
		
		if(tarifa.getCilindroVehiculo() < parqueadero.getCilindraje())
			parqueadero.setValorCilindraje(tarifa.getPrecioCilindro());

		parqueadero.setPagoTotal(parqueadero.getPagoCancelado() + parqueadero.getValorCilindraje() );
		return parqueadero;
	}

	/**
	 * resgistra la salida del auto en el parqueadero
	 */
	@Override
	public ParqueaderoDTO registrarPago(ParqueaderoDTO parqueaderoDTO) {

		Optional<Parqueadero> entidad = ParqueaderoAdapter.getInstance().obtenerEntidad(parqueaderoDTO);

		Parqueadero response = Parqueadero.builder().build();
		if (entidad.isPresent())
			response  = parqueaderoService.crear(entidad.get());

		if (Objects.nonNull(response) && Objects.nonNull(response.getId()))
			parqueaderoDTO.setId(response.getId());

		return parqueaderoDTO;
	}

	/**
	 * verifica el ingreso de la placa
	 */
	private void verificarIngresoPlaca(ParqueaderoDTO parqueaderoDTO) {

		if ( !parqueaderoDTO.getPlacaVehiculo()
				.startsWith(parqueaderoDTO.getTipoVehiculo().getPlacaBloqueada()))
			return;

		if (!parqueaderoDTO.getTipoVehiculo()
				.getDiasPermitidos().contains(ConstantesParqueadero.diaSemana())){
			DetailError detailError = DetailError.builder()
					.detail("Placa Inabilitada para parquear")
					.title("Placa Inabilitada para parquear")
					.timeStamp(Instant.now().getEpochSecond())
					.build();
			throw new ParqueaderoException(detailError);
		}
	}

	/**
	 * metodo que valida si existe el parqueadero
	 */
	private void existeCupoParqueadero(ParqueaderoDTO parqueaderoDTO) {
		Optional<Integer> cupoVehiculo = parqueaderoService
				.obtenerCupoParqueadero(ConstantesParqueadero.ASIGNADO, parqueaderoDTO.getTipoVehiculo().getId());
		if (cupoVehiculo.get() >= parqueaderoDTO.getTipoVehiculo().getCupo()) {
			DetailError detailError = DetailError.builder()
					.detail("Cupo de parqueadero lleno")
					.title("Parqueadero lleno")
					.timeStamp(Instant.now().getEpochSecond())
					.build();
			throw new ParqueaderoException(detailError);
		}
	}

	/**
	 * calcula el monto de la fecha
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
