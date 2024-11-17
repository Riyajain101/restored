package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AcountService;
import com.example.demo.service.AddressService;
import com.example.demo.service.CustomerService;
import com.example.demo.service.TransactionService;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.example.demo.Dto.PaginationRequestDto;
import com.example.demo.Dto.PaginationResponse;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j 

public class AdminController {
	
	    @Autowired
    CustomerService cs;
    @Autowired
    AcountService accountService;
    @Autowired
    AddressService addressService;
    @Autowired
    TransactionService transactionService;
    
    private static final Logger log = LoggerFactory.getLogger(AdminController.class);


@PostMapping("/pagination")

public PaginationResponse PaginationAndSortingOfAllCustomerTbl(@RequestBody PaginationRequestDto paginationRequestDto){
	

	return cs.paginationAndSortingOfAllCustomerTbl(paginationRequestDto);
}
}