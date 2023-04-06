package com.Prospecta.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	  @ExceptionHandler(EntryException.class)
	    public ResponseEntity<ErrorDetails> customerExceptionHandler(EntryException e, WebRequest req){

	        ErrorDetails er = new ErrorDetails(e.getMessage(), req.getDescription(false), LocalDateTime.now());
	        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
	    }
}
