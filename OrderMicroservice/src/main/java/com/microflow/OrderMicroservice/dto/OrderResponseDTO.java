package com.microflow.OrderMicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

public class OrderResponseDTO {
    public OrderResponseDTO(String orderId, String status, String message) {
        this.orderId = orderId;
        this.status = status;
        this.message = message;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String orderId;
    private String status;
    private String message;
}
