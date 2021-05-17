package com.example.demo.dto;

import com.example.demo.constant.ErrorCode;

public class ErrorResponse {
    String errorCode;

    public ErrorResponse(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
