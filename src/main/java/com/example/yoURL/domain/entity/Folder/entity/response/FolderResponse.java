package com.example.yoURL.domain.entity.Folder.entity.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FolderResponse {
    private Long id;
    private Long parentFolderId;
    private String name;

    @Builder
    private FolderResponse(Long id, Long parentFolderId, String name) {
        this.id = id;
        this.parentFolderId = parentFolderId;
        this.name = name;
    }

    public static FolderResponse of(Long id, Long parentFolderId, String name) {
        return FolderResponse.builder()
                .id(id)
                .parentFolderId(parentFolderId)
                .name(name)
                .build();
    }
}