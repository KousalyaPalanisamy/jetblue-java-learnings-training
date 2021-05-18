package com.blob.exceptionHandlers;

import java.io.UncheckedIOException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.blob.exceptions.ApiException;
import com.blob.exceptions.BlobException;

@ControllerAdvice
public class BlobExceptionHandler 
{
	HttpStatus badRequest = HttpStatus.BAD_REQUEST;
	HttpStatus notFound = HttpStatus.NOT_FOUND;
	
	@ExceptionHandler(UnknownHostException.class)
	public ResponseEntity<Object> handleUnknownHostException(UnknownHostException e)
	{	List<String> details = Arrays.asList("Check your Internet Connection");
		return errorResponse(new ApiException("Network unavailable", details,HttpStatus.SERVICE_UNAVAILABLE));
	}
	
	@ExceptionHandler(BlobException.class)
	public ResponseEntity<Object> handleBlobException(BlobException e)
	{List<String> details = Arrays.asList(e.getMessage());
		return errorResponse(new ApiException(e.getStatus(), details, notFound));
	}
	
	@ExceptionHandler(UncheckedIOException.class)
	public ResponseEntity<Object> handleUncheckedIOException(UncheckedIOException e)
	{
		return errorResponse(new ApiException(e.getMessage(), e.getCause()));
	}
	public ResponseEntity<Object> errorResponse(ApiException apiException) {
		return new ResponseEntity<>(apiException, apiException.getHttpStatus());
	}
}
