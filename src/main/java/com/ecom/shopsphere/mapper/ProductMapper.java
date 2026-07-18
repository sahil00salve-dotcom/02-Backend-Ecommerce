package com.ecom.shopsphere.mapper;

import com.ecom.shopsphere.dto.request.ProductRequestDto;
import com.ecom.shopsphere.dto.response.ProductResponseDto;
import com.ecom.shopsphere.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toEntity(ProductRequestDto dto);
    ProductResponseDto toResponseDto(Product product);
    List<ProductResponseDto> toResponseDtoList(List<Product> products);

}
