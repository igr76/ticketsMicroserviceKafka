package com.example.stmlabs.service.impl;


import com.example.stmlabs.dto.UserDto;
import com.example.stmlabs.mapper.UserMapper;
import com.example.stmlabs.model.User;
import com.example.stmlabs.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;


/**
 * Сервис пользователей
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

  private final UserMapper userMapper;

  @Value("${image.user.dir.path}")
  private String userPhotoDir;

  public UserServiceImpl( UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  /**
   * Получить данные пользователя
   */
  @Override
  public UserDto getUser(String login,Authentication authentication) {
    log.info("Получить данные пользователя" );
//    String nameEmail = authentication.getName();
//    UserEntity userEntity = findEntityByEmail(nameEmail);
    return null;
  }

  /**
   * Обновить данные пользователя
   */
  @Override
  public UserDto updateUser(UserDto newUserDto, Authentication authentication) {
    log.info("Получить данные пользователя");
    return null;
  }

  @Override
  public void deleteUser(String login, Authentication authentication) {

  }

  @Override
  public UserDto greaetUser(UserDto userDto, Authentication authentication) {
    return null;
  }


}
