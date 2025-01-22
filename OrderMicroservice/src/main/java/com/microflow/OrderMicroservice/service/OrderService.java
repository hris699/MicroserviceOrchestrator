package com.microflow.OrderMicroservice.service;

import com.microflow.OrderMicroservice.dto.OrderRequestDTO;
import com.microflow.OrderMicroservice.dto.OrderResponseDTO;

public interface OrderService {
    OrderResponseDTO validateOrder(OrderRequestDTO orderRequestDTO);
}
