package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.model.Acount;
import com.example.demo.model.Customer;
import com.example.demo.repo.AcountRepository;
import com.example.demo.repo.CustomerRepository;
import com.example.demo.service.AcountService;
import com.example.demo.service.CustomerService;
import com.example.demo.service.TransactionService;

@SpringBootTest
class WalletApplicationTests {

	@Test
	void contextLoads() {
	}
@Autowired
private CustomerService cs;
@Autowired
private AcountService as;
@MockBean
private AcountRepository rp;
@Autowired
private TransactionService ts;

private MockMvc mockMvc;  // MockMvc object for simulating HTTP requests

@MockBean
private CustomerRepository repository;

//public void saveCustomerTest() {
//	Customer c= new Customer();
//
//	when(repository.save (c)).thenReturn(c);
//	assetsEquals(c,cs.addCustomer(c));
//}
@Test
public void saveCustomerTest() {
    // Arrange: Create a mock customer object
    Customer c = new Customer();
    c.setFirstName("vvvv");
    c.setLastName("vvvv");
    c.setEmailId("vvvvvvvv.com");
    c.setContactNo(123456789);
    c.setGender("Male");
    c.setPassword("password123");
    c.setRegistrationDate(LocalDate.now());

    // Mock repository's save method to return the same customer
    when(repository.save(c)).thenReturn(c);

    // Act: Call the service's addCustomer method
    Customer result = cs.addCustomer(c);

    // Assert: Verify the result and interactions
    assertEquals(c, result, "The saved customer should match the input customer");
    verify(repository, times(1)).save(c); // Verify that save was called once
}

@Test
public void saveAccountTest() {
	Customer customer = new Customer();
    customer.setCustomerId(1); // Set a valid customer ID or create a real customer if needed


	Acount a=new Acount();
	a.setAccountno(0);
	a.setCustomer(customer);
	a.setAccountType("deposit");
	a.setOpeningBalance(676);
	a.setOpeningDate(LocalDate.now());
	a.setDescription("done");
	
	when(rp.save(a)).thenReturn(a);
	Acount res=as.addAcount(a);
	assertEquals(a,res,"done");
	verify(rp,times(1)).save(a);
	
}

@Test
public void testGetAccountByAccountNo() {
    // Arrange: Prepare a mock account to be returned by the repository
    int accountNo = 1;  // Sample account number
    Acount mockAccount = new Acount();
    mockAccount.setAccountno(accountNo);
    mockAccount.setAccountType("savings");
    mockAccount.setOpeningBalance(1000);
    mockAccount.setOpeningDate(LocalDate.now());
    mockAccount.setDescription("Test Account");

    // Mock the repository call to return the mock account by account number
    when(rp.findById(accountNo)).thenReturn(Optional.of(mockAccount));

    // Act: Call the service method
    Acount result = as.getAccountById(accountNo);

    // Assert: Verify the result and check the values
    assertNotNull(result, "Account should not be null");
    assertEquals(accountNo, result.getAccountno(), "Account number should match");
    assertEquals("savings", result.getAccountType(), "Account type should be 'savings'");
    assertEquals(1000, result.getOpeningBalance(), "Opening balance should be 1000");
    assertEquals("Test Account", result.getDescription(), "Description should match");

    // Verify repository interaction: Ensure the repository method was called once with the given account number
    verify(rp, times(1)).findById(accountNo);
}


@Test
public void testGetaccountList() throws Exception {
    // Arrange: Create mock Customer object
    Customer mockCustomer = new Customer();  // Assuming Customer has a no-argument constructor
    mockCustomer.setCustomerId(1);  // Set customer details (assuming this is a valid field)
    mockCustomer.setFirstName("John Doe");

    // Create mock data for Acount objects using setters
    Acount account1 = new Acount();  // Default constructor
    account1.setAccountno(1);  // Set values using setters
    account1.setCustomer(mockCustomer);
    account1.setAccountType("Savings");
    account1.setOpeningBalance(1000.0);
    account1.setOpeningDate(LocalDate.now());
    account1.setDescription("Test account 1");

    Acount account2 = new Acount();  // Default constructor
    account2.setAccountno(2);  // Set values using setters
    account2.setCustomer(mockCustomer);
    account2.setAccountType("Checking");
    account2.setOpeningBalance(2000.0);
    account2.setOpeningDate(LocalDate.now());
    account2.setDescription("Test account 2");

    List<Acount> mockAccounts = Arrays.asList(account1, account2);  // Mock list of accounts

    // Mock the service method to return the list of mock accounts
    when(as.getAllAccounts()).thenReturn(mockAccounts);

    // Act: Perform the GET request to the controller
    mockMvc.perform(get("/listallaccounts"))  // Simulate GET request to the controller endpoint
        .andExpect(status().isOk())  // Assert the HTTP status is 200 OK
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))  // Assert the response content type is JSON
        .andExpect(jsonPath("$[0].accountno").value(1))  // Assert the account number of the first account
        .andExpect(jsonPath("$[0].accountType").value("Savings"))  // Assert the account type of the first account
        .andExpect(jsonPath("$[1].accountno").value(2))  // Assert the account number of the second account
        .andExpect(jsonPath("$[1].accountType").value("Checking"));  // Assert the account type of the second account

    // Verify that the service method was called once
    verify(as, times(1)).getAllAccounts();
}
}