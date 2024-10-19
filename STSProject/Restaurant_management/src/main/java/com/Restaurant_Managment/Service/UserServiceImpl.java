package com.Restaurant_Managment.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Restaurant_Managment.Dao.UserDao; // Make sure to create this DAO
import com.Restaurant_Managment.entities.User;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired    
    private UserDao userDao;
    
    @Override
    public List<User> getUsers() {
        return userDao.findAll();  // Correct usage
    }
    
    @Override
    public User getUser(String userId) {
        // Using findById to fetch user by ID
        Optional<User> optionalUser = userDao.findById(userId);
        // Return the user if found, or throw an exception or handle it as needed
        return optionalUser.orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
    }
    
    @Override
    public User addUser(User user) {
        userDao.save(user);  // Saving new user
        return user;
    }

    @Override
    public User updateUser(User user) {
        userDao.save(user);  // Updating existing user
        return user;
    }

    @Override
    public void deleteUser(String userId) {
        // Using findById to check if user exists
        Optional<User> optionalUser = userDao.findById(userId);
        User user = optionalUser.orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
        userDao.delete(user);  // Deleting the user
    }
}
