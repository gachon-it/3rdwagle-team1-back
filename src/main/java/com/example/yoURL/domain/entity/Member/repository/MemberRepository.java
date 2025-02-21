package com.example.yoURL.domain.entity.Member.repository;

import com.example.yoURL.domain.entity.Member.entity.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByName(String name);

    boolean existsByName(String name);
}
