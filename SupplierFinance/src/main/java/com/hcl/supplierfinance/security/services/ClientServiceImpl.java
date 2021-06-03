package com.hcl.supplierfinance.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.supplierfinance.models.Client;
import com.hcl.supplierfinance.repository.ClientRepository;
@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public ResponseEntity<?> saveClient(Client clientData) {
		clientRepository.save(clientData);
		return null;
	}
}
