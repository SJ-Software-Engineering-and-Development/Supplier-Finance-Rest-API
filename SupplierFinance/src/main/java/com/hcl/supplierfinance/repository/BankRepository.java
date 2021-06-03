package com.hcl.supplierfinance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hcl.supplierfinance.models.Bank;

public interface BankRepository extends JpaRepository<Bank, Long>{
	
	@Query(value = "SELECT * FROM bank WHERE bank_id = ?1", nativeQuery = true)
	   Bank findUserById(Long user_id);

}
