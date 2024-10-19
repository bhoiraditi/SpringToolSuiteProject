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

import com.Restaurant_Managment.Service.OrderrService;
import com.Restaurant_Managment.entities.Orderr;

@RestController
public class OrderrController {

    @Autowired
    private OrderrService orderService;

    // Get the list of orders
    @GetMapping("/orders")
    public List<Orderr> getOrders() {
        return this.orderService.getOrders();
    }

    // Get an order by ID
    @GetMapping("/orders/{id}")
    public Orderr getOrder(@PathVariable Long id) {
        return this.orderService.getOrder(id);
    }

    // Add a new order
    @PostMapping("/orders")
    public Orderr addOrder(@RequestBody Orderr order) {
        return this.orderService.addOrder(order);
    }

    // Update an existing order by ID
    @PutMapping("/orders/{id}")
    public ResponseEntity<Orderr> updateOrder(@PathVariable Long id, @RequestBody Orderr order) {
        try {
            // Ensure that the correct orderId is set
            order.setOrderId(id);
            Orderr updatedOrder = this.orderService.updateOrder(order);
            return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete an order by ID
    @DeleteMapping("/orders/{id}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable Long id) {
        try {
            this.orderService.deleteOrder(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
