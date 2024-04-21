package com.joaoroberto.workshopmongo.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;

import com.joaoroberto.workshopmongo.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;
@ControllerAdvice
public class ResourceExceptionHandler {
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandartError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
	 
		
	HttpStatus status = HttpStatus.NOT_FOUND;	
	 StandartError err = new StandartError(System.currentTimeMillis(),status.value(),"nao encontrado",e.getMessage(),request.getRequestURI());
	 return ResponseEntity.status(status).body(err);
	
	}

}
