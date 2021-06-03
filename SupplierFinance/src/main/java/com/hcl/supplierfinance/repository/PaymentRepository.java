package com.hcl.supplierfinance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.supplierfinance.models.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
