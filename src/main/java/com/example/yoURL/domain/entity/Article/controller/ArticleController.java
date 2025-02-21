package com.example.yoURL.domain.entity.Article.controller;

import com.example.yoURL.domain.entity.Article.dto.ArticleRequestDTO;
import com.example.yoURL.domain.entity.Article.dto.ArticleResponseDTO;
import com.example.yoURL.domain.entity.Article.entity.Article;
import com.example.yoURL.domain.entity.Article.repository.ArticleRepository;
import com.example.yoURL.domain.entity.Article.service.ArticleService;
import com.example.yoURL.domain.entity.Folder.entity.entity.Folder;
import com.example.yoURL.domain.entity.Folder.entity.repository.FolderRepository;
import com.example.yoURL.domain.entity.Folder.entity.service.FolderService;
import com.example.yoURL.global.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.yoURL.domain.entity.Article.controller.ArticleResponseMessage.*;

@Tag(name = "ArticleController", description = "게시글 관련 컨트롤러")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Validated
public class ArticleController {

    private final ArticleService articleService;
    private final FolderService folderService;
    private final FolderRepository folderRepository;
    private final ArticleRepository articleRepository;

    @PostMapping("/article")
    @Operation(summary = "게시물 등록 API")
    public ApiResponse<Void> createArticle(@RequestBody @Valid ArticleRequestDTO.CreateArticle request) {
        articleService.createArticle(request);
        return ApiResponse.response(ADD_ARTICLE_SUCCESS.getCode(), ADD_ARTICLE_SUCCESS.getMessage());
    }

//    @GetMapping("/")
//    @Operation(summary = "폴더 if게시물 전체 조회 API")
//    public ApiResponse<List<ArticleResponseDTO>> getAllArticles() {
//        List<ArticleResponseDTO> responseDTO = articleService.getAllArticles();
//        return ApiResponse.response(GET_ALL_ARTICLE_SUCCESS.getCode(), GET_ALL_ARTICLE_SUCCESS.getMessage(), responseDTO);
//    }

    @GetMapping("/{folder_id}")
    @Operation(summary = "폴더 id 기반 게시물,폴더 전체 조회 API")
    public ApiResponse<List<ArticleResponseDTO>> getLowerFolderArticleById(@PathVariable Long folder_id){
        Folder folder = folderRepository.findById(folder_id).orElse(null);
        long memberId = folder.getMember().getId();
        List<Article> articleList = articleRepository.findByMemberId(memberId);
        List<ArticleResponseDTO> articleResponseDTOList = articleList.stream().map(article -> ArticleResponseDTO.from(article)).toList();
        return ApiResponse.response(GET_ARTICLE_SUCCESS.getCode(), GET_ARTICLE_SUCCESS.getMessage(), articleResponseDTOList);
    }

    @GetMapping("/article/{folder_id}")
    @Operation(summary = "특정 폴더 id 기반 게시물 단건 조회 API")
    public ApiResponse<ArticleResponseDTO> getArticleById(@PathVariable Long folder_id){

        folderRepository.findById(folder_id);
        ArticleResponseDTO responseDTO = articleService.getArticleById(folder_id);

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
}
