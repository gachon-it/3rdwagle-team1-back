package com.example.yoURL.domain.entity.Folder.entity;

import com.example.yoURL.domain.entity.Article.entity.Article;
import com.example.yoURL.domain.entity.Member.entity.Member;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "folder",
       indexes = {
           @Index(name = "IDX_FOLDER_MEMBER_ID", columnList = "member_id"),
           @Index(name = "idx_folder_parent_folder_id", columnList = "parent_folder_id")
       })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "folder_id")
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_folder_id")
    private Folder parentFolder;

    @OneToMany(mappedBy = "parentFolder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Folder> childFolders;

    @OneToMany(mappedBy = "folder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Article> articles;


    // 부모 폴더 추가 메서드
    public void setParentFolder(Folder parentFolder) {
        this.parentFolder = parentFolder;
        if(parentFolder != null){
            parentFolder.getChildFolders().add(this);
        }
    }

}
