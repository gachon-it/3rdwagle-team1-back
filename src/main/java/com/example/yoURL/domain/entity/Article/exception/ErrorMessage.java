package com.example.yoURL.domain.entity.Article.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessage {
    ARTICLE_NOT_FOUND("게시글을 찾을 수 없습니다."),
    ARTICLE_ALREADY_LIKED("이미 즐겨찾기로 등록한 게시글입니다."),
    ARTICLE_NOT_LIKED("즐겨찾기로 등록되지 않은 게시글입니다.");

    private final String message;
}
