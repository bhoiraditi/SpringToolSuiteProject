package com.Restaurant_Managment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Restaurant_Managment.Service.UserService;
import com.Restaurant_Managment.entities.User;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // Get the list of users
    @GetMapping("/User")
    public List<User> getUsers() {
        return this.userService.getUsers();
    }

    // Get a user by ID
    @GetMapping("/User/{id}")
    public User getUser(@PathVariable String id) {
        return this.userService.getUser(id);
    }

    // Add a new user
    @PostMapping("/User")
    public User addUser(@RequestBody User user) {
        return this.userService.addUser(user);
    }

    // Update an existing user by ID
    @PutMapping("/User/{id}") // Update a user based on userId
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) {
        try {
            // Ensure that the correct userId is set
            user.setUserId(id);
            User updatedUser = this.userService.updateUser(user);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete a user by ID
    @DeleteMapping("/User/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable String id) {
        try {
            this.userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
