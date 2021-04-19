package com.ross.myrewards.controller;

import com.ross.myrewards.model.Payment;
import com.ross.myrewards.model.Reward;
import com.ross.myrewards.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

import static java.lang.Math.max;

@RestController
@RequestMapping("api/rewards")
public class RewardController {

    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping("by-user-id/last-n-days")
    public Reward getUserRewards(@RequestParam Long id, @RequestParam Long days) {
        Long till = System.currentTimeMillis();
        Long from = till - days * 24 * 60 * 60 * 1000;
        List<Payment> payments = paymentRepository.findByUserIdInTimeRange(id, from, till);
        Long points = calculatePoints(payments.stream());
        return new Reward(payments, points);
    }

    protected Long calculatePoints(Stream<Payment> payments) {
        return payments.map(p -> p.getAmount().toBigInteger().longValue())
                .map(amount ->  max((amount - 50), 0) + max((amount - 100), 0))
                .reduce(0L, (a, b) -> a + b);
    }
}
