package com.woong.tacocloud.security;

import com.woong.tacocloud.domain.User;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {
    private final String username;
    private final String password;
    private final String fullname;
    private final String street;
    private final String city;
    private final String state;
    private final String zip;
    private final String phone;

    public User toUser(PasswordEncoder passwordEncoder)
    {
        return User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .fullname(fullname)
                .street(street)
                .city(city)
                .state(state)
                .zip(zip)
                .phoneNumber(phone)
                .build();
    }
}
