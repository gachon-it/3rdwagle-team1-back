package com.example.yoURL.domain.entity.Article.service;

import com.example.yoURL.domain.entity.Article.dto.ArticleRequestDTO;
import com.example.yoURL.domain.entity.Article.dto.ArticleResponseDTO;

import java.util.List;

public interface ArticleService {
    Long createArticle(ArticleRequestDTO.CreateArticle requestDto);
    List<ArticleResponseDTO> getAllArticles();
    ArticleResponseDTO getArticleById(Long id);
    ArticleResponseDTO updateArticle(Long id, ArticleRequestDTO.editArticle updateDTO);
    void deleteArticle(Long id);
}
