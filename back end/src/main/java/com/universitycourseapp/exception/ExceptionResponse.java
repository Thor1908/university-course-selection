package com.universitycourseapp.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {
	
	private int status;
	private String message;
	private LocalDateTime time;
	
	public ExceptionResponse() {
		super();
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the time
	 */
	public LocalDateTime getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public ExceptionResponse(int status, String message, LocalDateTime time) {
		super();
		this.status = status;
		this.message = message;
		this.time = time;
	}
	
	
	

}
