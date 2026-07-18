package com.ecom.shopsphere.mapper;

import com.ecom.shopsphere.dto.request.LoginRequestDto;
import com.ecom.shopsphere.dto.request.RegisterRequestDto;
import com.ecom.shopsphere.dto.response.RegisterResponseDto;
import com.ecom.shopsphere.dto.response.UserResponseDto;
import com.ecom.shopsphere.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(RegisterRequestDto dto);

    UserResponseDto toResponseDto(User user);

    List<UserResponseDto> toResponseDtoList(List<User> users);

    RegisterResponseDto toRegisterResponseDto(User user);


}