package com.hcl.supplierfinance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.supplierfinance.models.Account;

@Repository
public interface AccoutRepository extends JpaRepository<Account, Long>{

}
