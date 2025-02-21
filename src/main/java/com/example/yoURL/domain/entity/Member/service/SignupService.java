package com.example.yoURL.domain.entity.Member.service;

import com.example.yoURL.domain.entity.Member.dto.SignupRequest;
import com.example.yoURL.domain.entity.Member.entity.Member;
import com.example.yoURL.domain.entity.Member.exception.DuplicatedNameException;
import com.example.yoURL.domain.entity.Member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupService {

    private final MemberRepository memberRepository;

    @Transactional
    public void signup(SignupRequest request) {
        validate(request);
        Member member = Member.create(request);
        memberRepository.save(member);
    }

    private void validate(SignupRequest request) {
        if (memberRepository.existsByName(request.name())) {
            throw new DuplicatedNameException();
        }

    }
}
