package com.example.yoURL.domain.entity.Article.repository;

import com.example.yoURL.domain.entity.Article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
//    List<Article> findAllByMemberId(Long memberId);
        List<Article> findByMemberId(Long memberId);
//    Article findByName(String name);
boolean existsByUrl(String url);
}
