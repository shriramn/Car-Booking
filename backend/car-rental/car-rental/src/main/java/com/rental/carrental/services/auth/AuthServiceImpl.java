package com.rental.carrental.services.auth;


import com.rental.carrental.dto.SignUpRequest;
import com.rental.carrental.dto.UserDto;
import com.rental.carrental.entity.User;
import com.rental.carrental.enums.UserRole;
import com.rental.carrental.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @PostConstruct
    public void createAdminAccount() {
        User user = userRepository.findByUserRole(UserRole.ADMIN);
        if (user == null) {
            User admin = new User();
            admin.setName("Admin");
            admin.setEmail("Administrator@gmail.com");
            admin.setPassword(new BCryptPasswordEncoder().encode("admin1234")) ;
            admin.setUserRole(UserRole.ADMIN);
            userRepository.save(admin);
            System.out.println("Admin Account Created" +
                    "");
            return;
        }
    }

    @Override
    public UserDto createCustomer(SignUpRequest signUpRequest) {
        User user = new User();
        user.setName(signUpRequest.getName());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(signUpRequest.getPassword()));
        user.setUserRole(UserRole.CUSTOMER);
        User createdUser = userRepository.save(user);
        UserDto userDto = new UserDto();
        userDto.setId(createdUser.getId());
        return userDto;
    }

    @Override
    public boolean hasCustomerWithEmail(String email) {

        return userRepository.findFirstByEmail(email).isPresent();
    }
}
