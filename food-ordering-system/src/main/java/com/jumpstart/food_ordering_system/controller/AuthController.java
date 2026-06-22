package com.jumpstart.food_ordering_system.controller;

import com.jumpstart.food_ordering_system.dto.auth.LoginRequest;
import com.jumpstart.food_ordering_system.dto.auth.LoginResponse;
import com.jumpstart.food_ordering_system.dto.auth.RegisterRequest;
import com.jumpstart.food_ordering_system.response.Response;
import com.jumpstart.food_ordering_system.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Response<Void>> register(@Valid @RequestBody RegisterRequest request) {
        authService.register(request);
        return ResponseEntity.ok(Response.success("User registered successfully", null));
    }

    @PostMapping("/login")
    public ResponseEntity<Response<LoginResponse>> login(@Valid @RequestBody LoginRequest request) {
        LoginResponse response = authService.login(request);
        return ResponseEntity.ok(Response.success("Login successful", response));
    }
}