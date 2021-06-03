package com.hcl.supplierfinance.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.supplierfinance.models.Invoice;

@RestController
@CrossOrigin
@RequestMapping("/supplierFinance/innvoice")
public class InnvoiceController {
	
	@Autowired
	private InnvoiceController innvoiceController;
	
	@PostMapping("/register")
	public ResponseEntity<?> saveInnvoice(@RequestBody Invoice innvoiceData){
		innvoiceController.saveInnvoice(innvoiceData);
		return null;
		
	}

}
