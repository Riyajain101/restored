package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//public class EmailController {
//	@Autowired
//    private JavaMailSender emailSender;
//
//	
//	@GetMapping("/sendEmail")
//	public String sendEmail{
//		emailSender.sendAccountExpiryNotification();
//		return "send sucessfully";
//	}
//
//}


@RestController
public class EmailController {

    @Autowired
    private JavaMailSender emailSender;

    @GetMapping("/sendEmail")
    public String sendEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("rihajain19.2001@gmail.com"); // Recipient email
        message.setSubject("Account Expiry Notification");
        message.setText(" Riya, your account is set to expire on 2024-01-10. Please take action to renew.");

        // Send the email
        emailSender.send(message);
        
        return "Email sent successfully";
        
    }
}
