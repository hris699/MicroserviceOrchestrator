package com.microflow.PaymentMicroservice.dto;


public class PaymentRequestDTO {
    private String orderId;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    private double amount;
}