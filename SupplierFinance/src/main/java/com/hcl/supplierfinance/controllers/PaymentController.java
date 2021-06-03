package com.hcl.supplierfinance.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.supplierfinance.models.Bank;
import com.hcl.supplierfinance.models.Invoice;
import com.hcl.supplierfinance.models.Payment;
import com.hcl.supplierfinance.payload.request.PaymentReuest;
import com.hcl.supplierfinance.payload.response.MessageResponse;
import com.hcl.supplierfinance.repository.BankRepository;
import com.hcl.supplierfinance.repository.InnvoiceRepository;
import com.hcl.supplierfinance.repository.PaymentRepository;

@RestController
@RequestMapping("/api/supplierFinance/payment")
public class PaymentController {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private BankRepository bankRepository;
	
	@Autowired
	private InnvoiceRepository innvoiceRepository;
	
	@PostMapping("/request")
	public ResponseEntity<?> addPayment(@Valid @RequestBody PaymentReuest paymentRequest){
		
		Bank bank = bankRepository.findById(paymentRequest.getBankId()).get();
		Invoice invoice = innvoiceRepository.findById(paymentRequest.getInnvoiceId()).get();
		
		Payment pay = new Payment(paymentRequest.getPaymentDate(), bank, invoice);
		paymentRepository.save(pay);
		return ResponseEntity.ok(new MessageResponse("Payment Requested Successfully!"));
		
	}
	

}
