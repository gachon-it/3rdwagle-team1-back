package com.example.yoURL.domain.entity.Folder.entity.controller;

import com.example.yoURL.domain.entity.Folder.entity.dto.FolderDTO;
import com.example.yoURL.domain.entity.Folder.entity.response.FolderResponse;
import com.example.yoURL.domain.entity.Folder.entity.service.FolderService;
import com.example.yoURL.global.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.example.yoURL.domain.entity.Folder.entity.controller.ResponseMessage.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/folder")
public class FolderController {

    private final FolderService folderService;

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
    public ApiResponse<FolderResponse> updateFolder(@RequestBody FolderDTO req) {
        FolderResponse folder = folderService.updateFolder(req.getId(), req.getName());
        return ApiResponse.response(UPDATE_SUCCESS.getCode(), UPDATE_SUCCESS.getMessage(), folder);
    }

    // ✅ 폴더 삭제
    @Operation(summary = "폴더 삭제")
    @DeleteMapping
    public ApiResponse<String> deleteFolder(@RequestBody FolderDTO req) {
        folderService.deleteFolder(req.getId(), req.getName());
        return ApiResponse.response(DELETE_SUCCESS.getCode(), DELETE_SUCCESS.getMessage(), "삭제 완료");
    }

    // ✅ 게시물 조회
    @Operation(summary = "게시물 조회")
    @GetMapping("/{folder_id}")
    public ApiResponse<FolderResponse> getFolder(@RequestParam Long id) {
        FolderResponse folder = folderService.
    }
}