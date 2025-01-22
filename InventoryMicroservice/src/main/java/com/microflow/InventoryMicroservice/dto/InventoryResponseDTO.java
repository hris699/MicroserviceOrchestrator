package com.microflow.InventoryMicroservice.dto;

public class InventoryResponseDTO {
    private String productId;

    public InventoryResponseDTO(String productId, int quantity, String message) {
        this.productId = productId;
        this.quantity = quantity;
        this.message = message;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private int quantity;
    private String message;
}
