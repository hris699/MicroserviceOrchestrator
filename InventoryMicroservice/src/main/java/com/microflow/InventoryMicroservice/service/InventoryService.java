package com.microflow.InventoryMicroservice.service;

import com.microflow.InventoryMicroservice.dto.InventoryRequestDTO;
import com.microflow.InventoryMicroservice.dto.InventoryResponseDTO;

public interface InventoryService {
    InventoryResponseDTO checkStock(String productId);
    InventoryResponseDTO addStock(InventoryRequestDTO inventoryRequestDTO);
    InventoryResponseDTO reduceStock(InventoryRequestDTO inventoryRequestDTO);
}
