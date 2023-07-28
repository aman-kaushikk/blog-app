package com.aman.blogapp.services.implementation;

import com.aman.blogapp.entities.User;
import com.aman.blogapp.exceptions.ResourceNotFoundException;
import com.aman.blogapp.payload.UserDto;
import com.aman.blogapp.repositories.UserRepo;
import com.aman.blogapp.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;


    public UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper){
        this.userRepo =userRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto registerNewUser(UserDto user) {
        return null;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user=this.dtoToUser(userDto);
       User  savedUser = this.userRepo.save(user);
       return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        // update this method to update the given payload and rest take from database
        User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        User updatedUser=this.userRepo.save(user);
        return this.userToDto(updatedUser);
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));

        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepo.findAll();
        return users.stream().map(this::userToDto).toList();
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        this.userRepo.delete(user);
    }



    public User dtoToUser(UserDto userDto) {
        return this.modelMapper.map(userDto, User.class);
    }

    public UserDto userToDto(User user) {
        return this.modelMapper.map(user, UserDto.class);
    }
}
