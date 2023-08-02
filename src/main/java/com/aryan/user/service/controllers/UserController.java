package com.aryan.user.service.controllers;

import com.aryan.user.service.entities.User;
import com.aryan.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserService service;

    // create
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User user1 = service.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    // get single user
    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
        User user = service.getUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    // get All user
    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        List<User> userList = service.getAllUser();
        return ResponseEntity.status(HttpStatus.OK).body(userList);
    }

    // update user
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User user1 = service.updateUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(user1);
    }

    // delete user
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId) {
        service.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body("DeletedSuccessfully");
    }
}
