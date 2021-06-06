package com.hcl.supplierfinance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hcl.supplierfinance.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
	
		@Query(value = "SELECT * FROM client WHERE user_id = ?1", nativeQuery = true)
		Client findUserById(Long user_id);
}
