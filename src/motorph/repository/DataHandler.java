package motorph.repository;

import com.opencsv.*;
import com.opencsv.exceptions.CsvException;

import motorph.model.EmployeeDetails;
import motorph.model.EmployeeTimeLogs;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class DataHandler {

    // Paths to the CSV files containing employee details and time logs
    private static final String CSV_FILE = "resources\\Copy of MotorPH Employee Data.csv";
    private static final String TIME_LOG_CSV = "resources\\Copy of MotorPH Employee Data Time Logs.csv";

    // Method to read employee details from the CSV file
    public static List<EmployeeDetails> readEmployeeDetails() {
        List<EmployeeDetails> employees = new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE));
                CSVReader csvReader = new CSVReader(reader)) {

            List<String[]> records = csvReader.readAll(); // Read all records from the CSV file
            records.remove(0); // Remove the header row

            // Iterate over each record and create an EmployeeDetails object
            for (String[] record : records) {
                EmployeeDetails employee = new EmployeeDetails(
                        record[0], record[1], record[2], record[3], record[4],
                        record[5], record[6], record[7], record[8], record[9],
                        record[10], record[11], record[12],
                        Double.parseDouble(record[13].replace(",", "")), // Basic Salary
                        Double.parseDouble(record[14].replace(",", "")), // Rice Subsidy
                        Double.parseDouble(record[15].replace(",", "")), // Phone Allowance
                        Double.parseDouble(record[16].replace(",", "")), // Clothing Allowance
                        Double.parseDouble(record[17].replace(",", "")), // Gross Semi-monthly Rate
                        Double.parseDouble(record[18].replace(",", "")) // Hourly Rate
                );
                employees.add(employee); // Add employee to the list
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace(); // Print error if reading fails
        }
        return employees; // Return the list of employees
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
                        CSVWriter.NO_QUOTE_CHARACTER,
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
                     CSVWriter.NO_QUOTE_CHARACTER,
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
                        CSVWriter.NO_QUOTE_CHARACTER,
                        CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                        CSVWriter.RFC4180_LINE_END)) {

            csvWriter.writeNext(emp.toCSVArray());
            System.out.println("✅ Employee added to CSV: " + emp.getEmployeeId());
        
        } catch (IOException e) {
            System.out.println("❌ Error adding employee: " + e.getMessage());
        }
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
