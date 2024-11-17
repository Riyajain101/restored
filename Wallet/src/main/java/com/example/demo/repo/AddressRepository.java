package com.example.demo.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Address;


public interface AddressRepository extends JpaRepository<Address,Integer>{


}
