package org.adn.ceiba.ceibarest.bussines.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.adn.ceiba.ceibarest.adapter.ParqueaderoAdapter;
import org.adn.ceiba.ceibarest.dto.ParqueaderoDTO;
import org.adn.ceiba.ceibarest.entity.Parqueadero;
import org.adn.ceiba.ceibarest.entity.Tarifa;
import org.adn.ceiba.ceibarest.exception.DetailError;
import org.adn.ceiba.ceibarest.exception.ParqueaderoException;
import org.adn.ceiba.ceibarest.repository.ParqueaderoRepository;
import org.adn.ceiba.ceibarest.repository.TarifaRepository;
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
public class ParqueaderoBussines {

	@Autowired
	private ParqueaderoRepository parqueaderoService;

	@Autowired
	private TarifaRepository tarifaService;

	/**
	 * Metodo que registra parqueadero
	 */
	public ParqueaderoDTO crear(ParqueaderoDTO parqueaderoDTO) {

		existeCupoParqueadero(parqueaderoDTO);
		verificarIngresoPlaca(parqueaderoDTO);

		Optional<Parqueadero> entidad = ParqueaderoAdapter.getInstance().obtenerEntidad(parqueaderoDTO);

		Parqueadero response = Parqueadero.builder().build();
		if (entidad.isPresent())
			response  = parqueaderoService.save(entidad.get());

		if (Objects.nonNull(response) && Objects.nonNull(response.getId())) {
			parqueaderoDTO.setId(response.getId());
			parqueaderoDTO.setHoraIngreso(response.getHoraIngreso());
		}

		return parqueaderoDTO;
	}

	/**
	 * obtiene lista de parqueaderos
	 */
	public Collection<ParqueaderoDTO> obtenerListaParqueadero() {
		Collection<Parqueadero> listaEntities = parqueaderoService.findByEstado(ConstantesParqueadero.ASIGNADO);
		
		Optional<Collection<ParqueaderoDTO>> listaOptional = ParqueaderoAdapter.getInstance()
				.getListaParqueaderoDTO(listaEntities);
		
		return listaOptional.isPresent() ? listaOptional.get() : new ArrayList<>();
	}

	/**
	 * obtener parqueadero por medio del id
	 */
	public ParqueaderoDTO obtenerParqueadero(ParqueaderoDTO parqueaderoDTO) {

		Optional<Parqueadero> entity = parqueaderoService.findById(parqueaderoDTO.getId());
		
		if (!entity.isPresent()) {
			throw new ParqueaderoException(DetailError.builder()
					.detail("Objeto parqueadero vacio")
					.title("Objeto parqueadero vacio")
					.timeStamp(Instant.now().getEpochSecond())
					.build());
		}
		
		Optional<ParqueaderoDTO> parqueaderoOptional = ParqueaderoAdapter.getInstance().obtenerDTO(entity);
		ParqueaderoDTO parqueadero = parqueaderoOptional.orElse(ParqueaderoDTO.builder().build());
		
		Optional< Tarifa > tarifaOptional = tarifaService.findByCodigoTipoVehiculo(
				parqueadero.getTipoVehiculo().getCodigo());

		if ( !tarifaOptional.isPresent()) {
			throw new ParqueaderoException(DetailError.builder()
					.detail("Objeto tarifa vacio")
					.title("Objeto tarifa vacio")
					.timeStamp(Instant.now().getEpochSecond())
					.build());
		}
		
		Tarifa tarifa = tarifaOptional.get();
		if ( Objects.isNull(parqueadero.getHoraSalida()))
			parqueadero.setHoraSalida( Timestamp.valueOf(LocalDateTime.now()) );
		
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
	public ParqueaderoDTO registrarPago(ParqueaderoDTO parqueaderoDTO) {

		Optional<Parqueadero> entidad = ParqueaderoAdapter.getInstance().obtenerEntidad(parqueaderoDTO);

		Parqueadero response = Parqueadero.builder().build();
		if (entidad.isPresent())
			response  = parqueaderoService.save(entidad.get());

		if (Objects.nonNull(response) && Objects.nonNull(response.getId()))
			parqueaderoDTO.setId(response.getId());

		return parqueaderoDTO;
	}

	/**
	 * verifica el ingreso de la placa
	 */
	private void verificarIngresoPlaca(ParqueaderoDTO parqueaderoDTO) {

		if ( !parqueaderoDTO.getPlacaVehiculo()
				.startsWith(parqueaderoDTO.getTipoVehiculo().getPlacaBloqueada())) {
			throw new ParqueaderoException(DetailError.builder()
					.detail("Placa Bloqueada para ingreso")
					.title("Placa Bloqueada para ingreso")
					.timeStamp(Instant.now().getEpochSecond())
					.build());
		}

		if (!parqueaderoDTO.getTipoVehiculo()
				.getDiasPermitidos().contains(ConstantesParqueadero.diaSemana())){
			throw new ParqueaderoException(DetailError.builder()
					.detail("Placa Inabilitada para parquear")
					.title("Placa Inabilitada para parquear")
					.timeStamp(Instant.now().getEpochSecond())
					.build());
		}
	}

	/**
	 * metodo que valida si existe el parqueadero
	 */
	private void existeCupoParqueadero(ParqueaderoDTO parqueaderoDTO) {
		Optional<Integer> cupoVehiculo = parqueaderoService
				.obtenerCupoParqueadero(ConstantesParqueadero.ASIGNADO, parqueaderoDTO.getTipoVehiculo().getId());
		if ( !cupoVehiculo.isPresent() || cupoVehiculo.orElse(-1) >= parqueaderoDTO.getTipoVehiculo().getCupo()) {
			throw new ParqueaderoException(DetailError.builder()
					.detail("Cupo de parqueadero lleno")
					.title("Parqueadero lleno")
					.timeStamp(Instant.now().getEpochSecond())
					.build());
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
