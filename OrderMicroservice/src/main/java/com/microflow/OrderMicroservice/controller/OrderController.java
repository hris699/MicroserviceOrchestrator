package com.microflow.OrderMicroservice.controller;

import com.microflow.OrderMicroservice.dto.OrderRequestDTO;
import com.microflow.OrderMicroservice.dto.OrderResponseDTO;
import com.microflow.OrderMicroservice.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping("/validate")
    public ResponseEntity<OrderResponseDTO> validateOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        OrderResponseDTO response = orderService.validateOrder(orderRequestDTO);
        return ResponseEntity.ok(response);
    }
}
