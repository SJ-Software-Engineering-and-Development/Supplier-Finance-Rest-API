package com.hcl.supplierfinance.DTO;

public class SupplierDTO {
	
	private Long supplierId;
	private String name;
	
	public SupplierDTO(Long supplierId, String name) {
		super();
		this.supplierId = supplierId;
		this.name = name;
	}

	public SupplierDTO() {
		super();
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
