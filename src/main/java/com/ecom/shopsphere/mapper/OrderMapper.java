package com.ecom.shopsphere.mapper;

import com.ecom.shopsphere.dto.request.OrderRequestDto;
import com.ecom.shopsphere.dto.response.OrderResponseDto;
import com.ecom.shopsphere.entity.Category;
import com.ecom.shopsphere.entity.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    Order toEntity(OrderRequestDto dto );
    OrderResponseDto toResponsedto (Order order);

    List<OrderResponseDto>toResponseDtoList(List<Order> OrderList);

}
