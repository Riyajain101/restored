package com.example.demo.service;
import java.util.List;

import com.example.demo.model.Address;




public interface AddressService {

	public Address list(Address a1);

	 public List<Address> getAllAddress(); 

	public Address addAddress(Address objaddress);

	

}

