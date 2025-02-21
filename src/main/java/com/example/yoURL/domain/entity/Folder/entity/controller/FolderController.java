package com.example.yoURL.domain.entity.Folder.entity.controller;

import com.example.yoURL.domain.entity.Folder.entity.dto.FolderDTO;
import com.example.yoURL.domain.entity.Folder.entity.dto.UpdateDTO;
import com.example.yoURL.domain.entity.Folder.entity.response.FolderResponse;
import com.example.yoURL.domain.entity.Folder.entity.service.FolderLikeService;
import com.example.yoURL.domain.entity.Folder.entity.service.FolderService;
import com.example.yoURL.global.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.yoURL.domain.entity.Folder.entity.controller.ResponseMessage.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/folder")
public class FolderController {

    private final FolderService folderService;
    private final FolderLikeService folderLikeService;

    // ✅ 폴더 생성
    @Operation(summary = "폴더 생성")
    @PostMapping("/create")
    public ApiResponse<FolderResponse> createFolder(@RequestBody FolderDTO req) {
        FolderResponse folder = folderService.createFolder(req.getId(), req.getName());
        return ApiResponse.response(CREATE_SUCCESS.getCode(), CREATE_SUCCESS.getMessage(), folder);
    }

    // ✅ 폴더 수정
    @Operation(summary = "폴더 수정")
    @PutMapping
    public ApiResponse<FolderResponse> updateFolder(@RequestBody UpdateDTO req) {
        FolderResponse folder = folderService.updateFolder(req.getMemberid(), req.getId(), req.getName());
        return ApiResponse.response(UPDATE_SUCCESS.getCode(), UPDATE_SUCCESS.getMessage(), folder);
    }

    // ✅ 폴더 삭제
    @Operation(summary = "폴더 삭제")
    @DeleteMapping
    public ApiResponse<String> deleteFolder(@RequestBody FolderDTO req) {
        folderService.deleteFolder(req.getId(), req.getName());
        return ApiResponse.response(DELETE_SUCCESS.getCode(), DELETE_SUCCESS.getMessage(), "삭제 완료");
    }

    // ✅ 전체 폴더 조회 (게시물 제외)
    @Operation(summary = "전체 폴더 조회")
    @GetMapping("/{id}")
    public ApiResponse<List<FolderResponse>> getAllFolders() {
        List<FolderResponse> folders = folderService.getAllFolders();
        return ApiResponse.response(200, "폴더 조회 성공", folders);
    }

    @PostMapping("/like/{id}")
    @Operation(summary = "폴더 관심 등록")
    public ApiResponse<Void> addLikeFolder(@PathVariable Long id, @AuthenticationPrincipal String name) {
        folderLikeService.addLikeFolder(id, name);
        return ApiResponse.response(FOLDER_LIKE_SUCCESS.getCode(), FOLDER_LIKE_SUCCESS.getMessage());
    }

    @DeleteMapping("/like/{id}")
    @Operation(summary = "폴더 관심 등록 해제")
    public ApiResponse<Void> deleteLikeFolder(@PathVariable Long id, @AuthenticationPrincipal String name) {
        folderLikeService.deleteLikeFolder(id, name);
        return ApiResponse.response(FOLDER_LIKE_REMOVE_SUCCESS.getCode(), FOLDER_LIKE_REMOVE_SUCCESS.getMessage());
    }
}