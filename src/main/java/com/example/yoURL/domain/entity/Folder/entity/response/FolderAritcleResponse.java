package com.example.yoURL.domain.entity.Folder.entity.response;


import com.example.yoURL.domain.entity.Article.entity.Article;
import com.example.yoURL.domain.entity.Folder.entity.entity.Folder;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FolderAritcleResponse {
    private Long id;
    private String name;
    private Article article;

    @Builder
    private FolderAritcleResponse(Long id, String name, Article article) {
        this.id = id;
        this.name = name;
        this.article = article;
    }

    public static FolderAritcleResponse of(Long id, String name, Article article) {
        return FolderAritcleResponse.builder()
                .id(id)
                .name(name)
                .article(article)
                .build();
    }

}
