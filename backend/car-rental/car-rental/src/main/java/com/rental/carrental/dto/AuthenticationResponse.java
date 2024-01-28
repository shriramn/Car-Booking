package com.rental.carrental.dto;

import com.rental.carrental.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String jwt;
    private UserRole userRole;
    private Long userId;

}
