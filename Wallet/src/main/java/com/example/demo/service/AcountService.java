package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Acount;




public interface AcountService {

	public Acount list(Acount a1);

	 public List<Acount> getAllAcounts(); 

	public Acount addAcount(Acount objacc);

	Acount getAccountById(int accountNo);

	public List<Acount> getAllAccounts();

	public void updateOpeningBalanceByAccountNumber(int accountNo, double newOpeningBalance);

	public Acount save(Acount acount);
	 


}
