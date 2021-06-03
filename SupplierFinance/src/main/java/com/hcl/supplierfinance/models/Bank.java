package com.hcl.supplierfinance.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bank")
public class Bank {
	@Id
	@Column(name="bankId")
	private long bankId;
	@Column(name="bankerName")
	private String name;
	@Column(name="contactNo")
	private String phoneNumber;
	@OneToOne
	private User user;
	@OneToMany(mappedBy="banker")
	private List<Payment> payment;
	
	public Bank() {
		super();
	}
	public Bank(long bankId, String name, String phoneNumber, User user) {
		super();
		this.bankId = bankId;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.user = user;
	}
	
	
	public List<Payment> getPayment() {
		return payment;
	}
	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}
	public long getBankId() {
		return bankId;
	}

	public void setBankId(long bankId) {
		this.bankId = bankId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
