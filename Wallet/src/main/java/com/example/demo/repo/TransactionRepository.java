package com.example.demo.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Acount;
import com.example.demo.model.Transaction;


public interface TransactionRepository extends JpaRepository<Transaction,Integer>{

	public void save(Acount acc);

	public List<Transaction> findByFromAccount_Customer_CustomerIdOrToAccount_Customer_CustomerId(int customerId,
			int customerId2);

	/*
	 * public List<Transaction> findByAccountAccountNo(int accountNo);
	 */

	

	
	 

	

}

