package com.example.yoURL.domain.entity.Member.exception;

import static com.example.yoURL.domain.entity.Member.exception.ErrorMessage.NOT_FOUND_MEMBER;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import com.example.yoURL.global.common.exception.BaseException;

public class MemberNotFoundException extends BaseException {
    public MemberNotFoundException() {
        super(NOT_FOUND, NOT_FOUND_MEMBER.getMessage());
    }
}
