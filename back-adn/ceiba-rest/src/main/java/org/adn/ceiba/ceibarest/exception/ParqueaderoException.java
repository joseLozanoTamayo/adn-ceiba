package org.adn.ceiba.ceibarest.exception;

import lombok.AllArgsConstructor;

/**
 * Clase que administra las excepciones logicas que puedan suceder
 * 
 * The Class CreditoDigitalException.
 */
@AllArgsConstructor
public class ParqueaderoException extends RuntimeException {
	private static final long serialVersionUID = 6759407566706191023L;
	
	private final DetailError detalleError;

	public DetailError getDetalleError() {
		return detalleError;
	}

}
