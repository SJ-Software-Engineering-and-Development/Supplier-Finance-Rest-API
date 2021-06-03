package com.hcl.supplierfinance.service;

import org.springframework.http.ResponseEntity;

import com.hcl.supplierfinance.models.Account;

public interface AccountService {
	
	public ResponseEntity<?> saveAccount(Account AccountData);
	
	public ResponseEntity<?> allAccounts();

}
