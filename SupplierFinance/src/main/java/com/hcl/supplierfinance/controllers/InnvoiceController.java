package com.hcl.supplierfinance.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.supplierfinance.DTO.SupplierDTO;
import com.hcl.supplierfinance.DTO.SupplierInvoiceDTO;
import com.hcl.supplierfinance.models.Client;
import com.hcl.supplierfinance.models.Invoice;
import com.hcl.supplierfinance.models.Supplier;
import com.hcl.supplierfinance.payload.request.InnvoiceUpdateRequest;
import com.hcl.supplierfinance.payload.request.InnvoiceUploadRequest;
import com.hcl.supplierfinance.payload.response.InnvoiceUpload;
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
				innvoiceUploadRequest.getStatus(), innvoiceUploadRequest.getInvoiceUrl(),
				innvoiceUploadRequest.getCurrency(),supplier, client);
		Invoice invoiceSave = innvoiceRepository.save(invoice);
		
		if(invoiceSave != null) {
			InnvoiceUpload inv = new InnvoiceUpload(invoiceSave.getInnvoiceId(),
					invoiceSave.getSupplier().getSupplierId(), invoiceSave.getClient().getUser().getId());
			return new ResponseEntity<>(inv, HttpStatus.OK);
		}else {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Invoice colud not save!"));
		}
	}
	
	@GetMapping(value = "getByRole/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllInvoice(@Valid @PathVariable("id") Long id ){

		if (supplierRepository.existsById(id)) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Supplier is not there!"));
		}
		
		List<Invoice> listSupplierInvoice = new ArrayList<Invoice>();
		listSupplierInvoice = innvoiceRepository.findSupplierInnvoiceById(id);

        List<SupplierInvoiceDTO> listSupplierDTO = new ArrayList<SupplierInvoiceDTO>();
 
        for (Invoice supp : listSupplierInvoice) {

        	SupplierInvoiceDTO supplierInvoice = new SupplierInvoiceDTO();
        	supplierInvoice.setAmount(supp.getAmount());
        	supplierInvoice.setCurrency(supp.getCurrency());
        	supplierInvoice.setInnvoiceDate(supp.getInnvoiceDate());
        	supplierInvoice.setInnvoiceId(supp.getInnvoiceId());
        	supplierInvoice.setInvoiceUrl(supp.getInvoiceUrl());
        	supplierInvoice.setStatus(supp.getStatus());
        	
        	Client client = supp.getClient();
        	supplierInvoice.setClientId(client.getClientId());

            listSupplierDTO.add(supplierInvoice);
        }

        return new ResponseEntity<>(listSupplierDTO, HttpStatus.OK) ;
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> invoiceUpdate(@Valid @PathVariable(value = "id") Long invoiceId, 
			 @RequestBody InnvoiceUpdateRequest invoiceUpdate){
		
		Long id = invoiceId;
		if(this.innvoiceRepository.findById(id).isPresent() != false) {
			
			try {
				Invoice oldInvoice = innvoiceRepository.findById(id).get();
				Invoice invoice = new Invoice();
				invoice.setInnvoiceId(id);
				invoice.setInnvoiceDate(oldInvoice.getInnvoiceDate());
				invoice.setAmount(oldInvoice.getAmount());
				invoice.setClient(oldInvoice.getClient());
				invoice.setCurrency(oldInvoice.getCurrency());
				invoice.setSupplier(oldInvoice.getSupplier());
				invoice.setStatus(oldInvoice.getStatus());
				
				invoice.setInvoiceUrl(invoiceUpdate.getInvoiceUrl());
				
				innvoiceRepository.save(invoice);
				return new ResponseEntity<>("Invoice update Succussfully!",HttpStatus.OK);
				
			}catch(Exception ex) {
				return new ResponseEntity<>("Invoice update fail!",HttpStatus.OK);
			}
			
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Requested resource does not found");
		}
	}

	//@GetMapping()
//	public ResponseEntity<?> getAllClientInnvoice(@PathVariable("id") Long id){
//
//		if (clientRepository.existsById(id)) {
//			return ResponseEntity.badRequest().body(new MessageResponse("Error: client is not there!"));
//		}
		
//		List<Invoice> listClientInvoice = new ArrayList<Invoice>();
//		listClientInvoice = innvoiceRepository.findSupplierInnvoiceById(id);
//
//        List<SupplierInvoiceDTO> listSupplierDTO = new ArrayList<SupplierInvoiceDTO>();
// 
//        //for (Invoice supp : listSupplierInvoice) {
//
//        	SupplierInvoiceDTO supplierInvoice = new SupplierInvoiceDTO();
//        	supplierInvoice.setAmount(supp.getAmount());
//        	supplierInvoice.setCurrency(supp.getCurrency());
//        	supplierInvoice.setInnvoiceDate(supp.getInnvoiceDate());
//        	supplierInvoice.setInnvoiceId(supp.getInnvoiceId());
//        	supplierInvoice.setInvoiceFile(supp.getInvoiceFile());
//        	supplierInvoice.setStatus(supp.getStatus());
//        	
//        	Client client = supp.getClient();
//        	supplierInvoice.setClientId(client.getClientId());
//
//            listSupplierDTO.add(supplierInvoice);
//        }

       // return new ResponseEntity<>(listSupplierDTO, HttpStatus.OK) ;
		//return null;
//	}
}
