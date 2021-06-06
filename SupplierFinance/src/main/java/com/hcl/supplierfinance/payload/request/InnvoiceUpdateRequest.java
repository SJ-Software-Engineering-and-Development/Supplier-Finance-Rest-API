package com.hcl.supplierfinance.payload.request;

public class InnvoiceUpdateRequest {
	
	private Long invoiceId;
	
	private String invoiceUrl;

	public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getInvoiceUrl() {
		return invoiceUrl;
	}

	public void setInvoiceUrl(String invoiceUrl) {
		this.invoiceUrl = invoiceUrl;
	}

}
