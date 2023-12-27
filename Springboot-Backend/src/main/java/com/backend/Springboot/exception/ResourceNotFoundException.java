package com.backend.Springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	
//	public void ResourceNotFound(String message) {
//		super(message);
//	}
	
	public ResourceNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

}
