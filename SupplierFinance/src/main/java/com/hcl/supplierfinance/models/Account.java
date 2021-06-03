package com.hcl.supplierfinance.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Account")
public class Account {
	
	@Id
	@Column(name="AccountNumber")
	private Long accountNumber;
	
	@Column(name="bankName")
	private String bankName;
	
	@Column(name="AccountType")
	private String accountType;
	
	@Column(name="bankCode")
	private String bankCode;
	
	public Account() {
	}
	
	public Account(Long accountNumber, String bankName, String accountType, String bankCode) {
		super();
		this.accountNumber = accountNumber;
		this.bankName = bankName;
		this.accountType = accountType;
		this.bankCode = bankCode;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	
	
}

