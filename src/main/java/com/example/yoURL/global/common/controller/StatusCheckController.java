package com.example.yoURL.global.common.controller;

import com.example.yoURL.global.common.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusCheckController {

    @GetMapping("/health-check")
    public ResponseEntity<ApiResponse<Void>> checkHealthStatus() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
