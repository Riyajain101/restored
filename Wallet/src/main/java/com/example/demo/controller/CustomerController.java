package com.example.demo.controller;





//import java.time.LocalDate;




//
//
//
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin; // Import this
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.model.Acount;
//import com.example.demo.model.Address;
//
//import com.example.demo.model.Customer;
//
//import com.example.demo.service.AddressService;
//import com.example.demo.service.AcountService;
//import com.example.demo.service.CustomerService;
//
//@RestController
//public class CustomerController {
//
//	@Autowired
//		CustomerService cs;
//
//	@Autowired
//		    AddressService as;
//	 
//	@Autowired
//		    AcountService ar;
//		 
//		@GetMapping("/saveCustomerTbl")
//		@CrossOrigin(origins = "http://localhost:3001")  
//
//		public Customer addCustomer()
//		
//		{
//			
//	    Customer c1=new Customer("riya", "jain", "riyajain@gmail.com",789456312 , "Female", "12345",LocalDate.now());		
//		Customer c2=new Customer( "parteek",    "jain",  "parteek1@mail.com",   888976558 ,  "male",   "jain1",    LocalDate.now());
//	    Customer c3=new Customer( "simran",  "goel","goel@goel.com",     788976778 ,     "female",   "76886",    LocalDate.now());
//	    
//	    
//	        Address a1 = new Address("abc1","abc2","panipat","haryana",132103);
//        Address b1 = as.addAddress(a1);
//	        Address k1 = new Address("def1","de2","panipat","haryana",132103);
//	        Address d1 = as.addAddress(k1);
//	        Address e1 = new Address("gh1","gh2","panipat","haryana",132103);
//	        Address f1 = as.addAddress(e1);
//	        c1.setAddress(b1);
////	        c2.setAddress(b1);
//	        c3.setAddress(d1);
//
//	        Acount z1=new Acount(1,c1,"current",0,LocalDate.now(),"desc1");
//			 Acount y1=new Acount(2,c1,"current",0,LocalDate.now(),"desc2");
//  
//        c1.getAcount().add(z1);
//        c1.getAcount().add(y1);
//       
//      cs.addCustomer(c1);
//      
//      cs.addCustomer(c2);
//      cs.addCustomer(c3);
//
//        return c1;    
//
//		}		
//}

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.config.ExcelService;
import com.example.demo.customAnnotation.ValidateCustomerId;
import com.example.demo.model.Acount;
import com.example.demo.model.Address;

import com.example.demo.model.Customer;
import com.example.demo.service.AddressService;
import com.example.demo.service.AcountService;
import com.example.demo.service.CustomerService;
import com.example.demo.servicei.CustomerServiceI;

import jakarta.validation.Valid;

@RestController
public class CustomerController {
	
	@Autowired
	private ExcelService es;


    @Autowired
    private CustomerService cs;

    @Autowired
    private AddressService as;

    @Autowired
    private AcountService ar;
@Autowired
private CustomerServiceI ci;
//---------------------------------------------------------------------------------------------------------------------------------------------- 
//1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111
    @PostMapping("/saveCustomerTbl")

    @CrossOrigin(origins = "http://localhost:3000")
    public Customer addCustomer(@RequestBody Customer customer) {
        Address address = customer.getAddress();
        if (address != null) {
            Address savedAddress = as.addAddress(address); 
            customer.setAddress(savedAddress); 
        }
      
       

        return cs.addCustomer(customer);
    }

//===============================================================================================================================================
  //  2222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222
    @PostMapping("/saveAcountTbl/{customerId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Acount saveAccount(@PathVariable int customerId, @RequestBody Acount acount) {
        // Create a new Customer object with the provided customerId
        Customer customer = new Customer();
        customer.setCustomerId(customerId);

        // Set the customer in the Acount object
        acount.setCustomer(customer);

        // Save the account
        return ar.addAcount(acount);
 }
    


//==============================================================================================================================================
    //333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333

    @CrossOrigin(origins = "http://localhost:3000")

    @RequestMapping(value="/getaccountbyaccountno",method=RequestMethod.GET)
    public Map<String,Object>getAccountByAccountNo(@RequestParam(value="accountno")int accountno)
    {
    	final HashMap<String,Object>map=new HashMap<>();
    	map.put("acount", ar.getAccountById(accountno));
    	return map;
    }
    
    //=======================================================================================================================================
    //4444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444
    
    
    @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping("/listallaccounts") 
	  public List<Acount> getaccountList() {
		  return 
	  ar.getAllAcounts();
  }
       
//========================================================================================================================================
    //555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555
@GetMapping("/excel")
//The download method handles requests to download an Excel file. It retrieves the Excel 
//data as a byte stream, checks for null conditions, and constructs a response
public ResponseEntity<Resource>download()
{
	//A string variable filename is defined to set the name of the Excel file that will be downloaded.
    String filename = "customer.xlsx";
    //This line calls the getActualData method from the ExcelService (represented by es) to retrieve the Excel data as a byte stream.
	ByteArrayInputStream ad=es.getActualData();
	if (es == null) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(null); // Handle this as needed
    }
	//InputStreamResource file = new InputStreamResource(ad);:
	//This wraps the byte stream in an InputStreamResource, which allows it to be returned as a downloadable resource.

	InputStreamResource file=new 	InputStreamResource (ad);
	ResponseEntity<Resource>body=ResponseEntity.ok()
			//This header specifies that the content should be treated as an attachment, prompting a file download with the specified filename.
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
//This sets the content type of the response to indicate that it's an Excel file in the modern format (.xlsx).

            .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) // For .xlsx
//the InputStreamResource containing the Excel data is set as the body of the response, which is then returned.
.body(file);

	return body;
}

@PostMapping("/validate")
public ResponseEntity<Customer> Customer(@Valid @RequestBody Customer customer) {
    // This triggers validation, including your custom @ValidateCustomerId
    Customer savedCustomer = ci.addCustomer(customer);  // Add customer to the database
    return ResponseEntity.ok(savedCustomer);  // Return the saved customer as response
}



}