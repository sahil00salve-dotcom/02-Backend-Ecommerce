package com.ecom.shopsphere.mapper;

import com.ecom.shopsphere.dto.request.CategoryRequestDto;
import com.ecom.shopsphere.dto.response.CartResponseDto;
import com.ecom.shopsphere.dto.response.CategoryResponseDto;
import com.ecom.shopsphere.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toEntity(CategoryRequestDto dto);
    CartResponseDto toResponseDto(Category category);
    List<CategoryResponseDto> toResponseDtoList(List<Category>categoryList);

}
