package com.example.demo.servicei;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.model.Acount;

import com.example.demo.repo.AcountRepository;
import com.example.demo.service.AcountService;





@Service
public class AcountServiceI implements AcountService
{
	@Autowired
	AcountRepository aa;

	@Override
	public Acount addAcount(Acount objacc) {

		return  aa.save(objacc);
	}

	@Override
	public Acount list(Acount a1) {
		// TODO Auto-generated method stub
		return aa.save(a1);
	}

	@Override
	public List<Acount> getAllAcounts() {
		
		return aa.findAll();
	}

	
	  @Override
	  public Acount getAccountById(int accountNo) {
	  System.out.println("done");
	  System.out.println(accountNo);
	  return aa.findById(accountNo).get();
	  }
	@Override
	public void updateOpeningBalanceByAccountNumber(int accountNo, double newOpeningBalance) {
		Acount account = getAccountById(accountNo);
        account.setOpeningBalance(newOpeningBalance);
        aa.save(account); // Save the updated account
    }

	@Override
	public List<Acount> getAllAccounts() {
		// TODO Auto-generated method stub
		return aa.findAll();
	}

	@Override
	public Acount save(Acount acount) {
		// TODO Auto-generated method stub
		return aa.save(acount);
	}
		
	}





		

