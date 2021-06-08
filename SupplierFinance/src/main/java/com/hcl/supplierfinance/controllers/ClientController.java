package com.hcl.supplierfinance.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.supplierfinance.models.Client;
import com.hcl.supplierfinance.security.services.ClientService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/supplierFinance/client")
public class ClientController {

	@Autowired
	private ClientService clientservice;

	@PostMapping("/register")
	public ResponseEntity<?> addClient(@RequestBody Client clientData) {
		return clientservice.saveClient(clientData);

	}

}
