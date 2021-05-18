package com.programs.exceptions;

public class ApiRequestExceptions extends RuntimeException 
{
	private static final long serialVersionUID = 1L;
	
	public ApiRequestExceptions(String message, Throwable cause)
	{
		super(message, cause);
	}
	public ApiRequestExceptions(String message) {
		super(message);
	}
}
