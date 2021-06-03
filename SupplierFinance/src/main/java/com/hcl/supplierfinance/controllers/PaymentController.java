package com.hcl.supplierfinance.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.supplierfinance.models.Payment;
import com.hcl.supplierfinance.service.PaymentService;

@RestController
@RequestMapping("/supplierFinance/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addPayment(@RequestBody Payment paymentData){
		return paymentService.savePayment(paymentData);
		
	}
	

}
