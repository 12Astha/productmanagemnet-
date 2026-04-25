package com.example.userlogin.Service;

import com.example.userlogin.DTO.LoginRequestDTO;
import com.example.userlogin.Entity.User;
import com.example.userlogin.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;

    public String registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return "user already exists";
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
    userRepository.save(user);
            return "Registration successful";


    }
    public String loginUser(String email, String password) {

        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent()) {

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            if (encoder.matches(password, user.get().getPassword())) {
                return "Login successful!";
            }
        }

        return "Invalid email or password!";
    }
}

