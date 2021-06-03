package com.hcl.supplierfinance.security.services;

import org.springframework.http.ResponseEntity;

import com.hcl.supplierfinance.models.Supplier;

public interface SuplierService {
	ResponseEntity<?> saveSupplier(Supplier supplierData);
}
