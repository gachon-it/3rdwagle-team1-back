package com.example.yoURL.domain.entity.Search.service;

import com.example.yoURL.domain.entity.Search.repository.SearchRepository;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class SearchService {
    private final SearchRepository searchRepository;

    public List<String> search(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return Collections.emptyList();
        }

        List<String> folders = searchRepository.searchFolders(keyword);
        List<String> articles = searchRepository.searchArticles(keyword);

        List<String> result = new ArrayList<>();
        result.addAll(folders);
        result.addAll(articles);

        return result;
    }
}
