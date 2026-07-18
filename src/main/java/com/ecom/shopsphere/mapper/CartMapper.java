package com.ecom.shopsphere.mapper;

import com.ecom.shopsphere.dto.request.CartRequestDto;
import com.ecom.shopsphere.dto.response.CartResponseDto;
import com.ecom.shopsphere.entity.Cart;
import com.ecom.shopsphere.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartMapper {

    Cart toEntity(CartRequestDto dto);
    CartResponseDto toResponsDto(Cart cart);
    List<CartResponseDto>toResponseDtoList(List<Cart> cartList);
}
