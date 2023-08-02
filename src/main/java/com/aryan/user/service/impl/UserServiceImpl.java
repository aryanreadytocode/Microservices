package com.aryan.user.service.impl;

import com.aryan.user.service.entities.User;
import com.aryan.user.service.exceptions.ResourceNotFoundException;
import com.aryan.user.service.repostitories.UserRepository;
import com.aryan.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        String randomUUID = UUID.randomUUID().toString();
        user.setUserId(randomUUID);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        return userRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User with given id is not found on server !! "+userId));
    }

    @Override
    public User updateUser(User user) {
        User user1 =  userRepository.findById(user.getUserId()).orElseThrow(() ->
                new ResourceNotFoundException("User with given id is not found on server !! "+user.getUserId()));
        if (user.getName() != null && !user.getName().equals(user1.getName())) {
            user1.setName(user.getName());
        }
        if (user.getEmail() != null && !user.getEmail().equals(user1.getEmail())) {
            user1.setEmail(user.getEmail());
        }
        if (user.getAbout() != null && !user.getAbout().equals(user1.getAbout())) {
            user1.setAbout(user.getAbout());
        }
        return userRepository.save(user1);
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
