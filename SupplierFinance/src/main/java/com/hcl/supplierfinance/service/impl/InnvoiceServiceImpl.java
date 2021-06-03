package com.hcl.supplierfinance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.hcl.supplierfinance.models.Invoice;
import com.hcl.supplierfinance.repository.InnvoiceRepository;
import com.hcl.supplierfinance.service.InvoiceService;

public class InnvoiceServiceImpl implements InvoiceService{
	
	@Autowired
	private InnvoiceRepository innvoicerepository;
	
	@Override
	public ResponseEntity<?> saveInnvoice(Invoice innvoiceData) {
		try {
			innvoicerepository.save(innvoiceData);
			return null;
		}catch(Exception ex) {
			return null;
		}
	}

	@Override
	public ResponseEntity<?> allInnvoice() {
		// TODO Auto-generated method stub
		return null;
	}

}
