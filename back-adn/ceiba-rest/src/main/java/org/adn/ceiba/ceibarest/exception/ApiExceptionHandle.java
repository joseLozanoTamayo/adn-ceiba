package org.adn.ceiba.ceibarest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


/**
 * The Class ApiExceptionHandle.
 *
 * @version 1.0
 * @since 1.0.0
 */
@ControllerAdvice
public class ApiExceptionHandle {

	/**
	 * Handler generic exception.
	 *
	 */
	@ExceptionHandler(ParqueaderoException.class)
	public final ResponseEntity<Object> handlerGenericException( final ParqueaderoException exception, final WebRequest request ) {
		return new ResponseEntity<>( exception.getDetalleError(), HttpStatus.NOT_ACCEPTABLE); 
	}
}