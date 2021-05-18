package com.cosmos.controllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ServiceBusExceptionHandler 
{
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException e)
	{
		Map<String, Object> contents = new HashMap<>();
		contents.put("timeStamp", LocalDateTime.now());
		contents.put("message", e.getMessage());
		contents.put("httpStatus", 400);
		return new ResponseEntity<>(contents, HttpStatus.BAD_REQUEST);
	}
}
