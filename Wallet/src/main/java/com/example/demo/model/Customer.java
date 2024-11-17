package com.example.demo.model;

//import java.time.LocalDate;
//
//
//
//
//
//
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToOne;
//import jakarta.persistence.SequenceGenerator;
//
//	@Entity
//	public class Customer {
//
//		@Id
//		@Column(name="Customer_Id")
//	@SequenceGenerator(name = "generator", sequenceName = "ID_SEQUENCE1", allocationSize = 1)
//		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
//		private int customerId;
//		
//		private String firstName;
//		public Customer(int customerId, String firstName, String lastName, String emailId, int contactNo,
//				boolean isDeleted, Date expiryDate, com.example.demo.model.Address address, List<Acount> accounts,
//				String gender, String password, LocalDate registrationDate) {
//			super();
//			this.customerId = customerId;
//			this.firstName = firstName;
//			this.lastName = lastName;
//			this.emailId = emailId;
//			this.contactNo = contactNo;
//			this.isDeleted = isDeleted;
//			this.expiryDate = expiryDate;
//			Address = address;
//			this.accounts = accounts;
//			Gender = gender;
//			this.password = password;
//			this.registrationDate = registrationDate;
//		}
//		@Override
//		public String toString() {
//			return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
//					+ ", emailId=" + emailId + ", contactNo=" + contactNo + ", isDeleted=" + isDeleted + ", expiryDate="
//					+ expiryDate + ", Address=" + Address + ", accounts=" + accounts + ", Gender=" + Gender
//					+ ", password=" + password + ", registrationDate=" + registrationDate + "]";
//		}
//		public boolean isDeleted() {
//			return isDeleted;
//		}
//		public void setDeleted(boolean isDeleted) {
//			this.isDeleted = isDeleted;
//		}
//		public Date getExpiryDate() {
//			return expiryDate;
//		}
//		public void setExpiryDate(Date expiryDate) {
//			this.expiryDate = expiryDate;
//		}
//		public List<Acount> getAccounts() {
//			return accounts;
//		}
//		public void setAccounts(List<Acount> accounts) {
//			this.accounts = accounts;
//		}
//
//		private String lastName;
//		private String emailId;
//		private int contactNo;
//		private boolean isDeleted;
//		private Date expiryDate;
//		@OneToOne(cascade = CascadeType.ALL)
//	    @JoinColumn(name ="addFK")
//	 Address Address;
//		
//          @OneToMany(targetEntity=Acount.class,mappedBy="customer",cascade = CascadeType.ALL)
//	     private List<Acount>accounts=new ArrayList<>();		
//
//		
//		private String Gender;
//		private String password;
//		private LocalDate registrationDate;
//
//		public int getCustomerId() {
//			return customerId;
//		}
//		public void setCustomerId(int customerId) {
//			this.customerId = customerId;
//		}
//		public String getFirstName() {
//			return firstName;
//		}
//		
//		public Customer( String firstName, String lastName, String emailId, int contactNo,
//		String gender, String password,
//		LocalDate registrationDate) {
//		super();
//			
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.emailId = emailId;
//		this.contactNo = contactNo;
//			
//		Gender = gender;
//		this.password = password;
//		this.registrationDate = registrationDate;
//
//		}
//		
//		public void setFirstName(String firstName) {
//		this.firstName = firstName;
//		}
//		public String getLastName() {
//		return lastName;
//		}
//		public void setLastName(String lastName) {
//		this.lastName = lastName;
//		}
//		public String getEmailId() {
//		return emailId;
//		}
//		public void setEmailId(String emailId) {
//		this.emailId = emailId;
//		}
//		public int getContactNo() {
//		return contactNo;
//		}
//		public void setContactNo(int contactNo) {
//		this.contactNo = contactNo;
//		}
//		public Address getAddress() {
//		return Address;
//		}
//		public void setAddress(Address address) {
//		Address = address;
//		}
//		public String getGender() {
//		return Gender;
//		}
//		public void setGender(String gender) {
//		Gender = gender;
//		}
//		public String getPassword() {
//		return password;
//		}
//		public void setPassword(String password) {
//		this.password = password;
//		}
//		public LocalDate getRegistrationDate() {
//		return registrationDate;
//		}
//		public void setRegistrationDate(LocalDate registrationDate) {
//		this.registrationDate = registrationDate;
//		}
//		public List<Acount> getAcount() {
//		return accounts;
//		}
//		public void setAcount(List<Acount> acounts) {
//		this.accounts = acounts;
//		}
//		
//		public Customer() {
//		super();
//			
//		}
//	}




import java.time.LocalDate;


import java.util.List;

import com.example.demo.customAnnotation.ValidateCustomerId;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Customer {

    @Id
    @Column(name = "Customer_Id")
    @SequenceGenerator(name = "generator", sequenceName = "ID_SEQUENCE777777", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    
    @ValidateCustomerId 
    private int customerId;
    
    @NotNull(message = "First name cannot be null")
    @NotEmpty(message = "First name cannot be empty")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
 
    private String firstName;
    private String lastName;
    private String emailId;
    private int contactNo;
    private boolean isDeleted;
    private LocalDate expiryDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addFK")
    private Address address;

//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//    private List<Acount> accounts = new ArrayList<>();

    private String gender;
    private String password;
    private LocalDate registrationDate;

    public Customer() {
        super();
    }

    
    public Customer(String firstName, String lastName, String emailId, int contactNo,
                    String gender, String password, LocalDate registrationDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.contactNo = contactNo;
        this.gender = gender;
        this.password = password;
        this.registrationDate = registrationDate;
    }

    // Getter and Setter methods

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getContactNo() {
        return contactNo;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Address getAddress() {
        return address;
    }

  public void setAddress(Address address) {
        this.address = address;
    }

  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
  private List<Acount> accounts;  // One customer can have many accounts

  
  public List<Acount> getAccounts() {
      return accounts;
  }

  public void setAccounts(List<Acount> accounts) {
      this.accounts = accounts;
  }
  
    public String getGender() {
        return gender;
    }

    public Customer(int customerId, String firstName, String lastName, String emailId, int contactNo, boolean isDeleted,
			LocalDate expiryDate, Address address, String gender, String password, LocalDate registrationDate) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.contactNo = contactNo;
		this.isDeleted = isDeleted;
		this.expiryDate = expiryDate;
		this.address = address;
		this.gender = gender;
		this.password = password;
		this.registrationDate = registrationDate;
	}

	public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", contactNo=" + contactNo + ", isDeleted=" + isDeleted + ", expiryDate="
				+ expiryDate + ", address=" + address + ", gender=" + gender + ", password=" + password
				+ ", registrationDate=" + registrationDate + "]";
	}
}

