package com.hcl.supplierfinance.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.hcl.supplierfinance.models.Account;

public class ClientSignupRequest extends SignupRequest{
	
	@NotBlank
    @Size(min = 3, max = 120)
    private String fullName;
    
    @NotBlank
    @Size(min = 3, max = 20)
    private String city;
    
    @NotBlank
    @Size(min = 3, max = 20)
    private String state;
    
    @NotBlank
    @Size(min = 3, max = 20)
    private String county;
    
    @NotBlank
    @Size(min = 10, max = 10)
    private String phoneNumber;
    
    private Double creditLimit;
    
    private Account account;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

}
