package com.example.yoURL.domain.entity.Article.entity;

import com.example.yoURL.domain.entity.Member.entity.Member;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "article")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long id;


    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "url", length = 250)
    private String url;

    @Column(name = "description", length = 250)
    private String description;

    @Column(name = "image_url", length = 250)
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "rating")
    private Rating rating;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;


    public enum Rating {
        ONE, TWO, THREE, FOUR, FIVE
    }

}
