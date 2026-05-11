package com.cognizant.greencity.authentication_service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private String name;
    private String email;
    private String password;
    private String phone;
}
