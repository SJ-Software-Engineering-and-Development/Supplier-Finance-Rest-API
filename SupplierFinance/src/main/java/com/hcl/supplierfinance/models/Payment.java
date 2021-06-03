package com.hcl.supplierfinance.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Payment")
public class Payment {
	
	@Id
	@GeneratedValue
	@Column(name="paymentId")
	private Long paymentId;
	
	@Column(name="paymentDate")
	private Date paymentDate;
	
	@ManyToOne
	private Bank banker;
	
	@ManyToOne
	private Invoice invoice;
	
	public Payment() {
		super();
	}
	public Payment(Date paymentDate, Bank banker, Invoice invoice) {
		this.paymentDate = paymentDate;
		this.banker = banker;
		this.invoice = invoice;
	}
	public long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Bank getBanker() {
		return banker;
	}
	public void setBanker(Bank banker) {
		this.banker = banker;
	}
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}	
	
}
