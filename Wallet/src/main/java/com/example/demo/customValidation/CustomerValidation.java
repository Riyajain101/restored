package com.example.demo.customValidation;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.customAnnotation.ValidateCustomerId;
import com.example.demo.model.Customer;
import com.example.demo.repo.CustomerRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//
//@RequiredArgsConstructor
//@Slf4j
//@Component
//public class CustomerValidation implements ConstraintValidator<ValidateCustomerId, Integer>  {
//	@Autowired
//	private  CustomerRepository cr;
//	
//	@Override
//	public boolean isValid(Integer cus, ConstraintValidatorContext context) {
//        Customer customer = cr.findById(cus).orElse(null);  
//
//        
//		return customer !=null;
//	}
//
//	public CustomerValidation() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public CustomerValidation(CustomerRepository cr) {
//		super();
//		this.cr = cr;
//	}
//
//	@Override
//	public String toString() {
//		return "CustomerValidation [cr=" + cr + "]";
//	}
//
//	public CustomerRepository getCr() {
//		return cr;
//	}
//
//	public void setCr(CustomerRepository cr) {
//		this.cr = cr;
//	}
//}
//


//public class CustomerValidation implements ConstraintValidator<ValidateCustomerId, Integer> {
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    @Override
//    public boolean isValid(Integer customerId, ConstraintValidatorContext context) {
//        if (customerId == null || customerId <= 0) {
//            return false;
//        }
//        
//        // Check if the customerId exists in the database
//        return customerRepository.existsById(customerId);
//    }
//}


public class CustomerValidation implements ConstraintValidator<ValidateCustomerId, Integer> {
    @Override
    public void initialize(ValidateCustomerId constraintAnnotation) {
        // Initialization logic (if any)
    }

    @Override
    public boolean isValid(Integer customerId, ConstraintValidatorContext context) {
    	
    	
        // Example logic to check if customerId is invalid (e.g., 0 is not valid)
        if (customerId == 0) {
            context.buildConstraintViolationWithTemplate("Customer ID cannot be zero.")
                   .addConstraintViolation();
            return false;  // Invalid
        }
        return true;  // Valid
    }
}

