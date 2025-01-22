package com.microflow.OrderMicroservice.repository;

import com.microflow.OrderMicroservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByOrderId(String orderId);
}
