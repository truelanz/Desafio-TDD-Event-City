package com.devsuperior.bds02.controllers.handlers;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.bds02.repositories.exceptions.StandardError;
import com.devsuperior.bds02.services.exceptions.DataBaseException;
import com.devsuperior.bds02.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    // 500/404 - conteúdo não encontrado \\
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Not Found");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    //404 - conteúdo não encontrado \\
    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandardError> dataBaseException(DataBaseException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Integrat violation");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
    
    
}