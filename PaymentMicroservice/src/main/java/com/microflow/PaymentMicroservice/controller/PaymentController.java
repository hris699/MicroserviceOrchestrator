package com.microflow.PaymentMicroservice.controller;

import com.microflow.PaymentMicroservice.dto.PaymentRequestDTO;
import com.microflow.PaymentMicroservice.dto.PaymentResponseDTO;
import com.microflow.PaymentMicroservice.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    private final PaymentService paymentService;
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @PostMapping("/process")
    public ResponseEntity<PaymentResponseDTO> processPayment(@RequestBody PaymentRequestDTO paymentRequestDTO) {
        PaymentResponseDTO response = paymentService.processPayment(paymentRequestDTO);
        return ResponseEntity.ok(response);
    }
}