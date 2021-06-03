package com.hcl.supplierfinance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.supplierfinance.models.Invoice;

public interface InnvoiceRepository extends JpaRepository<Invoice, Long>{

		
}
