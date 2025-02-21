package com.example.yoURL.domain.entity.Article.dto;

import com.example.yoURL.domain.entity.Article.entity.Article;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
public class ArticleResponseDTO {
    @NotNull
    private final Long articleId;
    private final String name;
    private final String url;
    private final String description;
    private final String imageUrl;
    private final Article.Rating rating;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    @Builder
    private ArticleResponseDTO(
            Long articleId,
            String name,
            String url,
            String description,
            String imageUrl,
            Article.Rating rating,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        this.articleId = articleId;

        this.name = name;
        this.url = url;
        this.description = description;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public static ArticleResponseDTO from(Article article) {
        return ArticleResponseDTO.builder()
                .articleId(article.getId())
                .name(article.getName())
                .url(article.getUrl())
                .description(article.getDescription())
                .imageUrl(article.getImageUrl())
                .rating(article.getRating())
                .createdAt(article.getCreatedAt())
                .updatedAt(article.getUpdatedAt())
                .build();
    }
}