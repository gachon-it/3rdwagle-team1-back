package com.example.yoURL.domain.entity.Article.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ArticleResponseMessage {
        ADD_ARTICLE_SUCCESS(HttpStatus.CREATED.value(), "게시글 등록에 성공했습니다."),
        GET_ALL_ARTICLE_SUCCESS(HttpStatus.OK.value(), "게시글 모두 흭득에 성공했습니다."),
        GET_ARTICLE_SUCCESS(HttpStatus.OK.value(), "게시글 단건 흭득에 성공했습니다."),
        EDIT_ARTICLE_SUCCESS(HttpStatus.OK.value(), "게시글 수정 성공"),
        DELETE_ARTICLE_SUCCESS(HttpStatus.OK.value(), "게시글 수정 성공"),
        ADD_ARTICLE_FAILED(HttpStatus.FORBIDDEN.value(), "중복된url")
        ;


        private final int code;
        private final String message;

    }
