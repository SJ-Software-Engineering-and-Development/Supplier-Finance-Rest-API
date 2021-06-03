package com.hcl.supplierfinance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.supplierfinance.models.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long>{

}
