package com.example.demo.model;

import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

@Entity
@Table(name="tblaccount")
public class Acount {

    @Id
    @Column(name="Account_no")
//    @SequenceGenerator(name = "generator", sequenceName = "ID_SEQUENCE3", allocationSize = 1)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    private int accountno;
    
   @ManyToOne
    @JoinColumn(name="custFK")
   @JsonIgnore
    private Customer customer;

    @Column(name="accountType")
    private String accountType;
    
  @Column(name="openingBalance")
    private double openingBalance;
    
    @Column(name="openingDate")
private LocalDate openingDate;
    
    @Column (name="description")
    private String description;

	public int getAccountno() {
		return accountno;
	}

	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(double newOpeningBalance) {
		this.openingBalance = newOpeningBalance;
	}

	public LocalDate getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(LocalDate openingDate) {
		this.openingDate = openingDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Account [accountno=" + accountno + ", customer=" + customer + ", accountType=" + accountType
				+ ", openingBalance=" + openingBalance + ", openingDate=" + openingDate + ", description=" + description
				+ "]";
	}

	public Acount(int accountno, Customer customer, String accountType, int openingBalance, LocalDate openingDate,
			String description) {
		super();
		this.accountno= accountno;
	this.customer = customer;
		this.accountType = accountType;
		this.openingBalance = openingBalance;
		this.openingDate = openingDate;
		this.description = description;
	}

	public Acount() {
		super();
		// TODO Auto-generated constructor stub
	}
}

