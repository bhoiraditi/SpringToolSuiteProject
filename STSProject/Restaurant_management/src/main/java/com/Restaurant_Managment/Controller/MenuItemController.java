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

import com.Restaurant_Managment.Service.MenuItemService;
import com.Restaurant_Managment.entities.MenuItem;

@RestController
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    // Get the list of menu items
    @GetMapping("/MenuItem")
    public List<MenuItem> getMenuItems() {
        return this.menuItemService.getMenuItems();
    }

    // Get a menu item by ID
    @GetMapping("/MenuItem/{id}")
    public MenuItem getMenuItem(@PathVariable String id) {
        return this.menuItemService.getMenuItem(id);
    }

    // Add a new menu item
    @PostMapping("/MenuItem")
    public MenuItem addMenuItem(@RequestBody MenuItem menuItem) {
        return this.menuItemService.addMenuItem(menuItem);
    }

    // Update an existing menu item by ID
    @PutMapping("/MenuItem/{id}")
    public ResponseEntity<MenuItem> updateMenuItem(@PathVariable String id, @RequestBody MenuItem menuItem) {
        try {
            // Ensure that the correct menuItemId is set
            menuItem.setMenuItemId(id);
            MenuItem updatedMenuItem = this.menuItemService.updateMenuItem(menuItem);
            return new ResponseEntity<>(updatedMenuItem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete a menu item by ID
    @DeleteMapping("/MenuItem/{id}")
    public ResponseEntity<HttpStatus> deleteMenuItem(@PathVariable String id) {
        try {
            this.menuItemService.deleteMenuItem(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
