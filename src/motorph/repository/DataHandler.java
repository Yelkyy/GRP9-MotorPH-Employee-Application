package motorph.repository;

import com.opencsv.*;
import com.opencsv.exceptions.CsvException;

import motorph.model.EmployeeDetails;
import motorph.model.EmployeeTimeLogs;

import java.io.*;
import java.nio.file.*;
import java.text.DecimalFormat;
import java.util.*;

public class DataHandler {

    // Paths to the CSV files containing employee details and time logs
    private static final String CSV_FILE = "resources\\Copy of MotorPH Employee Data.csv";
    private static final String TIME_LOG_CSV = "resources\\Copy of MotorPH Employee Data Time Logs.csv";

    // Method to read employee details from the CSV file
    public static List<EmployeeDetails> readEmployeeDetails() {
    List<EmployeeDetails> employees = new ArrayList<>();
    try (Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE));
         CSVReader csvReader = new CSVReaderBuilder(reader)
             .withCSVParser(new CSVParserBuilder()
                 .withSeparator(',')  // Comma as delimiter
                 .withIgnoreQuotations(false)
                 .build())
             .build()) {

        List<String[]> records = csvReader.readAll();
        records.remove(0); // Remove header

        for (String[] record : records) {
            if (record.length < 19) {
                System.out.println("Skipping malformed row: " + Arrays.toString(record));
                continue;
            }

            DecimalFormat df = new DecimalFormat("0");

            String formattedPhilHealth = record[7].trim();
            String formattedTin = record[8].trim();
            String formattedPagibig = record[9].trim();

            EmployeeDetails employee = new EmployeeDetails(
                record[0], // Emp ID
                record[1], // Last Name
                record[2], // First Name
                record[3], // Birthday
                record[4], // Address
                record[5], // Phone
                record[6], // SSS
                record[7].trim(), // PhilHealth
                record[8].trim(), // TIN
                record[9].trim(), // Pag-IBIG
                record[10], // Status
                record[11], // Position
                record[12], // Supervisor
                parseDoubleSafe(record[13]), // Basic Salary
                parseDoubleSafe(record[14]), // Rice Subsidy
                parseDoubleSafe(record[15]), // Phone Allowance
                parseDoubleSafe(record[16]), // Clothing Allowance
                parseDoubleSafe(record[17]), // Gross Semi-monthly Rate
                parseDoubleSafe(record[18])  // Hourly Rate
            );
            employees.add(employee);
        }

    } catch (IOException | CsvException e) {
        e.printStackTrace();
    }
    return employees;
}

// 🔽 Add this inside the same class, outside of readEmployeeDetails()
private static double parseDoubleSafe(String value) {
    if (value == null || value.trim().isEmpty() || value.equalsIgnoreCase("N/A")) {
        return 0.0;
    }
    try {
        return Double.parseDouble(value.replace(",", "").trim());
    } catch (NumberFormatException e) {
        //System.err.println("Invalid number: " + value);
        return 0.0;
    }
}


    // Method to read employee time logs from the CSV file
    public static List<EmployeeTimeLogs> readEmployeeTimeLogs() {
        List<EmployeeTimeLogs> timeLogs = new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(TIME_LOG_CSV));
                CSVReader csvReader = new CSVReader(reader)) {

            List<String[]> records = csvReader.readAll(); // Read all records from the time logs CSV

            // Check if the file is empty and print a warning if so
            if (records.isEmpty()) {
                System.out.println("Warning: No records found in Time Logs CSV.");
                return timeLogs;
            }

            records.remove(0); // Remove the header row

            // Iterate over each time log record and create an EmployeeTimeLogs object
            for (String[] record : records) {
                if (record.length < 6) { // Check if all required columns exist
                    System.out.println("Skipping malformed row: " + Arrays.toString(record));
                    continue; // Skip malformed rows
                }

                // Create EmployeeTimeLogs object for each record and add to the list
                EmployeeTimeLogs timeLog = new EmployeeTimeLogs(
                        record[0], record[1], record[2], record[3], record[4], record[5]);
                timeLogs.add(timeLog);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace(); // Print error if reading fails
        }
        return timeLogs; // Return the list of time logs
    }

    // NEW METHOD: Write a new employee time log to the CSV file
    public static void logEmployeeTime(String empId, String lastName, String firstName, String date, String logIn,
            String logOut) {
        File file = new File(TIME_LOG_CSV); // Create file object
        boolean fileExists = file.exists(); // Check if file already exists

        try (Writer writer = new FileWriter(file, true);
                CSVWriter csvWriter = new CSVWriter(writer,
                        CSVWriter.DEFAULT_SEPARATOR,
                        CSVWriter.DEFAULT_QUOTE_CHARACTER,
                        CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                        CSVWriter.RFC4180_LINE_END)) {

            // If the file is newly created, write the header row
            if (!fileExists) {
                csvWriter.writeNext(
                        new String[] { "Employee #", "Last Name", "First Name", "Date", "Log In", "Log Out" });
            }

            // Append the new time log entry to the file
            csvWriter.writeNext(new String[] { empId, lastName, firstName, date, logIn, logOut });
            System.out.println("✅ Time log recorded for Employee #" + empId);

        } catch (IOException e) {
            System.out.println("❌ Error writing time log: " + e.getMessage()); // Print error if writing fails
        }
    }

    // NEW METHOD: 
    public static void writeEmployeeData(List<EmployeeDetails> employees) {
        try (Writer writer = new FileWriter(CSV_FILE);
             CSVWriter csvWriter = new CSVWriter(writer,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.DEFAULT_QUOTE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.RFC4180_LINE_END)) {
    
            // Optional: write header
            csvWriter.writeNext(new String[] {
                "Employee #", "Last Name", "First Name", "Birthday", "Address", "Phone",
                "SSS", "PhilHealth", "TIN", "Pag-IBIG", "Status", "Position",
                "Supervisor", "Basic Salary", "Rice Subsidy", "Phone Allowance",
                "Clothing Allowance", "Semi-Monthly Rate", "Hourly Rate"
            });
    
            for (EmployeeDetails emp : employees) {
                csvWriter.writeNext(emp.toCSVArray());
            }
    
            System.out.println("✅ Employee data written to CSV.");
        } catch (IOException e) {
            System.out.println("❌ Error writing employee data: " + e.getMessage());
        }
    }
    


    // NEW METHOD: Add a new employee to the CSV file
    public static void addEmployeeToCSV(EmployeeDetails emp) {
        try (Writer writer = new FileWriter(CSV_FILE, true);
                CSVWriter csvWriter = new CSVWriter(writer,
                        CSVWriter.DEFAULT_SEPARATOR,
                        CSVWriter.DEFAULT_QUOTE_CHARACTER,
                        CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                        CSVWriter.RFC4180_LINE_END)) {

            csvWriter.writeNext(emp.toCSVArray());
            System.out.println("✅ Employee added to CSV: " + emp.getEmployeeId());
        
        } catch (IOException e) {
            System.out.println("❌ Error adding employee: " + e.getMessage());
        }
    }
    
    //Will generate new employee number for the new employee
    public static String generateNewEmpId() {
        List<EmployeeDetails> employees = readEmployeeDetails();
        int maxId = 10000;
        
        for (EmployeeDetails emp : employees) {
            try {
                int id = Integer.parseInt(emp.getEmployeeNumber());
                if (id > maxId) {
                    maxId = id;
                }
            } catch (NumberFormatException e){
                e.printStackTrace();
            }
        }
        
        return String.valueOf(maxId + 1);
    }

    // NEW METHOD: Remove an employee from the CSV file
    public static void removeEmployeeFromCSV(String employeeNumber) {
        List<EmployeeDetails> employees = readEmployeeDetails();
            employees.removeIf(emp -> emp.getEmployeeId().equals(employeeNumber));
            writeEmployeeData(employees);
        System.out.println("🗑️ Employee #" + employeeNumber + " removed.");
}


    // NEW METHOD: Update an existing employee's details in the CSV file
    public static void updateEmployeeinCSV(EmployeeDetails updateEmp) {
        List<EmployeeDetails> employees = readEmployeeDetails();
             for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getEmployeeId().equals(updateEmp.getEmployeeId())) {
                    employees.set(i, updateEmp); // Update the employee details in the list
                    break; // Exit loop after updating
                }
    }
    writeEmployeeData(employees); // Write updated data back to CSV
    System.out.println("✅ Employee #" + updateEmp.getEmployeeId() + " updated.");
    }

}
