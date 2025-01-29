package com.microflow.OrderMicroservice.repository;

import com.microflow.OrderMicroservice.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
    Orders findByOrderId(String orderId);
}
