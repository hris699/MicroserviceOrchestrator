package com.microflow.PaymentMicroservice.repository;

import com.microflow.PaymentMicroservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
