package com.example.yoURL.domain.entity.Member.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessage {
    // Member
    DUPLICATED_NAME("중복되는 닉네임입니다."),
    NOT_FOUND_MEMBER("등록되지 않은 유저입니다."),
    EMPTY_NAME("닉네임을 입력해주세요."),
    TOO_LONG_NAME("닉네임은 10자 미만으로 입력해주세요.");


    private final String message;
}
