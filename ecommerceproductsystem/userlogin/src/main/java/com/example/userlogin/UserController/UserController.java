package com.example.userlogin.UserController;

import com.example.userlogin.DTO.LoginRequestDTO;
import com.example.userlogin.Entity.User;
import com.example.userlogin.Service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserServices service;
    @PostMapping("/register")
    public String registerUser(@RequestBody User user)
        {
           return service.registerUser(user);
        }
        @PostMapping("/login")
        public String loginUser(@RequestBody LoginRequestDTO loginRequestDTO)
        {
            return service.loginUser(
                loginRequestDTO.getEmail(),
                loginRequestDTO.getPassword()
            );
        }
    }



