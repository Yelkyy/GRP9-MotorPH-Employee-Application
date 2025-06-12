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

    private static final Path CSV_FILE = Paths.get("resources", "Copy of MotorPH Employee Data.csv");
    private static final Path TIME_LOG_CSV = Paths.get("resources", "Copy of MotorPH Employee Data Time Logs.csv");

    private static final String[] EMPLOYEE_CSV_HEADER = {
        "Employee #", "Last Name", "First Name", "Birthday", "Address", "Phone Number",
        "SSS #", "PhilHealth #", "TIN #", "Pag-IBIG #", "Status", "Position",
        "Immediate Supervisor", "Basic Salary", "Rice Subsidy", "Phone Allowance",
        "Clothing Allowance", " Gross Semi-Monthly Rate", "Hourly Rate"
    };

    /**
     * Reads employee details from the CSV file.
     * @return List of EmployeeDetails objects.
     */
    public static List<EmployeeDetails> readEmployeeDetails() {
        List<EmployeeDetails> employees = new ArrayList<>();

        try (Reader reader = Files.newBufferedReader(CSV_FILE);
             CSVReader csvReader = new CSVReaderBuilder(reader)
                     .withCSVParser(new CSVParserBuilder()
                             .withSeparator(',')
                             .withIgnoreQuotations(false)
                             .build())
                     .build()) {

            List<String[]> records = csvReader.readAll();

            if (records.isEmpty()) return employees;

            records.remove(0); // Remove header row

            for (String[] record : records) {
                if (record.length < EMPLOYEE_CSV_HEADER.length) {
                    System.out.println("Skipping malformed row: " + Arrays.toString(record));
                    continue;
                }

                EmployeeDetails employee = new EmployeeDetails(
                        record[0], record[1], record[2], record[3], record[4], record[5], record[6],
                        record[7].trim(), record[8].trim(), record[9].trim(), record[10], record[11],
                        record[12], parseDoubleSafe(record[13]), parseDoubleSafe(record[14]),
                        parseDoubleSafe(record[15]), parseDoubleSafe(record[16]),
                        parseDoubleSafe(record[17]), parseDoubleSafe(record[18])
                );

                employees.add(employee);
            }
        } catch (IOException | CsvException e) {
            System.err.println("Error reading employee details: " + e.getMessage());
        }

        return employees;
    }

    /**
     * Reads employee time logs from the CSV file.
     * @return List of EmployeeTimeLogs objects.
     */
    public static List<EmployeeTimeLogs> readEmployeeTimeLogs() {
        List<EmployeeTimeLogs> timeLogs = new ArrayList<>();

        try (Reader reader = Files.newBufferedReader(TIME_LOG_CSV);
             CSVReader csvReader = new CSVReader(reader)) {

            List<String[]> records = csvReader.readAll();

            if (records.isEmpty()) {
                System.out.println("Warning: No records found in Time Logs CSV.");
                return timeLogs;
            }

            records.remove(0); // Remove header

            for (String[] record : records) {
                if (record.length < 6) {
                    System.out.println("Skipping malformed time log row: " + Arrays.toString(record));
                    continue;
                }

                EmployeeTimeLogs timeLog = new EmployeeTimeLogs(
                        record[0], record[1], record[2], record[3], record[4], record[5]
                );
                timeLogs.add(timeLog);
            }
        } catch (IOException | CsvException e) {
            System.err.println("Error reading employee time logs: " + e.getMessage());
        }

        return timeLogs;
    }

    /**
     * Appends a new employee time log entry to the CSV file.
     */
    public static void logEmployeeTime(String empId, String lastName, String firstName, String date,
                                       String logIn, String logOut) {
        File file = TIME_LOG_CSV.toFile();
        boolean fileExists = file.exists();

        try (Writer writer = new FileWriter(file, true);
             CSVWriter csvWriter = new CSVWriter(writer,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.DEFAULT_QUOTE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.RFC4180_LINE_END)) {

            if (!fileExists) {
                csvWriter.writeNext(new String[] {
                        "Employee #", "Last Name", "First Name", "Date", "Log In", "Log Out"
                });
            }

            csvWriter.writeNext(new String[] {empId, lastName, firstName, date, logIn, logOut});
            System.out.println("✅ Time log recorded for Employee #" + empId);

        } catch (IOException e) {
            System.err.println("Error writing time log: " + e.getMessage());
        }
    }

    /**
     * Writes the full list of employees back to the CSV file, overwriting existing content.
     */
    public static void writeEmployeeData(List<EmployeeDetails> employees) {
        try (Writer writer = new FileWriter(CSV_FILE.toFile());
             CSVWriter csvWriter = new CSVWriter(writer,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.DEFAULT_QUOTE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.RFC4180_LINE_END)) {

            csvWriter.writeNext(EMPLOYEE_CSV_HEADER);

            for (EmployeeDetails emp : employees) {
                csvWriter.writeNext(emp.toCSVArray());
            }

            System.out.println("✅ Employee data written to CSV.");

        } catch (IOException e) {
            System.err.println("Error writing employee data: " + e.getMessage());
        }
    }

    /**
     * Adds a new employee record to the CSV file.
     */
    public static void addEmployeeToCSV(EmployeeDetails emp) {
        try (Writer writer = new FileWriter(CSV_FILE.toFile(), true);
             CSVWriter csvWriter = new CSVWriter(writer,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.DEFAULT_QUOTE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.RFC4180_LINE_END)) {

            csvWriter.writeNext(emp.toCSVArray());
            System.out.println("✅ Employee added to CSV: " + emp.getEmployeeId());

        } catch (IOException e) {
            System.err.println("Error adding employee: " + e.getMessage());
        }
    }

    /**
     * Generates a new unique employee ID by incrementing the highest existing ID.
     * @return New employee ID as a String.
     */
    public static String generateNewEmpId() {
        List<EmployeeDetails> employees = readEmployeeDetails();
        int maxId = 10000;

        for (EmployeeDetails emp : employees) {
            try {
                int id = Integer.parseInt(emp.getEmployeeId());
                if (id > maxId) maxId = id;
            } catch (NumberFormatException e) {
                // Ignore malformed IDs
            }
        }

        return String.valueOf(maxId + 1);
    }

    /**
     * Removes an employee by employee number from the CSV file.
     */
    public static void removeEmployeeFromCSV(String employeeNumber) {
        List<EmployeeDetails> employees = readEmployeeDetails();

        boolean removed = employees.removeIf(emp -> emp.getEmployeeId().equals(employeeNumber));

        if (removed) {
            writeEmployeeData(employees);
            System.out.println("🗑️ Employee #" + employeeNumber + " removed.");
        } else {
            System.out.println("⚠️ Employee #" + employeeNumber + " not found.");
        }
    }

    /**
     * Updates an existing employee's details in the CSV file.
     */
    public static void updateEmployeeInCSV(EmployeeDetails updatedEmployee) {
        List<EmployeeDetails> employees = readEmployeeDetails();
        boolean updated = false;

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeId().equals(updatedEmployee.getEmployeeId())) {
                employees.set(i, updatedEmployee);
                updated = true;
                break;
            }
        }

        if (updated) {
            writeEmployeeData(employees);
            System.out.println("✅ Employee #" + updatedEmployee.getEmployeeId() + " updated.");
        } else {
            System.out.println("⚠️ Employee #" + updatedEmployee.getEmployeeId() + " not found.");
        }
    }

    /**
     * Parses a String to double safely, returning 0.0 for invalid or missing values.
     */
    private static double parseDoubleSafe(String value) {
        if (value == null || value.trim().isEmpty() || value.equalsIgnoreCase("N/A")) {
            return 0.0;
        }
        try {
            return Double.parseDouble(value.replace(",", "").trim());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

}
