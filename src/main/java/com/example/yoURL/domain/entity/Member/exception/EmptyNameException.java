package com.example.yoURL.domain.entity.Member.exception;

import static com.example.yoURL.domain.entity.Member.exception.ErrorMessage.EMPTY_NAME;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

import com.example.yoURL.global.common.exception.BaseException;

public class EmptyNameException extends BaseException {
    public EmptyNameException() {
        super(BAD_REQUEST, EMPTY_NAME.getMessage());
    }
}
