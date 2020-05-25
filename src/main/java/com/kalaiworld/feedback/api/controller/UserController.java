package com.kalaiworld.feedback.api.controller;

import com.kalaiworld.feedback.api.dto.UserDto;
import com.kalaiworld.feedback.api.model.Users;
import com.kalaiworld.feedback.api.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    UsersRepository usersRepository;

    Users users;

    @PostMapping("/new")
    public Users saveUser(UserDto user) {
        UUID uuid = UUID.randomUUID();
        users=new Users();
        users.setId(uuid.toString());
        users.setUserId(user.getUserId());
        users.setPassword(user.getPassword());
        return usersRepository.save(users);
    }

    @GetMapping
    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }

}
