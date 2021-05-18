package com.cosmos.exceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.cosmos.exceptions.ApiException;

@ControllerAdvice
public class GlobalExceptionHandler 
{
//	@ExceptionHandler(Exception.class)
//	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<Object> handleAllUncaughtException(Exception e) 
	{
		return errorResponse(new ApiException("Unknown error occurred", e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR));
	}
	
	public ResponseEntity<Object> errorResponse(ApiException apiException)
	{
		return new ResponseEntity<>(apiException, apiException.getHttpStatus());
	}

}
