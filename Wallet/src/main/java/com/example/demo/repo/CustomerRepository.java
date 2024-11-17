package com.example.demo.repo;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer,Integer>{

    List<Customer> findByExpiryDate(LocalDate expiryDate);
    
    @Query(value = "SELECT * FROM ( " +
	        "  SELECT c1_0.customer_id, c1_0.addfk, c1_0.contact_no, c1_0.email_id, " +
	        "         c1_0.expiry_date, c1_0.first_name, c1_0.gender, c1_0.is_deleted, " +
	        "         c1_0.last_name, c1_0.password, c1_0.registration_date, " +
	        "         ROW_NUMBER() OVER (ORDER BY " +
	        "           CASE WHEN :sortedType = 'asc' THEN c1_0.customer_id END ASC, " +
	        "           CASE WHEN :sortedType = 'desc' THEN c1_0.customer_id END DESC " +
	        "         ) AS rn " +
	        "  FROM customer c1_0 " +
	        ") " +
	        "WHERE rn > :offset AND rn <= (:offset + :limit)", nativeQuery = true)
	List<Customer> findCustomersWithPagination(@Param("offset") int offset, @Param("limit") int limit, 
	                                           @Param("sortedType") String sortedType);
}