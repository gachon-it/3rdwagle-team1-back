package com.example.yoURL.domain.entity.Member.exception;

import static com.example.yoURL.domain.entity.Member.exception.ErrorMessage.DUPLICATED_NAME;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

import com.example.yoURL.global.common.exception.BaseException;

public class DuplicatedNameException extends BaseException {
    public DuplicatedNameException() {
        super(BAD_REQUEST, DUPLICATED_NAME.getMessage());
    }
}
