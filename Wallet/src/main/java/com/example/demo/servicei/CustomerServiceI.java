package com.example.demo.servicei;

import java.sql.Date;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.PaginationRequestDto;
import com.example.demo.Dto.PaginationResponse;
import com.example.demo.model.Acount;
import com.example.demo.model.Customer;
import com.example.demo.repo.CustomerRepository;
import com.example.demo.service.CustomerService;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;

@Service
public class CustomerServiceI implements CustomerService
{
	@Autowired
	CustomerRepository cr;



	@Value("${customer.expiry.days}")
    private int expiryDays;

    @Override
    public Customer addCustomer(@Valid Customer objcustomer) {
        if (objcustomer.getRegistrationDate() != null) {
//            objcustomer.setExpiryDate(Date.from(objcustomer.getRegistrationDate().plusDays(expiryDays).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        	LocalDate registrationDate = objcustomer.getRegistrationDate(); // Assuming this is already a LocalDate
        	LocalDate expiryDate = registrationDate.plusDays(expiryDays); // Add days to registration date
        	objcustomer.setExpiryDate(expiryDate); // Set the LocalDate directly
        	System.out.println(objcustomer);
        }
        return cr.save(objcustomer); 

	}


	@Override
	public Customer getAccountByAccountNo(int accno) {
		// TODO Auto-generated method stub
		return cr.findById(accno).get();
	}


	@Override
	public Customer findCustomerById(int customerId) {
	    return cr.findById(customerId).orElse(null);

	}


	@Override
	public Customer findCustomerWithAddressAndAccount(int customerId) {
        return cr.findById(customerId).orElse(null); 


		
	}

	public List<Customer> findAllCustomersWithAddressAndAccounts() {
        // Fetch all customers
        List<Customer> customers = cr.findAll();

        // Iterate through each customer and populate address and account details
        for (Customer customer : customers) {
            // Optionally, you could manually fetch addresses and accounts here, but they should already
            // be fetched based on your JPA entity relationship mappings.
            customer.getAddress();  // This will load the associated address
            customer.getAccounts();  // This will load associated accounts if using @OneToMany mapping
        }

        return customers;
    }
	
	
	
	
	//                     Pagination--------------------------------------------------------------------------------------------

//	Offset is generally used to skip a certain number of records from the beginning of the dataset.
//	For example:
//	If you are displaying 10 records per page and you are on page 3, the offset would be calculated as:
//	makefile
//	Copy code
//	offset = (page_number - 1) * records_per_page
//	offset = (3 - 1) * 10 = 20
//	This means the query will start retrieving records from the 21st record (remember that offset is zero-based).
	@Override
//	public PaginationResponse paginationAndSortingOfAllCustomerTbl(PaginationRequestDto paginationRequestDto) {
//	    // Determine the sort direction (ascending or descending)
//	    Sort.Direction sortDirection = paginationRequestDto.getSortedType().equalsIgnoreCase("DESC") 
//	        ? Sort.Direction.DESC : Sort.Direction.ASC;
//
//	    // Create a Sort object based on the field name and direction
//	    Sort sort = Sort.by(sortDirection, paginationRequestDto.getSortByFieldName());  // Use the instance
//
//	    // Create PageRequest using the offset and limit provided
//	    PageRequest pageRequest = PageRequest.of(
//	        paginationRequestDto.getOffSet() / paginationRequestDto.getLimit(),  // Use the instance
//	        paginationRequestDto.getLimit(),  // Page size
//	        sort  // Sorting order
//	    );
//
//	    // Query the repository to fetch the data with pagination and sorting
//	    Page<Customer> customerPage = cr.findAll(pageRequest);
//
//	    // Create the PaginationResponse
//	    PaginationResponse response = new PaginationResponse(
//	        customerPage.getContent(),    // The content of the current page (list of customers)
//	        customerPage.getTotalElements(),  // Total number of elements in the database
//	        customerPage.getTotalPages(),  // Total number of pages
//	        customerPage.getNumber(),     // Current page number (0-based index)
//	        customerPage.getSize()        // Page size
//	    );
//
//	    return response;
//	}
//}
	
	
//	public PaginationResponse paginationAndSortingOfAllCustomerTbl(PaginationRequestDto paginationRequestDto) {
//	    // Calculate the offset for pagination
//	    int offset = paginationRequestDto.getOffSet();
//	    int limit = paginationRequestDto.getLimit();
//
//	    // Call the repository method to fetch paginated data
//	    List<Customer> customers = cr.findCustomersWithPagination(offset, limit);
//
//	    // Get the total number of records (without pagination) to calculate total pages
//	    long totalRecords = cr.count(); // or any other method you have for counting the total records
//
//	    // Prepare the pagination response
//	    int totalPages = (int) Math.ceil((double) totalRecords / limit);
//
//	    return new PaginationResponse(
//	            customers,  // the paginated content
//	            totalRecords,  // total number of records
//	            totalPages,  // total number of pages
//	            offset / limit,  // current page number (0-based)
//	            limit  // page size
//	    );
//	}
//}
	
	
	
	
	
	
	
	
	public PaginationResponse paginationAndSortingOfAllCustomerTbl(PaginationRequestDto paginationRequestDto) {
	    // Calculate the offset and limit for pagination
	    int offset = paginationRequestDto.getOffSet();
	    int limit = paginationRequestDto.getLimit();
	    String sortedType = paginationRequestDto.getSortedType();  // 'asc' or 'desc'
//String sort=paginationRequestDto.getSortByFieldName();
	    // Call the repository method to fetch paginated and sorted data
	    List<Customer> customers = cr.findCustomersWithPagination(offset, limit, sortedType);

	    // Get the total number of records (without pagination) to calculate total pages
	    long totalRecords = cr.count(); // Or any other method to count the total records

	    // Calculate total pages
	    int totalPages = (int) Math.ceil((double) totalRecords / limit);

	    return new PaginationResponse(
	            customers,  // List of customers (paginated)
	            totalRecords,  // Total number of records
	            totalPages,  // Total number of pages
	            offset / limit,  // Current page number (0-based)
	            limit  // Page size
	    );
	}
}
//------------------------------------------------------------------------------------------------------------------------------------------------------------