package com.Restaurant_Managment.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MenuItem {
    @Id
    @Column(name = "menu_item_id")
    private String menuItemId;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "status", length = 20, nullable = false)
    private String status;

    public MenuItem(String menuItemId, String name, String description, double price, String status) {
        this.menuItemId = menuItemId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.status = status;
    }

    public MenuItem() {
        // Default constructor
    }

    public String getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(String menuItemId) {
        this.menuItemId = menuItemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MenuItem [menuItemId=" + menuItemId + ", name=" + name + ", description=" + description +
               ", price=" + price + ", status=" + status + "]";
    }
}
