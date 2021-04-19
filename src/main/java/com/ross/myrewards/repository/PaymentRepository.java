package com.ross.myrewards.repository;

import com.ross.myrewards.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByUserUserId(Long id);

    List<Payment> findByUserEmail(String email);

    @Query("SELECT p FROM Payment p JOIN p.user u WHERE u.userId = :id AND p.createdAt >= :from AND p.createdAt < :till")
    List<Payment> findByUserIdInTimeRange(Long id, Long from, Long till);

}
