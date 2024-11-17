package com.example.demo.config;

import java.io.ByteArrayInputStream;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Customer;
import com.example.demo.repo.CustomerRepository;

@Service
public class ExcelService {
	
	@Autowired
	private CustomerRepository cr;
	public ByteArrayInputStream getActualData() {
		//This method is designed to retrieve customer data from the database and return it as a byte stream suitable for creating an Excel file.
		List<Customer>all=cr.findAll();
		
		//The method then calls the static dataToExcel method from the Helper class, 
		//passing the list of customers. This method converts the customer data into an Excel format and returns it as a ByteArrayInputStream.

		ByteArrayInputStream b=Helper.dataToExcel(all);
		return b;
		
	}

}
