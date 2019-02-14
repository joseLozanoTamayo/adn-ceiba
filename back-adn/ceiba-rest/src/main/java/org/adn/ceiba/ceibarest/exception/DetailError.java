package org.adn.ceiba.ceibarest.exception;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * The Class DetailError.
 *
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailError implements Serializable{
	private static final long serialVersionUID = 1L;

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

}
