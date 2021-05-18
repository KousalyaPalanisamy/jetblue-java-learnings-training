package com.cosmos.exceptions;

public class EntityNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	
	private final String fieldName;
	private final String value;
	private final String message;
	
	public EntityNotFoundException(String message) {
		this.fieldName = "";
		this.value = "";
		this.message = message;
	}

	public EntityNotFoundException(String fieldName, String value) {
		this.fieldName = fieldName;
		this.value = value;
		this.message = "";
	}
	
	public EntityNotFoundException(String fieldName, String value, String message) {
		this.fieldName = fieldName;
		this.value = value;
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public String getFieldName() {
		return fieldName;
	}

	public String getValue() {
		return value;
	}
	
	
}
