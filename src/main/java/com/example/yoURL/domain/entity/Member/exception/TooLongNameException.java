package com.example.yoURL.domain.entity.Member.exception;

import static com.example.yoURL.domain.entity.Member.exception.ErrorMessage.TOO_LONG_NAME;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

import com.example.yoURL.global.common.exception.BaseException;

public class TooLongNameException extends BaseException {
    public TooLongNameException() {
        super(BAD_REQUEST, TOO_LONG_NAME.getMessage());
    }
}
