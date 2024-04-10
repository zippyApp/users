package com.zippy.users.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zippy.users.dto.UserDTO;
import com.zippy.users.service.interfaces.IUserService;
import com.zippy.users.mappers.UserMapper;

import java.util.List;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final IUserService userService;
    private final UserMapper userMapper;

    public UserController(IUserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userMapper.UserToUserDTO(userService.getUserById(id)));
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers().stream().map(userMapper::UserToUserDTO).toList());
    }

}
