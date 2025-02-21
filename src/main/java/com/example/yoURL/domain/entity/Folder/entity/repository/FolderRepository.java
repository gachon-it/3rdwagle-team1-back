package com.example.yoURL.domain.entity.Folder.entity.repository;

import com.example.yoURL.domain.entity.Folder.entity.entity.Folder;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FolderRepository extends JpaRepository<Folder, Long> {

    // 같은 이름의 폴더가 존재하는지 확인 (멤버 정보 없이 이름만 체크)
    boolean existsByName(String name);

    // 특정 폴더 ID가 존재하는지 확인
    boolean existsById(Long id);

    // 특정 폴더를 조회
    Optional<Folder> findById(Long id);

    Optional<Folder> findByNameAndMemberId(String name,Long id);

    List<Folder> findAllByMemberId(Long memberId);
}