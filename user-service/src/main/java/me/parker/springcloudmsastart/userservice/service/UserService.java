package me.parker.springcloudmsastart.userservice.service;

import me.parker.springcloudmsastart.userservice.dto.UserDto;

public interface UserService {

    UserDto createUser(UserDto userDto);
}
