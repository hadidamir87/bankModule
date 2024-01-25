package com.example.demo.exceptionHandller;

import com.example.demo.exceptionHandller.exceptions.handledExceptions.DuplicateCustomerEntry;
import com.example.demo.exceptionHandller.exceptions.handledExceptions.ErrorDetailsForClient;
//import com.example.demo.exceptionHandller.exceptions.IdNotFoundException;
import com.example.demo.exceptionHandller.exceptions.ServiceException;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import java.util.Properties;

@ControllerAdvice

public class RestExceptionHandler {

    //NullPointerException:unchecked
    //SQLIntegrityConstraintViolationException
    //NoSuchElementException:unchecked

    private final Properties properties = new Properties();
    private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);

    @PostConstruct
    public void init() {
        try {
            properties.load(new FileReader(
                    "F:\\H1\\JOB\\programming\\Java\\develop\\demo1\\bank\\src\\main\\resources\\exceptions_fa_IR.properties",
                    StandardCharsets.UTF_8));
//            F:\H1\JOB\programming\Java\develop\demo1\bank\src\main\resources\exceptions_fa_IR.properties
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorDetailsForClient> getValidation(ServiceException exception) {
        LOGGER.error("service exception", exception);
        LOGGER.debug("test for debug", exception);
        ErrorDetailsForClient exceptionResponse = new ErrorDetailsForClient();
        exceptionResponse.setError(true);
        String property = properties.getProperty(exception.getErrorCode());
        exceptionResponse.setError(true);

        if (property == null) {
            property = properties.getProperty("default");
        }
        exceptionResponse.setMessage(property);

        return ResponseEntity.badRequest().body(exceptionResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorDetailsForClient> getValidations(MethodArgumentNotValidException exception) {
        LOGGER.error("service exception", exception);
        LOGGER.debug("test for debug", exception);
        ErrorDetailsForClient exceptionResponse = new ErrorDetailsForClient();
        exceptionResponse.setError(true);
        FieldError fieldError = exception.getBindingResult().getFieldError();
        String message =
                "error in field :" +fieldError.getField()+"should have this pattern :"+fieldError.getDefaultMessage();
        exceptionResponse.setMessage(message);
        return ResponseEntity.badRequest().
                body(exceptionResponse);

    }


    @ExceptionHandler(DuplicateCustomerEntry.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorDetailsForClient> getValidation(DuplicateCustomerEntry exception) {
        LOGGER.error("duplicate customer entry.", exception);
        LOGGER.debug("test for debug in duplicate exception.", exception);

        ErrorDetailsForClient exceptionResponse = new ErrorDetailsForClient();
        String property = properties.getProperty(exception.getErrorCode());
        exceptionResponse.setError(true);

        if (property == null) {
            property = properties.getProperty("idIsNull");
        }
        exceptionResponse.setMessage(property);
        return ResponseEntity.badRequest().body(exceptionResponse);
    }
/*
    @ExceptionHandler(RuntimeException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorDetailsForClient> getValidation(RuntimeException exception) {
        ErrorDetailsForClient exceptionResponse = new ErrorDetailsForClient();
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
    }*/



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


/*
    @ExceptionHandler(IdNotFoundException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionResponse> getValidation(IdNotFoundException exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setError(true);
        String property = properties.getProperty(exception.getErrorCode());
        exceptionResponse.setError(true);

        if (property == null) {
            property = properties.getProperty("default");
        }
        exceptionResponse.setMessage(property);

        return ResponseEntity.badRequest().body(exceptionResponse);
    }*/

}



