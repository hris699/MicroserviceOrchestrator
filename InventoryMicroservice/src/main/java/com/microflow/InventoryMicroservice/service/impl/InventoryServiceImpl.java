package com.microflow.InventoryMicroservice.service.impl;

import com.microflow.InventoryMicroservice.dto.InventoryRequestDTO;
import com.microflow.InventoryMicroservice.dto.InventoryResponseDTO;
import com.microflow.InventoryMicroservice.entity.Inventory;
import com.microflow.InventoryMicroservice.repository.InventoryRepository;
import com.microflow.InventoryMicroservice.service.InventoryService;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;
    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }
    @Override
    public InventoryResponseDTO checkStock(String productId) {
        Inventory inventory = inventoryRepository.findByProductId(productId);
        if (inventory == null) {
            return new InventoryResponseDTO(productId, 0, "Product not found in inventory");
        }
        return new InventoryResponseDTO(productId, inventory.getQuantity(), "Stock retrieved successfully");
    }
    @Override
    public InventoryResponseDTO addStock(InventoryRequestDTO inventoryRequestDTO) {
        Inventory inventory = inventoryRepository.findByProductId(inventoryRequestDTO.getProductId());
        if (inventory == null) {
            inventory = new Inventory();
            inventory.setProductId(inventoryRequestDTO.getProductId());
        }
        inventory.setQuantity(inventory.getQuantity() + inventoryRequestDTO.getQuantity());
        inventoryRepository.save(inventory);
        return new InventoryResponseDTO(inventory.getProductId(), inventory.getQuantity(), "Stock added successfully");
    }
    @Override
    public InventoryResponseDTO reduceStock(InventoryRequestDTO inventoryRequestDTO) {
        Inventory inventory = inventoryRepository.findByProductId(inventoryRequestDTO.getProductId());
        if (inventory == null || inventory.getQuantity() < inventoryRequestDTO.getQuantity()) {
            return new InventoryResponseDTO(inventoryRequestDTO.getProductId(), 0, "Insufficient stock");
        }
        inventory.setQuantity(inventory.getQuantity() - inventoryRequestDTO.getQuantity());
        inventoryRepository.save(inventory);
        return new InventoryResponseDTO(inventory.getProductId(), inventory.getQuantity(), "Stock reduced successfully");
    }
}