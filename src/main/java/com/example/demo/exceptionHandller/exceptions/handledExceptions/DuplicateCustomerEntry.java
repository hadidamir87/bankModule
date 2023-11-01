package com.example.demo.exceptionHandller.exceptions.handledExceptions;

public class DuplicateCustomerEntry extends RuntimeException {
    private final String errorCode;

    public DuplicateCustomerEntry(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
