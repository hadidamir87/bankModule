package com.example.demo.exceptionHandller.exceptions;

public class DuplicateEntry extends Exception {
    private final String errorCode;

    public DuplicateEntry(String errorCode) {
        this.errorCode = errorCode;
    }
}
