package motorph.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import motorph.model.EmployeeDetails;
import motorph.model.EmployeeTimeLogs;

import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.Duration;

public class PayrollService {

    private static final Scanner scanner = new Scanner(System.in);

    // Main method to handle payroll based on user choice
    public static void processPayroll(EmployeeDetails employee, List<EmployeeTimeLogs> logs, String monthYear) {
        System.out.println("Select Pay Period: [1] 1-15 or [2] 16-30");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        int startDay = 1, endDay = 15;
        if (choice == 2) {
            startDay = 16;
            endDay = 30;
        } else if (choice != 1) {
            System.out.println("Invalid choice. Returing to menu.");
            return;
        }
        
        System.out.printf("\nProcessing Payroll for %s | Days %d to %d\n", monthYear, startDay, endDay);
        displayPayrollSummary(employee, filterLogsByDateRange(logs, monthYear, startDay, endDay),
                monthYear,
                startDay,
                endDay
        );
    }



    // Filter the logs based on the month/year and the week range
    private static List<EmployeeTimeLogs> filterLogsByDateRange(List<EmployeeTimeLogs> logs, String monthYear, int startDay, int endDay) {
    List<EmployeeTimeLogs> filteredLogs = new ArrayList<>();
    DateTimeFormatter ymFormatter = DateTimeFormatter.ofPattern("MM-yyyy");

    for (EmployeeTimeLogs log : logs) {
        try {
            LocalDate logDate = LocalDate.parse(log.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String logMonthYear = logDate.format(ymFormatter);

            if (logMonthYear.equals(monthYear) && logDate.getDayOfMonth() >= startDay && logDate.getDayOfMonth() <= endDay) {
                filteredLogs.add(log);
            }
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format in logs: " + e.getMessage());
        }
    }
    return filteredLogs;
    }

    // Display the payroll summary for the employee
    private static void displayPayrollSummary(EmployeeDetails employee, List<EmployeeTimeLogs> logs,
        String monthYear, int startDay, int endDay) {
    boolean hasDeductions = (endDay == 30); // Apply deductions only for 16–30
    double semiMonthlyBasic = employee.getBasicSalary() / 2;
    double totalCompensation = employee.getRiceSubsidy() + employee.getPhoneAllowance() + employee.getClothingAllowance();

    List<String[]> lateDeductions = hasDeductions ? calculateLateUndertime(logs) : new ArrayList<>();
    double totalLateUndertimeDeductions = lateDeductions.isEmpty() ? 0.0
        : extractTotalLateDeductions(lateDeductions);

    double sss = hasDeductions ? calculateSSS(semiMonthlyBasic) : 0.0;
    double philhealth = hasDeductions ? calculatePhilHealth(semiMonthlyBasic) : 0.0;
    double pagibig = hasDeductions ? calculatePagIbig(semiMonthlyBasic) : 0.0;
    double nonTaxDeductions = totalLateUndertimeDeductions + sss + philhealth + pagibig;
    double tax = hasDeductions ? calculateTax(semiMonthlyBasic, nonTaxDeductions) : 0.0;
    double totalDeductions = nonTaxDeductions + tax;
    double netPay = semiMonthlyBasic + totalCompensation - totalDeductions;

    // Output remains the same except labels changed to day range
    System.out.println("=============================================");
    System.out.println("          PAYROLL SUMMARY          ");
    System.out.println("=============================================");
    System.out.printf("Employee        : %s (%s)%n", employee.getFullName(), employee.getEmployeeNumber());
    System.out.printf("Payroll Period  : %s | Days %d - %d%n", monthYear, startDay, endDay);
    System.out.println("-------------------------------------");
    System.out.printf("Basic Salary       : PHP %,10.2f%n", semiMonthlyBasic);
    System.out.printf("Rice Subsidy       : PHP %,10.2f%n", employee.getRiceSubsidy());
    System.out.printf("Phone Allowance    : PHP %,10.2f%n", employee.getPhoneAllowance());
    System.out.printf("Clothing Allowance : PHP %,10.2f%n", employee.getClothingAllowance());
    System.out.println("-------------------------------------");
    System.out.printf("Total Compensation : PHP %,10.2f%n", totalCompensation);
    System.out.println("-------------------------------------");
    System.out.printf("Late & Undertime   : PHP %,10.2f%n", totalLateUndertimeDeductions);
    System.out.printf("SSS Contribution   : PHP %,10.2f%n", sss);
    System.out.printf("PhilHealth         : PHP %,10.2f%n", philhealth);
    System.out.printf("Pag-IBIG           : PHP %,10.2f%n", pagibig);
    System.out.printf("Withholding Tax    : PHP %,10.2f%n", tax);
    System.out.println("-------------------------------------");
    System.out.printf("Total Deductions   : PHP %,10.2f%n", totalDeductions);
    System.out.println("-------------------------------------");
    System.out.printf("Net Pay            : PHP %,10.2f%n", netPay);
    System.out.println("=============================================");
}

    // Calculate late and undertime deductions based on time logs
    private static List<String[]> calculateLateUndertime(List<EmployeeTimeLogs> logs) {
        List<String[]> lateDeductions = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
        LocalTime scheduledIn = LocalTime.parse("09:00", formatter);
        LocalTime scheduledOut = LocalTime.parse("18:00", formatter);
        double totalDeduction = 0.0;

        for (EmployeeTimeLogs log : logs) {
            try {
                LocalTime actualIn = LocalTime.parse(log.getLogIn().trim(), formatter);
                LocalTime actualOut = LocalTime.parse(log.getLogOut().trim(), formatter);

                long minutesLate = Math.max(0, Duration.between(scheduledIn, actualIn).toMinutes());
                long minutesUndertime = Math.max(0, Duration.between(actualOut, scheduledOut).toMinutes());

                double deduction = ((minutesLate + minutesUndertime) / 60.0) * 100;
                totalDeduction += deduction;

                // Add deduction details for each log
                lateDeductions.add(new String[] {
                        log.getDate(),
                        String.valueOf(minutesLate),
                        String.valueOf(minutesUndertime),
                        String.format("%,.2f", deduction)
                });

            } catch (DateTimeParseException e) {
                System.out.println(
                        "Invalid time format for Employee #" + log.getEmployeeNumber() + ": " + e.getMessage());
            }
        }

        // Add total deduction at the end of the list
        lateDeductions.add(new String[] { "TOTAL", "", "", String.format("%,.2f", totalDeduction) });
        return lateDeductions;
    }

    // Calculate the SSS contribution
    private static double calculateSSS(double basicSalary) {
        if (basicSalary > 24750) {
            return 1125.00; // For salaries above 24,750
        }
        return basicSalary * 0.045; // For salaries below or equal to 24,750
    }

    // Calculate the PhilHealth contribution
    private static double calculatePhilHealth(double basicSalary) {
        double premium;

        if (basicSalary <= 10000) {
            premium = 300; // Fixed premium for salary <= 10,000
        } else if (basicSalary <= 59999.99) {
            premium = Math.min(basicSalary * 0.03, 1800); // 3% of salary or 1,800, whichever is lower
        } else {
            premium = 1800; // Fixed premium for salary >= 60,000
        }

        return premium / 2; // Employee pays 50% of the premium
    }

    // Calculate the Pag-IBIG contribution
    private static double calculatePagIbig(double basicSalary) {
        return Math.min(100, basicSalary * 0.02); // 2% or 100, whichever is lower
    }

    // Calculate the withholding tax
    private static double calculateTax(double basicSalary, double totalDeductions) {
        double taxableIncome = basicSalary;
        double tax = 0.0;

        // Calculate the tax based on income ranges
        if (taxableIncome <= 20832) {
            tax = 0;
        } else if (taxableIncome <= 33333) {
            tax = (taxableIncome - 20833) * 0.20;
        } else if (taxableIncome <= 66667) {
            tax = 2500 + (taxableIncome - 33333) * 0.25;
        } else if (taxableIncome <= 166667) {
            tax = 10833 + (taxableIncome - 66667) * 0.30;
        } else if (taxableIncome <= 666667) {
            tax = 40833.33 + (taxableIncome - 166667) * 0.32;
        } else {
            tax = 200833.33 + (taxableIncome - 666667) * 0.35;
        }

        return Math.round(tax * 100.0) / 100.0;
    }
    
    
    public static double calculateNetPay(EmployeeDetails employee, List<EmployeeTimeLogs> logs, 
            String monthYear, int payPeriod){
        
        int startDay = (payPeriod == 1) ? 1 : 16;
        int endDay = (payPeriod == 1) ? 15 : 30;
        boolean hasDeductions = (endDay == 30);
        
        double semiMonthlyBasic = employee.getBasicSalary() / 2;
        double totalCompensation = employee.getRiceSubsidy() + 
                                   employee.getPhoneAllowance() + 
                                   employee.getClothingAllowance();

    List<String[]> lateDeductions = hasDeductions ? calculateLateUndertime(logs) : new ArrayList<>();
    double totalLateUndertimeDeductions = hasDeductions ? extractTotalLateDeductions(lateDeductions) : 0.0;


        double sss = hasDeductions ? calculateSSS(semiMonthlyBasic) : 0.0;
        double philhealth = hasDeductions ? calculatePhilHealth(semiMonthlyBasic) : 0.0;
        double pagibig = hasDeductions ? calculatePagIbig(semiMonthlyBasic) : 0.0;
        
        double nonTaxDeductions = totalLateUndertimeDeductions + sss + philhealth + pagibig;
        
        double tax = hasDeductions ? calculateTax(semiMonthlyBasic, nonTaxDeductions) : 0.0;
        double totalDeductions = nonTaxDeductions + tax;
        double netPay = semiMonthlyBasic + totalCompensation - totalDeductions;

        return netPay;
    }

    private static double extractTotalLateDeductions(List<String[]> lateDeductions) {
        if (lateDeductions.isEmpty()) return 0.0;

        String[] totalRow = lateDeductions.get(lateDeductions.size() - 1);
        try {
            return Double.parseDouble(totalRow[3].replace(",", ""));
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Error extracting total late deduction: " + e.getMessage());
            return 0.0;
        }
    }

}

