package com.hcl.supplierfinance.DTO;

import java.sql.Date;

public class ClientInvoiceDTO {
	
	private Long innvoiceId;
	
	private Date innvoiceDate;
	
	private double amount;
	
	private String status;
	
	private String invoiceUrl;
	
	private String currency;
	
	private Long supplierId;

	
	public Long getInnvoiceId() {
		return innvoiceId;
	}

	public void setInnvoiceId(Long innvoiceId) {
		this.innvoiceId = innvoiceId;
	}

	public Date getInnvoiceDate() {
		return innvoiceDate;
	}

	public void setInnvoiceDate(Date innvoiceDate) {
		this.innvoiceDate = innvoiceDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInvoiceUrl() {
		return invoiceUrl;
	}

	public void setInvoiceUrl(String invoiceUrl) {
		this.invoiceUrl = invoiceUrl;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

}
