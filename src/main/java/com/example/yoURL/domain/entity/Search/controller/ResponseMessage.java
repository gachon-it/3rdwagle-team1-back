package com.example.yoURL.domain.entity.Search.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ResponseMessage {
    SEARCH_SUCCESS(HttpStatus.OK.value(), "검색에 성공했습니다.");

    private final int code;
    private final String message;

}
