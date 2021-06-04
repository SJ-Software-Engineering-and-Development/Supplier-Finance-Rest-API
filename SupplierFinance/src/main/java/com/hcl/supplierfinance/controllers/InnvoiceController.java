package com.hcl.supplierfinance.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.supplierfinance.models.Client;
import com.hcl.supplierfinance.models.Invoice;
import com.hcl.supplierfinance.models.Supplier;
import com.hcl.supplierfinance.payload.request.InnvoiceUploadRequest;
import com.hcl.supplierfinance.payload.response.MessageResponse;
import com.hcl.supplierfinance.repository.ClientRepository;
import com.hcl.supplierfinance.repository.InnvoiceRepository;
import com.hcl.supplierfinance.repository.SupplierRepository;


@RestController
@CrossOrigin
@RequestMapping("/api/supplierFinance/innvoice")
public class InnvoiceController {
	
	@Autowired
	private InnvoiceRepository innvoiceRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	//For Invoice upload
	@PostMapping("/upload")
	public ResponseEntity<?> uploadInvoice(@Valid @RequestBody InnvoiceUploadRequest innvoiceUploadRequest) {
		
		Supplier supplier = supplierRepository.findById(innvoiceUploadRequest.getSupplier_id()).get();
		Client client = clientRepository.findUserById(innvoiceUploadRequest.getCus_user_id());
		
		Invoice invoice = new Invoice(innvoiceUploadRequest.getInnvoiceDate(),innvoiceUploadRequest.getAmount(),
				innvoiceUploadRequest.getStatus(), innvoiceUploadRequest.getInvoiceFile(),
				innvoiceUploadRequest.getCurrency(),supplier, client);
		innvoiceRepository.save(invoice);
		return ResponseEntity.ok(new MessageResponse("Invoice upaded Successfully!"));
	}

}
