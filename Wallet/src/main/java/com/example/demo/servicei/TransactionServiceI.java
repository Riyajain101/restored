package com.example.demo.servicei;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.model.Acount;
import com.example.demo.model.Transaction;

import com.example.demo.repo.TransactionRepository;
import com.example.demo.service.TransactionService;






@Service
public class TransactionServiceI implements TransactionService
{
	@Autowired
	TransactionRepository tr;

	public Transaction depositInAcount( Transaction t1) {

		return tr.save(t1);
	}

	@Override
	public void save(Transaction transaction) {
	tr.save(transaction);
		
	}
	@Override
	public void updateOpeningBalanceByAccountNumber(Acount acc, double newOpeningBalance) {
		// TODO Auto-generated method stub
		acc.setOpeningBalance(newOpeningBalance);
		tr.save(acc);
}

	@Override
	public List<Transaction> findTransactionsByCustomerId(int customerId) {
        return tr.findByFromAccount_Customer_CustomerIdOrToAccount_Customer_CustomerId(customerId, customerId);

	}
}



	