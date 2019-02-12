package org.adn.ceiba.ceibarest.exception;

import org.adn.ceiba.ceibarest.utils.EstadoServicioErrorEnum;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



/**
 * The Class ServicioException.
 */
@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ServicioException extends RuntimeException {
		
	/** The codigo status. */
	private HttpStatus status;
	
	/** The mensaje status. */
	private EstadoServicioErrorEnum codigoEnum;

	/**
	 * Instantiates a new servicio exception.
	 *
	 * @param codigoError the codigo error
	 * @param exception the exception
	 */
	public ServicioException(String codigoError, String exception) {
		super(exception);
	}

	
	/**
	 * Instantiates a new servicio exception.
	 *
	 * @param codigoEnum the codigo enum
	 * @param exception the exception
	 */
	public ServicioException(EstadoServicioErrorEnum codigoEnum, String exception) {
		super(exception);
		this.codigoEnum = codigoEnum;
	}
	
	/**
	 * Instantiates a new servicio exception.
	 *
	 * @param codigoEnum the codigo enum
	 * @param status the status
	 * @param exception the exception
	 */
	public ServicioException(EstadoServicioErrorEnum codigoEnum, HttpStatus status, String exception) {
		super(exception);
		this.codigoEnum = codigoEnum;
		this.status = status;
	}
	
	
	/**
	 * Gets the codigo enum.
	 *
	 * @return the codigo enum
	 */
	public EstadoServicioErrorEnum getCodigoEnum() {
		return codigoEnum;
	}


	/**
	 * Gets the codigo status.
	 *
	 * @return the codigo status
	 */
	public HttpStatus getStatus() {
		return status;
	}
}
