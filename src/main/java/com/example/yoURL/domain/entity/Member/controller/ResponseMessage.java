package com.example.yoURL.domain.entity.Member.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ResponseMessage {
    SIGNUP_SUCCESS(HttpStatus.CREATED.value(), "회원가입에 성공했습니다."),
    LOGIN_SUCCESS(HttpStatus.OK.value(), "로그인에 성공했습니다");

    private final int code;
    private final String message;

}
