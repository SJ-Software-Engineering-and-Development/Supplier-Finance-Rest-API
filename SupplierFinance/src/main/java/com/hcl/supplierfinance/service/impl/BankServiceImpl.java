package com.hcl.supplierfinance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.supplierfinance.models.Bank;
import com.hcl.supplierfinance.repository.BankRepository;
import com.hcl.supplierfinance.service.BankService;

@Service
public class BankServiceImpl implements BankService{

	@Autowired
	private BankRepository bankrepository;
	
	@Override
	public ResponseEntity<?> saveBank(Bank BankData) {
		try {
			bankrepository.save(BankData);
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
