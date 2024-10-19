package com.Restaurant_Managment.Service;

import java.util.List;
import com.Restaurant_Managment.entities.Orderr;

public interface OrderrService {
    List<Orderr> getOrders();
    Orderr getOrder(Long orderId);
    Orderr addOrder(Orderr order);
    Orderr updateOrder(Orderr order);
    void deleteOrder(Long orderId);
}
