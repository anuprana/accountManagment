package com.au.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.au.model.TransactionDetails;

public interface TransactionRepo extends CrudRepository<TransactionDetails, Integer>{
	
	@Query("SELECT a.accountNumber,a.currency,a.debitamount,a.creditamount,a.transactionType,a.valueDate,a.transactionNarrative FROM TransactionDetails a where a.accountNumber = :accountNumber") 
    List<TransactionDetails> findAccountByAccountNumber(@Param("accountNumber") Integer  accountNumber);
}
