package com.example.demo.customAnnotation;

import java.lang.annotation.*;


import com.example.demo.customValidation.CustomerValidation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CustomerValidation.class)
@ReportAsSingleViolation
public @interface ValidateCustomerId {
	
	 String message() default "id cannot be 0000000000";

	    Class<?>[] groups() default {};
	    Class<? extends Payload>[] payload() default { };
}

