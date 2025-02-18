package com.learning.ps.api.controller;

import com.learning.ps.api.model.Payment;
import com.learning.ps.api.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/doPayment")
    public Payment doPayment(@RequestBody Payment payment) {
        return paymentService.doPayment(payment);
    }

    @GetMapping("/{orderId}")
    public List<Payment> getPaymentDetailsByOrderId(@PathVariable int orderId) {
        return paymentService.getPaymentDetailsByOrderId(orderId);
    }

}
