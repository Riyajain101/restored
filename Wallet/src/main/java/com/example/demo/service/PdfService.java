package com.example.demo.service;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Element;
import com.example.demo.model.Acount;
import com.example.demo.model.Customer;
import com.example.demo.model.Transaction;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
//
//@Service
//public class PdfService {
//
//    public ByteArrayInputStream createPdf(Customer customer, List<Transaction> transactions,List<Acount> accounts) throws DocumentException, IOException {
//    	
//        // Create a ByteArrayOutputStream to write the PDF to memory
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//
//        // Create the Document object
//        Document document = new Document();
//
//        // Create PdfWriter instance to write content to the document
//        PdfWriter.getInstance(document, out);
//
//        // Open the document to add content
//        document.open();
//        
//        
//        Paragraph heading1 = new Paragraph("**************************Customer Details***********************", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16));
//        heading1.setAlignment(Element.ALIGN_CENTER);
//        document.add(heading1);
//
//       
//        document.add(new Paragraph("Full-Name: " + customer.getFirstName() + " " + customer.getLastName()));
//        document.add(new Paragraph("Email: " + customer.getEmailId()));
//        document.add(new Paragraph("Contact No: " + customer.getContactNo()));
//        document.add(new Paragraph("Gender: " + customer.getGender()));
//        document.add(new Paragraph("Registration Date: " + customer.getRegistrationDate()));
//        document.add(new Paragraph("ExpiryDate: " + customer.getExpiryDate()));
//
//        Paragraph heading2 = new Paragraph("********************Address Details***********************", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16));
//        heading2.setAlignment(Element.ALIGN_CENTER);
//        document.add(heading2);
//
//
//             if (customer != null && customer.getAddress() != null) {
//
//        document.add(new Paragraph("Address Line 1: " + customer.getAddress().getAddressLine1()));
//        document.add(new Paragraph("Address Line 2: " + customer.getAddress().getAddressLine2()));
//        document.add(new Paragraph("City: " + customer.getAddress().getCity()));
//        document.add(new Paragraph("State: " + customer.getAddress().getState()));
//        document.add(new Paragraph("Pincode: " + customer.getAddress().getPincode()));
//         } else {
//             document.add(new Paragraph("Address information is missing"));
//         }
//        
//             Paragraph heading3= new Paragraph("********************Account Details***********************", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16));
//             heading3.setAlignment(Element.ALIGN_CENTER);
//             document.add(heading3);
//
//
//        
//         if (accounts != null && !accounts.isEmpty()) {
//             for (Acount acount : accounts) {
//                 // Process each account in the list
//                 document.add(new Paragraph("Account Type: " + acount.getAccountType()));
//                 document.add(new Paragraph("Account Number: " + acount.getAccountno()));
//                 document.add(new Paragraph("Opening Balance: " + acount.getOpeningBalance()));
//                 document.add(new Paragraph("Opening Date: " + acount.getOpeningDate()));
//             }
//         } else {
//             document.add(new Paragraph("No accounts found for this customer."));
//         }
//         Paragraph heading4= new Paragraph("********************Transaction Details***********************", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16));
//         heading4.setAlignment(Element.ALIGN_CENTER);
//         document.add(heading4);
//         if (transactions != null && !transactions.isEmpty()) {
//             document.add(new Paragraph("\nTransaction Details:"));
//
//             // Create a table with 4 columns: Transaction Date, Description, Amount, From Account / To Account
//             PdfPTable table = new PdfPTable(4);
//             table.setWidthPercentage(100);
//             table.setSpacingBefore(10f);
//             table.setSpacingAfter(10f);
//
//             // Add table headers
//             table.addCell(new Phrase("Transaction Date", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
//             table.addCell(new Phrase("Description", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
//             table.addCell(new Phrase("Amount", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
//             table.addCell(new Phrase("From / To Account", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
//
//             // Add rows for each transaction
//             for (Transaction transaction : transactions) {
//                 table.addCell(transaction.getTransactionDate().toString());
//                 table.addCell(transaction.getDescription());
//                 table.addCell(String.valueOf(transaction.getAmount()));
//
//                 // Null check for From Account
//                 String fromAccountInfo = (transaction.getFromAccount() != null) 
//                     ? "From: " + transaction.getFromAccount().getAccountno() 
//                     : "0";
//
//                 // Null check for To Account
//                 String toAccountInfo = (transaction.getToAccount() != null) 
//                     ? "To: " + transaction.getToAccount().getAccountno() 
//                     : "0";
//
//                 // Combine From and To account information
//                 table.addCell(fromAccountInfo + " / " + toAccountInfo);
//             }
//
//             // Add table to document
//             document.add(table);
//  
//         } else {
//             document.add(new Paragraph("No Transactions Found"));
//         }
//
//        
//
//        
//             
//        document.close();
//
//        // Return the PDF as ByteArrayInputStream
//        return new ByteArrayInputStream(out.toByteArray());
//    }
//}
//















@Service
public class PdfService {

    public ByteArrayInputStream createPdfForAllCustomers(List<Customer> customers, List<Transaction> transactions, List<Acount> accounts) throws DocumentException, IOException {
        // Create a ByteArrayOutputStream to write the PDF to memory
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        // Create the Document object
        Document document = new Document();

        // Create PdfWriter instance to write content to the document
        PdfWriter.getInstance(document, out);

        // Open the document to add content
        document.open();

        // Add Title Heading
        Paragraph heading = new Paragraph("Customer Details", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16));
        heading.setAlignment(Element.ALIGN_CENTER);
        document.add(heading);

        // Iterate through each customer and add their details to the document
        for (Customer customer : customers) {
            document.add(new Paragraph("Full Name: " + customer.getFirstName() + " " + customer.getLastName()));
            document.add(new Paragraph("Email: " + customer.getEmailId()));
            document.add(new Paragraph("Contact No: " + customer.getContactNo()));
            document.add(new Paragraph("Gender: " + customer.getGender()));
            document.add(new Paragraph("Registration Date: " + customer.getRegistrationDate()));
            document.add(new Paragraph("Expiry Date: " + customer.getExpiryDate()));

            // Address details
            if (customer.getAddress() != null) {
                document.add(new Paragraph("Address Line 1: " + customer.getAddress().getAddressLine1()));
                document.add(new Paragraph("Address Line 2: " + customer.getAddress().getAddressLine2()));
                document.add(new Paragraph("City: " + customer.getAddress().getCity()));
                document.add(new Paragraph("State: " + customer.getAddress().getState()));
                document.add(new Paragraph("Pincode: " + customer.getAddress().getPincode()));
            }

            // Add Accounts Details
            if (accounts != null && !accounts.isEmpty()) {
                for (Acount account : accounts) {
                    document.add(new Paragraph("Account Type: " + account.getAccountType()));
                    document.add(new Paragraph("Account Number: " + account.getAccountno()));
                    document.add(new Paragraph("Opening Balance: " + account.getOpeningBalance()));
                    document.add(new Paragraph("Opening Date: " + account.getOpeningDate()));
                }
            }

            // Add Transaction Details as a Table
            if (transactions != null && !transactions.isEmpty()) {
                document.add(new Paragraph("Transaction Details:"));

                PdfPTable table = new PdfPTable(4);
                table.setWidthPercentage(100);
                table.setSpacingBefore(10f);
                table.setSpacingAfter(10f);

                // Add table headers
                table.addCell("Transaction Date");
                table.addCell("Description");
                table.addCell("Amount");
                table.addCell("From/To Account");

                for (Transaction transaction : transactions) {
                    table.addCell(transaction.getTransactionDate().toString());
                    table.addCell(transaction.getDescription());
                    table.addCell(String.valueOf(transaction.getAmount()));
                    boolean fromAccountInfo = (transaction.getFromAccount() != null) ;
//                          ? "From: " + transaction.getFromAccount().getAccountno() 
//                          : "0";
     //
//                      // Null check for To Account
//                      String toAccountInfo = (transaction.getToAccount() != null) 
//                          ? "To: " + transaction.getToAccount().getAccountno() 
//                          : "0";
//                    String fromAccountInfo = (transaction.getFromAccount() != null) ? transaction.getFromAccount().getAccountno() : "From Account not available";
//                    String toAccountInfo = (transaction.getToAccount() != null) ? transaction.getToAccount().getAccountno() : "To Account not available";
                    table.addCell(fromAccountInfo + " / " + fromAccountInfo);
                }

                document.add(table);
            }

            // Add a page break after each customer
            document.newPage();
        }

        // Close the document after adding content
        document.close();

        // Return the PDF as ByteArrayInputStream
        return new ByteArrayInputStream(out.toByteArray());
    }
}
