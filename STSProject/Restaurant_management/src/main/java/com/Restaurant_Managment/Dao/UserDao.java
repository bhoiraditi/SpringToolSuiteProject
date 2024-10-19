package com.Restaurant_Managment.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Restaurant_Managment.entities.User;

public interface UserDao extends JpaRepository<User, String> {

}
