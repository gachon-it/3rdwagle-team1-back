package com.example.yoURL.domain.entity.Member.dto;

public record LoginResponse(
        Long userId,
        String token
) {
}
