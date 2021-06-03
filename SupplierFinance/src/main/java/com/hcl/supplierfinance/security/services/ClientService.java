package com.hcl.supplierfinance.security.services;

import org.springframework.http.ResponseEntity;

import com.hcl.supplierfinance.models.Client;

public interface ClientService {
	
	ResponseEntity<?> saveClient(Client clientData);

}
