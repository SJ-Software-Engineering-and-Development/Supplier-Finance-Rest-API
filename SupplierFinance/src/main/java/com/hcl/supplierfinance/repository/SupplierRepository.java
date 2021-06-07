package com.hcl.supplierfinance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hcl.supplierfinance.models.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long>{
	
		@Query(value = "SELECT * FROM supplier WHERE user_id = ?1", nativeQuery = true)
     Supplier findUserById(Long supplier_id);
		
		@Query(value = "SELECT supplier_id FROM supplier WHERE user_id = ?1", nativeQuery = true)
	     Long findSupplierIdByUserId(Long user_id);

}
