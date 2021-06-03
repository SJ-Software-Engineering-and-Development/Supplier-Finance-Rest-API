package com.hcl.supplierfinance.service;

import org.springframework.http.ResponseEntity;

import com.hcl.supplierfinance.models.Invoice;

public interface InvoiceService {

	public ResponseEntity<?> saveInnvoice(Invoice innvoiceData);
	
	public ResponseEntity<?> allInnvoice();
}
