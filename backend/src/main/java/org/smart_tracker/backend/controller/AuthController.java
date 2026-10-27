package org.smart_tracker.backend.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.smart_tracker.backend.dto.request.AuthRequest;
import org.smart_tracker.backend.dto.response.ApiResponse;
import org.smart_tracker.backend.dto.response.AuthResponse;
import org.smart_tracker.backend.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ApiResponse<AuthResponse> register(@Valid @RequestBody AuthRequest request) {
        return ApiResponse.success(authService.register(request));
    }

    @PostMapping("/login")
    public ApiResponse<AuthResponse> login(@Valid @RequestBody AuthRequest request) {
        return ApiResponse.success(authService.login(request));
    }
}
