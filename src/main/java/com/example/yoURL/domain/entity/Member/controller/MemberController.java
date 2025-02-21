package com.example.yoURL.domain.entity.Member.controller;

import static com.example.yoURL.domain.entity.Member.controller.ResponseMessage.LOGIN_SUCCESS;
import static com.example.yoURL.domain.entity.Member.controller.ResponseMessage.SIGNUP_SUCCESS;
import com.example.yoURL.domain.entity.Member.dto.LoginRequest;
import com.example.yoURL.domain.entity.Member.dto.LoginResponse;
import com.example.yoURL.domain.entity.Member.dto.SignupRequest;
import com.example.yoURL.domain.entity.Member.service.LoginService;
import com.example.yoURL.domain.entity.Member.service.SignupService;
import com.example.yoURL.global.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "UserController", description = "사용자 관련 컨트롤러")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {

    private final SignupService signupService;
    private final LoginService loginService;

    @PostMapping("/signup")
    @Operation(summary = "회원가입")
    public ApiResponse<Void> ceoSignup(@RequestBody @Valid SignupRequest request) {
        signupService.signup(request);
        return ApiResponse.response(SIGNUP_SUCCESS.getCode(), SIGNUP_SUCCESS.getMessage());
    }

    @PostMapping("/login")
    @Operation(summary = "로그인")
    public ApiResponse<LoginResponse> login(@RequestBody LoginRequest request, HttpServletResponse response) {
        LoginResponse loginResponse = loginService.authenticate(request.name(), response);
        return ApiResponse.response(LOGIN_SUCCESS.getCode(), LOGIN_SUCCESS.getMessage(), loginResponse);
    }
}