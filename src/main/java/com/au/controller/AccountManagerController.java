package com.au.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.au.constants.AccountConstants;
import com.au.exception.NoAccountExistException;
import com.au.exception.NoTransactionExistException;
import com.au.model.AccountDetails;
import com.au.model.TransactionDetails;
import com.au.service.AccountManagerService;

@RestController
public class AccountManagerController {
	
	@Autowired
	private AccountManagerService accountManagerService;
	
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/getAccountList/{accountName}")
	public List<AccountDetails> getAccountDetails(@PathVariable String accountName) throws NoAccountExistException {
		List<AccountDetails> accountDetails =  accountManagerService.getAccountDetails(accountName);
		if(accountDetails.size() == 0)
			throw new NoAccountExistException(AccountConstants.NO_ACCOUNT_FOUND);
		return accountManagerService.getAccountDetails(accountName);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/getTransactionsList/{accountNumber}")
	public List<TransactionDetails> getAccountDetails(@PathVariable Integer accountNumber) throws NoTransactionExistException {
		List<TransactionDetails> transactionDetails= accountManagerService.getAccountDetails(accountNumber);
		
		if(transactionDetails.size() == 0 )
			throw new NoTransactionExistException(AccountConstants.NO_TRANSACTION_DETAILS_FOUND);
		return accountManagerService.getAccountDetails(accountNumber);
	}
}
