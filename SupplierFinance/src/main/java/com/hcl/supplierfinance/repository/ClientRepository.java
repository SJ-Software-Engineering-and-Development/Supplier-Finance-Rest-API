package com.hcl.supplierfinance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.supplierfinance.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
}
