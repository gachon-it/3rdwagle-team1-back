
package com.example.yoURL.domain.entity.Article.service;

import com.example.yoURL.domain.entity.Article.dto.ArticleRequestDTO;
import com.example.yoURL.domain.entity.Article.dto.ArticleResponseDTO;
import com.example.yoURL.domain.entity.Article.entity.Article;
import com.example.yoURL.domain.entity.Article.repository.ArticleRepository;
import com.example.yoURL.domain.entity.Folder.entity.entity.Folder;
import com.example.yoURL.domain.entity.Folder.entity.repository.FolderRepository;
import com.example.yoURL.domain.entity.Member.entity.Member;
import com.example.yoURL.domain.entity.Member.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final NameAndImageService nameAndImageService; // name, imageUrl 가져오는 서비스
    private final FolderRepository folderRepository;
    private final MemberRepository memberRepository;



        @Transactional
        public Long createArticle(ArticleRequestDTO.CreateArticle request) {
            // 1 member 조회 (Corrected to Member)
            Member member = memberRepository.findById(request.getMemberId())
                    .orElseThrow(() -> new EntityNotFoundException("Member not found with id: " + request.getMemberId())); // Corrected exception message


            Article article = request.toEntity(member); // DTO -> Entity
            log.info("Creating article: {}", article); // Added more informative log

            try{
                // 2. URL로부터 name, imageUrl 가져오기
                NameAndImageService.NameAndImage nameAndImage = nameAndImageService.fetchNameAndImage(request.getUrl());

                // 3. Article 엔티티에 name, imageUrl 설정
                article.setName(nameAndImage.getName());
                article.setImageUrl(nameAndImage.getImageUrl());
                article.setUrl(nameAndImage.getUrl());


                log.info("Successfully fetched name and image: Name={}, ImageUrl={}", nameAndImage.getName(), nameAndImage.getImageUrl()); // Added success log
            } catch (Exception e){
                log.error("Error fetching name and image from URL: {}", request.getUrl(), e); // Improved error logging, including URL and exception
                article.setName(null); // Or set to a default value like "" if preferred
                article.setImageUrl(null); // Or set to a default value like "" if preferred
                log.warn("Using default name and imageUrl due to fetching error."); // Added warning log
            }


            //4. db 저장
            article.setCreatedAt(LocalDateTime.now());
            Article savedArticle = articleRepository.save(article);
            log.info("Article saved successfully with ID: {}", savedArticle.getId()); // Added success log for saving
            return savedArticle.getId(); // 생성된 게시물 ID 반환
        }




    @Override
    @Transactional(readOnly = true)
    public List<ArticleResponseDTO> getAllArticles() {
        List<Article> articles = articleRepository.findAll();
        return articles.stream()
                .map(ArticleResponseDTO::from)
                .collect(Collectors.toList());
    }


    @Override
    @Transactional(readOnly = true)
    public ArticleResponseDTO getArticleById(Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Article not found"));
        return ArticleResponseDTO.from(article);
    }





    @Override
    public ArticleResponseDTO updateArticle(Long id, ArticleRequestDTO.editArticle request) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Article not found"));


        article.setName(request.getName());
        article.setUrl(request.getUrl());
        article.setDescription(request.getDescription());
        article.setImageUrl(request.getImageUrl());
        article.setRating(request.getRating());
        article.setUpdatedAt(LocalDateTime.now());

        Article updatedArticle = articleRepository.save(article);
        return ArticleResponseDTO.from(updatedArticle);
    }

    @Override
    public void deleteArticle(Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Article not found"));
        articleRepository.delete(article);
    }
}
