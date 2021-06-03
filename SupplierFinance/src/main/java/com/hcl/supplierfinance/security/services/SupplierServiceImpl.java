package com.hcl.supplierfinance.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.supplierfinance.models.Supplier;
import com.hcl.supplierfinance.repository.SupplierRepository;

@Service
public class SupplierServiceImpl implements SuplierService{
	
	@Autowired
	private SupplierRepository supplierRepository;

	@Override
	public ResponseEntity<?> saveSupplier(Supplier supplierData) {
		Supplier supplier = new Supplier();
		supplierRepository.save(supplierData);
		return null;
	}
	
	

}
