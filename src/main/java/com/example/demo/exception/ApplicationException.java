package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ApplicationException extends RuntimeException {
    private String errorCode;

    public ApplicationException(String errorCode) {
        super("Application Exception");
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
