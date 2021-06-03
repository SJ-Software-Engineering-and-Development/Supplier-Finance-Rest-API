package com.hcl.supplierfinance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hcl.supplierfinance.models.Invoice;

public interface InnvoiceRepository extends JpaRepository<Invoice, Long>{
	
	@Query(value = "SELECT * FROM invoice WHERE innvoice_id = ?1", nativeQuery = true)
	   Invoice findInnvoiceById(Long innvoice_id);		
}
