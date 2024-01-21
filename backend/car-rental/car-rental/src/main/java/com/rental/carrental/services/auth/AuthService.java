package com.rental.carrental.services.auth;

import com.rental.carrental.dto.SignUpRequest;
import com.rental.carrental.dto.UserDto;

public interface AuthService {

    UserDto createCustomer(SignUpRequest signUpRequest);
    boolean hasCustomerWithEmail(String email);
}
