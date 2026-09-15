package com.emp.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobleExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex){
		ErrorResponse response = new ErrorResponse(ex.getMessage(),ex.getStatus()); 
		return new ResponseEntity<>(response, ex.getStatus());
		
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFoundException(BadRequestException ex){
		ErrorResponse response = new ErrorResponse(ex.getMessage(),ex.getStatus()); 
		return new ResponseEntity<>(response, ex.getStatus());
		
	}
	
}

