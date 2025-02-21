package com.example.yoURL.domain.entity.Folder.entity.entity;

import com.example.yoURL.domain.entity.Article.entity.Article;
import com.example.yoURL.domain.entity.Member.entity.Member;
import com.example.yoURL.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "folder",
       indexes = {
           @Index(name = "IDX_FOLDER_MEMBER_ID", columnList = "member_id"),
       })
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)  // 기본 생성자 보호
@AllArgsConstructor
@Builder
public class Folder extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "folder_id")
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    // ✅ 북마크 상태 (0: 북마크 안됨, 1: 북마크 됨)
    @Column(name = "bookmark", nullable = false)
    private int bookmark = 0;

    // 폴더 이름 변경 메서드
    public void rename(String newName) {
        this.name = newName;
    }

    // ✅ 북마크 토글 메서드
    public void toggleBookmark() {
        this.bookmark = (this.bookmark == 0) ? 1 : 0;
    }
}