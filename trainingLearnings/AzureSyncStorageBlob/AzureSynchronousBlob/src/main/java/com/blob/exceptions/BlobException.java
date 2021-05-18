package com.blob.exceptions;

public class BlobException extends RuntimeException 
{
	private static final long serialVersionUID = 1L;
	
	private final String status;
	private final String message;
	
	
	public BlobException(String status, String message) 
	{
		this.status = status;
		this.message = message;
	}
	
	public String getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	
	
}
