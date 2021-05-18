package com.cosmos.exceptions;

public class EntityNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	
	private String fieldName;
	private String value;
	private String message;
	
	public EntityNotFoundException(String message) {
		this.message = message;
	}

	public EntityNotFoundException(String fieldName, String value) {
		this.fieldName = fieldName;
		this.value = value;
	}
	
	public EntityNotFoundException(String fieldName, String value, String message) {
		this.fieldName = fieldName;
		this.value = value;
		this.message = message;
	}

	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
