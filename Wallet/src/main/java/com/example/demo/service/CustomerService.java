package com.example.demo.service;


import java.util.List;



import com.example.demo.model.Customer;
import com.example.demo.Dto.PaginationRequestDto;
import com.example.demo.Dto.PaginationResponse;
public interface CustomerService {

	
	
public Customer addCustomer(Customer objcustomer);
public Customer getAccountByAccountNo(int accno);
public Customer findCustomerById(int customerId);
public Customer findCustomerWithAddressAndAccount(int customerId);

public PaginationResponse paginationAndSortingOfAllCustomerTbl(PaginationRequestDto paginationRequestDto);
public List<Customer> findAllCustomersWithAddressAndAccounts();


}


