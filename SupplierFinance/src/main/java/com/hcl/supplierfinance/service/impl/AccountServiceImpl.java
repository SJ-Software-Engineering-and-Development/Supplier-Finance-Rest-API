package com.hcl.supplierfinance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.supplierfinance.models.Account;
import com.hcl.supplierfinance.repository.AccoutRepository;
import com.hcl.supplierfinance.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccoutRepository accountrepository;

	@Override
	public ResponseEntity<?> saveAccount(Account AccountData) {
		try {
			accountrepository.save(AccountData);
			return null;
		}catch(Exception ex) {
			return null;
		}
	}

	@Override
	public ResponseEntity<?> allAccounts() {
		return null;
	}

}
