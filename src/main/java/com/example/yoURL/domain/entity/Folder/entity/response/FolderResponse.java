package com.example.yoURL.domain.entity.Folder.entity.response;

import com.example.yoURL.domain.entity.Article.dto.ArticleResponseDTO;
import com.example.yoURL.domain.entity.Article.entity.Article;
import com.example.yoURL.domain.entity.Folder.entity.entity.Folder;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class FolderResponse {
    private final Long id;
    private final String name;
    private final LocalDate date;

    @Builder
    private FolderResponse(Long id, String name, LocalDate date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public static FolderResponse from(Long id, String name, LocalDate date) {
        return FolderResponse.builder()
                .id(id)
                .name(name)
                .date(date)
                .build();
    }

    // `of` 메서드 수정: builder 사용
    public static FolderResponse of(Long id, String name) {
        return FolderResponse.builder()
                .id(id)
                .name(name)
                .build();
    }
}
