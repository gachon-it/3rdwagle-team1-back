package com.example.yoURL.domain.entity.Article.service;

import com.example.yoURL.domain.entity.Article.entity.Article;
import com.example.yoURL.domain.entity.Article.exception.ArticleAlreadyLikedException;
import com.example.yoURL.domain.entity.Article.exception.ArticleNotFoundException;
import com.example.yoURL.domain.entity.Article.exception.ArticleNotLikedException;
import com.example.yoURL.domain.entity.Article.repository.ArticleRepository;
import com.example.yoURL.domain.entity.Member.entity.Member;
import com.example.yoURL.domain.entity.Member.exception.MemberNotFoundException;
import com.example.yoURL.domain.entity.Member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ArticleLikeService {

    private final ArticleRepository articleRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void addLikeArticle(Long id, String name) {
        Member member = memberRepository.findByName(name)
                .orElseThrow(MemberNotFoundException::new);
        Article article = articleRepository.findById(id)
                .orElseThrow(ArticleNotFoundException::new);

        if (member.getLikes().contains(article)) {
            throw new ArticleAlreadyLikedException();
        }
        member.addLike(article);
        memberRepository.save(member);
    }

    @Transactional // 관심 게시물 삭제
    public void deleteLikeArticle(Long id, String name) {
        Member member = memberRepository.findByName(name)
                .orElseThrow(MemberNotFoundException::new);
        Article article = articleRepository.findById(id)
                .orElseThrow(ArticleNotFoundException::new);

        if (!member.getLikes().contains(article)) {
            throw new ArticleNotLikedException();
        }
        member.deleteLike(article);
        memberRepository.save(member);
    }
}
