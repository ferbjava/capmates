package com.capgemini.capmates.Exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ProfileControllerAdvice extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ProfileExceptions.class)
	public ResponseEntity<Object> handleIllegalArgumentExceptions(ProfileExceptions ex, HttpServletRequest request){
		return ResponseEntity.badRequest().body("Invalid index: "+ex.getMessage()+" "+request.getRequestURI());
	}
	
}
