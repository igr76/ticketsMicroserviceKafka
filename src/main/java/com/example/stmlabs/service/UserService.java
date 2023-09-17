package com.example.stmlabs.service;
import com.example.stmlabs.dto.UserDto;
import org.springframework.security.core.Authentication;

public interface UserService {
    UserDto getUser(String login,Authentication authentication);

    UserDto updateUser(UserDto newUserDto, Authentication authentication);

    void deleteUser(String login, Authentication authentication);
}
