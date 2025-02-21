package com.example.yoURL.domain.entity.Search.controller;

import static com.example.yoURL.domain.entity.Search.controller.ResponseMessage.SEARCH_SUCCESS;

import com.example.yoURL.domain.entity.Search.service.SearchService;
import com.example.yoURL.global.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "SearchController", description = "검색 관련 컨트롤러")
@RestController
@RequestMapping("/api/v1/search")
@RequiredArgsConstructor
public class SearchController {
    private final SearchService searchService;

    @GetMapping
    public ApiResponse<List<String>> search(@RequestParam String keyword) {
        List<String> result = searchService.search(keyword);
        return ApiResponse.response(SEARCH_SUCCESS.getCode(), SEARCH_SUCCESS.getMessage(), result);
    }
}
