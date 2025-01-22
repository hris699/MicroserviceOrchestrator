package com.microflow.InventoryMicroservice.controller;

import com.microflow.InventoryMicroservice.dto.InventoryRequestDTO;
import com.microflow.InventoryMicroservice.dto.InventoryResponseDTO;
import com.microflow.InventoryMicroservice.service.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    private final InventoryService inventoryService;
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }
    @GetMapping("/check/{productId}")
    public ResponseEntity<InventoryResponseDTO> checkStock(@PathVariable String productId) {
        InventoryResponseDTO response = inventoryService.checkStock(productId);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/add")
    public ResponseEntity<InventoryResponseDTO> addStock(@RequestBody InventoryRequestDTO inventoryRequestDTO) {
        InventoryResponseDTO response = inventoryService.addStock(inventoryRequestDTO);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/reduce")
    public ResponseEntity<InventoryResponseDTO> reduceStock(@RequestBody InventoryRequestDTO inventoryRequestDTO) {
        InventoryResponseDTO response = inventoryService.reduceStock(inventoryRequestDTO);
        return ResponseEntity.ok(response);
    }
}