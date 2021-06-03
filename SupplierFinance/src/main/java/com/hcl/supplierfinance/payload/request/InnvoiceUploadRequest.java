package com.hcl.supplierfinance.payload.request;

import java.sql.Date;


public class InnvoiceUploadRequest {
		
		
		private Date innvoiceDate;
		
		private double amount;
		
		private String status;
		
		private String invoiceFile;
		
		private Long suserId;
		
		private Long cuserId;

		
		public String getInvoiceFile() {
			return invoiceFile;
		}

		public void setInvoiceFile(String invoiceFile) {
			this.invoiceFile = invoiceFile;
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

		public Long getSuserId() {
			return suserId;
		}

		public void setSuserId(Long suserId) {
			this.suserId = suserId;
		}

		public Long getCuserId() {
			return cuserId;
		}

		public void setCuserId(Long cuserId) {
			this.cuserId = cuserId;
		}
		
	}
