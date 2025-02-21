package com.example.yoURL.domain.entity.Article.exception;

import static com.example.yoURL.domain.entity.Article.exception.ErrorMessage.ARTICLE_NOT_FOUND;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import com.example.yoURL.global.common.exception.BaseException;

public class ArticleNotFoundException extends BaseException {
    public ArticleNotFoundException() {
        super(NOT_FOUND, ARTICLE_NOT_FOUND.getMessage());
    }
}
