package com.example.yoURL.global.common.auth.jwt;

import lombok.Builder;

@Builder
public record JwtResponse(
        String accessToken,
        String refreshToken
) {
}
