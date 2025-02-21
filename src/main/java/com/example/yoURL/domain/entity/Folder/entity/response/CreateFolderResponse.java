package com.example.yoURL.domain.entity.Folder.entity.response;

import com.example.yoURL.domain.entity.Article.dto.ArticleResponseDTO;
import com.example.yoURL.domain.entity.Article.entity.Article;
import com.example.yoURL.domain.entity.Folder.entity.entity.Folder;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class CreateFolderResponse {
    private final Long id;
    private final String name;
    private LocalDate date;

    @Builder
    private CreateFolderResponse(Long id, String name, LocalDate date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public static CreateFolderResponse from(Folder folder) {
        return CreateFolderResponse.builder()
                .id(folder.getId())
                .name(folder.getName())
                .build();
    }

    // `of` method
    public static CreateFolderResponse of(Long id, String name, LocalDate date) {
        return CreateFolderResponse.builder()
                .id(id)
                .name(name)
                .date(date)
                .build();
    }
}
