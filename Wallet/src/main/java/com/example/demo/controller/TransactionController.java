package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.DepositRequest;
import com.example.demo.model.WithdrawRequest;
import org.springframework.web.bind.annotation.CrossOrigin;


import com.example.demo.model.FundTransferRequest;
import com.example.demo.model.Acount;
import com.example.demo.model.Transaction;
import com.example.demo.service.AcountService;
import com.example.demo.service.TransactionService;

//@RestController
//public class TransactionController {
//
//
//		@Autowired
//		TransactionService ts;
//
//		@Autowired
//	    AcountService aS;
		
//	    @GetMapping("/deposit")
//
//    public Transaction depositInAccount() {
//	        
//	        int accountNo = 1;
//	        double amount = 50000.0;
//
//	        
//	        Acount account = aS.getAccountById(accountNo);
//	        double newOpeningBalance = account.getOpeningBalance() + amount;
//
//	        aS.updateOpeningBalanceByAccountNumber(accountNo, newOpeningBalance);
//	        String transactionType = "credit";  
//	        LocalDate transactionDate = LocalDate.now();
//	        String description = "desc1 " ;
//	        
//	        
//	        Transaction transaction = new Transaction(transactionType, transactionDate, amount, description, null,account);
//	        ts.save(transaction);
//	        return transaction;
//	    }
//
//
//
//	    @GetMapping("/withdraw")
//	    public Transaction withdrawInAccount() {
//	        
//	        int accountNo = 2;
//	        double withdrawalAmount = 50000.0;
//
//	       
//	        Acount account = aS.getAccountById(accountNo);
//	        if (account.getOpeningBalance() < withdrawalAmount) {
//	            throw new RuntimeException("no balance**********");
//	        }
//
//	        
//	        double newOpeningBalance = account.getOpeningBalance() - withdrawalAmount;
//
//	        
//	        aS.updateOpeningBalanceByAccountNumber(accountNo, newOpeningBalance);
//
//	      
//	        String transactionType = "debit";  
//	        LocalDate transactionDate = LocalDate.now();
//	        String description = "desc3 " ;
//
//	     
//	        Transaction transaction = new Transaction(transactionType, transactionDate, withdrawalAmount, description, null, account);
//	        ts.save(transaction);
//	        return transaction;
//	    }
//	    
//	    
//	    
//	    @GetMapping("/fundtransfer")
//	    public Transaction fundTransfer() {
//	        
//	        int fromAccountNumber = 1;
//	        int toAccountNumber = 2;
//	        double amount = 20000.0;
//	        String description = "Fund Transfer";
//
//	        
//	        Acount fromAccount = aS.getAccountById(fromAccountNumber);
//	        Acount toAccount = aS.getAccountById(toAccountNumber);
//
//	        if (fromAccount == null || toAccount == null) {
//	            throw new RuntimeException("One or both accounts not found");
//	        }
//
//	        if (fromAccount.getOpeningBalance() < amount) {
//	            throw new RuntimeException("Insufficient balance in source account");
//	        }
//
//	      
//	        double newFromAccountBalance = fromAccount.getOpeningBalance() - amount;
//	        aS.updateOpeningBalanceByAccountNumber(fromAccountNumber, newFromAccountBalance);
//
//	      
//	        double newToAccountBalance = toAccount.getOpeningBalance() + amount;
//	        aS.updateOpeningBalanceByAccountNumber(toAccountNumber, newToAccountBalance);
//
//	        
//	        LocalDate transactionDate = LocalDate.now();
//	        Transaction creditTransaction = new Transaction("credit", transactionDate, amount, description, null, toAccount);
//	        Transaction debitTransaction = new Transaction("debit", transactionDate, amount, description, fromAccount, null);
//
//	        ts.save(creditTransaction);
//	        ts.save(debitTransaction);
//
//	        return creditTransaction; 
//	    }
//	}
//

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		@RestController
		@RequestMapping("/api")
		public class TransactionController {

		    @Autowired
		    private TransactionService ts;

		    @Autowired
		    private AcountService aS;
		    @CrossOrigin(origins = "http://localhost:3000") 

		    @PostMapping("/deposit")
		    public ResponseEntity<Transaction> depositInAccount(@RequestBody DepositRequest depositRequest) {
		        int accountNo = depositRequest.getAccountNo();
		        double amount = depositRequest.getAmount();
		        String description = depositRequest.getDescription();

		        Acount account = aS.getAccountById(accountNo);
		        if (account == null) {
		            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		        }

		        double newOpeningBalance = account.getOpeningBalance() + amount;
		        aS.updateOpeningBalanceByAccountNumber(accountNo, newOpeningBalance);

		        String transactionType = "credit";
		        LocalDate transactionDate = LocalDate.now();

		        Transaction transaction = new Transaction(transactionType, transactionDate, amount, description, null, account);
		        ts.save(transaction);

		        return ResponseEntity.ok(transaction);
		    }
		    @CrossOrigin(origins = "http://localhost:3000") 

		    @PostMapping("/withdraw")
		    public ResponseEntity<Transaction> withdrawFromAccount(@RequestBody WithdrawRequest withdrawRequest) {
		        int accountNo = withdrawRequest.getAccountNo();
		        double withdrawalAmount = withdrawRequest.getAmount();
		        String description = withdrawRequest.getDescription();

		        Acount account = aS.getAccountById(accountNo);
		        if (account == null) {
		            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		        }

		        if (account.getOpeningBalance() < withdrawalAmount) {
		            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		        }

		        double newOpeningBalance = account.getOpeningBalance() - withdrawalAmount;
		        aS.updateOpeningBalanceByAccountNumber(accountNo, newOpeningBalance);

		        String transactionType = "debit";
		        LocalDate transactionDate = LocalDate.now();

		        Transaction transaction = new Transaction(transactionType, transactionDate, withdrawalAmount, description, null, account);
		        ts.save(transaction);

		        return ResponseEntity.ok(transaction);
		    }
		    @CrossOrigin(origins = "http://localhost:3000") 

		    @PostMapping("/fundtransfer")
		    public ResponseEntity<String> fundTransfer(@RequestBody FundTransferRequest fundTransferRequest) {
		        int fromAccountNumber = fundTransferRequest.getFromAccountNumber();
		        int toAccountNumber = fundTransferRequest.getToAccountNumber();
		        double amount = fundTransferRequest.getAmount();
		        String description = fundTransferRequest.getDescription();

		        Acount fromAccount = aS.getAccountById(fromAccountNumber);
		        Acount toAccount = aS.getAccountById(toAccountNumber);

		        if (fromAccount == null || toAccount == null) {
		            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("One or both accounts not found");
		        }

		        if (fromAccount.getOpeningBalance() < amount) {
		            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insufficient balance in source account");
		        }

		        double newFromAccountBalance = fromAccount.getOpeningBalance() - amount;
		        aS.updateOpeningBalanceByAccountNumber(fromAccountNumber, newFromAccountBalance);

		        double newToAccountBalance = toAccount.getOpeningBalance() + amount;
		        aS.updateOpeningBalanceByAccountNumber(toAccountNumber, newToAccountBalance);

		        LocalDate transactionDate = LocalDate.now();
		        Transaction creditTransaction = new Transaction("credit", transactionDate, amount, description, null, toAccount);
		        Transaction debitTransaction = new Transaction("debit", transactionDate, amount, description, fromAccount, null);

		        ts.save(creditTransaction);
		        ts.save(debitTransaction);

		        return ResponseEntity.ok("Fund transfer successful");
		    }
		    
		    
		    
		    
		    
		    
		    
		    
		    
		  

			/*
			 * @CrossOrigin(origins = "http://localhost:3000") // Allow CORS from your
			 * frontend
			 * 
			 * @GetMapping("/transactionsummary/{accountNo}") public
			 * ResponseEntity<List<Transaction>> transactionSummary(@PathVariable int
			 * accountNo) { Acount account = aS.getAccountById(accountNo); if (account ==
			 * null) { return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); }
			 * 
			 * List<Transaction> transactions = ts.getTransactionsByAccount(accountNo);
			 * return ResponseEntity.ok(transactions); }
			 */

		}