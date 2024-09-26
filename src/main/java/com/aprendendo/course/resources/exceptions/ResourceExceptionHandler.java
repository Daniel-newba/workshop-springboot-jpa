package com.aprendendo.course.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.aprendendo.course.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;


@ControllerAdvice
public class ResourceExceptionHandler implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity <StandardError> resourceNotFound (ResourceNotFoundException e, HttpServletRequest request){
		String error = "Recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError erro = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(erro);
		
	}
}
