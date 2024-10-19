package com.Restaurant_Managment.Service;

import java.util.List;
import com.Restaurant_Managment.entities.User;

public interface UserService {
    List<User> getUsers();
    User getUser(String userId);
    User addUser(User user);
    User updateUser(User user);
    void deleteUser(String userId);
}
