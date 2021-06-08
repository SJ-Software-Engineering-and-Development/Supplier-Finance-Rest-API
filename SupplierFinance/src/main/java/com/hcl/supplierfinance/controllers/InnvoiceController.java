package com.hcl.supplierfinance.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.supplierfinance.models.Client;
import com.hcl.supplierfinance.models.ERole;
import com.hcl.supplierfinance.models.Invoice;
import com.hcl.supplierfinance.models.Role;
import com.hcl.supplierfinance.models.Supplier;
import com.hcl.supplierfinance.payload.request.InnvoiceUpdateRequest;
import com.hcl.supplierfinance.payload.request.InnvoiceUploadRequest;
import com.hcl.supplierfinance.payload.request.InvoiceViewRequest;
import com.hcl.supplierfinance.payload.response.InnvoiceUpload;
import com.hcl.supplierfinance.payload.response.InvoiceResponse;
import com.hcl.supplierfinance.payload.response.MessageResponse;
import com.hcl.supplierfinance.repository.ClientRepository;
import com.hcl.supplierfinance.repository.InnvoiceRepository;
import com.hcl.supplierfinance.repository.RoleRepository;
import com.hcl.supplierfinance.repository.SupplierRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/supplierFinance/innvoice")
public class InnvoiceController {

	@Autowired
	private InnvoiceRepository innvoiceRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private SupplierRepository supplierRepository;

	@Autowired
	private RoleRepository roleRepository;

	// For Invoice upload
	@PostMapping("/upload")
	public ResponseEntity<?> uploadInvoice(@Valid @RequestBody InnvoiceUploadRequest innvoiceUploadRequest) {

		Supplier supplier = supplierRepository.findById(innvoiceUploadRequest.getSupplier_id()).get();
		Client client = clientRepository.findUserById(innvoiceUploadRequest.getCus_user_id());

		Invoice invoice = new Invoice(innvoiceUploadRequest.getInnvoiceDate(), innvoiceUploadRequest.getAmount(),
				innvoiceUploadRequest.getStatus(), innvoiceUploadRequest.getInvoiceUrl(),
				innvoiceUploadRequest.getCurrency(), supplier, client);
		Invoice invoiceSave = innvoiceRepository.save(invoice);

		if (invoiceSave != null) {
			InnvoiceUpload inv = new InnvoiceUpload(invoiceSave.getInnvoiceId(),
					invoiceSave.getSupplier().getSupplierId(), invoiceSave.getClient().getUser().getId());
			return new ResponseEntity<>(inv, HttpStatus.OK);
		} else {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Invoice colud not save!"));
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> invoiceUpdate(@Valid @PathVariable(value = "id") Long invoiceId,
			@RequestBody InnvoiceUpdateRequest invoiceUpdate) {

		Long id = invoiceId;
		if (this.innvoiceRepository.findById(id).isPresent() != false) {

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
				return new ResponseEntity<>("Invoice update Succussfully!", HttpStatus.OK);

			} catch (Exception ex) {
				return new ResponseEntity<>("Invoice update fail!", HttpStatus.OK);
			}

		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Requested resource does not found");
		}
	}

	@PostMapping("/getByRole")
	public ResponseEntity<?> getAllInvoice(@Valid @RequestBody InvoiceViewRequest invoiceView) {

		Set<String> strRoles = invoiceView.getRole();
		Set<Role> roles = new HashSet<>();
		List<InvoiceResponse> listInvoiceResponse = new ArrayList<InvoiceResponse>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_BUYER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				Long roleId;
				List<Invoice> listInvoice;

				switch (role) {
				case "ROLE_SELLER":

					roleId = supplierRepository.findSupplierIdByUserId(invoiceView.getUserId());
					listInvoice = innvoiceRepository.findSupplierInnvoiceById(roleId);

					for (Invoice supp : listInvoice) {
						InvoiceResponse invr = new InvoiceResponse();

						invr.setInnvoiceId(supp.getInnvoiceId());
						invr.setInnvoiceDate(supp.getInnvoiceDate());
						invr.setAmount(supp.getAmount());
						invr.setStatus(supp.getStatus());
						invr.setInvoiceUrl(supp.getInvoiceUrl());
						invr.setCurrency(supp.getCurrency());
						invr.setClientUserId(supp.getClient().getClientId());
						invr.setClientName(supp.getClient().getName());
						invr.setSupplierUserId(supp.getSupplier().getSupplierId());
						invr.setSupplierName(supp.getSupplier().getName());
						listInvoiceResponse.add(invr);
					}
					break;

				case "ROLE_BUYER":
					roleId = clientRepository.findClientIdByUserId(invoiceView.getUserId());
					listInvoice = innvoiceRepository.findClientInnvoiceById(roleId);

					for (Invoice supp : listInvoice) {
						InvoiceResponse invr = new InvoiceResponse();

						invr.setInnvoiceId(supp.getInnvoiceId());
						invr.setInnvoiceDate(supp.getInnvoiceDate());
						invr.setAmount(supp.getAmount());
						invr.setStatus(supp.getStatus());
						invr.setInvoiceUrl(supp.getInvoiceUrl());
						invr.setCurrency(supp.getCurrency());
						invr.setClientUserId(supp.getClient().getClientId());
						invr.setClientName(supp.getClient().getName());
						invr.setSupplierUserId(supp.getSupplier().getSupplierId());
						invr.setSupplierName(supp.getSupplier().getName());
						listInvoiceResponse.add(invr);
					}

					break;

				case "ROLE_BANKER":
					listInvoice = innvoiceRepository.findAll();

					for (Invoice supp : listInvoice) {
						InvoiceResponse invr = new InvoiceResponse();

						invr.setInnvoiceId(supp.getInnvoiceId());
						invr.setInnvoiceDate(supp.getInnvoiceDate());
						invr.setAmount(supp.getAmount());
						invr.setStatus(supp.getStatus());
						invr.setInvoiceUrl(supp.getInvoiceUrl());
						invr.setCurrency(supp.getCurrency());
						invr.setClientUserId(supp.getClient().getClientId());
						invr.setClientName(supp.getClient().getName());
						invr.setSupplierUserId(supp.getSupplier().getSupplierId());
						invr.setSupplierName(supp.getSupplier().getName());
						listInvoiceResponse.add(invr);
					}

					break;
				case "ROLE_WEB_MASTER":

				}
			});
		}
		return new ResponseEntity<>(listInvoiceResponse, HttpStatus.OK);

	}
}
