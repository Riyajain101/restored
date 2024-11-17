package com.example.demo.model;





import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

	@Entity
	public class Address{

		@Id
		@Column(name="Address_Id")
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@SequenceGenerator(name = "generator", sequenceName = "ID_SEQUENCE2", allocationSize = 1)
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
		private int addressId;
		private String addressLine1;
		private String addressLine2;
		private String city;
		private String state;
		private int pincode;
		public int getAddressId() {
			return addressId;
		}
		public void setAddressId(int addressId) {
			this.addressId = addressId;
		}
		public String getAddressLine1() {
			return addressLine1;
		}
		public void setAddressLine1(String addressLine1) {
			this.addressLine1 = addressLine1;
		}
		public String getAddressLine2() {
			return addressLine2;
		}
		public void setAddressLine2(String addressLine2) {
			this.addressLine2 = addressLine2;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public int getPincode() {
			return pincode;
		}
		public void setPincode(int pincode) {
			this.pincode = pincode;
		}
		@Override
		public String toString() {
			return "Address [addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city
					+ ", state=" + state + ", pincode=" + pincode + "]";
		}
		public Address(String addressLine1, String addressLine2, String city, String state, int pincode) {
			super();
			this.addressLine1 = addressLine1;
			this.addressLine2 = addressLine2;
			this.city = city;
			this.state = state;
			this.pincode = pincode;
		}
		public Address() {
			super();
			// TODO Auto-generated constructor stub
		}
		
}
