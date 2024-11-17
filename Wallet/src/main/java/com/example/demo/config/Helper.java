package com.example.demo.config;

//ByteArrayInputStream and ByteArrayOutputStream for handling byte streams.


import java.io.ByteArrayInputStream;

import java.io.ByteArrayOutputStream;
//handle input/output/exception
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
//Apache POI classes (Cell, Row, Sheet, Workbook, XSSFWorkbook) for working with Excel files.

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.demo.model.Address;
import com.example.demo.model.Customer;
//HEADERS: An array of strings that represent the column headers in the Excel sheet.

public class Helper {
    public static String[] HEADERS = {
        "firstName",
        "lastName",
        "gender",
        "emailId",
        "contactNo",
        "registrationDate", 
        "expiryDate",
        "addressLine1",
        "addressLine2",
        "city",
        "state",
        "pinCode"
    };
 //   SHEET_NAME: A string that defines the name of the Excel sheet.

    public static String SHEET_NAME = "customerData"; 
//Parameters: Takes a list of Customer objects as input.
//method name-data to excel
    //Return Type: Returns a ByteArrayInputStream, which allows the generated Excel file to be read as a byte stream.
    public static ByteArrayInputStream dataToExcel(List<Customer> lst) {
    	//A ByteArrayOutputStream (out) is created to hold the generated Excel file in memory.

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        //A XSSFWorkbook (which creates an Excel workbook in .xlsx format) is initialized within
       // a try-with-resources statement to ensure proper resource management
        try (Workbook wb = new XSSFWorkbook()) { // Use try-with-resources
        	//A sheet is created in the workbook using the defined SHEET_NAME.

            Sheet sheet = wb.createSheet(SHEET_NAME);
            //A header row is created at the first position (index 0) of the sheet, and the column headers are populated from the HEADERS array.
            Row headerRow = sheet.createRow(0);
            // loop iterates through the list of Customer objects:
            //For each customer, a new row is created.
          //  Customer attributes (like first name, last name, email, etc.) are set in the corresponding cells.
            for (int i = 0; i < HEADERS.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(HEADERS[i]);
            }
            int rowIndex = 1;
            for (Customer c : lst) {
                Row dataRow = sheet.createRow(rowIndex++);
                dataRow.createCell(0).setCellValue(c.getFirstName());
                dataRow.createCell(1).setCellValue(c.getLastName());
                dataRow.createCell(2).setCellValue(c.getGender());
                dataRow.createCell(3).setCellValue(c.getEmailId());
                dataRow.createCell(4).setCellValue(c.getContactNo());
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
                dataRow.createCell(5).setCellValue(c.getRegistrationDate().format(dateFormatter));
                dataRow.createCell(6).setCellValue(c.getExpiryDate().format(dateFormatter));
                
//Address fields are populated by accessing the Address object associated with each Customer.
                Address address = c.getAddress();

                
                dataRow.createCell(7).setCellValue(address.getAddressLine1());
                dataRow.createCell(8).setCellValue(address.getAddressLine2());
                dataRow.createCell(9).setCellValue(address.getCity());
                dataRow.createCell(10).setCellValue(address.getState());
                dataRow.createCell(11).setCellValue(address.getPincode());

            }
            //The workbook is written to the ByteArrayOutputStream.
            wb.write(out);
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Return null or handle accordingly
        }
        //            After writing, the output stream is converted to a ByteArrayInputStream, which is returned to the caller.

        return new ByteArrayInputStream(out.toByteArray());
    }
}

