package com.example.yoURL.domain.entity.Member.entity;

import com.example.yoURL.domain.entity.Folder.entity.Folder;
import com.example.yoURL.domain.entity.Member.dto.SignupRequest;
import com.example.yoURL.domain.entity.Member.exception.EmptyNameException;
import com.example.yoURL.domain.entity.Member.exception.TooLongNameException;
import com.example.yoURL.global.common.entity.BaseEntity;
import jakarta.persistence.*;
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
}






