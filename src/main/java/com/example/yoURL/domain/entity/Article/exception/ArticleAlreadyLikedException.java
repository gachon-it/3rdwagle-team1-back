package com.example.yoURL.domain.entity.Article.exception;

import static com.example.yoURL.domain.entity.Article.exception.ErrorMessage.ARTICLE_ALREADY_LIKED;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

import com.example.yoURL.global.common.exception.BaseException;

public class ArticleAlreadyLikedException extends BaseException {
    public ArticleAlreadyLikedException() {
        super(BAD_REQUEST, ARTICLE_ALREADY_LIKED.getMessage());
    }
}
