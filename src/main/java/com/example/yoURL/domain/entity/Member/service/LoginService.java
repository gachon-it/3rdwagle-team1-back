package com.example.yoURL.domain.entity.Member.service;

import com.example.yoURL.domain.entity.Member.dto.LoginResponse;
import com.example.yoURL.domain.entity.Member.entity.Member;
import com.example.yoURL.domain.entity.Member.exception.MemberNotFoundException;
import com.example.yoURL.domain.entity.Member.repository.MemberRepository;
import com.example.yoURL.global.common.auth.jwt.JwtProvider;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;
    private final JwtProvider jwtProvider;

    public LoginResponse authenticate(String name, HttpServletResponse response) {
        Member member = memberRepository.findByName(name)
                .orElseThrow(MemberNotFoundException::new);

        String token = jwtProvider.generateAccessToken(name);
        response.setHeader("Authorization", "Bearer " + token);

        return new LoginResponse(member.getId(), token);
    }
}
