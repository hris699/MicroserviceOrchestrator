package com.microflow.OrderMicroservice.service.impl;

import com.microflow.OrderMicroservice.dto.OrderRequestDTO;
import com.microflow.OrderMicroservice.dto.OrderResponseDTO;
import com.microflow.OrderMicroservice.entity.Orders;
import com.microflow.OrderMicroservice.repository.OrderRepository;
import com.microflow.OrderMicroservice.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @Override
    public OrderResponseDTO validateOrder(OrderRequestDTO orderRequestDTO) {
        Orders order = new Orders();
        order.setOrderId(orderRequestDTO.getOrderId());
        order.setProductId(orderRequestDTO.getProductId());
        order.setQuantity(orderRequestDTO.getQuantity());
        order.setStatus("Validated");
        orderRepository.save(order);
        return new OrderResponseDTO(order.getOrderId(), order.getStatus(), "Order validated successfully.");
    }
}