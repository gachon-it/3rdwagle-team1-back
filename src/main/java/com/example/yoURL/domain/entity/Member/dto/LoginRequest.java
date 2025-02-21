package com.example.yoURL.domain.entity.Member.dto;

public record LoginRequest(
        String name
) {
    public static LoginRequest from(String name) {
        return new LoginRequest(name);
    }
}
