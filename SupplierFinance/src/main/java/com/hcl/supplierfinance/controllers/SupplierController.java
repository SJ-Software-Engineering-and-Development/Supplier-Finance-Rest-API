package com.hcl.supplierfinance.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.supplierfinance.models.Supplier;
import com.hcl.supplierfinance.security.services.SuplierService;

@RestController
@RequestMapping("/supplierFinance/supplier")
public class SupplierController {
	
	@Autowired
	private SuplierService supplierService;
	
	@PostMapping("/register")
	public ResponseEntity<?> saveSupplier(@RequestBody Supplier supplierData){
		return supplierService.saveSupplier(supplierData);
	}

}
