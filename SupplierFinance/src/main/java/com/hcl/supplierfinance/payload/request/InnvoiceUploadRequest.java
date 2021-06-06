package com.hcl.supplierfinance.payload.request;

import java.sql.Date;


public class InnvoiceUploadRequest {
		
		
		private Date innvoiceDate;
		
		private double amount;
		
		private String status;
		
		private String invoiceUrl;
		
		private String currency;
		
		private Long supplier_id;
		
		private Long cus_user_id;
		
		public String getCurrency() {
			return currency;
		}

		public void setCurrency(String currency) {
			this.currency = currency;
		}

		public String getInvoiceUrl() {
			return invoiceUrl;
		}

		public void setInvoiceUrl(String invoiceUrl) {
			this.invoiceUrl = invoiceUrl;
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

		public Long getSupplier_id() {
			return supplier_id;
		}

		public void setSupplier_id(Long supplier_id) {
			this.supplier_id = supplier_id;
		}

		public Long getCus_user_id() {
			return cus_user_id;
		}

		public void setCus_user_id(Long cus_user_id) {
			this.cus_user_id = cus_user_id;
		}
		
	}
