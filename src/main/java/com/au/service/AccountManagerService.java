package com.au.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.model.AccountDetails;
import com.au.model.TransactionDetails;
import com.au.repository.AccountRepository;
import com.au.repository.TransactionRepo;

@Service
public class AccountManagerService {

	@Autowired
	private AccountRepository accountRepo;
	@Autowired 
	private TransactionRepo transactionRepo;
	private List<AccountDetails> accountDetails;
	
	private void saveAccountDetails() {
		
		accountRepo.save(new AccountDetails(55334859,"SGSaving1","SavingsType",1000,"AUD",20000, new Date(10/11/2019)));
		accountRepo.save(new AccountDetails(65737764,"AUSavings1","SavingsType",20000,"AUD",20000,new Date(02/11/2019)));
		accountRepo.save(new AccountDetails(44569703,"AUCurrent34","CurrentType",1000,"AUD",20000,new Date(20/04/2018)));
		accountRepo.save(new AccountDetails(78934789,"FYSavings23","SavingsType",1000,"AUD",20000,new Date(19/11/2018)));
		
		transactionRepo.save(new TransactionDetails("SGSaving1",55334859, "AUD", 100, 0, "Credit", "", new Date(10/11/2019)));
		transactionRepo.save(new TransactionDetails("SGSavings1",55334859, "AUD", 0, 200, "Debit", "Debited", new Date(10/11/2019)));
		transactionRepo.save(new TransactionDetails("FYSavings23",78934789, "AUD", 23000, 0, "Credit", "Credit Transaction", new Date(10/11/2019)));
		transactionRepo.save(new TransactionDetails("AUCurrent34",44569703, "AUD", 1000, 0, "Credit", "", new Date(10/11/2019)));
		
		
	}
	public List<AccountDetails> getAccountDetails() {
		
		if(accountRepo.count() == 0)
			saveAccountDetails();
		
		accountDetails =  new ArrayList<AccountDetails>();
		accountRepo.findAll().forEach(accountDetails::add);

		return accountDetails;
	}
	
	public List<AccountDetails> getAccountDetails(String accountName) {

		if(accountRepo.count() == 0)
			saveAccountDetails();
		System.out.println(" Account Detaills --> " + accountRepo.count());
		return accountRepo.findAccountByName(accountName);

	}
	
	public List<TransactionDetails> getAccountDetails(Integer accountNumber) {
		if(accountRepo.count() == 0)
			saveAccountDetails();
		
		return transactionRepo.findAccountByAccountNumber(accountNumber);
	}
}
