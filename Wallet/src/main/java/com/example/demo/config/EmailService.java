package com.example.demo.config;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendAccountExpiryNotification(String toEmail, String firstName,String fromEmailId) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmailId);
        message.setTo(toEmail);
        message.setSubject("Ac");
        message.setText(",\n\nYour account is set to expire tomorrow.");
        emailSender.send(message);
        try {
            emailSender.send(message);
            System.out.println("Email sent successfully to " + toEmail);
        } catch (Exception e) {
            System.err.println("Failed to send email: " + e.getMessage());
            e.printStackTrace();
    }
}
}
