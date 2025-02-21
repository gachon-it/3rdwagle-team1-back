package com.example.yoURL.domain.entity;

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
    private Long id;

    private String name;
    private String url;
    private String description;
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "folder_id", nullable = false)
    private Folder folder;

    public enum Rating {
        ONE, TWO, THREE, FOUR, FIVE
    }
}
