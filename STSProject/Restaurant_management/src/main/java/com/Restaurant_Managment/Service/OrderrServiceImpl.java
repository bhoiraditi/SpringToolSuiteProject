package com.Restaurant_Managment.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Restaurant_Managment.Dao.OrderrDao; // Make sure to create this DAO
import com.Restaurant_Managment.entities.Orderr;

@Service
public class OrderrServiceImpl implements OrderrService {
    
    @Autowired    
    private OrderrDao orderDao;

    @Override
    public List<Orderr> getOrders() {
        return orderDao.findAll();  // Retrieve all orders
    }
    
    @Override
    public Orderr getOrder(Long orderId) {
        // Using findById to fetch order by ID
        Optional<Orderr> optionalOrder = orderDao.findById(orderId);
        // Return the order if found, or throw an exception if not
        return optionalOrder.orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));
    }
    
    @Override
    public Orderr addOrder(Orderr order) {
        orderDao.save(order);  // Saving new order
        return order;
    }

    @Override
    public Orderr updateOrder(Orderr order) {
        orderDao.save(order);  // Updating existing order
        return order;
    }

    @Override
    public void deleteOrder(Long orderId) {
        // Using findById to check if order exists
        Optional<Orderr> optionalOrder = orderDao.findById(orderId);
        Orderr order = optionalOrder.orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));
        orderDao.delete(order);  // Deleting the order
    }
}
