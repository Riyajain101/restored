package com.example.demo.controller;
//import java.util.Date;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.model.Address;
//
//import com.example.demo.service.AddressService;

//@RestController
//public class AddressController {
//
//
//		@Autowired
//		AddressService ad;
//
//		@GetMapping("/alladdress") 
//		  public List<Address> getaddressList() {
//			  return  ad.getAllAddress();
//		  }
//		
//		@GetMapping("/saveAddressTbl")
//		public Address addAddress()
//		{
////			return "Address [addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city
////					+ ", state=" + state + ", pincode=" + pincode + "]";
////	
//			
//		Address a1=new Address( "abc1", "abc2", "panipat", "haryana", 132103);
//		Address a2=new Address( "def1", "def2", "panipat", "haryana", 132103);
//		Address a3=new Address( "gh1", "gh2", "panipat", "haryana", 132103);
//			System.out.println(a1);
//	ad.	addAddress(a1);
//	ad.	addAddress(a2);
//			return ad.addAddress(a3);
//		}
//}
