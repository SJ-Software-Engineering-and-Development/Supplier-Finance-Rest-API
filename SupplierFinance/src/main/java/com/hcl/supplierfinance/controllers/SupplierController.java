package com.hcl.supplierfinance.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.supplierfinance.DTO.SupplierDTO;
import com.hcl.supplierfinance.models.Supplier;
import com.hcl.supplierfinance.repository.SupplierRepository;

@RestController
@RequestMapping("api/supplierFinance/supplier")
public class SupplierController {
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	@PostMapping("/getall")
	public List<SupplierDTO> getAllSupplier(){
		
		List<Supplier> listSupplier = new ArrayList<Supplier>();
		listSupplier = supplierRepository.findAll();

        List<SupplierDTO> listSupplierDTO = new ArrayList<SupplierDTO>();
 
        for (Supplier supp : listSupplier) {

        	SupplierDTO supplier = new SupplierDTO();
            supplier.setSupplierId(supp.getSupplierId());
            supplier.setName(supp.getName());

            listSupplierDTO.add(supplier);
        }

        return listSupplierDTO;
	}

}
