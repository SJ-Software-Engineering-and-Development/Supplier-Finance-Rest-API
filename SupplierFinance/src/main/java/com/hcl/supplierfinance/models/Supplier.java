package com.hcl.supplierfinance.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="supplier")
public class Supplier {
	
	@Id
	@GeneratedValue
	@Column(name="suppliertId")
	private Long supplierId;
	@Column(name="supplierName")
	private String name;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	@Column(name="country")
	private String country;
	@Column(name="contactNo")
	private String phoneNumber;
	
	@Column(name="supplierLimit")
	private Double supplierLimit;
	
	@OneToOne
	private User user;
	
	@OneToOne
	private Account account;
	
	@OneToMany(mappedBy = "supplier")
	private List<Invoice> innvoice;
	
	
	public Supplier() {
		super();
	}
	public Supplier(String name, String city, String state, String country, String phoneNumber,Double supplierLimit, User user, Account account) {
		super();
		this.name = name;
		this.city = city;
		this.state = state;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.user = user;
		this.supplierLimit = supplierLimit;
		this.account = account;
	}
	
	
	public Double getSupplierLimit() {
		return supplierLimit;
	}
	public void setSupplierLimit(Double supplierLimit) {
		this.supplierLimit = supplierLimit;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
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
