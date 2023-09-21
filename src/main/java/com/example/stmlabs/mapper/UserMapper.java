package com.example.stmlabs.mapper;


import com.example.stmlabs.dto.UserDto;
import com.example.stmlabs.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * маппер для {@link User} готовый dto {@link UserDto}
 */
@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    User toEntity(UserDto userDto);

    UserDto toDTO(User user);
}
