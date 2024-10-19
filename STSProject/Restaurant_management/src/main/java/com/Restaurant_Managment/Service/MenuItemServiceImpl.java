package com.Restaurant_Managment.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Restaurant_Managment.Dao.MenuItemDao; // Ensure this DAO is created
import com.Restaurant_Managment.entities.MenuItem;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    @Autowired    
    private MenuItemDao menuItemDao;

    @Override
    public List<MenuItem> getMenuItems() {
        return menuItemDao.findAll();  // Retrieve all menu items
    }

    @Override
    public MenuItem getMenuItem(String menuItemId) {
        // Fetch menu item by ID
        Optional<MenuItem> optionalMenuItem = menuItemDao.findById(menuItemId);
        // Return the menu item if found, or throw an exception if not
        return optionalMenuItem.orElseThrow(() -> new RuntimeException("MenuItem not found with ID: " + menuItemId));
    }

    @Override
    public MenuItem addMenuItem(MenuItem menuItem) {
        menuItemDao.save(menuItem);  // Save new menu item
        return menuItem;
    }

    @Override
    public MenuItem updateMenuItem(MenuItem menuItem) {
        menuItemDao.save(menuItem);  // Update existing menu item
        return menuItem;
    }

    @Override
    public void deleteMenuItem(String menuItemId) {
        // Check if menu item exists before deletion
        Optional<MenuItem> optionalMenuItem = menuItemDao.findById(menuItemId);
        MenuItem menuItem = optionalMenuItem.orElseThrow(() -> new RuntimeException("MenuItem not found with ID: " + menuItemId));
        menuItemDao.delete(menuItem);  // Delete the menu item
    }
}
