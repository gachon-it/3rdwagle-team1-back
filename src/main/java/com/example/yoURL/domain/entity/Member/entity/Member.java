package com.example.yoURL.domain.entity.Member.entity;

import com.example.yoURL.domain.entity.Article.entity.Article;
import com.example.yoURL.domain.entity.Folder.entity.entity.Folder;
import com.example.yoURL.domain.entity.Member.dto.SignupRequest;
import com.example.yoURL.domain.entity.Member.exception.EmptyNameException;
import com.example.yoURL.domain.entity.Member.exception.TooLongNameException;
import com.example.yoURL.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import java.util.ArrayList;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "member")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "name", length = 10, nullable = false)
    private String name;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Folder> folders;

    @ManyToMany
    @JoinTable(name = "likes", joinColumns = @JoinColumn(name = "member_id"), inverseJoinColumns = @JoinColumn(name = "folder_id"))
    private List<Folder> likes = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "member_liked_articles", joinColumns = @JoinColumn(name = "member_id"), inverseJoinColumns = @JoinColumn(name = "article_id"))
    private List<Article> likedArticles = new ArrayList<>();

    public Member(String name) {
        this.name = name;
    }

    public static Member create(SignupRequest request) {
        Member member = new Member(request.name());
        member.validateName();
        return member;
    }

    public void validateName() {
        if (this.name == null || this.name.trim().isEmpty()) {
            throw new EmptyNameException();
        }
        if (this.name.length() > 9) {
            throw new TooLongNameException();
        }
    }

    public void addLike(Folder folder) {
        if (!likes.contains(folder)) {
            likes.add(folder);
        }
    }

    public void deleteLike(Folder folder) {
        likes.remove(folder);
    }

    public void addLike(Article article) {
        if (!likedArticles.contains(article)) {
            likedArticles.add(article);
        }
    }

    public void deleteLike(Article article) {
        likedArticles.remove(article);
    }
}






