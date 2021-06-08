package com.hcl.supplierfinance.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.supplierfinance.models.Bank;
import com.hcl.supplierfinance.service.BankService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/supplierFinance/bank")
public class BankController {

	@Autowired
	private BankService bankService;

	@PostMapping("/register")
	public ResponseEntity<?> saveBank(@RequestBody Bank bankData) {
		bankService.saveBank(bankData);
		return null;

	}
}
