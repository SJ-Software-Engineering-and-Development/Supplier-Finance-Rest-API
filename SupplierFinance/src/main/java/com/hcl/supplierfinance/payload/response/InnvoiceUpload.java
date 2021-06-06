package com.hcl.supplierfinance.payload.response;

public class InnvoiceUpload {

	private Long invoiceId;
	
	private Long supplierId;
	
	private Long clientUserId;

	public InnvoiceUpload() {
		super();
	}

	public InnvoiceUpload(Long invoiceId, Long supplierId, Long clientUserId) {
		super();
		this.invoiceId = invoiceId;
		this.supplierId = supplierId;
		this.clientUserId = clientUserId;
	}

	public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public Long getClientUserId() {
		return clientUserId;
	}

	public void setClientUserId(Long clientUserId) {
		this.clientUserId = clientUserId;
	}
	
}
