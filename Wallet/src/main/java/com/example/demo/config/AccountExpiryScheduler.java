package com.example.demo.config;



//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import com.example.demo.model.Customer;
//import com.example.demo.repo.CustomerRepository;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@Component
//public class AccountExpiryScheduler {
//
//    @Autowired
//    private CustomerRepository cr; 
//    @Autowired
//    private EmailService es;
//
//    @Scheduled(cron = "0 0 10 * * ?") // Every day at 10 AM
//    public void checkForExpiringAccounts() {
//        LocalDate tomorrow = LocalDate.now().plusDays(1);
//        List<Customer> expiringCustomers = cr.findByExpiryDate(tomorrow);
//
//        for (Customer customer : expiringCustomers) {
//            es.sendAccountExpiryNotification(customer.getEmailId(), customer.getFirstName(), null);
//        }
//    }
//}

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import com.example.demo.model.Customer;
//import com.example.demo.repo.CustomerRepository;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@Component
//public class AccountExpiryScheduler {
//
//    @Autowired
//    private CustomerRepository cr; 
//    @Autowired
//    private EmailService es;
//
//    // Scheduled task to send notification one day before expiration
//    @Scheduled(cron = "0 0 10 * * ?") // Every day at 10 AM
//    public void checkForExpiringAccounts() {
//        LocalDate tomorrow = LocalDate.now().plusDays(1);
//        List<Customer> expiringCustomers = cr.findByExpiryDate(tomorrow);
//
//        for (Customer customer : expiringCustomers) {
//            es.sendAccountExpiryNotification(customer.getEmailId(), customer.getFirstName(), "Your account is set to expire tomorrow.");
//        }
//    }
//
//    // Scheduled task to send notification on the expiration date
//    @Scheduled(cron = "0 0 10 * * ?") // Every day at 10 AM
//    public void checkForExpiredAccounts() {
//        LocalDate today = LocalDate.now();
//        List<Customer> expiredCustomers = cr.findByExpiryDate(today);
//
//        for (Customer customer : expiredCustomers) {
//            es.sendAccountExpiryNotification(customer.getEmailId(), customer.getFirstName(), "Your account has expired today.");
//        }
//    }
//}
//



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.example.demo.model.Customer;
import com.example.demo.repo.CustomerRepository;
import java.time.LocalDate;
import java.util.List;

@Component
public class AccountExpiryScheduler {

    @Autowired
    private CustomerRepository cr; 
    @Autowired
    private EmailService es;

    // Scheduled to run every day at 10 AM
    @Scheduled(cron = "0 0 10 * * ?")
    public void checkForExpiringAccounts() {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);

        // Check for customers whose accounts expire tomorrow
        List<Customer> expiringTomorrow = cr.findByExpiryDate(tomorrow);
        for (Customer customer : expiringTomorrow) {
            es.sendAccountExpiryNotification(customer.getEmailId(), customer.getFirstName(), null);
        }

        // Check for customers whose accounts expire today
        List<Customer> expiredToday = cr.findByExpiryDate(today);
        for (Customer customer : expiredToday) {
            es.sendAccountExpiryNotification(customer.getEmailId(), customer.getFirstName(), null);
        }
    }
}
