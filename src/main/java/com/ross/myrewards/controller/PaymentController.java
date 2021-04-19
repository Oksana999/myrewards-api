package com.ross.myrewards.controller;

import com.ross.myrewards.model.Payment;
import com.ross.myrewards.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/payments")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping("all")
    public List<Payment> getPayment() {
        return paymentRepository.findAll();
    }

    @GetMapping("by-user-id")
    public List<Payment> getPaymentByUserId(@RequestParam Long id) {
        return paymentRepository.findByUserUserId(id);
    }

    @GetMapping("by-user-id/last-n-days")
    public List<Payment> getPaymentByUserId(@RequestParam Long id, @RequestParam Long days) {
        Long till = System.currentTimeMillis();
        Long from = till - days * 24 * 60 * 60 * 1000;
        return paymentRepository.findByUserIdInTimeRange(id, from, till);
    }

    @GetMapping("by-user-email")
    public List<Payment> getPaymentByUserEmail(@RequestParam String email) {
        return paymentRepository.findByUserEmail(email);
    }
}
