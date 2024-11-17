
  package com.example.demo.model; 
  
  
  import java.time.LocalDate;



  import jakarta.persistence.Column; 
  import jakarta.persistence.Entity; 
  import jakarta.persistence.GeneratedValue; 
  import jakarta.persistence.GenerationType; 
  import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne; 
  import jakarta.persistence.SequenceGenerator;
  import jakarta.persistence.Table;
 
 
  @Entity
  
  @Table(name="tbltransaction") 
  public class Transaction {
  
  @Id
  
  @Column(name="Transaction_Id")
  
  @SequenceGenerator(name = "generator", sequenceName = "ID_SEQUENCE4",
  allocationSize = 1)
  
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
  private int transactionid;
  
  
  
//  @ManyToOne
  
//  @Column(name="custFK") 
//  private Customer customer;
  
//  
  @Column(name="transactionType")
  private String transactionType;
  
  @Column(name="transactionDate") 
  private LocalDate transactionDate;
  
  @Column(name="amount") 
  private double amount;
  
  @Column(name="Description") 
  private String description;
  
  @ManyToOne
  @JoinColumn(name="fromAccFK")
  private Acount fromAccount;


@ManyToOne
  @JoinColumn(name="toAccFK")
  private Acount toAccount;


public String getTransactionType() {
	return transactionType;
}


public void setTransactionType(String transactionType) {
	this.transactionType = transactionType;
}


public LocalDate getTransactionDate() {
	return transactionDate;
}


public void setTransactionDate(LocalDate transactionDate) {
	this.transactionDate = transactionDate;
}


public double getAmount() {
	return amount;
}


public void setAmount(double amount) {
	this.amount = amount;
}


public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}


public Acount getFromAccount() {
	return fromAccount;
}


public void setFromAccount(Acount fromAccount) {
	this.fromAccount = fromAccount;
}


public Acount getToAccount() {
	return toAccount;
}


public void setToAccount(Acount toAccount) {
	this.toAccount = toAccount;
}


@Override
public String toString() {
	return "Transaction [ transactionType=" + transactionType + ", transactionDate="
			+ transactionDate + ", amount=" + amount + ", description=" + description + ", fromAccount=" + fromAccount
			+ ", toAccount=" + toAccount + "]";
}


public Transaction( String transactionType, LocalDate transactionDate, double amount, String description,
		Acount fromAccount, Acount toAccount) {
	super();
	
	this.transactionType = transactionType;
	this.transactionDate = transactionDate;
	this.amount = amount;
	this.description = description;
	this.fromAccount = fromAccount;
	this.toAccount = toAccount;
}


public Transaction() {
	super();
	// TODO Auto-generated constructor stub
}
  }
  
  
 