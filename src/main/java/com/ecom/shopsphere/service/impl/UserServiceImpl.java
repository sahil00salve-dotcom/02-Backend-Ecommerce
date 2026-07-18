package com.ecom.shopsphere.service.impl;

import com.ecom.shopsphere.dto.request.LoginRequestDto;
import com.ecom.shopsphere.dto.request.RegisterRequestDto;
import com.ecom.shopsphere.dto.response.LoginResponseDto;
import com.ecom.shopsphere.dto.response.RegisterResponseDto;
import com.ecom.shopsphere.dto.response.UserResponseDto;
import com.ecom.shopsphere.entity.RefreshToken;
import com.ecom.shopsphere.entity.User;
import com.ecom.shopsphere.enums.AccountStatus;
import com.ecom.shopsphere.enums.Role;
import com.ecom.shopsphere.mapper.UserMapper;
import com.ecom.shopsphere.repository.UserRepository;
import com.ecom.shopsphere.service.RefreshTokenService;
import com.ecom.shopsphere.service.UserService;
import com.ecom.shopsphere.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RefreshTokenService refreshTokenService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private  UserMapper userMapper;

    public RegisterResponseDto registerUser(RegisterRequestDto dto){
       User user= userMapper.toEntity(dto);
        user.setRole(Role.USER);
        user.setAccountStatus(AccountStatus.ACTIVE);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepository.save(user);
        return userMapper.toRegisterResponseDto(user);
    }

    public RegisterResponseDto registerAdmin(RegisterRequestDto dto){
        User user= userMapper.toEntity(dto);
        user.setAccountStatus(AccountStatus.ACTIVE);
        user.setRole(Role.ADMIN);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepository.save(user);
        return userMapper.toRegisterResponseDto(user);

    }

    public LoginResponseDto login(LoginRequestDto dto) {

        // 1. Authenticate user
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                dto.getEmail(),
                                dto.getPassword()
                        )
                );

        // 2. Get authenticated user
        UserDetails userDetails =
                (UserDetails) authentication.getPrincipal();

        // 3. Get full user entity
        User user = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // 4. Generate JWT
        String accessToken = jwtUtil.generateToken(userDetails.getUsername());

        // 5. Generate refresh token (if using one)
        RefreshToken refreshToken =
                refreshTokenService.createRefreshToken(user);

        UserResponseDto userDto =
                userMapper.toResponseDto(user);

        return LoginResponseDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken.getToken())
                .user(userDto)
                .build();
    }

    public List<UserResponseDto> getAllUsers(){
     return null;
    }

    public UserResponseDto getUserByEmail(String email){
    return null;
    }

    public void deleteUser(String email){

    }


}
