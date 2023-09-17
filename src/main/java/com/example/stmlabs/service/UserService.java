package com.example.stmlabs.service;

import com.example.stmlabs.dto.UserDto;

public interface UserService {
    UserDto getUser(Authentication authentication);

    UserDto updateUser(UserDto newUserDto, Authentication authentication);
}
