package com.address.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

	private String message;
	private HttpStatus status;
	private LocalDateTime timestamp;
	
  public ErrorResponse (String message, HttpStatus httpStatus) {
	  this.message=message;
	  this.status=status;
	  this.timestamp=LocalDateTime.now();
  }

  
  public String getMessage() {
	return message;
  }

  public HttpStatus getStatus() {
	return status;
  }

  public LocalDateTime getTimestamp() {
	return timestamp;
  }

  public void setMessage(String message) {
	this.message = message;
  }

  public void setStatus(HttpStatus status) {
	this.status = status;
  }

  public void setTimestamp(LocalDateTime timestamp) {
	this.timestamp = timestamp;
  }

  

  
}
