package com.au.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.au.model.AccountDetails;

public interface AccountRepository extends CrudRepository<AccountDetails, Integer>{
	
	@Query("SELECT a.accountNumber,a.accountName,a.accountType,a.balanceDate,a.currency,a.availableBalance FROM AccountDetails a where a.accountName = :accountName") 
    List<AccountDetails> findAccountByName(@Param("accountName") String  accountName);
}
