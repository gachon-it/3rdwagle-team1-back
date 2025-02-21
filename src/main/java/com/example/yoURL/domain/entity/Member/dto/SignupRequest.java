package com.example.yoURL.domain.entity.Member.dto;

public record SignupRequest(
        String name
) {
    public static SignupRequest from(String name) {
        return new SignupRequest(name);
    }
}
