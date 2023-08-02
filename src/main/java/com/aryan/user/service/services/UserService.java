package com.aryan.user.service.services;

import com.aryan.user.service.entities.User;

import java.util.List;

public interface UserService {
    // user operations

    //create
    User saveUser(User user);

    //get all user
    List<User> getAllUser();

    //get single user of given userId
    User getUser(String userId);

    // update
    User updateUser(User user);

    // delete
    void deleteUser(String userId);


}
