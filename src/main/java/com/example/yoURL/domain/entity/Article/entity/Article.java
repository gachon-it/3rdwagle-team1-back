package com.example.yoURL.domain.entity.Article.entity;

import com.example.yoURL.domain.entity.Folder.entity.Folder;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "article",
       indexes = @Index(name = "IDX_ARTICLE_FOLDER_ID", columnList = "folder_id"))
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "folder_id", nullable = false)
    private Folder folder;

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



    public enum Rating {
        ONE, TWO, THREE, FOUR, FIVE
    }
}
