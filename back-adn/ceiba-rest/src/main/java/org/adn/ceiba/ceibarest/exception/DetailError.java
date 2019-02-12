package org.adn.ceiba.ceibarest.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class DetailError.
 *
 * @author <a href="tecnico_integracion5@utayecisa.com"> Guillermo García</a> Creation date 24/05/2018
 * @since 1.0
 * @version 1.0 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailError {

	/** The title. */
	private String title;
	
	/** The status. */
	private int status;
	
	/** The detail. */
	private String detail;
	
	/** The time stamp. */
	private Long timeStamp;
	
	/** The developer message. */
	private String developerMessage;
			
	/** The errors. */
	private Map<String, List<ValidationError>> errors = new HashMap<String, List<ValidationError>>();
		
}
