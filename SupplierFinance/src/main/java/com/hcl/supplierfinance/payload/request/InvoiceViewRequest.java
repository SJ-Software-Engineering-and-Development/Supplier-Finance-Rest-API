package com.hcl.supplierfinance.payload.request;

import java.util.Set;

public class InvoiceViewRequest {
	
	private Long userId;
	
	private Set<String> role;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}
	
	

}
