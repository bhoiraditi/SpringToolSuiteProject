package com.Restaurant_Managment.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Orderr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "table_id", nullable = false)
    private String tableId;

    @Column(name = "menu_item_id", nullable = false)
    private String menuItemId;

    @Column(name = "order_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Column(name = "total_amount", nullable = false)
    private double totalAmount;

    @Column(name = "status", length = 20, nullable = false)
    private String status;

    public Orderr(Long orderId, String userId, String tableId, String menuItemId, Date orderDate, double totalAmount, String status) {
        this.orderId = orderId;
        this.userId = userId;
        this.tableId = tableId;
        this.menuItemId = menuItemId;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public Orderr() {
        // Default constructor
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(String menuItemId) {
        this.menuItemId = menuItemId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", userId=" + userId + ", tableId=" + tableId +
               ", menuItemId=" + menuItemId + ", orderDate=" + orderDate + 
               ", totalAmount=" + totalAmount + ", status=" + status + "]";
    }
}
