package com.example.yoURL.domain.entity.Folder.entity.entity;

import com.example.yoURL.domain.entity.Member.entity.Member;
import com.example.yoURL.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @ManyToMany(mappedBy = "likes")
    private List<Member> likeMember = new ArrayList<>();

    // 폴더 이름 변경 메서드
    public void rename(String newName) {
        this.name = newName;
    }

    @Column(name = "date")
    private LocalDate date;


    // createDate와 updateDate는 BaseEntity에서 상속받아서 자동으로 관리됨
    // 따라서 getCreatedAt()과 getUpdatedAt() 메서드는 필요하지 않음.
    // BaseEntity에서 제공되는 메서드를 직접 사용할 수 있음
}
