package com.ecom.shopsphere.mapper;

import com.ecom.shopsphere.dto.request.RefreshTokenRequestDto;
import com.ecom.shopsphere.dto.response.RefreshTokenResponseDto;
import com.ecom.shopsphere.entity.RefreshToken;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RefreshTokenMapper {

    RefreshToken toEntity(RefreshTokenRequestDto dto);
    RefreshTokenResponseDto toResponseDto(RefreshToken refreshToken);

}
