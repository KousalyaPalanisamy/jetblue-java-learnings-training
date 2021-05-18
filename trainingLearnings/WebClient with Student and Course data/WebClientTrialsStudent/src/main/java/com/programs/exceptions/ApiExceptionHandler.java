package com.programs.exceptions;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(value = {IllegalArgumentException.class})
	public ResponseEntity<Object> handleApiRequestException(IllegalArgumentException e)
	{
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		ApiException apiException = new ApiException(e.getMessage(), e.getCause(), badRequest, ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<>(apiException, badRequest);
	}
}
