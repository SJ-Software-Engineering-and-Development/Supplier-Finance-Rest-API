package com.hcl.supplierfinance.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client {
	@Id
	@GeneratedValue
	@Column(name="clientId")
	private long clientId;
	
	@Column(name="fullName")
	private String name;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="country")
	private String country;
	
	@Column(name="contactNo")
	private String phoneNumber;
	
	@Column(name="creditLimit")
	private Double creditLimit;
	
	@OneToOne
	private User user;
	
	@OneToOne
	private Account account;
	
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	private List<Invoice> innvoice;
	
	
	public Client() {
		super();
	}
	
	public Client(String name, String city, String state, String country, String phoneNumber,
			Double creditLimit, User user, Account account) {
		super();
		this.name = name;
		this.city = city;
		this.state = state;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.creditLimit = creditLimit;
		this.user = user;
		this.account = account;
	}


	public Double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(Double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Invoice> getInnvoice() {
		return innvoice;
	}

	public void setInnvoice(List<Invoice> innvoice) {
		this.innvoice = innvoice;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	public Long getClientId() {
		return clientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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
