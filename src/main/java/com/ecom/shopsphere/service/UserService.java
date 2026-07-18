package com.ecom.shopsphere.service;

import com.ecom.shopsphere.dto.request.LoginRequestDto;
import com.ecom.shopsphere.dto.request.RegisterRequestDto;
import com.ecom.shopsphere.dto.response.LoginResponseDto;
import com.ecom.shopsphere.dto.response.RegisterResponseDto;
import com.ecom.shopsphere.dto.response.UserResponseDto;
import com.ecom.shopsphere.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    RegisterResponseDto registerUser(RegisterRequestDto dto);

    RegisterResponseDto registerAdmin(RegisterRequestDto dto);

    LoginResponseDto login(LoginRequestDto dto);

    List<UserResponseDto> getAllUsers();

    UserResponseDto getUserByEmail(String email);

    void deleteUser(String email);

}
