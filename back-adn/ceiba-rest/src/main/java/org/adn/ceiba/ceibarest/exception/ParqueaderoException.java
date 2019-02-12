package org.adn.ceiba.ceibarest.exception;

import lombok.Data;

/**
 * Clase que administra las excepciones logicas que puedan suceder
 * 
 * The Class CreditoDigitalException.
 */
@Data
public class ParqueaderoException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2490976302110629726L;
	
	/** The detail error. */
	private DetailError detalleError;


	/**
	 * Instantiates a new credito digital exception.
	 */
	public ParqueaderoException() {
	}

	/**
	 * Instantiates a new credito digital exception.
	 *
	 * @param detalleError the detalle error
	 */
	public ParqueaderoException (DetailError detalleError) {
		super("Esto es un error controlado");
		this.detalleError = detalleError;
	}
}
