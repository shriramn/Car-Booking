package com.rental.carrental.controller;

import com.rental.carrental.dto.SignUpRequest;
import com.rental.carrental.dto.UserDto;
import com.rental.carrental.services.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signupCustomer(@RequestBody SignUpRequest signUpRequest){
        if(authService.hasCustomerWithEmail(signUpRequest.getEmail())) return new ResponseEntity<>("Email already exists", HttpStatus.NOT_ACCEPTABLE);
        UserDto createdCustomerDto =authService.createCustomer(signUpRequest);
        if(createdCustomerDto==null) return new ResponseEntity<>("Customer not created, come again later", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(createdCustomerDto, HttpStatus.CREATED);

    }
}
