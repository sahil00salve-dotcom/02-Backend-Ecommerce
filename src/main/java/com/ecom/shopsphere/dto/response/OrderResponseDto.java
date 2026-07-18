package com.ecom.shopsphere.dto.response;

import com.ecom.shopsphere.enums.OrderStatus;
import com.ecom.shopsphere.enums.PaymentMethod;
import com.ecom.shopsphere.enums.PaymentStatus;
import jakarta.persistence.Entity;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponseDto {

    private Long id;

    private String orderNumber;

    private BigDecimal totalAmount;

    private OrderStatus orderStatus;

    private PaymentStatus paymentStatus;

    private PaymentMethod paymentMethod;

    private LocalDateTime orderDate;

    private LocalDateTime deliveredDate;

}
