package com.example.demo.exceptionHandller;

import com.example.demo.exceptionHandller.exceptions.DuplicateEntry;
import com.example.demo.exceptionHandller.exceptions.ExceptionResponse;
import com.example.demo.exceptionHandller.exceptions.ServiceException;
import com.example.demo.exceptionHandller.exceptions.handledExceptions.CheckNullityOfCreateCustomer;
import jakarta.annotation.PostConstruct;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import java.util.NoSuchElementException;
import java.util.Properties;

@ControllerAdvice

public class RestExceptionHandler {


//    private final Properties properties = new Properties();

/*
    @PostConstruct
    public void init() {
        try {
            properties.load(new FileReader(
                    "F:\\H1\\Education\\programming\\Java\\develop\\demo1\\bank\\src\\main\\resources\\exception_fa_IR.properties",
                    StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/


    //NullPointerException
    //SQLIntegrityConstraintViolationException
    /*exception instanceof SQLIntegrityConstraintViolationException*/
    @ExceptionHandler(RuntimeException.class)
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ExceptionResponse> getValidation(RuntimeException exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        if (exception instanceof NullPointerException) {
            exceptionResponse.setMessage("customer's null.");
            return ResponseEntity.badRequest().body(exceptionResponse);
        }
        if (exception instanceof NoSuchElementException) {
            exceptionResponse.setMessage("id is not found.");
            return ResponseEntity.badRequest().body(exceptionResponse);
        }
        if (exception instanceof ArithmeticException) {
            exceptionResponse.setMessage(".");
            return ResponseEntity.badRequest().body(exceptionResponse);
        }
        if (exception instanceof DataIntegrityViolationException) {
            exceptionResponse.setMessage("duplicate entry.");

        } else {

            exceptionResponse.setMessage("system's error.");

        }
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
        if (exception.getStackTrace().equals("DataIntegrityViolationException")) {
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



