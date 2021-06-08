package com.hcl.supplierfinance.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.supplierfinance.models.Account;
import com.hcl.supplierfinance.service.AccountService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(name = "/supplierFinance/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/register")
	public ResponseEntity<?> saveAccount(@RequestBody Account accountData) {
		accountService.saveAccount(accountData);
		return null;

	}

}
