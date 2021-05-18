package com.cosmos.exceptionHandlers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.azure.cosmos.implementation.BadRequestException;
import com.cosmos.exceptions.ApiException;
import com.cosmos.exceptions.EntityNotFoundException;
import com.cosmos.exceptions.InvalidEntityException;

@ControllerAdvice
public class ApiExceptionHandler {
	HttpStatus badRequest = HttpStatus.BAD_REQUEST;
	HttpStatus notFound = HttpStatus.NOT_FOUND;

	@ExceptionHandler(value = { EntityNotFoundException.class })
	public ResponseEntity<Object> handleNotFoundException(EntityNotFoundException e) {
		String message = "No such " + e.getFieldName() + " available as " + e.getValue();
		return errorResponse(new ApiException(message, notFound));
	}

	@ExceptionHandler(value = { BadRequestException.class })
	public ResponseEntity<Object> handleBadRequestException(BadRequestException e) {
		return errorResponse(new ApiException("Missing required fields", e.getCause(), badRequest));
	}

	@ExceptionHandler(InvalidEntityException.class)
	public final ResponseEntity<Object> handleInvalidEntityException(InvalidEntityException e) {
		List<String> details = new ArrayList<>();
		details.add(e.getLocalizedMessage());
		return errorResponse(new ApiException("Invalid Entity", details, notFound));
	}

	public ResponseEntity<Object> errorResponse(ApiException apiException) {
		return new ResponseEntity<>(apiException, apiException.getHttpStatus());
	}
}
