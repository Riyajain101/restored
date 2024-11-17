package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Acount;
import com.example.demo.model.Customer;
import com.example.demo.model.Transaction;
import com.example.demo.service.CustomerService;
import com.example.demo.service.TransactionService;

import com.example.demo.service.PdfService;
import com.itextpdf.text.DocumentException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PdfController {
@Autowired
    private PdfService pdfService;

   @Autowired
   CustomerService cs;
//   
//              @Autowired
//       private CustomerService customerService;
              
              @Autowired
              private TransactionService ts;

//              @GetMapping("/pdffile/{customerId}")
//              public ResponseEntity<InputStreamResource> createPdf(@PathVariable int customerId) throws DocumentException, IOException {
//                  // Fetch customer details along with address and account details
//                  Customer customer = customerService.findCustomerWithAddressAndAccount(customerId);
//
//                  // If customer is not found, return a Not Found response
//                  if (customer == null) {
//                      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//                  }
//
//                  // Fetch transactions for the customer
//                  List<Transaction> transactions = ts.findTransactionsByCustomerId(customerId);
//
//                  // If no transactions are found, you can still proceed, but maybe with a warning message.
//                  if (transactions == null || transactions.isEmpty()) {
//                      // Optionally log or handle empty transactions case
//                  }
//
//                  // Generate the PDF using the customer, transactions, and account details
//                  List<Acount> accounts = new ArrayList<>();
//                  for (Transaction transaction : transactions) {
//                      // Adding accounts associated with transactions
//                      if (transaction.getFromAccount() != null && !accounts.contains(transaction.getFromAccount())) {
//                          accounts.add(transaction.getFromAccount());
//                      }
//                      if (transaction.getToAccount() != null && !accounts.contains(transaction.getToAccount())) {
//                          accounts.add(transaction.getToAccount());
//                      }
//                  }
//
//                  // Generate the PDF
//                  ByteArrayInputStream pdf = pdfService.createPdf(customer, transactions, accounts);
//
//                  // Set the response headers to indicate a PDF content type and inline display
//                  HttpHeaders httpHeaders = new HttpHeaders();
//                  httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=customer-details.pdf");
//
//                  // Return the response with PDF content and headers
//                  return ResponseEntity.ok()
//                          .headers(httpHeaders)
//                          .contentType(MediaType.APPLICATION_PDF)
//                          .body(new InputStreamResource(pdf));
//              }
//
//}
              
              
              
              
              
              
              
              
              
              //fetching all customers
              
              
              
              
              
              
              
              
              
              
              
              
              @GetMapping("/pdffile")
              public ResponseEntity<InputStreamResource> createPdf() throws DocumentException, IOException {
                  // Fetch all customers along with address and account details
                  List<Customer> customers = cs.findAllCustomersWithAddressAndAccounts();

                  // If no customers are found, return a Not Found response
                  if (customers == null || customers.isEmpty()) {
                      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
                  }

                  // Initialize the list to collect all accounts associated with the customers
                  List<Acount> accounts = new ArrayList<>();
                  List<Transaction> transactions = new ArrayList<>();

                  // Iterate through each customer and their associated transactions and accounts
                  for (Customer customer : customers) {
                      // Fetch transactions for the customer
                      List<Transaction> customerTransactions = ts.findTransactionsByCustomerId(customer.getCustomerId());

                      // Add transactions to the transactions list
                      if (customerTransactions != null && !customerTransactions.isEmpty()) {
                          transactions.addAll(customerTransactions);
                      }

                      // Add accounts associated with the transactions for the customer
                      for (Transaction transaction : customerTransactions) {
                          if (transaction.getFromAccount() != null && !accounts.contains(transaction.getFromAccount())) {
                              accounts.add(transaction.getFromAccount());
                          }
                          if (transaction.getToAccount() != null && !accounts.contains(transaction.getToAccount())) {
                              accounts.add(transaction.getToAccount());
                          }
                      }
                  }

                  // Generate the PDF using the customers, transactions, and accounts
                  ByteArrayInputStream pdf = pdfService.createPdfForAllCustomers(customers, transactions, accounts);

                  // Set the response headers to indicate a PDF content type and inline display
                  HttpHeaders httpHeaders = new HttpHeaders();
                  httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=all-customers-details.pdf");

                  // Return the response with PDF content and headers
                  return ResponseEntity.ok()
                          .headers(httpHeaders)
                          .contentType(MediaType.APPLICATION_PDF)
                          .body(new InputStreamResource(pdf));
              }

}