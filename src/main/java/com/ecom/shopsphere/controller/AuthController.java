package com.ecom.shopsphere.controller;
import com.ecom.shopsphere.dto.request.LoginRequestDto;
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
    public String healthcheck(){
        return "Application is Running !!";
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> loginUser(@Valid @RequestBody LoginRequestDto dto) {
      LoginResponseDto response= userService.login(dto);
      return ResponseEntity.ok(response);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?>registeruser(@Valid @RequestBody RegisterRequestDto dto){
        RegisterResponseDto response=userService.registerUser(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }




}
