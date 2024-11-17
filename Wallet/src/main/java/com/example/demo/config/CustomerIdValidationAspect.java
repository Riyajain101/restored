//package com.example.demo.config;
//
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import jakarta.servlet.http.HttpServletRequest;
//
//
//@Aspect
//@Component
//public class CustomerIdValidationAspect {
//
//    // Define a pointcut that matches any method annotated with @CustomerIdRequired
////    @Pointcut("@annotation(CustomerIdRequired)")
////    public void customerIdRequiredMethods() {}
////
////    // Before advice: runs before methods with @CustomerIdRequired annotation are executed
////    @Before("customerIdRequiredMethods() && args(request, ..)")
////    public void validateCustomerId(HttpServletRequest request) throws Exception {
////        String customerId = request.getParameter("customerId");
////
////        if (customerId == null || customerId.isEmpty()) {
////            throw new IllegalArgumentException("Customer ID is required.");
////        }
////    }
////}
//	
//	
//	
//	
//	
//	
//	
////	@Aspect
////	@Component
////	public class CustomerIdValidationAspect {
//
//	    @Before("@annotation(CustomerIdRequired)")
//	    public void validateCustomerIdPresence(HttpServletRequest request) {
//	        String customerId = request.getParameter("customerId");
//	        if (customerId == null ) {
//	            throw new IllegalArgumentException("Customer ID is required.");
//	        }
//	    }
//	}
//
