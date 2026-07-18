package com.ecom.shopsphere.dto.response;

import com.ecom.shopsphere.entity.Product;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryResponseDto {


    private Long id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private List<Product> products;
}
