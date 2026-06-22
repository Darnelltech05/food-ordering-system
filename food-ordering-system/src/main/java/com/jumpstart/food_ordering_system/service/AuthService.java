package com.jumpstart.food_ordering_system.service;

import com.jumpstart.food_ordering_system.dto.auth.LoginRequest;
import com.jumpstart.food_ordering_system.dto.auth.LoginResponse;
import com.jumpstart.food_ordering_system.dto.auth.RegisterRequest;
import com.jumpstart.food_ordering_system.entity.Role;
import com.jumpstart.food_ordering_system.entity.User;
import com.jumpstart.food_ordering_system.exception.BadRequestException;
import com.jumpstart.food_ordering_system.repository.RoleRepository;
import com.jumpstart.food_ordering_system.repository.UserRepository;
import com.jumpstart.food_ordering_system.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    public void register(RegisterRequest request) {
        // Check if email already exists
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new BadRequestException("Email already registered");
        }

        // Get CUSTOMER role
        Role customerRole = roleRepository.findByName("CUSTOMER")
                .orElseThrow(() -> new RuntimeException("CUSTOMER role not found"));

        // Create new user
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phoneNumber(request.getPhoneNumber())
                .address(request.getAddress())
                .active(true)
                .roles(Collections.singletonList(customerRole))
                .build();

        userRepository.save(user);
    }

    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BadCredentialsException("Invalid credentials"));

        // Check if user is active
        if (!user.isActive()) {
            throw new BadRequestException("Account is inactive. Please contact support.");
        }

        // Verify password
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Invalid credentials");
        }

        // Generate token
        String token = jwtUtils.generateToken(user.getEmail());

        // Extract role names
        List<String> roles = user.getRoles().stream()
                .map(Role::getName)
                .collect(Collectors.toList());

        return LoginResponse.builder()
                .token(token)
                .email(user.getEmail())
                .name(user.getName())
                .roles(roles)
                .build();
    }
}