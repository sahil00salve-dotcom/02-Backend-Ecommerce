package com.ecom.shopsphere.dto.response;

import com.ecom.shopsphere.enums.AccountStatus;
import com.ecom.shopsphere.enums.Role;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterResponseDto {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private Role role;

    private AccountStatus accountStatus;

    private LocalDateTime createdAt;
}


