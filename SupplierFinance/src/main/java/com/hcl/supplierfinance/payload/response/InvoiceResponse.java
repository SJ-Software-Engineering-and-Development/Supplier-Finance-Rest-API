package com.hcl.supplierfinance.payload.response;

import java.sql.Date;

public class InvoiceResponse {

	private Long innvoiceId;

	private Date innvoiceDate;

	private double amount;

	private String status;

	private String invoiceUrl;

	private String currency;

	private Long clientUserId;

	private String clientName;

	private Long supplierUserId;

	private String supplierName;

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

	public Long getClientUserId() {
		return clientUserId;
	}

	public void setClientUserId(Long clientUserId) {
		this.clientUserId = clientUserId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public Long getSupplierUserId() {
		return supplierUserId;
	}

	public void setSupplierUserId(Long supplierUserId) {
		this.supplierUserId = supplierUserId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

}
