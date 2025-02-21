package com.example.yoURL.domain.entity.Folder.entity.dto;

import com.example.yoURL.domain.entity.Folder.entity.response.FolderResponse;
import java.util.List;
import lombok.Builder;

@Builder
public record FolderListResponse(
        List<FolderResponse> folders
) {
    public static FolderListResponse of(List<FolderResponse> folders) {
        return new FolderListResponse(folders);
    }
}
