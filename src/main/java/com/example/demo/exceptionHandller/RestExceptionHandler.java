package com.example.demo.exceptionHandller;

import com.example.demo.exceptionHandller.exceptions.ExceptionResponse;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.reflect.Field;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionResponse> getException(ServiceException serviceException) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setError(true);
        exceptionResponse.setMessage(serviceException.getMessage());//this must be re place.
        return ResponseEntity.badRequest().body(exceptionResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
        public ResponseEntity<ExceptionResponse> getValidation(MethodArgumentNotValidException exception) {
        exception.printStackTrace();
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setError(true);
        FieldError fieldError=exception.getBindingResult().getFieldError();
        String message="error in field: "+fieldError.getField()+"should have... "+fieldError.getDefaultMessage();
//        exception.getBindingResult().getFieldError().
        exceptionResponse.setMessage(message);//this must be re place.
        return ResponseEntity.badRequest().body(exceptionResponse);
    }

}
