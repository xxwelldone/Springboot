package com.welldone.springboot.controller.exception;

import com.welldone.springboot.model.exception.StandardError;
import com.welldone.springboot.service.exceptions.DatabaseException;
import com.welldone.springboot.service.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.Instant;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> notFound(
            ResourceNotFoundException e, HttpServletRequest request
    ) {
        String error = "Not Found";
        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError err = new StandardError(
                Instant.now(),
                status,
                error,
                e.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(
            DatabaseException e, HttpServletRequest request
    ) {
        String error = "This user cannot be deleted for it has data associated in it";
        HttpStatus status = HttpStatus.FORBIDDEN;

        StandardError err = new StandardError(
                Instant.now(),
                status,
                error,
                e.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }
}
