package com.hcl.supplierfinance.payload.request;

import java.util.Date;


public class PaymentReuest {
	
	private Date paymentDate;
	
	private Long bankId;
	
	private Long innvoiceId;

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public Long getInnvoiceId() {
		return innvoiceId;
	}

	public void setInnvoiceId(Long innvoiceId) {
		this.innvoiceId = innvoiceId;
	}
	
	

}
