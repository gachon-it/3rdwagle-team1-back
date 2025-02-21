package com.example.yoURL.domain.entity.Article.exception;

import static com.example.yoURL.domain.entity.Article.exception.ErrorMessage.ARTICLE_NOT_LIKED;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

import com.example.yoURL.global.common.exception.BaseException;

public class ArticleNotLikedException extends BaseException {
    public ArticleNotLikedException() {
        super(BAD_REQUEST, ARTICLE_NOT_LIKED.getMessage());
    }
}
