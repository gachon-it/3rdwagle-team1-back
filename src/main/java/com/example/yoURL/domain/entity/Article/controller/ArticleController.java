package com.example.yoURL.domain.entity.Article.controller;

import com.example.yoURL.domain.entity.Article.dto.ArticleRequestDTO;
import com.example.yoURL.domain.entity.Article.dto.ArticleResponseDTO;
import com.example.yoURL.domain.entity.Article.entity.Article;
import com.example.yoURL.domain.entity.Article.repository.ArticleRepository;
import com.example.yoURL.domain.entity.Article.service.ArticleLikeService;
import com.example.yoURL.domain.entity.Article.service.ArticleService;
import com.example.yoURL.domain.entity.Folder.entity.entity.Folder;
import com.example.yoURL.domain.entity.Folder.entity.repository.FolderRepository;
import com.example.yoURL.global.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.yoURL.domain.entity.Article.controller.ArticleResponseMessage.*;
import static com.example.yoURL.domain.entity.Folder.entity.controller.ResponseMessage.FOLDER_LIKE_REMOVE_SUCCESS;
import static com.example.yoURL.domain.entity.Folder.entity.controller.ResponseMessage.FOLDER_LIKE_SUCCESS;

@Tag(name = "ArticleController", description = "게시글 관련 컨트롤러")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Validated
public class ArticleController {

    private final ArticleService articleService;
    private final ArticleLikeService articleLikeService;
    private final FolderRepository folderRepository;
    private final ArticleRepository articleRepository;

    @PostMapping("/article")
    @Operation(summary = "게시물 등록 API")
    public ApiResponse<Void> createArticle(@RequestBody @Valid ArticleRequestDTO.CreateArticle request) {
        if (articleRepository.existsByUrl(request.getUrl())) {
            return ApiResponse.response(ADD_ARTICLE_FAILED.getCode(), "An article with this URL already exists.");
        }

        articleService.createArticle(request);

        return ApiResponse.response(ADD_ARTICLE_SUCCESS.getCode(), ADD_ARTICLE_SUCCESS.getMessage());

    }

    @GetMapping("/{folder_id}")
    @Operation(summary = "한개의 폴더 id로 게시물 전체 조회 API")
    public ApiResponse<List<ArticleResponseDTO>> getLowerFolderArticleById(@PathVariable Long folder_id){
        Folder folder = folderRepository.findById(folder_id).orElse(null);
        long memberId = folder.getMember().getId();
        List<Article> articleList = articleRepository.findByMemberId(memberId);
        List<ArticleResponseDTO> articleResponseDTOList = articleList.stream().map(article -> ArticleResponseDTO.from(article)).toList();
        return ApiResponse.response(GET_ALL_ARTICLE_SUCCESS.getCode(), GET_ALL_ARTICLE_SUCCESS.getMessage(), articleResponseDTOList);
    }

    @GetMapping("/article/{article_id}")
    @Operation(summary = "게시물 id 기반 조회 API")
    public ApiResponse<ArticleResponseDTO> getArticleById(@PathVariable Long article_id){

        articleRepository.findById(article_id);
        ArticleResponseDTO responseDTO = articleService.getArticleById(article_id);

        return ApiResponse.response(GET_ARTICLE_SUCCESS.getCode(), GET_ARTICLE_SUCCESS.getMessage(), responseDTO);
    }



    @PutMapping("/article/{article_id}")
    @Operation(summary = "게시물 수정 API")
    public ApiResponse<ArticleResponseDTO> updateArticle(
            @PathVariable Long article_id,
            @Valid @RequestBody ArticleRequestDTO.editArticle editArticleDTO) {
        articleService.updateArticle(article_id, editArticleDTO);
        return ApiResponse.response(EDIT_ARTICLE_SUCCESS.getCode(), EDIT_ARTICLE_SUCCESS.getMessage());

    }

    @DeleteMapping("/article/{articleId}")
    @Operation(summary = "게시물 삭제 API")
    public ApiResponse<Void> deleteArticle(@PathVariable Long articleId) {
        articleService.deleteArticle(articleId);
        return ApiResponse.response(DELETE_ARTICLE_SUCCESS.getCode(), DELETE_ARTICLE_SUCCESS.getMessage());
    }

    @PostMapping("/like/{id}")
    @Operation(summary = "게시물 관심 등록")
    public ApiResponse<Void> addLikeFolder(@PathVariable Long id, @AuthenticationPrincipal String name) {
        articleLikeService.addLikeArticle(id, name);
        return ApiResponse.response(FOLDER_LIKE_SUCCESS.getCode(), FOLDER_LIKE_SUCCESS.getMessage());
    }

    @DeleteMapping("/like/{id}")
    @Operation(summary = "게시물 관심 등록 해제")
    public ApiResponse<Void> deleteLikeFolder(@PathVariable Long id, @AuthenticationPrincipal String name) {
        articleLikeService.deleteLikeArticle(id, name);
        return ApiResponse.response(FOLDER_LIKE_REMOVE_SUCCESS.getCode(), FOLDER_LIKE_REMOVE_SUCCESS.getMessage());
    }
}
