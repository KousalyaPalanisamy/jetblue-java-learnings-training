package com.cosmos.exceptionHandlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.azure.cosmos.implementation.BadRequestException;
import com.cosmos.exceptions.ApiException;
import com.cosmos.exceptions.EntityNotFoundException;
import com.cosmos.exceptions.NoDataAvailable;
import com.cosmos.exceptions.NotFoundException;

@ControllerAdvice
public class ApiExceptionHandler {
	HttpStatus badRequest = HttpStatus.BAD_REQUEST;
	HttpStatus notFound = HttpStatus.NOT_FOUND;

	@ExceptionHandler(value = { EntityNotFoundException.class })
	public ResponseEntity<Object> handleNotFoundException(EntityNotFoundException e) {
		String message = "No students found with " + e.getFieldName() + " as " + e.getValue();
		return errorResponse(new ApiException(message, notFound));
	}

	@ExceptionHandler(value = { BadRequestException.class })
	public ResponseEntity<Object> handleBadRequestException(BadRequestException e) {
		return errorResponse(new ApiException("Missing required fields", e.getCause(), badRequest));
	}

	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<Object> handleNotFoundException(NotFoundException e) {
		List<String> details = new ArrayList<>();
		details.add(e.getLocalizedMessage());
		return errorResponse(new ApiException(e.getMessage(), details, notFound));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public final ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		List<String> details = new ArrayList<>();
		for(ObjectError error : e.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
		return errorResponse(new ApiException("Validation Failed", details, badRequest));
	}

	@ExceptionHandler(NoDataAvailable.class)
	public final ResponseEntity<Object> handleNoDataAvailable(NoDataAvailable e){
		List<String> details = Arrays.asList(e.getDebugMessage());
		return errorResponse(new ApiException(e.getMessage(), details, HttpStatus.NO_CONTENT));
	}
	
	public ResponseEntity<Object> errorResponse(ApiException apiException) {
		return new ResponseEntity<>(apiException, apiException.getHttpStatus());
	}
}
