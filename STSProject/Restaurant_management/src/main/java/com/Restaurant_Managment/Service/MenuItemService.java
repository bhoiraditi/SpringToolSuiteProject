package com.Restaurant_Managment.Service;

import java.util.List;
import com.Restaurant_Managment.entities.MenuItem;

public interface MenuItemService {
    List<MenuItem> getMenuItems();
    MenuItem getMenuItem(String menuItemId);
    MenuItem addMenuItem(MenuItem menuItem);
    MenuItem updateMenuItem(MenuItem menuItem);
    void deleteMenuItem(String menuItemId);
	
}
