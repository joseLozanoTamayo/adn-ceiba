package org.adn.ceiba.ceibarest.exception;

import java.io.IOException;
import java.time.Instant;
import java.util.Calendar;

import org.adn.ceiba.ceibarest.utils.EstadoServicioErrorEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;


/**
 * The Class ApiExceptionHandle.
 *
 * @version 1.0
 * @since 1.0.0
 */
@ControllerAdvice
@Slf4j
public class ApiExceptionHandle extends RestExceptionHandler {

	/** The Constant RECURSO_NO_ENCONTRADO. */
	private static final String RECURSO_NO_ENCONTRADO = "Recurso no encontrado";

	private static final String FALLO_EN_CONEXION = "Fallo en la comunicacion con recurso";

	/**
	 * Handle service exception.
	 *
	 * @param exception the exception
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler(ServicioException.class)
	public final ResponseEntity<Object> handleServiceException(final ServicioException exception, final WebRequest request) {
		DetailError detailError = null;

		try {

			if ( exception.getCodigoEnum() == EstadoServicioErrorEnum.ERROR_VALIDACION ) {
				final ObjectMapper objectMapper = new ObjectMapper();
				detailError = objectMapper.readValue(exception.getMessage(), DetailError.class);
			}

			if ( exception.getCodigoEnum() != EstadoServicioErrorEnum.ERROR_VALIDACION) {
				detailError = new DetailError();
				detailError.setTitle(RECURSO_NO_ENCONTRADO);
				detailError.setTimeStamp(Calendar.getInstance().getTimeInMillis());
				detailError.setStatus(exception.getStatus().value());
				detailError.setDetail(exception.getMessage());
				detailError.setDeveloperMessage(exception.getClass().getName());
			}

		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		return new ResponseEntity<>(detailError, exception.getStatus());
	}

	/**
	 * Handler generic exception.
	 *
	 * @param exception the exception
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler(ParqueaderoException.class)
	public final ResponseEntity<?> handlerGenericException( final ParqueaderoException exception, final WebRequest request ) {
		return new ResponseEntity<>( exception.getDetalleError(), HttpStatus.NOT_ACCEPTABLE); 
	}
	
	/**
	 * Handler conexion client exception.
	 *
	 * @param exception the exception
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler(ResourceAccessException.class)
	public final ResponseEntity<?> handlerConexionClientException(final ResourceAccessException exception, final WebRequest request) {
		DetailError detalle = new DetailError();
		detalle.setTitle(RECURSO_NO_ENCONTRADO);
		detalle.setDetail( FALLO_EN_CONEXION );
		detalle.setTimeStamp(Instant.now().getEpochSecond());
		detalle.setDeveloperMessage(exception.getMessage());
		return new ResponseEntity<>( detalle, HttpStatus.NOT_ACCEPTABLE );
	}

}
