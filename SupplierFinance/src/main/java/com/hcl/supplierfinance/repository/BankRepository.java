package com.hcl.supplierfinance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.supplierfinance.models.Bank;

public interface BankRepository extends JpaRepository<Bank, Long>{

}
