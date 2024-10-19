package com.Restaurant_Managment.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Restaurant_Managment.entities.Orderr;

public interface OrderrDao extends JpaRepository<Orderr, Long> {
    // You can add custom query methods here if needed
}
