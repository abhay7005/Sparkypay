package com.sparkypay.accountservices.dto;

import java.time.LocalDateTime;

public class AccountDto {
	String id; // Identifier for the user who owns the account
	String accountName; // Name given to the account by the user
	String accountType; // Type of the account (e.g., Wallet, Savings,salary)
	Boolean status; // Current status of the account (e.g., Active, Inactive)
	String currency; // Currency in which the account operates (e.g., USD, EUR)
	Double balance; // Current balance of the account
	String accountNumber; // Unique identifier for the account within the application
	String iban;
	LocalDateTime createdAt;
	LocalDateTime updatedAt;

	public AccountDto() {

	}

	public AccountDto(String id, String accountName, String accountType, Boolean status, String currency,
			Double balance, String accountNumber, String iban, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.accountName = accountName;
		this.accountType = accountType;
		this.status = status;
		this.currency = currency;
		this.balance = balance;
		this.accountNumber = accountNumber;
		this.iban = iban;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "AccountDto [id=" + id + ", accountName=" + accountName + ", accountType=" + accountType + ", status="
				+ status + ", currency=" + currency + ", balance=" + balance + ", accountNumber=" + accountNumber
				+ ", iban=" + iban + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

	

}
