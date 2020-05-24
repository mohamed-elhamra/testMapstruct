package com.melhamra.controller;

import com.melhamra.enity.UserDto;
import com.melhamra.mapper.MyMapper;
import com.melhamra.model.Laptop;
import com.melhamra.model.User;
import com.melhamra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private MyMapper myMapper;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    public void addUser(@RequestBody UserDto userDto){
        User user = myMapper.toUser(userDto);
        userRepository.saveUser(user);
    }

    @GetMapping("/users/{id}")
    public UserDto getUserByID(@PathVariable int id){
        User user = userRepository.getUserByID(id);
        return myMapper.toUserDto(user);
    }

    @GetMapping("/users")
    public List<UserDto> getAllUser(){
        List<User> userList = userRepository.getAllUsers();
        return myMapper.toUserDtos(userList);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        User user = userRepository.getUserByID(id);
        userRepository.deleteUser(user);
    }

    @PatchMapping("/users/{id}")
    public void updateUser(@PathVariable int id,
                           @RequestBody UserDto userDto){
        userDto.setId(id);
        User user = myMapper.toUser(userDto);
        userRepository.updateUser(user);
    }

}
