package com.example.demo.service;


import java.util.List;

import com.example.demo.model.Acount;
import com.example.demo.model.Transaction;

public interface TransactionService {

	public Transaction  depositInAcount(Transaction t1);

	public void save(Transaction transaction);

	public void updateOpeningBalanceByAccountNumber(Acount acc, double newOpeningBalance);

	public List<Transaction> findTransactionsByCustomerId(int customerId);

	/*
	 * public List<Transaction> getTransactionsByAccount(int accountNo);
	 */
}
