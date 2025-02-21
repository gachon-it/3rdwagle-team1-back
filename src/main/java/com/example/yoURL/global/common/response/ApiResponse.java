package com.example.yoURL.global.common.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private Integer code;
    private String message;
    private T result;

    public static <T> ApiResponse<T> response(int code, String message, T data) {
        return new ApiResponse<>(code, message, data);
    }

    public static <T> ApiResponse<T> response(int code, String message) {
        return new ApiResponse<>(code, message, null);
    }
}
