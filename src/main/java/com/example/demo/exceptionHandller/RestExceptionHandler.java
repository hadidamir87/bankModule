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
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;
import java.util.NoSuchElementException;

@ControllerAdvice
public class RestExceptionHandler {
/*
    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionResponse> getException(ServiceException serviceException) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setError(true);
        exceptionResponse.setMessage(serviceException.getMessage());//this must be re place.
        return ResponseEntity.badRequest().body(exceptionResponse);
    }*/

    //NullPointerException
    //SQLIntegrityConstraintViolationException
    /*exception instanceof SQLIntegrityConstraintViolationException*/
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionResponse> getValidation(Exception exception) {
//        exception.printStackTrace();
        ExceptionResponse exceptionResponse = new ExceptionResponse();
      /*  if (Arrays.toString(exception.getStackTrace()) =="SQLIntegrityConstraintViolationException") {
            exceptionResponse.setMessage("duplicate element.");
            return ResponseEntity.badRequest().body(exceptionResponse);

        }*/
        if (exception instanceof SQLIntegrityConstraintViolationException){
            exceptionResponse.setMessage("duplicate element.");
            return ResponseEntity.badRequest().body(exceptionResponse);


        }        if (exception instanceof NullPointerException) {
            exceptionResponse.setMessage("customer's null.");
        }
        if (exception instanceof NoSuchElementException) {
            exceptionResponse.setMessage("id is not fount");
        }
//        exception.printStackTrace();

        exceptionResponse.setError(true);
        return ResponseEntity.badRequest().body(exceptionResponse);
    }

/*
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionResponse> getValidation(RuntimeException exception) {
//        exception.printStackTrace();
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        if (exception instanceof NullPointerException) {
            exceptionResponse.setMessage("customer's id is not enough.");
        }
        if (exception instanceof NoSuchElementException){
            exceptionResponse.setMessage("id is null");

        }
        if (exception.getStackTrace().equals("SQLIntegrityConstraintViolationException")) {
            exceptionResponse.setMessage("duplicate entry.");
        }else {
//        FieldError fieldError=exception.getBindingResult().getFieldError();
//        String message="error in field: "+fieldError.getField()+"should have... "+fieldError.getDefaultMessage();
//        exception.getBindingResult().getFieldError().
            exceptionResponse.setError(true);
            exceptionResponse.setMessage("unknown");
//            exception.printStackTrace();
        }
        return ResponseEntity.badRequest().body(exceptionResponse);
    }*/
}

