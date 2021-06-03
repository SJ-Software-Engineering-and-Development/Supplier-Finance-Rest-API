package com.hcl.supplierfinance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.supplierfinance.models.Payment;
import com.hcl.supplierfinance.repository.PaymentRepository;
import com.hcl.supplierfinance.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Override
	public ResponseEntity<?> savePayment(Payment paymentData) {
		try {
			paymentRepository.save(paymentData);
			return null;
		}catch(Exception ex) {
			return null;
		}
		
	}

	@Override
	public ResponseEntity<?> allBank() {
		// TODO Auto-generated method stub
		return null;
	}

}
