package com.au.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TransactionDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String accountName;
	private int accountNumber;
	private String currency;
	private int debitamount;
	private int creditamount;
	private String transactionType;
	private String transactionNarrative;
	private Date valueDate;
	
	public TransactionDetails(String accountName,int accountNumber, String currency, int debitamount, int creditamount,
			String transactionType, String transactionNarrative, Date valueDate) {
		super();
		this.accountName = accountName;
		this.accountNumber = accountNumber;
		this.currency = currency;
		this.debitamount = debitamount;
		this.creditamount = creditamount;
		this.transactionType = transactionType;
		this.transactionNarrative = transactionNarrative;
		this.valueDate = valueDate;
	}

	public TransactionDetails() {
		
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public int getDebitamount() {
		return debitamount;
	}

	public void setDebitamount(int debitamount) {
		this.debitamount = debitamount;
	}

	public int getCreditamount() {
		return creditamount;
	}

	public void setCreditamount(int creditamount) {
		this.creditamount = creditamount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTransactionNarrative() {
		return transactionNarrative;
	}

	public void setTransactionNarrative(String transactionNarrative) {
		this.transactionNarrative = transactionNarrative;
	}

	public Date getValueDate() {
		return valueDate;
	}

	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}
	
	
}
