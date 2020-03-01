package com.learningspringmongo.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.learningspringmongo.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<DefaultError> objectNotFound(ObjectNotFoundException ex, HttpServletRequest servletRequest) {

		HttpStatus status = HttpStatus.NOT_FOUND;
		DefaultError err = new DefaultError(Instant.now(), status.value(), "Não encontrado", ex.getMessage(),
				servletRequest.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
}
