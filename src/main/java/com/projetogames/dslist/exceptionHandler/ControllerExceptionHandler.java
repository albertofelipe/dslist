package com.projetogames.dslist.exceptionHandler;

import com.projetogames.dslist.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> resourceNotFound(ResourceNotFoundException exception, WebRequest request){

        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError standardError = new StandardError();
        standardError.setStatus(status.value());
        standardError.setInstant(OffsetDateTime.now());
        standardError.setTitle(exception.getMessage());

        return handleExceptionInternal(exception, standardError, new HttpHeaders(), status, request);
    }
}
