package com.example.yoURL.domain.entity.Search.repository;

import com.example.yoURL.domain.entity.Folder.entity.entity.Folder;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchRepository extends JpaRepository<Folder, Long> {
    @Query("SELECT f.name FROM Folder f WHERE f.name LIKE :keyword% ORDER BY f.name ASC")
    List<String> searchFolders(@Param("keyword") String keyword);

    @Query("SELECT a.name FROM Article a WHERE a.name LIKE :keyword% ORDER BY a.name ASC")
    List<String> searchArticles(@Param("keyword") String keyword);
}
