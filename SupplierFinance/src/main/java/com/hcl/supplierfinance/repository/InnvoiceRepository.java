package com.hcl.supplierfinance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hcl.supplierfinance.models.Invoice;

public interface InnvoiceRepository extends JpaRepository<Invoice, Long> {

	@Query(value = "SELECT * FROM invoice WHERE supplier_supplier_id = ?1", nativeQuery = true)
	List<Invoice> findSupplierInnvoiceById(Long supplierId);

	@Query(value = "SELECT * FROM invoice WHERE supplier_supplier_id = ?1", nativeQuery = true)
	List<Invoice> findClientInnvoiceById(Long supplierId);

}
