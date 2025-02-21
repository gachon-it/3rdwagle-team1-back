package com.example.yoURL.global.common.exception;

import org.springframework.http.HttpStatus;

public class BaseException extends RuntimeException {

    private final int errorCode;

    public BaseException(HttpStatus httpStatus, String message) {
        super(message);
        this.errorCode = httpStatus.value();
    }

    public int getErrorCode() {
        return errorCode;
    }
}
