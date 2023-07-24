package com.aman.blogapp.services;

import com.aman.blogapp.entities.User;
import com.aman.blogapp.payload.UserDto;

import java.util.List;

public interface UserService {

    UserDto registerNewUser(UserDto user);


    UserDto createUser(UserDto user);

    UserDto updateUser(UserDto user, Integer userId);

    UserDto getUserById(Integer userId);

    List<UserDto> getAllUsers();

    void deleteUser(Integer userId);
}
