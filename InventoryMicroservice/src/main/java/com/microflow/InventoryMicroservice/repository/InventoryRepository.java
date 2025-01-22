package com.microflow.InventoryMicroservice.repository;

import com.microflow.InventoryMicroservice.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Inventory findByProductId(String productId);
}
