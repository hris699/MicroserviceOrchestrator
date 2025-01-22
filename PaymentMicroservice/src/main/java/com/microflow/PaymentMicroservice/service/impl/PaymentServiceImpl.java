package com.microflow.PaymentMicroservice.service.impl;

import com.microflow.PaymentMicroservice.dto.PaymentRequestDTO;
import com.microflow.PaymentMicroservice.dto.PaymentResponseDTO;
import com.microflow.PaymentMicroservice.entity.Payment;
import com.microflow.PaymentMicroservice.repository.PaymentRepository;
import com.microflow.PaymentMicroservice.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }
    @Override
    public PaymentResponseDTO processPayment(PaymentRequestDTO paymentRequestDTO) {
        Payment payment = new Payment();
        payment.setPaymentId(UUID.randomUUID().toString());
        payment.setOrderId(paymentRequestDTO.getOrderId());
        payment.setAmount(paymentRequestDTO.getAmount());
        payment.setStatus("Processed");
        paymentRepository.save(payment);
        return new PaymentResponseDTO(payment.getPaymentId(), payment.getStatus(), "Payment processed successfully.");
    }
}