package org.adn.ceiba.ceibarest.exception;

import java.io.Serializable;

/**
 * The Class ValidationError.
 *
 * @since 1.0
 * @version 1.0 
 */
public class ValidationError  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6595769106829629391L;

	/** The code. */
	private String code;
	
	/** The message. */
	private String message;
	
	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
}
