package com.example.yoURL.domain.entity.Article.dto;

import com.example.yoURL.domain.entity.Article.entity.Article;
import com.example.yoURL.domain.entity.Folder.entity.entity.Folder;

import com.example.yoURL.domain.entity.Member.entity.Member;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ArticleRequestDTO {

    @Getter
    @Setter
    public static class CreateArticle { // 내부 클래스로 분리 (선택 사항)


        @NotNull
        private Long memberId;

        @NotBlank
        @Size(max = 250)
        private String url;

        @Size(max = 250)
        private String description;

        @NotNull
        private Article.Rating rating; // Enum 타입

        // DTO를 Entity로 변환 (folder, url, description, rating만 사용)
        public Article toEntity(Member member) {
            return Article.builder()
                    .url(this.url)
                    .description(this.description)
                    .rating(this.rating)
                    .member(member)
                    .build();
        }
    }

    @Getter
    @Setter
    public static class editArticle {
        @NotNull
        private Long articleId;


        @NotBlank
        @Size(max = 100)
        private String name;

        @NotBlank
        @Size(max = 250)
        private String url;

        @Size(max = 250)
        private String description;

        @Size(max = 250)
        private String imageUrl;

        @NotNull
        private Article.Rating rating;
    }
}