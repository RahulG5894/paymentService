package com.learning.ps.api.service;

import com.learning.ps.api.model.Payment;
import com.learning.ps.api.model.Payment; // Generate explicit getters and setters
import com.learning.ps.api.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment doPayment(Payment payment) {
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        return paymentRepository.save(payment);
    }

    public String paymentProcessing() {
        // api should be 3rd party payment gateway (paypal or paytm)
        return new Random().nextBoolean() ? "success" : "failed";
    }

    public List<Payment> getPaymentDetailsByOrderId(int orderId) {
        return paymentRepository.findByOrderId(orderId);
    }
}