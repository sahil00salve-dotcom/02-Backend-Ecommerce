package com.ecom.shopsphere.controller;

import com.ecom.shopsphere.dto.ApiResponse;
import com.ecom.shopsphere.dto.request.LoginRequestDto;
import com.ecom.shopsphere.dto.request.RefreshTokenRequestDto;
import com.ecom.shopsphere.dto.request.RegisterRequestDto;
import com.ecom.shopsphere.dto.response.LoginResponseDto;
import com.ecom.shopsphere.dto.response.RegisterResponseDto;
import com.ecom.shopsphere.dto.response.UserResponseDto;
import com.ecom.shopsphere.entity.RefreshToken;
import com.ecom.shopsphere.entity.User;
import com.ecom.shopsphere.mapper.UserMapper;
import com.ecom.shopsphere.service.RefreshTokenService;
import com.ecom.shopsphere.service.UserService;
import com.ecom.shopsphere.service.impl.UserServiceImpl;
import com.ecom.shopsphere.util.JwtUtil;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private RefreshTokenService refreshTokenService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @GetMapping("/Health-Check")
    public String healthcheck() {
        return "Application is Running !!";
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponseDto>> loginUser(@Valid @RequestBody LoginRequestDto dto) {
        LoginResponseDto response = userService.login(dto);
        return ResponseEntity.ok(
                ApiResponse.<LoginResponseDto>builder()
                        .success(true)
                        .message("Login Successful")
                        .data(response)
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

    @PostMapping("/sign-up")
    public ResponseEntity<ApiResponse<RegisterResponseDto>> registeruser(@Valid @RequestBody RegisterRequestDto dto) {
        RegisterResponseDto response = userService.registerUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<RegisterResponseDto>builder()
                        .success(true)
                        .message("Sign-up Successful")
                        .data(response)
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

    @PostMapping("/logout")
    public ResponseEntity<ApiResponse<?>> logout(@Valid @RequestBody RefreshTokenRequestDto dto) {
        System.out.println("Logout endpoint hit");
        refreshTokenService.deleteByToken(dto.getRefreshToken());
        return ResponseEntity.ok(
                ApiResponse.<String>builder()
                        .success(true)
                        .message("Logged out Successfully")
                        .data(null)
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

    @PostMapping("/refresh")
    public ResponseEntity<ApiResponse<LoginResponseDto>> refresh(
            @Valid @RequestBody RefreshTokenRequestDto dto) {

        LoginResponseDto response = userService.refreshAccessToken(dto);
        return ResponseEntity.ok(
                ApiResponse.<LoginResponseDto>builder()
                        .success(true)
                        .message("Refresh Successful")
                        .data(response)
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

}
