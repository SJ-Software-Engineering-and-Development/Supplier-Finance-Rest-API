package com.hcl.supplierfinance.service;

import org.springframework.http.ResponseEntity;

import com.hcl.supplierfinance.models.Payment;

public interface PaymentService {
	
	public ResponseEntity<?> savePayment(Payment paymentData);
	
	public ResponseEntity<?> allBank();

}
