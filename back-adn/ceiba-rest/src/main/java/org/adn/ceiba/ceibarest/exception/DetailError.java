package org.adn.ceiba.ceibarest.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * The Class DetailError.
 *
 * @author <a href="tecnico_integracion5@utayecisa.com"> Guillermo García</a> Creation date 24/05/2018
 * @since 1.0
 * @version 1.0 
 */
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
	private Map<String, List<ValidationError>> errors = new HashMap<>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

	public Map<String, List<ValidationError>> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, List<ValidationError>> errors) {
		this.errors = errors;
	}
	
	
	
		
}
