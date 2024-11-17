package com.example.demo.servicei;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.model.Address;

import com.example.demo.repo.AddressRepository;
import com.example.demo.service.AddressService;



@Service
public class AddressServiceI implements AddressService
{
	@Autowired
	AddressRepository ar;

	@Override
	public Address addAddress(Address objaddress) {
	
		return ar.save(objaddress);
	}

	@Override
	public Address list(Address a1) {
		// TODO Auto-generated method stub
		return ar.save(a1);
	}

	@Override
	public List<Address> getAllAddress() {
		
		return ar.findAll();
	}


}
