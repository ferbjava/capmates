package com.capgemini.capmates.Exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ProfileExceptions extends IllegalArgumentException {

	private static final long serialVersionUID = 5534091722875804464L;

	public ProfileExceptions(){
		super();
	}
	
	public ProfileExceptions(String string){
		super(string);
	}
	
}
