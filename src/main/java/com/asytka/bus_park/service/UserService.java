package com.asytka.bus_park.service;

import com.asytka.bus_park.model.User;
import com.asytka.bus_park.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public void save(User user) {
        userRepository.save(user);
    }
}
