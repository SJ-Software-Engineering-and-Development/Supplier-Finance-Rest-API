package com.hcl.supplierfinance.service;

import org.springframework.http.ResponseEntity;

import com.hcl.supplierfinance.models.Bank;

public interface BankService {
	
	public ResponseEntity<?> saveBank(Bank BankData);
	
	public ResponseEntity<?> allBank();
}
