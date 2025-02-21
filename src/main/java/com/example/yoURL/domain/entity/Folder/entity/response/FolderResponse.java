package com.example.yoURL.domain.entity.Folder.entity.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FolderResponse {
    private Long id;
    private String name;

    @Builder
    private FolderResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static FolderResponse of(Long id, String name) {
        return FolderResponse.builder()
                .id(id)
                .name(name)
                .build();
    }
}