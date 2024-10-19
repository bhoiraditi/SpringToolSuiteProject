package com.Restaurant_Managment.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Restaurant_Managment.entities.MenuItem;

public interface MenuItemDao extends JpaRepository<MenuItem, String> {

}
