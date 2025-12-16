package com.example.ubo.weatherapi.business;

import com.example.ubo.weatherapi.entity.UserEntity;
import com.example.ubo.weatherapi.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBusiness {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserBusiness(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public UserEntity registerUser(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
}
