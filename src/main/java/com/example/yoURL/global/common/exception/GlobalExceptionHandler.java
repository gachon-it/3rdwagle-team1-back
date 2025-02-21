package com.example.yoURL.global.common.exception;

import com.example.yoURL.global.common.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final int SERVER_ERROR_CODE = 500;
    private static final String SERVER_ERROR_MESSAGE = "에러가 발생했습니다.";

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ApiResponse<Void>> handleBaseException(BaseException e) {
        ApiResponse<Void> response = ApiResponse.response(e.getErrorCode(), e.getMessage(), null);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleException() {
        ApiResponse<Void> response = ApiResponse.response(SERVER_ERROR_CODE, SERVER_ERROR_MESSAGE, null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
