package com.blob.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiException 
{
	private String userMessage;
	private List<String> details;
	private Throwable cause;
	private HttpStatus statusCode;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	
	public ApiException()
	{
		timestamp = LocalDateTime.now();
	}
	public ApiException(String userMessage, Throwable cause, HttpStatus statusCode) {
		this.userMessage = userMessage;
		this.cause = cause;
		this.statusCode = statusCode;
		this.timestamp = LocalDateTime.now();
	}
	
	public ApiException(String userMessage, HttpStatus statusCode) {
		this.userMessage = userMessage;
		this.statusCode = statusCode;
		this.timestamp = LocalDateTime.now();
	}

	
	public ApiException(String userMessage, List<String> details, HttpStatus statusCode) {
		this.userMessage = userMessage;
		this.setDetails(details);
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return userMessage;
	}
	public Throwable getThrowable() {
		return cause;
	}
	public HttpStatus getHttpStatus() {
		return statusCode;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setMessage(String userMessage) {
		this.userMessage = userMessage;
	}
	public void setThrowable(Throwable cause) {
		this.cause = cause;
	}
	public void setHttpStatus(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public List<String> getDetails() {
		return details;
	}
	public void setDetails(List<String> details) {
		this.details = details;
	}
	
	
   

}
