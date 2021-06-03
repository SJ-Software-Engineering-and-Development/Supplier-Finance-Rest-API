package com.hcl.supplierfinance.DTO;

import javax.persistence.Column;
import javax.persistence.OneToOne;

import com.hcl.supplierfinance.models.User;

public class SupplierDTO {
	
	private String name;
	private String city;
	private String state;
	private String country;
	private String phoneNumber;
	private User user;
	
	public SupplierDTO() {
		super();
	}
	public SupplierDTO(String name, String city, String state, String country, String phoneNumber, User user) {
		super();
		this.name = name;
		this.city = city;
		this.state = state;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.user = user;
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
