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
	private Long innvoiceId;
	
	@Column(name="innvoiceDate")
	private Date innvoiceDate;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="status")
	private String status;
	
	@Column(name="invoiceUrl")
	private String invoiceUrl;
	
	@Column(name="currency")
	private String currency;
	
	@OneToMany(mappedBy="invoice")
	private List<Payment> payment;
	
	@ManyToOne
	private Supplier supplier;
	
	@ManyToOne
	private Client client;
	
	
	public Invoice() {
		super();
	}

	public Invoice(Date innvoiceDate, double amount, String status, String invoiceUrl, String currency,
			Supplier supplier, Client client) {
		super();
		this.innvoiceDate = innvoiceDate;
		this.amount = amount;
		this.status = status;
		this.invoiceUrl = invoiceUrl;
		this.currency = currency;
		this.supplier = supplier;
		this.client = client;
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

	public List<Payment> getPayment() {
		return payment;
	}


	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}


	public Supplier getSupplier() {
		return supplier;
	}


	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Long getInnvoiceId() {
		return innvoiceId;
	}


	public void setInnvoiceId(Long innvoiceId) {
		this.innvoiceId = innvoiceId;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
}
