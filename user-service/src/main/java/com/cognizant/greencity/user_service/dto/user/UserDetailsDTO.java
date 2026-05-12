package com.cognizant.greencity.user_service.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsDTO {
    private Integer userId;
    private String name;
    private String email;
    private String phone;
    private String role;
    private String status;
    private String password;
}
