package com.env.agile.exception.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.env.agile.exception.ResourceNotFoundException;
import com.env.agile.model.UserToken;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
 
    @ExceptionHandler(value 
      = { ResourceNotFoundException.class, InternalAuthenticationServiceException.class })
    protected ResponseEntity<Object> handleConflict(
      Exception ex, WebRequest request) {
    	System.out.println(ex.getMessage());
    	UserToken _token = new UserToken();
    	_token.setMessage(ex.getMessage());
        return handleExceptionInternal(ex, _token, 
          new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}


