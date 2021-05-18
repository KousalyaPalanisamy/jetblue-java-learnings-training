package com.cosmos.exceptions;

public class NoDataAvailable extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	
	private final String message;
	private final String debugMessage;
	
	public NoDataAvailable(String message, String debugMessage) {
		this.message = message;
		this.debugMessage = debugMessage;
	}

	@Override
	public String getMessage() {
		return message;
	}
	
	public String getDebugMessage() {
		return debugMessage;
	}

	
}
