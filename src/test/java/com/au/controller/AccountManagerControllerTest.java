package com.au.controller;

import java.util.Date;
import java.util.List;

import org.hibernate.service.spi.InjectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.au.model.AccountDetails;
import com.au.model.TransactionDetails;
import com.au.repository.AccountRepository;
import com.au.repository.TransactionRepo;
import com.au.service.AccountManagerService;

import junit.framework.Assert;
import junit.framework.TestCase;

@RunWith(MockitoJUnitRunner.class)
public class AccountManagerControllerTest extends TestCase{

	
	@Mock
    private RestTemplate restTemplate;

	@Mock
    private AccountManagerService mockAccountService;
	
	@Mock 
	AccountRepository accountRepo;
	
	@Mock
	TransactionRepo transactionRepo;

	
	@Test
	public void testAccountDetails() {
		
		AccountDetails account = new AccountDetails(123,"ANUP","SavingsType",1000,"AUD",20000, new Date(10/11/2019));
				
		Mockito
          .when(restTemplate.getForEntity(
            "http://localhost:8080/getAccountList/ANUP", AccountDetails.class))
          .thenReturn(new ResponseEntity(account, HttpStatus.OK));
		 
		List<AccountDetails> accountDetails = mockAccountService.getAccountDetails("ANUP");
		
		Assert.assertEquals(account.getAccountName(), accountDetails.get(0).getAccountName());		
	}
	
	@Test
	public void testTransactionDetails() {
		
		
		TransactionDetails transaction = new TransactionDetails("SGSaving1",55334859, "AUD", 100, 0, "Credit", "", new Date(10/11/2019));	
		Mockito
          .when(restTemplate.getForEntity(
            "http://localhost:8080/getTransactionsList/55334859", AccountDetails.class))
          .thenReturn(new ResponseEntity(transaction, HttpStatus.OK));
		 
		
		List<TransactionDetails> transDetail = mockAccountService.getAccountDetails(55334859);
		
		Assert.assertEquals(transaction.getAccountNumber(), transDetail.get(0).getAccountNumber());		
	}
	

	
}
