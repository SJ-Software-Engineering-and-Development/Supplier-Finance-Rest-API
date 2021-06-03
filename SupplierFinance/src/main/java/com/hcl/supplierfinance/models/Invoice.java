package com.hcl.supplierfinance.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Invoice")
public class Invoice {
	
	@Id
	@GeneratedValue
	@Column(name="innvoiceId")
	private long innvoiceId;
	
	@Column(name="innvoiceDate")
	private Date innvoiceDate;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="status")
	private int status;
	
	@OneToMany(mappedBy="invoice")
	private List<Payment> payment;
	
	@ManyToOne
	private Supplier supplier;
	
	@ManyToOne
	private Client client;
	
	public Invoice() {
		super();
	}
	public Invoice(long innvoiceId, Date innvoiceDate, double amount, int status,
			Supplier supplier, Client client) {
		super();
		this.innvoiceId = innvoiceId;
		this.innvoiceDate = innvoiceDate;
		this.amount = amount;
		this.status = status;
		this.supplier = supplier;
		this.client = client;
	}
	
	public List<Payment> getPayment() {
		return payment;
	}
	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}
	public long getInnvoiceId() {
		return innvoiceId;
	}
	public void setInnvoiceId(long innvoiceId) {
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
}
