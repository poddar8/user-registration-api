package com.example.restservice.model;

import java.util.Date;


import lombok.NoArgsConstructor;

//@Setter
//@Builder
@NoArgsConstructor
public class AccountResponse {
	
	private String accountNumber; 
	
	private Date lastUpdateTimestamp;
	
	private double balance;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Date getLastUpdateTimestamp() {
		return lastUpdateTimestamp;
	}

	public void setLastUpdateTimestamp(Date lastUpdateTimestamp) {
		this.lastUpdateTimestamp = lastUpdateTimestamp;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
