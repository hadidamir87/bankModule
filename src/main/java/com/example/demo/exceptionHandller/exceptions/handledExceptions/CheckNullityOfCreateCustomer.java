package com.example.demo.exceptionHandller.exceptions.handledExceptions;

import com.example.demo.exceptionHandller.exceptions.ServiceException;

        public class CheckNullityOfCreateCustomer extends ServiceException {

    public CheckNullityOfCreateCustomer(String errorCode) {
        super(errorCode);
    }

    public CheckNullityOfCreateCustomer(String message, String errorCode) {
        super(message, errorCode);
    }

    public CheckNullityOfCreateCustomer(String message, Throwable cause, String errorCode) {
        super(message, cause, errorCode);
    }

    public CheckNullityOfCreateCustomer(Throwable cause, String errorCode) {
        super(cause, errorCode);
    }

    public CheckNullityOfCreateCustomer(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String errorCode) {
        super(message, cause, enableSuppression, writableStackTrace, errorCode);
    }
}
