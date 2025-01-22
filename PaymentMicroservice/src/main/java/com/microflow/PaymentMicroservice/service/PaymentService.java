package com.microflow.PaymentMicroservice.service;

import com.microflow.PaymentMicroservice.dto.PaymentRequestDTO;
import com.microflow.PaymentMicroservice.dto.PaymentResponseDTO;

public interface PaymentService {
    PaymentResponseDTO processPayment(PaymentRequestDTO paymentRequestDTO);
}
